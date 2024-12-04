package com.outsera.tests.steps.mobile;

import com.outsera.core.drivers.MobileDriverFactory;
import com.outsera.domain.mobile.commands.CartMobileCommands;
import com.outsera.domain.mobile.commands.CheckoutMobileCommands;
import com.outsera.domain.mobile.commands.LoginMobileCommands;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ValidacaoMobileSteps {

    private AndroidDriver driver;
    private CartMobileCommands cartMobileCommands;
    private CheckoutMobileCommands checkoutMobileCommands;
    private LoginMobileCommands loginMobileCommands;

    @Given("que o aplicativo está aberto no dispositivo Android")
    public void queOAplicativoEstaAbertoNoDispositivoAndroid() {
        driver = MobileDriverFactory.getMobileDriver();
        cartMobileCommands = new CartMobileCommands(driver);
        checkoutMobileCommands = new CheckoutMobileCommands(driver);
        loginMobileCommands = new LoginMobileCommands(driver);
    }

    @When("eu informo o usuário {string}")
    public void euInformoOUsuario(String usuario) {
        loginMobileCommands.informUser(usuario);
    }

    @When("eu clico na senha")
    public void euInformoASenha() {
        loginMobileCommands.selectPassword();
    }

    @When("eu clico no botão de login Mobile")
    public void euClicoNoBotaoDeLoginMobile() {
        loginMobileCommands.clickLoginButton();
    }

    @Then("eu devo ver a tela inicial")
    public void euDevoVerATelaInicial() {
        Assert.assertTrue("Tela inicial não carregada corretamente!", loginMobileCommands.isHomeScreenDisplayed());
    }

    @When("eu adiciono um item ao carrinho Mobile")
    public void euAdicionoUmItemAoCarrinhoMobile() {
        cartMobileCommands.addToCart();
    }

    @When("eu acesso o carrinho Mobile")
    public void euAcessoOCarrinhoMobile() {
        cartMobileCommands.accessCart();
    }

    @When("eu preencho os detalhes do checkout com {string}, {string}, {string}")
    public void euPreenchoOsDetalhesDoCheckout(String primeiroNome, String sobrenome, String cep) {
        checkoutMobileCommands.fillCheckoutDetails(primeiroNome, sobrenome, cep);
    }

    @When("eu clico no botão continuar")
    public void euClicoNoBotaoContinuar() {
        checkoutMobileCommands.clickContinue();
    }

    @When("eu clico no botão finalizar")
    public void euClicoNoBotaoFinalizar() {
        checkoutMobileCommands.finishCheckout();
    }

    @Then("eu devo ver o botão de sucesso")
    public void euDevoVerOBotaoDeSucesso() {
        assert checkoutMobileCommands.isSuccessButtonDisplayed();
    }
}