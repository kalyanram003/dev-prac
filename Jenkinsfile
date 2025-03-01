pipeline {
    agent any
    tools {
        maven 'MAVEN_HOME'
    }

    environment {
        IMAGE_NAME = 'kalyanramn/example'  // Your Docker image name
        IMAGE_TAG = 'latest'                // Change tag if needed
        DOCKER_REGISTRY = 'docker.io'       // Change if using AWS ECR, GCR, GHCR
        DOCKER_CREDENTIALS = credentials('jenkins-devops')  // Jenkins credentials ID
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

        stage('Docker Login') {
            steps {
                script {
                    if (isUnix()) {
                        sh "echo ${DOCKER_CREDENTIALS_PSW} | docker login -u ${DOCKER_CREDENTIALS_USR} --password-stdin ${DOCKER_REGISTRY}"
                    } else {
                        bat "echo %DOCKER_CREDENTIALS_PSW% | docker login -u %DOCKER_CREDENTIALS_USR% --password-stdin %DOCKER_REGISTRY%"
                    }
                }
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    if (isUnix()) {
                        sh """
                            docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .
                            docker tag ${IMAGE_NAME}:${IMAGE_TAG} ${DOCKER_REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG}
                            docker push ${DOCKER_REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG}
                        """
                    } else {
                        bat """
                            docker build -t %IMAGE_NAME%:%IMAGE_TAG% .
                            docker tag %IMAGE_NAME%:%IMAGE_TAG% %DOCKER_REGISTRY%/%IMAGE_NAME%:%IMAGE_TAG%
                            docker push %DOCKER_REGISTRY%/%IMAGE_NAME%:%IMAGE_TAG%
                        """
                    }
                }
            }
        }

        stage('Docker Logout') {
            steps {
                script {
                    if (isUnix()) {
                        sh "docker logout"
                    } else {
                        bat "docker logout"
                    }
                }
            }
        }

        stage('Success Stage') {
            steps {
                echo 'Successfully Built and Pushed to Docker Hub!'
            }            
        }
    }
}
