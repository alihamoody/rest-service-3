pipeline {
    agent {    
        docker {
            image 'maven:3.6.1-jdk-13-alpine'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Example Stage') {
            steps {
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn --version'
                sh 'unset MAVEN_CONFIG && ./mvnw clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'unset MAVEN_CONFIG && ./mvnw test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'docker build -t bootcamp-0-rest-service .'
                sh 'docker run -p 8081:8081 bootcamp-0-rest-service'

            }
        }
    }
}