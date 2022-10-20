pipeline {
    agent {label 'java_11'}
    triggers { pollSCM ('H 17 * * 1-5')}
    stages{
        stage ('clone') {
            steps {
                
                git branch:'master', url:'git@github.com:vamsibakka/shopizer.git'
            }
        }
            stage ('merge') {
            steps{
            
                    sh 'git checkout develop'
                    sh 'git checkout master'
                    hs 'git branch -a'
                    sh 'git checkout release'
                    sh 'git merge develop --no-ff'
                    sh 'git log -3 --oneline'
                
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