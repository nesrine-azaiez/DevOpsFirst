import java.text.SimpleDateFormat
pipeline {
environment {
        registry = "ismailbouchahoua/projetdevop"
        registryCredential = 'dckr_pat_DLqYC-nW2MIuIg04Dko4zcf_02w'
        dockerImage = ''
    }

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
                              /* stage("NEXUS"){
                                                                                 steps{
                                                                                         sh 'mvn deploy:deploy-file -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId= -Durl=http://192.168.1.188:8081/repository/deploymentRepo -Dfile=target/docker-spring-boot.jar'
                                                                                         }
                                                                  }*/
                     /* stage("nexus deploy"){
                                  steps{
                                       sh 'mvn  deploy'
                                  }
                             }*/
stage("Test JUnit /Mockito"){
                                 steps {
                                             sh 'mvn test'
                                 }
                           }
                           stage('Building our image') {
                                                           steps {
                                                               script {
                                                               dockerImage = docker.build registry + ":$BUILD_NUMBER"
                                                                       }
                                                           }
                                    }

                                   stage('Deploy our image') {
                                                           steps {
                                                               script {
                                                               docker.withRegistry( '', registryCredential ) {
                                                               dockerImage.push()}
                                                                       }
                                                           }
                                   }
                                   stage('Cleaning up') {
                                                           steps {
                                                           sh "docker rmi $registry:$BUILD_NUMBER"
                                                           }
                                   }
                                  /* stage('Building our image') {
                                                  steps {
                                                                                      sh 'docker build -t ismailbouchahoua/projetdevop'
                                                                                  }
                                                                              }
                                                                               stage('Docker login') {
                                                                                                                   steps {
                                                                                                                     sh 'echo "login Docker ...."'
                                                                                                                     sh 'docker login -u ismailbouchahoua -p bouchahoua99'
                                                                                                                         }
                                                                                                                                     }
                                                                                                                                     stage('Docker push') {
                                                                                                                                                                                                        steps {
                                                                                                                                                                                                                 sh 'echo "Docker is pushing ...."'
                                                                                                                                                                                                                 sh 'docker push ismailbouchahoua/projetdevop:156 '
                                                                                                                                                                                                        }
                                                                                                                                                                                                  }*/
                                  stage('DOCKER COMPOSE') {
                                                          steps {
                                                                      sh 'docker-compose up -d --build'
                                                          }
                                          }

}
}