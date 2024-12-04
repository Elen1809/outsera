@api
Feature: Testes de integração com a API ReqRes

  @APITarefa1e2
  Scenario: Validar chamada GET para listar usuários
    Given que a API está configurada
    When eu faço uma requisição GET para "/api/users?page=2"
    Then o status da resposta deve ser 200
    And o campo "page" deve ser 2
    And o campo "total" deve ser 12

  @APITarefa1e2
  Scenario: Validar chamada GET para listar usuários
    Given que a API está configurada
    When eu faço uma requisição GET para "/api/users"
    Then o status da resposta deve ser 200
    And o campo "page" deve ser 1
    And o campo "per_page" deve ser 6
    And o campo "total" deve ser 12
    And o campo "total_pages" deve ser 2
    And o campo "data[0].first_name" deve ser "George"
    And o campo "data[1].last_name" deve ser "Weaver"
    And o campo "data[5].email" deve ser "tracey.ramos@reqres.in"

  @APITarefa1e2
  Scenario: Validar chamada PUT para atualizar um usuário
    Given que a API está configurada
    When eu faço uma requisição PUT para "/api/users/2" com o payload:
      | name     | job           |
      | morpheus | zion resident |
    Then o status da resposta deve ser 200
    And o campo "name" deve ser "morpheus"
    And o campo "job" deve ser "zion resident"

  @APITarefa1e2
  Scenario: Validar chamada DELETE para excluir um usuário
    Given que a API está configurada
    When eu faço uma requisição DELETE para "/api/users/2"
    Then o status da resposta deve ser 204
