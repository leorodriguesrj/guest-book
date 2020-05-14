pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    // def imageName = 'jdk-mvn-test'
                    // def options = '-v jenkins-mvn-cache:/root/.m2'
                    // def image = docker.build(imageName)

                    // image.withRun(options).inside {
                    //     image.inside {
                    //         sh 'mvn compile'
                    //     }
                    // }

                    // def imageName = 'jdk-mvn-test'
                    def options = '-v jenkins-mvn-cache:/root/.m2'
                    def image = docker.image(imageName)

                    image.withRun(options) {
                        image.inside {
                            sh 'mvn compile'
                        }
                    }
                }
            }
        }
    }
}