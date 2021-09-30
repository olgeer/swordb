package com.sword.base.datasource;

import com.sword.base.common.Configure;
import com.sword.base.common.Util;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by Max on 2017/2/7.
 */
public class DataSource {
    private static HikariDataSource ds = null;
    private static final int connectiontimeout = 10 * 1000;//等待连接池分配连接的最大时长（毫秒），超过这个时长还没可用的连接则发生SQLException， 缺省:30秒
    private static final int idletimeout = 10 * 60 * 1000;//一个连接idle状态的最大时长（毫秒），超时则被释放（retired），缺省:10分钟
    private static final int maxlifetime = 30 * 60 * 1000;//一个连接的生命时长（毫秒），超时而且没被使用则被释放（retired），缺省:30分钟，建议设置比数据库超时时长少30秒，参考sql wait_timeout参数（show variables like '%timeout%';）
    private static final int logintimeout = 30 * 60;        //登录超时，默认30分钟，单位秒
    private static final int minimum = 1;
    private static final int maximum = 3;//连接池中允许的最大连接数。缺省值：10；推荐的公式：((core_count * 2) + effective_spindle_count)
    private static String PREFIX ="mysql";
    private static DataSource instance = null;
    private static String driverClassName;

    public static void init(){
        init(null);
    }

    public static void init(String prefix){
        try {
            Properties jdbcProperty = Configure.getConfig();
            if(prefix!=null) {
                PREFIX=prefix;
            }else{
                PREFIX = Util.setValue(jdbcProperty.getProperty("prefix"), PREFIX);
            }

            if(ds!=null)ds.close();     //之前已经进行过链接，先关闭

            HikariConfig config = new HikariConfig();
            driverClassName =jdbcProperty.getProperty(PREFIX +".driverClassName");
            config.setDriverClassName(driverClassName);
            config.setJdbcUrl(jdbcProperty.getProperty(PREFIX +".url"));
            config.setUsername(Util.setValue(jdbcProperty.getProperty(PREFIX +".username"),null));
            config.setPassword(Util.setValue(jdbcProperty.getProperty(PREFIX +".password"),null));
            config.setConnectionTimeout(Long.parseLong(Util.setValue(jdbcProperty.getProperty(PREFIX +".connectiontimeout"),Long.toString(connectiontimeout))));
            config.setIdleTimeout(Long.parseLong(Util.setValue(jdbcProperty.getProperty(PREFIX +".idletimeout"),Long.toString(idletimeout))));
            config.setMaxLifetime(Long.parseLong(Util.setValue(jdbcProperty.getProperty(PREFIX +".maxlifetime"),Long.toString(maxlifetime))));
            config.setMinimumIdle(Integer.parseInt(Util.setValue(jdbcProperty.getProperty(PREFIX +".minIdle"),Integer.toString(minimum))));
            config.setMaximumPoolSize(Integer.parseInt(Util.setValue(jdbcProperty.getProperty(PREFIX +".maxIdle"),Integer.toString(maximum))));
            config.setConnectionTestQuery(Util.setValue(jdbcProperty.getProperty(PREFIX +".validationQuery"),"select 1;"));
            config.addDataSourceProperty("cachePrepStmts", true);
            config.addDataSourceProperty("prepStmtCacheSize", 500);
            config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
            config.setAutoCommit(Boolean.parseBoolean(Util.setValue(jdbcProperty.getProperty(PREFIX +".defaultAutoCommit"),"true")));
            config.setPoolName(Util.setValue(jdbcProperty.getProperty(PREFIX +".database"),"database"));

            ds = new HikariDataSource(config);
            ds.setLoginTimeout(logintimeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDriverClassName() {
        return driverClassName;
    }

    protected DataSource() {
    }

    public static DataSource newInstance(){
        return newInstance(null);
    }

    public static DataSource newInstance(String prefix) {
        if(ds==null)init(prefix);
        if (instance == null) instance = new DataSource();
        return instance;
    }

    /**
     * 销毁连接池
     */
    public void close() {
        ds.close();
    }

    public Connection getConn() {
        try {
            if(ds!=null)
                return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
