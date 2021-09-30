package com.sword.base.common;

import java.io.*;
import java.util.Properties;

/**
 * Created by Max on 2017/6/6.
 */
public class Configure {
    private static Properties config;
    private static String ConfigPath;

    //测试用，不建议使用
    private static void init() {
        ConfigPath = "d:\\dev\\qichacha\\src\\resources\\application.properties.bak";
        if (!System.getProperty("os.name").toLowerCase().contains("windows")) { //linux，非开发环境
            ConfigPath = "/usr/local/data/spider/application.properties";
        }
        loadConfig(ConfigPath);
    }

    public static Properties loadConfig(String configPath) {
        if (config == null) config = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(new File(configPath)));
            config.load(in);
            in.close();
            ConfigPath = configPath;
        } catch (IOException e) {
            config = null;
        }
        return config;
    }

    public static Properties loadConfig(Properties cfg) {
        if (cfg != null) config = cfg;
        return config;
    }

    public static String getConfigPath() {
        return ConfigPath;
    }

    public static Properties getConfig() {
        if (config == null) init();
        return config;
    }
}
