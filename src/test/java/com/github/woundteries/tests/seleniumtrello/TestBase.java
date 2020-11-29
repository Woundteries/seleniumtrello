package com.github.woundteries.tests.seleniumtrello;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    protected static WebDriver driver;
    protected static TestData testData;

    @BeforeClass
    public static void setupConfiguration() {
        ConfigurationReader configReader = new ConfigurationReader();
        testData = new TestData(configReader);
        System.setProperty("webdriver.chrome.driver", configReader.getChromeDriverPath());
    }

    @Before
    public void setupDriver() {
        driver = new ChromeDriver();
    }

    @After
    public void quit() {
        driver.quit();
    }

}
