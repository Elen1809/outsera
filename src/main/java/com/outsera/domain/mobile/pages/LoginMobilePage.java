package com.outsera.domain.mobile.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginMobilePage {
    public static final By USERNAME_FIELD = AppiumBy.accessibilityId("test-Username");
    public static final By PASSWORD_FIELD = By.xpath("//android.widget.TextView[@text='standard_user']");
    public static final By LOGIN_BUTTON = AppiumBy.accessibilityId("test-LOGIN");
    public static final By HOME_SCREEN = By.xpath("//*[@content-desc='test-Cart drop zone']");
}
