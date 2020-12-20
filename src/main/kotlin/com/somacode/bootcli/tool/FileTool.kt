package com.somacode.bootcli.tool

import org.apache.commons.io.FileUtils
import java.io.File
import java.nio.charset.Charset

object FileTool {

    fun getContentFromFile(path: String): String {
        return javaClass.classLoader.getResource(path).readText()
    }

    fun createFile(path: String, content: String) {
        val file = File(path);
        FileUtils.write(file, content, Charset.defaultCharset())
    }

}