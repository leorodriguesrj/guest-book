pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    def runOptions = '-v jenkins-mvn-cache:/root/.m2'
                    def buildOptions = '-f Dockerfile.agent'
                    def image = docker.build('jdk13-mvn-test', buildOptions)

                    image.withRun(runOptions) {
                        image.inside {
                            sh 'mvn compile'
                        }
                    }
                }
            }
        }
    }
}