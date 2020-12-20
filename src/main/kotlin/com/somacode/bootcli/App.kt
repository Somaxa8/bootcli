package com.somacode.bootcli

import com.somacode.bootcli.commands.MainCommand
import picocli.CommandLine


fun main(args: Array<String>) {
    CommandLine(MainCommand()).execute(*args)
}
