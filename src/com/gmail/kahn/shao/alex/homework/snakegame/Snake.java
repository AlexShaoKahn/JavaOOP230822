package com.gmail.kahn.shao.alex.homework.snakegame;

import java.awt.*;

public class Snake {
    private final int MIN_LENGTH = 3;
    private final Image head = Toolkit.getDefaultToolkit().createImage("./src/com/gmail/kahn/shao/alex/homework/snakegame/pics/snakehead.png");
    private final Image body = Toolkit.getDefaultToolkit().createImage("./src/com/gmail/kahn/shao/alex/homework/snakegame/pics/snakebody.png");
    private int length;

    public Snake() {
        length = MIN_LENGTH;
    }

    public int getMinLength() {
        return MIN_LENGTH;
    }

    public void incLength() {
        length++;
    }

    public int getLength() {
        return length;
    }

    public Image getHead() {
        return head;
    }

    public Image getBody() {
        return body;
    }
}
