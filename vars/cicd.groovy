def gitDownload(repo)
{
  git "https://github.com/intelliqittrainings/${repo}.git"
}
def mavenBuild()
{
   sh 'mvn package'
}
def deployTomcat(ip,context)
{
  deploy adapters: [tomcat9(credentialsId: '44318a32-4d25-463d-a227-59b291422838', path: '', url: 'http://${ip}:8080')], contextPath: '${context}', war: '**/*.war'
}
def runSelenium(jobname)
{
sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
  
