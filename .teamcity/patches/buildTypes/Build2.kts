package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.FTPUpload
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.ftpUpload
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build2'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build2")) {
    expectSteps {
        ftpUpload {
            targetUrl = "ftp://172.31.131.24:22"
            securityMode = FTPUpload.SecurityMode.FTPS
            authMethod = usernameAndPassword {
                username = "jetbrains"
                password = "credentialsJSON:3a18efca-ee26-4fc5-ab03-1ba28a703208"
            }
            ftpMode = FTPUpload.FTPMode.ACTIVE
            transferMode = FTPUpload.TransferMode.BINARY
            sourcePath = "9.png"
        }
    }
    steps {
        update<FTPUpload>(0) {
            clearConditions()
            securityMode = FTPUpload.SecurityMode.FTPES
        }
    }
}
