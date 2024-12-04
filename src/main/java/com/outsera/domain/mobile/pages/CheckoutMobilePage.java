package com.outsera.domain.mobile.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CheckoutMobilePage {
    public static final By FIRST_NAME_FIELD = AppiumBy.accessibilityId("test-First Name");
    public static final By LAST_NAME_FIELD = AppiumBy.accessibilityId("test-Last Name");
    public static final By ZIP_CODE_FIELD = AppiumBy.accessibilityId("test-Zip/Postal Code");
    public static final By CONTINUE_BUTTON = AppiumBy.accessibilityId("test-CONTINUE");
    public static final By FINISH_BUTTON = AppiumBy.accessibilityId("test-FINISH");
    public static final By BACK_HOME_BUTTON = AppiumBy.accessibilityId("test-BACK HOME");
}
