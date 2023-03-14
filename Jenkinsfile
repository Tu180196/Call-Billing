pipeline {

  agent any

  options {
    buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '5')
  }
  tools {
    maven "M3"
  }

  stages {
    stage("Build") {
        steps {
          sh "mvn clean install"
        }
    }
    stage('SonarQube Analysis') {
      environment {
        SCANNER_HOME = tool 'sonar-scanner' 
      }
      steps {
        withSonarQubeEnv(installationName: 'sonar1') { 
          sh "${SCANNER_HOME}/bin/sonar-scanner \
          -Dsonar.projectKey=mobilebilling \
          -Dsonar.projectName=mobilebilling \
          -Dsonar.sources=src \
          -Dsonar.java.binaries=target/classes/ \
          -Dsonar.java.libraries=$HOME/.m2/**/*.jar \
          -Dsonar.exclusions=target/**"

        }
      }
    }

    stage('SQuality Gate') {
      steps {
        timeout(time: 2, unit: 'MINUTES') {
          waitForQualityGate abortPipeline: false
        }	
      }
    }

    stage("Build & push docker image") {
        steps {
            script {
                docker.withRegistry(env.AWS_DOCKER_REGISTRY,env.AWS_DOCKER_CREDENTIAL) {
                    sh "mvn clean package -Pdocker-image,no-scs,no-latest-tag -Ddocker.repo.project=business-dev"
                }
            }
        }
    }

    stage("Deploy service") {
        steps {
            script {
                docker.withRegistry(env.AWS_DOCKER_REGISTRY,env.AWS_DOCKER_CREDENTIAL) {
                    // sh "helmfile -f deployment/helmfile.yaml -l 'stage=dev' sync --skip-deps"
                    sh "kubectl rollout restart deployment mobilebilling"
                }
            }
        }
    }
  }
}
