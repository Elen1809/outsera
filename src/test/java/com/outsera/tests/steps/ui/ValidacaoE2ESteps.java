package com.outsera.tests.steps.ui;

import com.outsera.core.drivers.WebDriverFactory;
import com.outsera.domain.ui.commands.CartSauceDemoCommands;
import com.outsera.domain.ui.commands.CheckoutSauceDemoCommands;
import com.outsera.domain.ui.commands.LoginAdopeCommands;
import com.outsera.domain.ui.commands.LoginSauceDemoCommands;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class ValidacaoE2ESteps {
    private WebDriver driver;
    private LoginAdopeCommands adopetCommands;
    private LoginSauceDemoCommands loginSauceDemoCommands;
    private CartSauceDemoCommands cartSauceDemoCommands;
    private CheckoutSauceDemoCommands checkoutSauceDemoCommands;


    @Given("que estou na página de login do AdoPet")
    public void acessarPaginaLogin() {
        driver = WebDriverFactory.getWebDriver();
        adopetCommands = new LoginAdopeCommands(driver);
        adopetCommands.acessarPaginaLogin("https://adopet-frontend-cypress.vercel.app/");
    }

    @When("eu insiro o email {string}")
    public void inserirEmail(String email) {
        adopetCommands.inserirEmail(email);
    }

    @And("eu insiro a senha {string}")
    public void inserirSenha(String senha) {
        adopetCommands.inserirSenha(senha);
    }

    @And("eu clico no botão de login")
    public void clicarBotaoLogin() {
        adopetCommands.clicarBotaoLogin();
    }

    @Then("eu devo ver a mensagem de boas-vindas na página inicial")
    public void validarMensagemBoasVindas() {
        Assert.assertTrue("Mensagem de boas-vindas incorreta!", adopetCommands.validarBoasVindas("Olá"));
    }

    @Given("que estou na página de login do Sauce Demo")
    public void acessarPaginaLoginSauceDemo() {
        driver = WebDriverFactory.getWebDriver();
        loginSauceDemoCommands = new LoginSauceDemoCommands(driver);
        cartSauceDemoCommands = new CartSauceDemoCommands(driver);
        checkoutSauceDemoCommands = new CheckoutSauceDemoCommands(driver);

        loginSauceDemoCommands.acessarPagina();
    }

    @When("eu faço login com {string} e {string}")
    public void facoLoginPagina(String user, String password) {
        loginSauceDemoCommands.realizarLogin(user, password);
    }

    @When("eu adiciono um produto")
    public void adicionarProdutoAoCarrinho() {
        cartSauceDemoCommands.adicionarProdutoAoCarrinho();
    }

    @And("eu acesso o carrinho")
    public void acessarCarrinho() {
        cartSauceDemoCommands.acessarCarrinho();
    }

    @And("eu avanço para o checkout preenchendo {string} {string} {string}")
    public void preencherCheckout(String nome, String sobrenome, String codigoPostal) {
        checkoutSauceDemoCommands.preencherCheckout(nome, sobrenome, codigoPostal);
    }

    @Then("eu devo ver a mensagem de sucesso {string}")
    public void validarMensagemDeSucesso(String mensagemEsperada) {
        Assert.assertTrue("Mensagem de sucesso incorreta!", checkoutSauceDemoCommands.finalizarCompra(mensagemEsperada));
    }
}