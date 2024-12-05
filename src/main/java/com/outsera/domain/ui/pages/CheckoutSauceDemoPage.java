package com.outsera.domain.ui.pages;

import org.openqa.selenium.By;

public class CheckoutSauceDemoPage {
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By POSTAL_CODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By FINISH_BUTTON = By.cssSelector("[data-test='finish']");
    public static final By SUCCESS_MESSAGE = By.className("complete-header");
}
