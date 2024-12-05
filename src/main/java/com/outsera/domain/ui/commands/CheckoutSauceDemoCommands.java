package com.outsera.domain.ui.commands;

import com.outsera.domain.ui.pages.CheckoutSauceDemoPage;
import com.outsera.domain.ui.pages.LoginSauceDemoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutSauceDemoCommands {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutSauceDemoCommands(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void preencherCheckout(String nome, String sobrenome, String codigoPostal) {
        wait.until(d -> d.findElement(CheckoutSauceDemoPage.CHECKOUT_BUTTON)).click();
        wait.until(d -> d.findElement(CheckoutSauceDemoPage.FIRST_NAME_INPUT)).sendKeys(nome);
        driver.findElement(CheckoutSauceDemoPage.LAST_NAME_INPUT).sendKeys(sobrenome);
        driver.findElement(CheckoutSauceDemoPage.POSTAL_CODE_INPUT).sendKeys(codigoPostal);
        driver.findElement(CheckoutSauceDemoPage.CONTINUE_BUTTON).click();
    }

    public boolean finalizarCompra(String mensagemEsperada) {
        WebElement botaoFinish = wait.until(d -> d.findElement(CheckoutSauceDemoPage.FINISH_BUTTON));
        botaoFinish.click();
        WebElement mensagemSucesso = wait.until(d -> d.findElement(CheckoutSauceDemoPage.SUCCESS_MESSAGE));
        return mensagemSucesso.getText().equals(mensagemEsperada);
    }
}
