package com.outsera.domain.mobile.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CartMobilePage {
    public static final By ADD_TO_CART_BUTTON = By.xpath("(//*[@text='ADD TO CART'])[1]");
    public static final By CART_BUTTON = AppiumBy.accessibilityId("test-Cart");
    public static final By CHECKOUT_BUTTON = AppiumBy.accessibilityId("test-CHECKOUT");
}
