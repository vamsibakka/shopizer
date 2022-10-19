pipeline {
    agent any
    triggers { pollSCM ('H 17 * * 1-5')}
    stages{
        stage ('clone') {
            steps {
                
                git branch : 'master', url: 'https://github.com/vamsibakka/shopizer.git'
            }
        }
            stage ('merge') {
            steps{
                sh '''
                    git checkout release
                    git merge develop --no-ff
                ''' 
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