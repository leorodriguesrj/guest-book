pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v jenkins-mvn-cache:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn compile'
            }
        }
    }
}