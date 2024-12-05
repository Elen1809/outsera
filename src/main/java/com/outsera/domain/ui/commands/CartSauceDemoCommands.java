package com.outsera.domain.ui.commands;

import com.outsera.domain.ui.pages.CartSauceDemoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartSauceDemoCommands {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartSauceDemoCommands(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void adicionarProdutoAoCarrinho() {
        driver.findElement(CartSauceDemoPage.ADD_TO_CART_BUTTON).click();
    }

    public void acessarCarrinho() {
        wait.until(d -> d.findElement(CartSauceDemoPage.CART_ICON)).click();
    }
}
