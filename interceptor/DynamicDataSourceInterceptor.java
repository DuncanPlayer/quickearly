package net.messi.early.interceptor;

import net.messi.early.holder.DyncmicDataSourceHolder;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.Executor;

@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class,
        Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class})})
public class DynamicDataSourceInterceptor implements Interceptor {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceInterceptor.class);
    // 写操作的正则表达式
    private static final String REGEX = ".*insert\\u0020.*||.*update\\u0020.*||.*delete\\u0020.*";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("早餐被拦截了...");
        // 判断方法是否是被事务管理的
        boolean synchronizationAction = TransactionSynchronizationManager.isActualTransactionActive();
        //获取sql中的参数
        Object[] objects = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) objects[0];
        //数据源key
        String lookupKey = DyncmicDataSourceHolder.DB_SLAVE;
        if (!synchronizationAction) {
            // 读方法
            if (mappedStatement.getSqlCommandType().equals(SqlCommandType.SELECT)) {
                //selectKey为自增id查询主键（SELECT LAST_INSERT_ID）方法
                if (mappedStatement.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
                    lookupKey = DyncmicDataSourceHolder.DB_SLAVE;
                } else {
                    //获取sql 语句
                    BoundSql boundSql = mappedStatement.getSqlSource().getBoundSql(objects[1]);
                    String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replace("\\t\\n\\r", " ");
                    System.out.println("操作语句sql::" + sql);
                    System.out.println("匹配结果:::" + sql.matches(REGEX));
                    if (sql.matches(REGEX)) {
                        //写操作
                        lookupKey = DyncmicDataSourceHolder.DB_MASTER;
                    } else {
                        //读操作
                        lookupKey = DyncmicDataSourceHolder.DB_SLAVE;
                    }
                }
            }
        } else {
            lookupKey = DyncmicDataSourceHolder.DB_SLAVE;
        }
        logger.debug("设置方法[{}] use [{}] Strategy,SqlCommandType [{}]...", mappedStatement.getId(),
                lookupKey, mappedStatement.getSqlCommandType().name());
        DyncmicDataSourceHolder.setDbType(lookupKey);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        //Executor表示含有增删改查的操作的对象
        if (target instanceof Executor) {
            //有增删改查的操作,就调用拦截方法
            return Plugin.wrap(target, this);
        } else {
            //无增删改查的操作。不做处理
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
