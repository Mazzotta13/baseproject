pipeline {
  agent any
  stages {
    stage('Starting ') {
      steps {
        echo 'Starting'
      }
    }

    stage('Shell scripting') {
      steps {
        sh 'echo \'Shell scripting test\''
      }
    }

    stage('Build') {
      steps {
        sh 'sh \'mvn -B -DskipTests clean package\' '
      }
    }

    stage('send email') {
      steps {
        mail(subject: 'pipeline test', body: 'pipeline test baseproject success', to: 'mazzottaalessio93@gmail.com')
      }
    }

  }
}