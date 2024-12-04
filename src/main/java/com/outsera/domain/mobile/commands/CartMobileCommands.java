package com.outsera.domain.mobile.commands;

import com.outsera.domain.mobile.pages.CartMobilePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartMobileCommands {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public CartMobileCommands(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void addToCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(CartMobilePage.ADD_TO_CART_BUTTON));
        addToCartButton.click();
    }

    public void accessCart() {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(CartMobilePage.CART_BUTTON));
        cartButton.click();
        WebElement cartCheckout = wait.until(ExpectedConditions.elementToBeClickable(CartMobilePage.CHECKOUT_BUTTON));
        cartCheckout.click();
    }

}
