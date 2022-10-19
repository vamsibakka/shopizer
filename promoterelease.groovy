pipeline {
    agent any
    triggers { pollSCM ('H 17 * * 1-5')}
    stages{
        stage ('clone') {
            steps {
                
                git url:'git@github.com:vamsibakka/shopizer.git'
            }
        }
            stage ('merge') {
            steps{
            
                    sh 'git checkout release'
                    sh 'git merge develop --no-ff'
                
                // sh   // merging the git develop branch to release branch without fastfarward.
                //sh 'mvn clean package'
            }
        }
        //stage ('junit_testresults') {
         //   steps {
           //     junit '**/surefire-reports/*.xml'
            //}
        //}
        //stage ('archives') {
          //  steps{
            //    archiveArtifacts artifacts: '**/target/*.jar'
            //}
            //}
    }
}