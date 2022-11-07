import java.text.SimpleDateFormat
pipeline {
agent any
stages {
    stage('Checkout GIT') {
        steps {
            echo 'Pulling .....';
            git branch : 'ismail-back',
            url : 'https://github.com/nesrine-azaiez/DevOpsFirst.git'

        }
        }
          stage('Date') {
                              steps {
                                   script{
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
                stage('SonarQube stage') {

                            steps {
                            sh'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=bouchahoua99 -e'

                            }
                        }
                 stage('MVN PACKAGE'){
                              steps{
                                  sh  'mvn package'
                              }
                               }
stage("Test JUnit /Mockito"){
                                 steps {
                                             sh 'mvn test'
                                 }
                           }
}
}