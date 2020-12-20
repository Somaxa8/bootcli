package com.somacode.bootcli.commands

import com.somacode.bootcli.tool.ConfigTool
import com.somacode.bootcli.tool.FileTool
import com.somacode.bootcli.tool.StringTool
import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command(name = "create")
class EntityCreateCommand : Runnable {

    @Option(names = ["-n", "--name"])
    var entityName: String? = null

    override fun run() {
        if (this.entityName == null) println("Usage: boot entity create <name>")
        val config = ConfigTool.getConfig()

        var entityFile = FileTool.getContentFromFile("templates/Entity.kt.boot")
        entityFile = entityFile.replace("{{packageName}}", "${config?.projectPackage}")
        entityFile = entityFile.replace("{{entityFolder}}", "${config?.entityFolder}")
        entityFile = entityFile.replace("{{EntityName}}", StringTool.firstLetterUppercase(entityName))
        FileTool.createFile(StringTool.createRoute(config?.path, config?.entityFolder, entityName, ""), entityFile)

        var repositoryFile = FileTool.getContentFromFile("templates/Repository.kt.boot")
        repositoryFile = repositoryFile.replace("{{packageName}}", "${config?.projectPackage}")
        repositoryFile = repositoryFile.replace("{{repositoryFolder}}", "${config?.repositoryFolder}")
        repositoryFile = repositoryFile.replace("{{EntityName}}", StringTool.firstLetterUppercase(entityName))
        repositoryFile = repositoryFile.replace("{{entityFolder}}", "${config?.entityFolder}")
        FileTool.createFile(StringTool.createRoute(config?.path, config?.repositoryFolder, entityName, "Repository"), repositoryFile)

        var serviceFile = FileTool.getContentFromFile("templates/Service.kt.boot")
        serviceFile = serviceFile.replace("{{packageName}}", "${config?.projectPackage}")
        serviceFile = serviceFile.replace("{{entityFolder}}", "${config?.entityFolder}")
        serviceFile = serviceFile.replace("{{repositoryFolder}}", "${config?.repositoryFolder}")
        serviceFile = serviceFile.replace("{{serviceFolder}}", "${config?.serviceFolder}")
        serviceFile = serviceFile.replace("{{EntityName}}", StringTool.firstLetterUppercase(entityName))
        serviceFile = serviceFile.replace("{{entityName}}", StringTool.firstLetterLowercase(entityName))
        FileTool.createFile(StringTool.createRoute(config?.path, config?.serviceFolder, entityName, "Service"), serviceFile)

        var controllerFile = FileTool.getContentFromFile("templates/Controller.kt.boot")
        controllerFile = controllerFile.replace("{{packageName}}", "${config?.projectPackage}")
        controllerFile = controllerFile.replace("{{controllerFolder}}", "${config?.controllerFolder}")
        controllerFile = controllerFile.replace("{{controllerFolder}}", "${config?.controllerFolder}")
        controllerFile = controllerFile.replace("{{entityFolder}}", "${config?.entityFolder}")
        controllerFile = controllerFile.replace("{{serviceFolder}}", "${config?.serviceFolder}")
        controllerFile = controllerFile.replace("{{entityName}}", StringTool.firstLetterLowercase(entityName))
        controllerFile = controllerFile.replace("{{EntityName}}", StringTool.firstLetterUppercase(entityName))
        FileTool.createFile(StringTool.createRoute(config?.path, config?.controllerFolder, entityName,"Controller"), controllerFile)
    }

}