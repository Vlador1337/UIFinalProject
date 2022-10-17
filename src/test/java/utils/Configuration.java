package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static utils.Const.CONFIGURATION_FILE;

public class Configuration {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = Configuration.class.getResourceAsStream(CONFIGURATION_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file" + CONFIGURATION_FILE, e);
        }
    }

    public static String getConfigurationValue(String key) {
        return (System.getProperty(key) == null) ? properties.getProperty(key) : System.getProperty(key);
    }
}