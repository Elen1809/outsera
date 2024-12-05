Os vídeos das execuções e outras evidências estão disponíveis no Google Drive:
https://drive.google.com/drive/folders/1c7aHI5OGjiBOzahzNklP9BsjLpfVisKm?usp=drive_link

Projeto Desenvolvido no macOS

Nome do Produto: macOS
Versão: 15.0.1
Build: 24A348
Requisitos para o Funcionamento do Projeto

Drivers de Navegador: Instale o ChromeDriver ou GeckoDriver (Firefox) para a execução de testes web e configure o caminho correto.
APK Android: Instale o APK necessário para rodar testes mobile, juntamente com as demais capabilities.
Configuração de Properties: Configure corretamente os arquivos properties com os dados necessários para a execução.
Evidências das Execuções


Descrição do Framework
Framework desenvolvido do zero para os exercícios propostos pela Outsera.

Testes Automatizados Implementados

Testes de Carga

Ferramenta utilizada: JMeter (Desktop).
Evidências disponíveis no link fornecido acima.
Relatório gerado em formato HTML, com as configurações detalhadas para 500 usuários simultâneos durante 5 minutos.
Testes de API

Ferramentas utilizadas: Cucumber + RestAssured.
Evidências disponíveis no Google Drive.
Testes End-to-End (E2E)

Ferramentas utilizadas: Cucumber + Selenium.
Evidências disponíveis no Google Drive.
Testes para Aplicativos Móveis

Ferramentas utilizadas: Cucumber + Appium (somente para Android).
Evidências e o APK necessário estão disponíveis no Google Drive.
Integração e CI/CD

Configuração realizada no Jenkins local utilizando o arquivo Jenkinsfile com as configurações necessárias.
Como o GitHub exige um Jenkins exposto na rede para configurar via webhook e realizar builds automáticas, optei por executar manualmente no próprio Jenkins para não expor minha instância local.
O vídeo no Google Drive demonstra o Jenkins rodando via disparo manual, bem como os relatórios gerados conforme solicitado.