pipeline {
    agent any
    tools {
        maven 'MAVEN_HOME'
    }

    environment {
        IMAGE_NAME = 'kalyanramn/dev-prac'  
        IMAGE_TAG = 'latest'               
        DOCKER_REGISTRY = 'docker.io'        
    }

    stages {
        stage('Welcome Stage') {
            steps {
                echo 'Welcome to Jenkins Pipeline'
            }            
        }

        stage('Clean Stage') {
            steps {
                bat 'mvn clean'
            }            
        }

        stage('Build Stage') {
            steps {
                bat 'mvn install'
            }            
        }

        stage('Test Stage') {
            steps {
                bat 'mvn test'
            }            
        }

        stage('Java Version Check') {
            steps {
                bat 'java --version'
            }            
        }

        stage('Success Stage') {
            steps {
                echo 'Successfully Built and Pushed to Docker Hub!'
            }            
        }
    }
}
