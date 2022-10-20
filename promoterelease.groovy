pipeline {
    agent {label 'java_11'}
    triggers { pollSCM ('H 17 * * 1-5')}
    stages{
        stage ('clone') {
            steps {
                
                git branch:'master', url:'https://github.com/vamsibakka/shopizer.git'
            }
        }
            stage ('merge') {
            steps{
            
                    sh 'git checkout develop'
                    sh 'git checkout master'
                    sh 'git branch -a'
                    sh 'git checkout release'
                    sh 'git merge develop --no-ff'
                    sh 'git push -u orogin release'
                
                
            }
        }
        }
}