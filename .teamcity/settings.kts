import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.1"

project {

    vcsRoot(HttpsGithubComIyankeBigdataRefsHeadsMaster)

    buildType(Build2)
}

object Build2 : BuildType({
    name = "Build2"

    vcs {
        root(HttpsGithubComIyankeBigdataRefsHeadsMaster)
    }

    steps {
        step {
            type = "ftp-deploy-runner"
            param("jetbrains.buildServer.deployer.username", "jetbrains")
            param("jetbrains.buildServer.deployer.ftp.authMethod", "USER_PWD")
            param("jetbrains.buildServer.deployer.ftp.transferMethod", "BINARY")
            param("jetbrains.buildServer.deployer.sourcePath", "9.png")
            param("jetbrains.buildServer.deployer.targetUrl", "ftp://172.31.131.24:22")
            param("secure:jetbrains.buildServer.deployer.password", "credentialsJSON:3a18efca-ee26-4fc5-ab03-1ba28a703208")
            param("jetbrains.buildServer.deployer.ftp.ftpMode", "ACTIVE")
            param("jetbrains.buildServer.deployer.ftp.securityMode", "1")
        }
    }
})

object HttpsGithubComIyankeBigdataRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/iyanke/bigdata#refs/heads/master"
    url = "https://github.com/iyanke/bigdata"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "iyanke"
        password = "credentialsJSON:be3ba775-e2e3-4e7c-a419-93c1194d42f2"
    }
})
