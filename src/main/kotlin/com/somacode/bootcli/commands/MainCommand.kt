package com.somacode.bootcli.commands

import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command(
        name = "boot",
        subcommands = [
            InitCommand::class,
            EntityCommand::class
        ]
)
class MainCommand : Runnable {

    @Option(names = ["-h", "--hello"])
    var hello: String? = null


    override fun run() {
        println(hello)
    }

}