package net.messi.early.holder;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DyncmicDataSourceHolder {

    private static Logger logger = LoggerFactory.getLogger(DyncmicDataSourceHolder.class);
    /**
     * 保证线程安全，使用线程threadlocal
     */
    private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static final String DB_MASTER = "master";

    public static final String DB_SLAVE = "slave";

    public static void setRead() {
        contextHolder.set(DB_SLAVE);
    }

    public static void setWrite() {
        contextHolder.set(DB_MASTER);
    }

    /**
     * @description 获取连接类型
     */
    public static String getDbType() {
        String db = contextHolder.get();
        if (StringUtils.isBlank(db)) {
            db = DB_SLAVE;
        }
        return db;
    }

    /**
     * 设置数据源类型
     *
     * @param str
     */
    public static void setDbType(String str) {
        logger.debug("使用数据源类型---" + str);
        contextHolder.set(str);
    }

    /**
     * 清理连接类型
     */
    public static void clearDaType() {
        contextHolder.remove();
    }
}
