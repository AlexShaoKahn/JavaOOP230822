package com.gmail.kahn.shao.alex.homework.snakegame;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameField extends JPanel implements ActionListener {
    private final int FIELD_WIDTH = 250;
    private final int FIELD_HEIGHT = 250;
    private final int CELL_SIZE = 10;
    private final int ALL_CELLS = FIELD_WIDTH * FIELD_HEIGHT / (CELL_SIZE * CELL_SIZE);

    private final int[] X_COORDS = new int[ALL_CELLS];
    private final int[] Y_COORDS = new int[ALL_CELLS];
    private boolean goLeft = false;
    private boolean goRight = true;
    private boolean goUp = false;
    private boolean goDown = false;
    private boolean inGame = true;

    private Timer timer;
    private Snake snake;
    private Food food;

    public GameField() {
        initField();
    }

    private void initField() {
        addKeyListener(new Direction());
        setBackground(Color.lightGray);
        setFocusable(true);

        setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));

        snake = new Snake();
        food = new Food();

        initGame();
    }

    private void initGame() {
        for (int i = 0; i < snake.getLength(); i++) {
            X_COORDS[i] = CELL_SIZE - i * CELL_SIZE;
            Y_COORDS[i] = CELL_SIZE;
        }

        food.randomizeCoords(FIELD_WIDTH, FIELD_HEIGHT, CELL_SIZE);

        int GAME_SPEED = 150;
        timer = new Timer(GAME_SPEED, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        if (inGame) {
            g.drawImage(food.getImage(), food.getX(), food.getY(), this);

            for (int i = 0; i < snake.getLength(); i++) {
                if (i == 0) {
                    g.drawImage(snake.getHead(), X_COORDS[i], Y_COORDS[i], this);
                } else {
                    g.drawImage(snake.getBody(), X_COORDS[i], Y_COORDS[i], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {
            printGameOver(g);
        }
    }

    private void printGameOver(@NotNull Graphics g) {
        String message = "Game Over";
        var font = new Font("Helvetica", Font.BOLD, 14);
        var metrics = getFontMetrics(font);

        g.setColor(Color.black);
        g.setFont(font);
        g.drawString(message, (FIELD_WIDTH - metrics.stringWidth(message)) / 2, FIELD_HEIGHT / 2);
    }

    private void checkFoodEaten() {
        if ((X_COORDS[0] == food.getX()) && (Y_COORDS[0] == food.getY())) {
            snake.incLength();
            food.randomizeCoords(FIELD_WIDTH, FIELD_HEIGHT, CELL_SIZE);
            food.randomizeImage();
        }
    }

    private void go() {
        for (int i = snake.getLength(); i > 0; i--) {
            X_COORDS[i] = X_COORDS[(i - 1)];
            Y_COORDS[i] = Y_COORDS[(i - 1)];
        }

        if (goLeft) {
            X_COORDS[0] -= CELL_SIZE;
        } else if (goRight) {
            X_COORDS[0] += CELL_SIZE;
        } else if (goUp) {
            Y_COORDS[0] -= CELL_SIZE;
        } else if (goDown) {
            Y_COORDS[0] += CELL_SIZE;
        }
    }

    private void collision() {
        for (int i = snake.getLength(); i > 0; i--) {
            if ((i > snake.getMinLength() + 1) && (X_COORDS[0] == X_COORDS[i]) && (Y_COORDS[0] == Y_COORDS[i])) {
                inGame = false;
                break;
            }
        }

        if (Y_COORDS[0] >= FIELD_HEIGHT || Y_COORDS[0] < 0 || X_COORDS[0] >= FIELD_WIDTH || X_COORDS[0] < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkFoodEaten();
            collision();
            go();
        }
        repaint();
    }

    private class Direction extends KeyAdapter {
        @Override
        public void keyPressed(@NotNull KeyEvent e) {
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!goRight)) {
                goLeft = true;
                goUp = false;
                goDown = false;
            } else if ((key == KeyEvent.VK_RIGHT) && (!goLeft)) {
                goRight = true;
                goUp = false;
                goDown = false;
            } else if ((key == KeyEvent.VK_UP) && (!goDown)) {
                goUp = true;
                goRight = false;
                goLeft = false;
            } else if ((key == KeyEvent.VK_DOWN) && (!goUp)) {
                goDown = true;
                goRight = false;
                goLeft = false;
            }
        }
    }
}
