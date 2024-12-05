package com.outsera.domain.mobile.commands;

import com.outsera.domain.mobile.pages.LoginMobilePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginMobileCommands {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public LoginMobileCommands(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void informUser(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginMobilePage.USERNAME_FIELD));
        usernameField.sendKeys(username);
    }

    public void selectPassword() {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginMobilePage.PASSWORD_FIELD));
        passwordField.click();
    }

    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(LoginMobilePage.LOGIN_BUTTON));
        loginButton.click();
    }

    public boolean isHomeScreenDisplayed() {
        WebElement homeScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginMobilePage.HOME_SCREEN));
        return homeScreen.isDisplayed();
    }
}
