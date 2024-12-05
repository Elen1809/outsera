package com.outsera.domain.ui.pages;
import org.openqa.selenium.By;

public class LoginAdoPetPage {
    public static final By LOGIN_BUTTON = By.cssSelector("[data-test='login-button']");
    public static final By EMAIL_INPUT = By.cssSelector("[data-test='input-loginEmail']");
    public static final By PASSWORD_INPUT = By.cssSelector("[data-test='input-loginPassword']");
    public static final By SUBMIT_BUTTON = By.cssSelector("[data-test='submit-button']");
    public static final By BOAS_VINDAS_TEXT = By.xpath("//p[contains(., 'Veja os amigos disponíveis para adoção!')]");
}
