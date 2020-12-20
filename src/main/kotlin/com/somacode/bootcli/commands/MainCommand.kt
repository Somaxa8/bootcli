package com.somacode.bootcli.commands

import picocli.CommandLine.Command

@Command(
        name = "boot",
        subcommands = [
            InitCommand::class,
            EntityCommand::class
        ]
)
class MainCommand : Runnable {

    override fun run() {
        println("boot")
    }

}