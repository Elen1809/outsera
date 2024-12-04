package com.outsera.tests.steps.ui;

import com.outsera.core.drivers.WebDriverFactory;
import com.outsera.domain.ui.commands.AdopeCommands;
import com.outsera.domain.ui.commands.SauceDemoCommands;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class ValidacaoE2ESteps {
    private WebDriver driver;
    private AdopeCommands adopetCommands;
    private SauceDemoCommands sauceDemoCommands;

    @Given("que estou na página de login do AdoPet")
    public void acessarPaginaLogin() {
        driver = WebDriverFactory.getWebDriver();
        adopetCommands = new AdopeCommands(driver);
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
        sauceDemoCommands = new SauceDemoCommands(driver);
        sauceDemoCommands.acessarPagina();
    }

    @When("eu faço login com {string} e {string}")
    public void facoLoginPagina(String user, String password) {
        sauceDemoCommands.realizarLogin(user, password);
    }

    @When("eu adiciono um produto")
    public void adicionarProdutoAoCarrinho() {
        sauceDemoCommands.adicionarProdutoAoCarrinho();
    }

    @And("eu acesso o carrinho")
    public void acessarCarrinho() {
        sauceDemoCommands.acessarCarrinho();
    }

    @And("eu avanço para o checkout preenchendo {string} {string} {string}")
    public void preencherCheckout(String nome, String sobrenome, String codigoPostal) {
        sauceDemoCommands.preencherCheckout(nome, sobrenome, codigoPostal);
    }

    @Then("eu devo ver a mensagem de sucesso {string}")
    public void validarMensagemDeSucesso(String mensagemEsperada) {
        Assert.assertTrue("Mensagem de sucesso incorreta!", sauceDemoCommands.finalizarCompra(mensagemEsperada));
    }
}