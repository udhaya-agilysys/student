pipeline {
    agent any

    tools {
        maven 'maven_3_9_9'
    }

    stages {
        stage('Build Maven') {
           steps {
               checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/udhaya-agilysys/student']])
               sh 'mvn clean install'
           }
        }
         stage('Build Docker image') {
           steps {
               script {
                   sh 'docker build -t thirunanau/student:latest .'
               }
           }
        }
        stage('Running spring boot application') {
           steps {
               script {
                   sh 'docker run -p 9000:9000 --network -d student thirunanau/student:latest'
               }
           }
         }
         stage('Push Docker image') {
           steps {
               script {
                   withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhub_pwd')]) {
                        sh 'docker login -u thirunanau -p ${dockerhub_pwd} docker.io'
                    }
                    sh 'docker push thirunanau/student:latest'
               }
           }
        }
    }
}