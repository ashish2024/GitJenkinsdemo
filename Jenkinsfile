pipeline {
    agent any

    environment {
        // Define variables (optional)
        DOCKER_IMAGE = 'ashish2024/blogservice:latest'  // Replace with your Docker Hub username/repository if you plan to push
        MYSQL_PASSWORD = 'root'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from your GitHub repository
                git branch: 'main', url: 'https://github.com/ashish2024/GitJenkinsdemo.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image for the Spring Boot app using Dockerfile
                    sh 'docker build -t ${DOCKER_IMAGE} .'
                }
            }
        }

        stage('Run Docker Compose') {
            steps {
                script {
                    // Run Docker Compose to start the containers for the app and MySQL
                    sh 'docker-compose -f docker-compose.yml up -d --build'
                }
            }
        }

        stage('Test Application') {
            steps {
                script {
                    // Test if the application is running by hitting the REST API (example: http://localhost:1010)
                    sh 'curl http://localhost:1010'
                }
            }
        }

        stage('Cleanup') {
            steps {
                script {
                    // Bring down the containers after testing
                    sh 'docker-compose down'
                }
            }
        }
    }

    post {
        always {
            // Clean up Docker system to free up space
            sh 'docker system prune -f'
        }
    }
}
