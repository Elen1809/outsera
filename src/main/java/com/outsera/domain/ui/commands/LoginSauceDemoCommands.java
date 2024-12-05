package com.outsera.domain.ui.commands;

import com.outsera.domain.ui.pages.LoginSauceDemoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSauceDemoCommands {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginSauceDemoCommands(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void acessarPagina() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        System.out.println("Acessando o Sauce Demo.");
    }

    public void realizarLogin(String username, String password) {
        wait.until(d -> d.findElement(LoginSauceDemoPage.USERNAME_INPUT)).sendKeys(username);
        driver.findElement(LoginSauceDemoPage.PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LoginSauceDemoPage.LOGIN_BUTTON).click();
    }
}
