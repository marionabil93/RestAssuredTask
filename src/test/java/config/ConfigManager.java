package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties = new Properties();

    static {
        try {
            InputStream file = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getUserName() {
        return properties.getProperty("user.name");
    }

    public static String getUserJob() {
        return properties.getProperty("user.job");
    }

    public static String getUserAge(){
        return properties.getProperty("user.age");
    }

    public static String getUpdatedJob(){
        return properties.getProperty("user.updatedAge");
    }
}
