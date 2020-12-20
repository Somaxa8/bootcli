package com.somacode.bootcli.tool

import com.google.gson.Gson
import com.somacode.bootcli.models.Config
import java.io.FileReader
import java.nio.file.Paths

object ConfigTool {

    fun getConfig(): Config? {
        val gson = Gson()
        val currentPath = Paths.get("").toAbsolutePath().toString();
        return gson.fromJson(FileReader("$currentPath/.bootcli"), Config::class.java)
    }

}