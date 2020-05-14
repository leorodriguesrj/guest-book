pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    def runOptions = '-v jenkins-mvn-cache:/root/.m2'
                    def buildOptions = '-f Dockerfile.agent .'
                    docker.build('jdk13-mvn-test', buildOptions)

                    docker.image('jdk13-mvn-test').withRun(runOptions) {
                        docker.image('jdk13-mvn-test').inside {
                            sh 'mvn compile'
                        }
                    }
                }
            }
        }
    }
}