package com.outsera.domain.ui.commands;

import com.outsera.domain.ui.pages.LoginAdoPetPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAdopeCommands {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginAdopeCommands(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void acessarPaginaLogin(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("Navegando para a página inicial.");
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='login-button']")));
        login.click();

    }

    public void inserirEmail(String email) {
        WebElement emailInput = wait.until(d -> d.findElement(LoginAdoPetPage.EMAIL_INPUT));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void inserirSenha(String senha) {
        WebElement passwordInput = wait.until(d -> d.findElement(LoginAdoPetPage.PASSWORD_INPUT));
        passwordInput.clear();
        passwordInput.sendKeys(senha);
    }

    public void clicarBotaoLogin() {
        WebElement loginButton = wait.until(d -> d.findElement(LoginAdoPetPage.SUBMIT_BUTTON));
        loginButton.click();
    }

    public boolean validarBoasVindas(String textoEsperado) {
        WebElement boasVindas = wait.until(d -> d.findElement(LoginAdoPetPage.BOAS_VINDAS_TEXT));
        return boasVindas.getText().contains(textoEsperado);
    }
}
