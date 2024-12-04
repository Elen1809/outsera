pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', credentialsId: 'git-credentials-id', url: 'https://github.com/usuario/repo.git'
            }
        }

        stage('Parallel Tests') {
            parallel {
                stage('API Tests') {
                    steps {
                        script {
                            echo 'Iniciando testes de API'
                            sh './run-api-tests.sh'
                        }
                    }
                }
                stage('E2E Tests') {
                    steps {
                        script {
                            echo 'Iniciando testes E2E'
                            sh './run-e2e-tests.sh'
                        }
                    }
                }
                stage('Mobile Tests') {
                    steps {
                        script {
                            echo 'Iniciando testes Mobile'
                            sh './run-mobile-tests.sh'
                        }
                    }
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
