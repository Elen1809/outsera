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
                    sh 'mvn clean install -DskipTests'
                }
            }
        }

        stage('API Tests') {
            steps {
                script {
                    echo 'Iniciando testes de API...'
                    sh 'mvn -Dtest=TestRunnerAPI -Dplatform=api test'
                    archiveArtifacts artifacts: 'target/cucumber-reports/*.json', allowEmptyArchive: true
                }
            }
        }

        stage('Generate Simple Report') {
            steps {
                script {
                    echo 'Gerando relatório simples...'
                    sh 'mvn surefire-report:report-only'
                    archiveArtifacts artifacts: 'target/site/surefire-report.html', allowEmptyArchive: true
                }
            }
        }

        stage('Publish HTML Report') {
            steps {
                script {
                    echo 'Publicando relatório HTML do Surefire...'
                    publishHTML(target: [
                        reportDir: 'target/site',
                        reportFiles: 'surefire-report.html',
                        reportName: 'Relatório de Teste Surefire',
                        keepAll: true
                    ])
                }
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
