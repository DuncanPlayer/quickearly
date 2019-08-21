package net.messi.early.utils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceUtil {

    public static MysqlDataSource dataSource = new MysqlDataSource();


    public static void connect() {
        dataSource.setServerName("localhost");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setDatabaseName("earlyshop");

    }
}
