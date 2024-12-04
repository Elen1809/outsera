@E2EMobile
Feature: Testes de validação mobile no aplicativo Swag Labs

  @E2EMobileTarefa1
  Scenario: Validar tela inicial após login
    Given que o aplicativo está aberto no dispositivo Android
    When eu informo o usuário "standard_user"
    And eu clico na senha
    And eu clico no botão de login Mobile
    Then eu devo ver a tela inicial

  @E2EMobileTarefa2
  Scenario: Adicionar item ao carrinho e finalizar compra
    Given que o aplicativo está aberto no dispositivo Android
    When eu informo o usuário "standard_user"
    And eu clico na senha
    And eu clico no botão de login Mobile
    And eu adiciono um item ao carrinho Mobile
    And eu acesso o carrinho Mobile
    And eu preencho os detalhes do checkout com "Anna", "Smith", "12345"
    And eu clico no botão continuar
    And eu clico no botão finalizar
    Then eu devo ver o botão de sucesso
