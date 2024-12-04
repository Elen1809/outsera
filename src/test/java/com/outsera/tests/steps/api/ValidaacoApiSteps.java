package com.outsera.tests.steps.api;

import com.outsera.core.utils.LogUtils;
import com.outsera.core.utils.RestAssuredClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.equalTo;

public class ValidaacoApiSteps {

    private Response response;
    private final Map<String, String> headers = new HashMap<>();
    private static final Logger logger = LogUtils.getLogger(ValidaacoApiSteps.class);


    @Given("que a API está configurada")
    public void configurarApi() {
        headers.put("Content-Type", "application/json");
        logger.info("API configurada com headers: " + headers);
    }

    @When("eu faço uma requisição GET para {string}")
    public void euFacoUmaRequisicaoGET(String endpoint) {
        logger.info("Iniciando requisição GET para: " + endpoint);
        response = RestAssuredClient.get(endpoint, headers);
        logger.info("Resposta recebida: " + response.prettyPrint());
    }

    @When("eu faço uma requisição POST para {string} com o payload:")
    public void euFacoUmaRequisicaoPOST(String endpoint, DataTable dataTable) {
        Map<String, String> payload = dataTable.asMap(String.class, String.class);
        logger.info("Iniciando requisição POST para: " + endpoint + " com payload: " + payload);
        response = RestAssuredClient.post(endpoint, headers, payload);
        logger.info("Resposta recebida: " + response.prettyPrint());
    }

    @When("eu faço uma requisição PUT para {string} com o payload:")
    public void euFacoUmaRequisicaoPUT(String endpoint, DataTable dataTable) {
        Map<String, String> payload = new HashMap<>();
        dataTable.asMaps().forEach(payload::putAll);
        logger.info("Iniciando requisição PUT para: " + endpoint + " com payload: " + payload);

        response = io.restassured.RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();

        logger.info("Resposta recebida: " + response.prettyPrint());
    }

    @When("eu faço uma requisição DELETE para {string}")
    public void euFacoUmaRequisicaoDELETE(String endpoint) {
        logger.info("Iniciando requisição DELETE para: " + endpoint);
        response = RestAssuredClient.delete(endpoint, headers);
        logger.info("Resposta recebida: " + response.prettyPrint());
    }

    @Then("o status da resposta deve ser {int}")
    public void validarStatusDaResposta(int statusCode) {
        logger.info("Validando status da resposta. Esperado: " + statusCode);
        response.then().statusCode(statusCode);
        logger.info("Status validado com sucesso.");
    }

    @Then("o campo {string} deve ser {string}")
    public void validarCampoString(String campo, String valorEsperado) {
        logger.info("Validando campo: " + campo + ". Valor esperado: " + valorEsperado);
        response.then().body(campo, equalTo(valorEsperado));
        logger.info("Campo validado com sucesso.");
    }

    @Then("o campo {string} deve ser {int}")
    public void validarCampoInt(String campo, int valorEsperado) {
        logger.info("Validando campo: " + campo + ". Valor esperado: " + valorEsperado);
        response.then().body(campo, equalTo(valorEsperado));
        logger.info("Campo validado com sucesso.");
    }
}
