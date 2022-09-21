package com.gmail.kahn.shao.alex.homework.filesio;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Dir implements Serializable {
    @Serial
    private static final long serialVersionUID = -1504307800627918407L;
    private int level;
    private String name;
    private List<Dir> dirs;
    private List<File> files;

    public Dir(String dir) {
        this(new File(dir), 0);
    }

    private Dir(@NotNull File file, int level) {
        this.level = level;
        name = file.getName();
        dirs = new LinkedList<>();
        Arrays.stream(file.listFiles())
                .filter(File::isDirectory)
                .forEach(e -> dirs.add(new Dir(e, level + 1)));
        files = Arrays.stream(file.listFiles())
                .filter(File::isFile)
                .collect(Collectors.toList());
    }

    public void printFiles(@NotNull File file) {
        System.out.println(new Dir(file.getName()).printFilesToString());
    }

    private @NotNull String printFilesToString() {
        var result = new StringBuilder();
        var spaces = new StringBuilder();
        for (int i = 0; i < level; i++) {
            spaces.append("\t");
        }
        result
                .append(spaces)
                .append("[").append(name).append("] (lvl:")
                .append(level).append(")")
                .append(System.lineSeparator());
        dirs.forEach(e -> result.append(e.printFilesToString()));
        files.forEach(e -> result
                .append(spaces).append("\t-")
                .append(e.getName())
                .append(System.lineSeparator()));

        return result.toString();
    }

    public void saveToFile(String filename) {
        try (var fos = new FileOutputStream(filename + ".ser");
             var oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
            oos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Dir readFromFile(String filename) {
        File file = new File(filename + ".ser");
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Dir) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return printFilesToString();
    }
}
