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
    }

    post {
        always {
            echo 'Pipeline concluído!'
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            echo 'Pipeline executado com sucesso!'
        }
        failure {
            echo 'Pipeline falhou.'
        }
    }
}
