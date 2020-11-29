package com.github.woundteries.tests.seleniumtrello.account;

import com.github.woundteries.tests.seleniumtrello.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class LoginTest extends TestBase {

    public static final String LOGIN_PAGE_URL = "https://trello.com/en/login";

    @Test
    public void testLogin_correctPassword_loginSuccessful() {
        // visit the login page
        driver.get(LOGIN_PAGE_URL);

        // type in the email, password and log in
        WebElement userNameBox = driver.findElement(By.cssSelector("#user"));
        userNameBox.sendKeys(testData.getEmail());

        WebElement passwordBox = driver.findElement(By.cssSelector("#password"));
        passwordBox.sendKeys(testData.getPassword());

        WebElement loginButton = driver.findElement(By.cssSelector("#login"));
        loginButton.click();

        // user is logged in and welcome message is visible
        new WebDriverWait(driver, 60).until(ExpectedConditions.urlContains("https://trello.com/create-first-team"));

        WebElement welcomeMessageBox = driver.findElement(By.xpath("//*[@data-test-id='moonshot-welcome-heading']"));

        String expectedWelcomeMessage = "Welcome, " + testData.getUserName();
        String actualWelcomeMessage = welcomeMessageBox.getText();
        assertNotNull(actualWelcomeMessage);
        assertTrue("Welcome message does not contain the user name", actualWelcomeMessage.contains(expectedWelcomeMessage));
    }

    @Test
    public void testLogin_wrongUserName_warningAboutWrongUserNameOrPassword() {
        // visit the login page
        driver.get(LOGIN_PAGE_URL);

        // type in the email, wrong password and try to log in
        WebElement userNameBox = driver.findElement(By.cssSelector("#user"));
        userNameBox.sendKeys("iw.notexisting@gmail.com");

        WebElement passwordBox = driver.findElement(By.cssSelector("#password"));
        passwordBox.sendKeys(testData.getPassword());

        WebElement loginButton = driver.findElement(By.cssSelector("#login"));
        loginButton.click();

        // warning about wrong email or user name is visible
        WebElement warningBox = driver.findElement(By.cssSelector("#password-error > p"));

        String expectedWarningMessage = "Incorrect email address and / or password.";
        String actualWarningMessage = warningBox.getAttribute("innerText");
        assertTrue(actualWarningMessage.contains(expectedWarningMessage));

        String expectedWarningColor = "rgba(235, 90, 70, 1)"; // red
        String actualWarningColor = warningBox.getCssValue("background-color");
        assertEquals(expectedWarningColor, actualWarningColor);
    }
}
