package com.outsera.domain.mobile.commands;

import com.outsera.domain.mobile.pages.CheckoutMobilePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutMobileCommands {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public CheckoutMobileCommands(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void fillCheckoutDetails(String firstName, String lastName, String zipCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutMobilePage.FIRST_NAME_FIELD)).sendKeys(firstName);
        driver.findElement(CheckoutMobilePage.LAST_NAME_FIELD).sendKeys(lastName);
        driver.findElement(CheckoutMobilePage.ZIP_CODE_FIELD).sendKeys(zipCode);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(CheckoutMobilePage.CONTINUE_BUTTON)).click();
    }

    public void finishCheckout() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""+"FINISH"+"\"));"));
        wait.until(ExpectedConditions.elementToBeClickable(CheckoutMobilePage.FINISH_BUTTON)).click();
    }

    public boolean isSuccessButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutMobilePage.BACK_HOME_BUTTON)).isDisplayed();
    }
}