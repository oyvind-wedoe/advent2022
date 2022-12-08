package com.oyvind.advent2022.service

import org.springframework.stereotype.Service

@Service
class Day7Service {

    data class Directory(
        val parent: Directory?,
        val name: String,
        var directories: MutableList<Directory> = mutableListOf(),
        var files: MutableList<File> = mutableListOf(),
    ) {
        fun findDirectory(name: String): Directory {
            return directories.find { it.name == name }!!
        }

        fun size(): Int {
            return files.sumOf { it.size } + directories.sumOf { it.size() }
        }
    }

    var directorySizes = mutableListOf<Int>()

    data class File(
        val name: String,
        val size: Int,
    )

    lateinit var root: Directory

    fun a(input: String): Int {
        directorySizes = mutableListOf()
        root = Directory(
            parent = null,
            name = "/",
            directories = mutableListOf(),
            files = mutableListOf(),
        )


        val firstInput = input.substring(startIndex = 0, endIndex = input.indexOf("\n"))
        val restInput = input.substring(firstInput.length + 1)

        handleInput(restInput, root)

        directorySizes.sort()

        return directorySizes.sumOf {
            if (it <= 100000) it else 0
        }
    }

    fun b(input: String): Int {
        a(input)
        val totalSpace = 70000000
        val requiredFreeSpace = 30000000
        val currentUsedSpace = root.size()
        val currentUnusedSpace = totalSpace - currentUsedSpace
        val requiredDeletion = requiredFreeSpace - currentUnusedSpace
        return directorySizes.first { it > requiredDeletion }
    }

    private fun handleInput(input: String, currentDirectory: Directory) {
        if (input.isEmpty()) {
            calculateDirectorySize(currentDirectory)
            return
        }
        val splitInput = input.split("\n", limit = 2)
        val currentLine = splitInput.first()
        val restInput = splitInput.last()

        val currentCommand = currentLine.substring(0, 4)

        when (currentCommand) {
            "$ ls" -> {
                listDirectory(restInput, currentDirectory)
            }

            "$ cd" -> {
                changeDirectory(currentLine, restInput, currentDirectory)
            }

            else -> {
                error("wrong input")
            }
        }
    }

    private fun changeDirectory(
        currentLine: String,
        restInput: String,
        currentDirectory: Directory,
    ) {
        val directoryName = currentLine.substring(5)
        if (directoryName == "..") {
            calculateDirectorySize(currentDirectory)
            handleInput(restInput, currentDirectory.parent!!)
            return
        }
        val newDirectory = currentDirectory.findDirectory(directoryName)
        handleInput(restInput, newDirectory)

    }

    private fun calculateDirectorySize(currentDirectory: Directory) {
        directorySizes.add(currentDirectory.size())
    }

    private fun listDirectory(input: String, currentDirectory: Directory) {
        val splitInput = input.split("\n$", limit = 2)
        val listElements = splitInput.first().lines()
        listElements.forEach { line ->
            if (line.trim().substring(0, 3) == "dir") {
                createDirectory(line, currentDirectory)
            } else {
                createFile(line, currentDirectory)
            }
        }
        if (splitInput.size != 1) {
            handleInput(
                input.substring(startIndex = splitInput.first().length + 1),
                currentDirectory,
            )
        } else {
            calculateDirectorySize(currentDirectory)
            handleInput("", root)
        }

    }

    private fun createDirectory(line: String, currentDirectory: Directory) {
        val directoryName = line.split(" ").last()
        currentDirectory.directories.add(Directory(parent = currentDirectory, name = directoryName))
    }

    private fun createFile(line: String, currentDirectory: Directory) {
        val splitLine = line.split(" ")
        val fileSize = splitLine.first()
        val fileName = splitLine.last()
        currentDirectory.files.add(File(name = fileName, size = fileSize.toInt()))
    }
}