package com.gmail.kahn.shao.alex.homework.snakegame;

import java.awt.*;
import java.util.Random;

public class Food {
    private final Random RANDOM = new Random();
    private final Image[] IMAGES = new Image[]{
            Toolkit.getDefaultToolkit().createImage("./src/com/gmail/kahn/shao/alex/homework/snakegame/pics/candy01.png"),
            Toolkit.getDefaultToolkit().createImage("./src/com/gmail/kahn/shao/alex/homework/snakegame/pics/candy02.png"),
            Toolkit.getDefaultToolkit().createImage("./src/com/gmail/kahn/shao/alex/homework/snakegame/pics/candy03.png"),
            Toolkit.getDefaultToolkit().createImage("./src/com/gmail/kahn/shao/alex/homework/snakegame/pics/candy04.png"),
            Toolkit.getDefaultToolkit().createImage("./src/com/gmail/kahn/shao/alex/homework/snakegame/pics/candy05.png")
    };
    private Image image;
    private int x;
    private int y;

    public Food() {
        randomizeImage();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void randomizeImage() {
        image = IMAGES[RANDOM.nextInt(IMAGES.length)];
    }

    public void randomizeCoords(int maxX, int maxY, int cellSize) {
        x = RANDOM.nextInt(maxX / cellSize) * cellSize;
        y = RANDOM.nextInt(maxY / cellSize) * cellSize;

    }
}
