pipeline{
  agent { label 'java_11'}
  triggers {cron('30 17 * * 1-5'')}
  stages{
    stage('shopizer'){
       steps{
          git branch:'release', url: 'https://github.com/vamsibakka/shopizer.git'
}
}
 stage('build'){
    steps{
      sh 'mvn package'
      sh '/target/*.war'
}
}
 stage('archive'){
    steps{
        junit '**/surefire-reports/*.xml'
}
}
}
}
