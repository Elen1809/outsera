Feature: Realizar teste E2E com Cucumber Java + Selenium

  Como usuário do site AdoPet e do Sauce Demo
  Quero realizar ações nas aplicações
  Para validar a navegação, login e funcionalidades de compra

  @E2ETarefa1 @E2EWEB
  Scenario: Realizar login com sucesso
    Given que estou na página de login do AdoPet
    When eu insiro o email "elenilva.ads@gmail.com"
    And eu insiro a senha "Batata@01"
    And eu clico no botão de login
    Then eu devo ver a mensagem de boas-vindas na página inicial

  @E2ETarefa2 @E2EWEB
  Scenario: Realizar login, adicionar produtos ao carrinho e finalizar compra
    Given que estou na página de login do Sauce Demo
    When eu faço login com "standard_user" e "secret_sauce"
    And eu adiciono um produto
    And eu acesso o carrinho
    And eu avanço para o checkout preenchendo "Anna Maria" "User" "12345"
    Then eu devo ver a mensagem de sucesso "Thank you for your order!"
