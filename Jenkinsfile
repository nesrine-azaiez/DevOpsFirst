import java.text.SimpleDateFormat


pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'NesrineBack',
                url : 'https://github.com/nesrine-azaiez/DevOpsFirst.git'
            }
        }
        stage('Testing Maven') {
            steps {
                sh """mvn -version"""
            }
        }

        stage('Date') {
            steps {
                    script {
                        def date = new Date()
                        sdf = new SimpleDateFormat("MM/dd/yyyy")
                            println(sdf.format(date))
                            }
                    }
                        }

        stage('MVN CLEAN'){
            steps{
                sh  'mvn clean'
            }
        }

        stage('MVN COMPILE'){
            steps{
                sh  'mvn compile'
            }
        }


        stage('MVN PACKAGE'){
              steps{
                  sh  'mvn package'
              }
        }

         stage('MVN SONARQUBE'){
               steps{
                  sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
               }
         }

         stage("Test JUnit /Mockito"){
                  steps {
                       sh 'mvn test'
                  }
         }

         stage("nexus deploy"){
              steps{
                   sh 'mvn  deploy'
              }
         }

         stage("Build the package"){
                            steps {
                                sh 'docker-compose up -d --build'
                            }
                        }


        stage('Building image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage('Deploy image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }

    }
}