package com.somacode.bootcli.tool

object StringTool {

    fun firstLetterUppercase(str: String?): String {
        if (str == null) return "Error"
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase()
    }

    fun firstLetterLowercase(str: String?): String {
        if (str == null) return "Error"
        return str.substring(0,1).toLowerCase() + str.substring(1).toLowerCase()
    }

    fun createRoute(path: String?, folder: String?, entityName: String?, subfix: String): String {
        return path + "/${folder}/${StringTool.firstLetterUppercase(entityName)}$subfix.kt"
    }

}