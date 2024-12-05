package com.outsera.tests;

import com.outsera.core.drivers.MobileDriverFactory;
import com.outsera.core.drivers.WebDriverFactory;
import com.outsera.core.utils.ConfigManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class BaseTest {

    String platform = System.getProperty("platform");

    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {

        String browser = ConfigManager.getRequiredProperty("browser");

        if(platform.equals("")){
            ConfigManager.getRequiredProperty("platform");
        }

        System.out.println("Inicializando o teste para o cenário: " + scenario.getName());

        switch (platform.toLowerCase()) {
            case "web":
                WebDriverFactory.createWebDriver(browser,false);
                break;

            case "android":
                MobileDriverFactory.createMobileDriver("android");
                break;

            case "api":
                RestAssured.baseURI = ConfigManager.getRequiredProperty("api.baseUri");
                System.out.println("RestAssured configurado com baseURI: " + RestAssured.baseURI);                break;

            default:
                throw new IllegalArgumentException("Plataforma inválida: " + platform);
        }
    }

    private void configureRestAssured() {
        String apiBaseUri = ConfigManager.getRequiredProperty("api.baseUri");
        RestAssured.baseURI = apiBaseUri;

        // Exibe no console a URL configurada para a API
        System.out.println("RestAssured configurado com baseURI: " + RestAssured.baseURI);
    }

    @After
    public void tearDown() {
        switch (platform.toLowerCase()) {
            case "web":
                WebDriver webDriver = WebDriverFactory.getWebDriver();
                if (webDriver != null) {
                    webDriver.quit();
                    System.out.println("Navegador fechado.");
                }
                break;
            case "android":
                try {
                    MobileDriverFactory.quitDriver();
                    System.out.println("Aplicativo fechado.");
                } catch (Exception e) {
                    System.err.println("Erro ao fechar o aplicativo: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Nenhum driver para fechar.");
                break;
        }
    }
}