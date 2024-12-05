package com.outsera.core.drivers;

import com.outsera.core.utils.ConfigManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriverFactory {

    private static AndroidDriver driver;

    public static void createMobileDriver(String platform) throws MalformedURLException {
        if (!"android".equalsIgnoreCase(platform)) {
            throw new IllegalArgumentException("Somente Android é suportado no momento.");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", ConfigManager.getRequiredProperty("deviceName"));
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("appium:automationName", "UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
    }

    public static AndroidDriver getMobileDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver não inicializado. Chame 'createMobileDriver' primeiro.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
