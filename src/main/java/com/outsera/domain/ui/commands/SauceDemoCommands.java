package com.outsera.domain.ui.commands;

import com.outsera.domain.ui.pages.SauceDemoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceDemoCommands {
    private WebDriver driver;
    private WebDriverWait wait;

    public SauceDemoCommands(WebDriver driver) {
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
        wait.until(d -> d.findElement(SauceDemoPage.USERNAME_INPUT)).sendKeys(username);
        driver.findElement(SauceDemoPage.PASSWORD_INPUT).sendKeys(password);
        driver.findElement(SauceDemoPage.LOGIN_BUTTON).click();
    }

    public void adicionarProdutoAoCarrinho() {
        driver.findElement(SauceDemoPage.ADD_TO_CART_BUTTON).click();
    }

    public void acessarCarrinho() {
        wait.until(d -> d.findElement(SauceDemoPage.CART_ICON)).click();
    }

    public void preencherCheckout(String nome, String sobrenome, String codigoPostal) {
        wait.until(d -> d.findElement(SauceDemoPage.CHECKOUT_BUTTON)).click();
        wait.until(d -> d.findElement(SauceDemoPage.FIRST_NAME_INPUT)).sendKeys(nome);
        driver.findElement(SauceDemoPage.LAST_NAME_INPUT).sendKeys(sobrenome);
        driver.findElement(SauceDemoPage.POSTAL_CODE_INPUT).sendKeys(codigoPostal);
        driver.findElement(SauceDemoPage.CONTINUE_BUTTON).click();
    }

    public boolean finalizarCompra(String mensagemEsperada) {
        WebElement botaoFinish = wait.until(d -> d.findElement(SauceDemoPage.FINISH_BUTTON));
        botaoFinish.click();
        WebElement mensagemSucesso = wait.until(d -> d.findElement(SauceDemoPage.SUCCESS_MESSAGE));
        return mensagemSucesso.getText().equals(mensagemEsperada);
    }
}
