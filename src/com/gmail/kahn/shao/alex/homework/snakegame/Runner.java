package com.gmail.kahn.shao.alex.homework.snakegame;

import javax.swing.*;
import java.awt.*;

public class Runner extends JFrame {
    public Runner() {
        init();
    }

    private void init() {

        add(new GameField());

        setResizable(false);
        pack();

        String ICON_PATH = "./src/com/gmail/kahn/shao/alex/homework/snakegame/pics/icon.jpg";
        setIconImage(Toolkit.getDefaultToolkit().getImage(ICON_PATH));

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame ex = new Runner();
            ex.setVisible(true);
        });
    }
}
