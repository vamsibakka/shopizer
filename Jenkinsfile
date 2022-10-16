pipeline{
  agent { label 'java_11'}
  triggers {pollscm('5 * * * 1-5'')}
  stages{
    stage('shopizer'){
       steps{
          git branch:'develop', url: 'https://github.com/vamsibakka/shopizer.git'
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
