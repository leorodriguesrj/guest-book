pipeline {
    agent any

    environment {
        VERSION = "${readMavenPom().version}"
        ARTIFACT_ID = "${readMavenPom().artifactId}"
        ARTIFACT_NAME = "${ARTIFACT_ID}-${VERSION}.jar"
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-11.0.8"
    }

    stages {
        stage('Unit Test') {
            steps {
                withMaven(maven: 'local-maven') {
                    bat 'mvn test'
                }
                junit testResults: 'target/surefire-reports/**/*.xml', allowEmptyResults: env.GIT_BRANCH != 'origin/master'
            }
        }

        stage('Build') {
            steps {
                withMaven(maven: 'local-maven') {
                    bat 'mvn package -Dmaven.test.skip=true'
                }
            }
        }

        stage('Make starter script') {
            steps {
                script {
                    def artifactPath = "%basepath%\\${ARTIFACT_NAME}"
                    def lines = [
                        "@echo off",
                        "set SSL_ENABLED=true",
                        "set SSL_KEYSTORE=c:\\Program files\\KeyStores\\osklen.com.br.p12",
                        "set basepath=C:\\RunningServices\\${ARTIFACT_ID}",
                        "set JAVA_HOME=\"C:\\Program Files\\Java\\jdk-11.0.8\"",
                        "set PATH=%JAVA_HOME%\\bin;%PATH%"
                    ]
                    lines << "java -jar ${artifactPath}"
                    writeFile file: 'target\\launch.bat', text: lines.join('\r\n') + "\r\n"
                    echo 'Done making start script.'
                }
            }
        }

        stage('Homologation Deploy') {
            steps {
                sshPublisher(
                    continueOnError: false,
                    failOnError: true,
                    publishers: [
                        sshPublisherDesc(
                            configName: "homologation-admin",
                            verbose: true,
                            transfers: [
                                sshTransfer(
                                    sourceFiles: "target\\*.jar target\\*.bat",
                                    remoteDirectory: ".\\${ARTIFACT_ID}",
                                    removePrefix: "target"
                                )
                            ]
                        )
                    ]
                )
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            deleteDir()
        }
    }
}
