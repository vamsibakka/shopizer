pipeline {
    agent any
    triggers { pollSCM ('* 17 * * 1-5')}
    stages{
        stage ('git clone') {
            steps {
                git branch : 'release', url : 'git@github.com:vamsibakka/shopizer.git'
            }
        }
        stage ('merge') {
            steps{
                sh 'git merge develop --no-ff'  // merging the git develop branch to release branch without fastfarward.
                sh 'mvn clean package'
            }
        }
        stage ('junit_testresults') {
            steps {
                junit '**/surefire-reports/*.xml'
            }
        }
        stage ('archives') {
            steps{
                archiveArtifacts artifacts: '**/target/*.jar'
            }
            }
        }
    }