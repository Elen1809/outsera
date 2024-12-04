package com.outsera.core.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static void createWebDriver(String browser, boolean isHeadless) {
        System.out.println("Criando WebDriver para o navegador: " + browser + ", Headless: " + isHeadless);

        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

                // Configurações adicionais para o ChromeDriver
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");

                if (isHeadless) {
                    chromeOptions.addArguments("--headless");
                }

                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

                // Configurações adicionais para o FirefoxDriver
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setAcceptInsecureCerts(true); // Aceitar certificados inseguros

                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }

                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new IllegalArgumentException("Navegador não suportado: " + browser);
        }

        webDriver.set(driver);
    }

    public static WebDriver getWebDriver() {
        WebDriver driver = webDriver.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver não inicializado! Certifique-se de que o método createWebDriver foi chamado.");
        }
        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = webDriver.get();
        if (driver != null) {
            driver.quit();
            webDriver.remove();
        }
    }
}
