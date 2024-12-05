pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Fazendo o checkout do código do repositório...'
                git branch: 'main', credentialsId: 'git-credentials-id', url: 'https://github.com/Elen1809/outsera.git'
            }
        }

        stage('Build and Install Dependencies') {
            steps {
                script {
                    echo 'Instalando dependências...'
                    sh 'mvn clean install'
                }
            }
        }

        stage('API Tests') {
            steps {
                script {
                    echo 'Iniciando testes de API...'
                    sh 'mvn -Dtest=TestRunnerAPI -Dplatform=api test"'
                    archiveArtifacts artifacts: 'target/cucumber-reports/*.json', allowEmptyArchive: true
                }
            }
        }

        stage('E2E Tests') {
            steps {
                script {
                    echo 'Iniciando testes E2E...'
                    sh 'mvn -Dtest=TestRunnerWeb.java -Dplatform=web test"'
                    archiveArtifacts artifacts: 'target/cucumber-reports/*.json', allowEmptyArchive: true
                }
            }
        }

        stage('Mobile Tests') {
            steps {
                script {
                    echo 'Iniciando testes Mobile...'
                    sh 'mvn -Dtest=TestRunnerMobile -Dplatform=android test'
                    archiveArtifacts artifacts: 'target/cucumber-reports/*.json', allowEmptyArchive: true
                }
            }
        }

         stage('Generate Simple Report') {
                    steps {
                        script {
                            echo 'Gerando relatório simples...'
                            sh 'mvn surefire-report:report'
                            archiveArtifacts artifacts: 'target/site/surefire-report.html', allowEmptyArchive: true
                        }
                    }
                }

    post {
        always {
            echo 'Pipeline concluído!'
        }
        success {
            echo 'Pipeline executado com sucesso!'
        }
        failure {
            echo 'Pipeline falhou.'
        }
    }
}