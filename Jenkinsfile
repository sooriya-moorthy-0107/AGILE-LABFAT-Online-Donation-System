pipeline {
    agent any

    environment {
        // Replace with your Docker Hub details
        DOCKER_IMAGE = 'sooriya/donation-system'
        DOCKER_TAG = 'latest'
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Uses the repository linked to your Jenkins pipeline job
                checkout scm
            }
        }

        stage('Build and Test (Maven)') {
            steps {
                echo 'Compiling the Java project and running JUnit Validations...'
                script {
                    if (isUnix()) {
                        sh 'mvn clean package'
                    } else {
                        // Jenkins running locally on your Windows machine
                        bat 'mvn clean package'
                    }
                }
            }
        }

        stage('Docker Containerization') {
            steps {
                echo 'Building the Docker Image...'
                script {
                    if (isUnix()) {
                        sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                    } else {
                        bat "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                    }
                }
                
                /* 
                // Uncomment to Push to Docker Hub (Requires Jenkins Credentials)
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
                    if (isUnix()) {
                        sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
                        sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                    } else {
                        bat "echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin"
                        bat "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                    }
                }
                */
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                echo 'Triggering automated Kubernetes Deployment...'
                script {
                    if (isUnix()) {
                        sh 'kubectl apply -f k8s/deployment.yaml'
                        sh 'kubectl apply -f k8s/service.yaml'
                    } else {
                        bat 'kubectl apply -f k8s/deployment.yaml'
                        bat 'kubectl apply -f k8s/service.yaml'
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully! CI/CD finished for Donation System.'
        }
        failure {
            echo 'Pipeline failed. Please check the logs.'
        }
    }
}
