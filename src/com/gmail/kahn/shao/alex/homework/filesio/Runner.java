package com.gmail.kahn.shao.alex.homework.filesio;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        String outputDir = ".\\out\\production\\JavaOOP230822\\com\\gmail\\kahn\\shao\\alex\\homework\\filesio\\";
        String outputFilename = "dir";
        String currentDir = ".\\src\\com\\gmail\\kahn\\shao\\alex\\";

        var dir = new Dir(currentDir);
        dir.printFiles(new File(".\\test"));

        dir.saveToFile(outputDir + outputFilename);
        var dirFromFile = dir.readFromFile(outputDir + outputFilename);
        System.out.println(dirFromFile);
    }
}
