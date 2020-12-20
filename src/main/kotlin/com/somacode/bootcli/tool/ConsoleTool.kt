package com.somacode.bootcli.tool

object ConsoleTool {
    fun printQuestion(message: String, default: String): String? {
        print(message)
        val value = readLine()
        println("\u000C")
        if (value == "") {
            return default
        }
        return value
    }
}