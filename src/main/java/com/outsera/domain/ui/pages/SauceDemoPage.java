package com.outsera.domain.ui.pages;

import org.openqa.selenium.By;

public class SauceDemoPage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ADD_TO_CART_BUTTON = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    public static final By CART_ICON = By.id("shopping_cart_container");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By POSTAL_CODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By FINISH_BUTTON = By.cssSelector("[data-test='finish']");
    public static final By SUCCESS_MESSAGE = By.className("complete-header");
}
