package com.somacode.bootcli.commands

import com.somacode.bootcli.tool.ConsoleTool
import com.somacode.bootcli.tool.FileTool
import picocli.CommandLine.Command

@Command(name = "init")
class InitCommand : Runnable {

    var packageName: String? = ""
    var entityFolder: String? = "entity"
    var serviceFolder: String? = "service"
    var repositoryFolder: String? = "repository"
    var controllerFolder: String? = "controller"


    override fun run() {
        println("What is the name of your project package?")
        packageName = ConsoleTool.printQuestion("[example com.example.project]: ", "$packageName")

        entityFolder = ConsoleTool.printQuestion("What is your entity folder called? [default: entity]: ", "$entityFolder")

        repositoryFolder = ConsoleTool.printQuestion("What is your repository folder called? [default: repository]: ", "$repositoryFolder")

        serviceFolder = ConsoleTool.printQuestion("What is your service folder called? [default: service]: ", "$serviceFolder")

        controllerFolder = ConsoleTool.printQuestion("What is your controller folder called? [default: controller]: ", "$controllerFolder")

        var content = FileTool.getContentFromFile("templates/.bootcli")

        val path = packageName!!.replace(".", "/")
        content = content.replace("{{path}}", "src/main/kotlin/$path/")

        content = content.replace("{{projectPackage}}", "$packageName")
        content = content.replace("{{entityFolder}}", "$entityFolder")
        content = content.replace("{{repositoryFolder}}", "$repositoryFolder")
        content = content.replace("{{serviceFolder}}", "$serviceFolder")
        content = content.replace("{{controllerFolder}}", "$controllerFolder")
        FileTool.createFile(".bootcli", content)
    }
}