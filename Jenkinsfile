pipeline {
    // agent {
    //     dockerfile true
    //     docker {
    //         // image 'maven:3-alpine'
    //         args '-v jenkins-mvn-cache:/root/.m2'
    //     }
    // }
    agent any
    stages {
        stage('Build') {
            steps {
                docker.build("jdk-mvn-test:${env.BUILD_ID}", "-v jenkins-mvn-cache:/root/.m2"). inside {
                    sh 'mvn compile'
                }
            }
        }
    }
}