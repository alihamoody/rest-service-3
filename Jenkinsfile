pipeline {
    agent {    
        docker {
            image 'maven:3-alpine'
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
                sh 'node --version'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}