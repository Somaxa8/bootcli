package com.somacode.bootcli.commands

import com.somacode.bootcli.tool.FileTool
import picocli.CommandLine.Command

@Command(
        name = "entity",
        subcommands = [EntityCreateCommand::class]
)
class EntityCommand : Runnable {

    override fun run() {
        var content = FileTool.getContentFromFile("templates/entityCreateCommand.txt")
        println(content)
    }

}