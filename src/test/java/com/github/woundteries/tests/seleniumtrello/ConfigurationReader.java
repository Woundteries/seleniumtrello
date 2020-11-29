package com.github.woundteries.tests.seleniumtrello;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(ConfigurationReader.class.getName());
    private Properties properties;

    public ConfigurationReader() {
        try (InputStream input = new FileInputStream("src/test/resources/test.properties")) {
            properties = new Properties();
            properties.load(input);

        } catch (IOException ex) {
            log.severe("Could not find or read the test.properties file.");
        }
    }

    public String getChromeDriverPath() {
        return properties.getProperty("chromeDriverPath");
    }

    public String getTestData(String data) {
        return properties.getProperty("test." + data);
    }

}
