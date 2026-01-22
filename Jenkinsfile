pipeline{
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Naglevivek/SpringBootDeployment']])
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    sh 'docker build -t vivek708/devops-integration:latest .'
                }
            }
        }
        stage('Push image to hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'DOCKERHUB_PWD')]) {
                        sh """
                          printf '%s' "\$DOCKERHUB_PWD" | docker login -u vivek708 --password-stdin
                          docker push vivek708/devops-integration:latest
                        """
                    }
                }
            }
        }
    }
}
