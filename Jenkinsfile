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
                script {
                    def imageName = "jdk-mvn-test:${env.BUILD_ID}"
                    def options = '-v jenkins-mvn-cache:/root/.m2'

                    docker.build(imageName, options).inside {
                        sh 'mvn compile'
                    }
                }
            }
        }
    }
}