package com.hillel.denisov.homeworks.homeunitmav.snake;

import com.hillel.denisov.homeworks.homeunitmav.snake.object.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SnakeFrame extends JPanel implements ActionListener {
    public static JFrame jFrame;

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;

    public Snake snake = new Snake(5, 6, 5, 5);

    public static int speed = 10;

    public Timer timer = new Timer(1000 / speed, this);

    public SnakeFrame() {
        timer.start();
    }

    public static void main(String[] args) {
        jFrame = new JFrame("SNAKE SUKA");

        jFrame.setSize(WIDTH * SCALE + 16, HEIGHT * SCALE + 6);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.setResizable(false);

        jFrame.setLocationRelativeTo(null);

        jFrame.add(new SnakeFrame());

        jFrame.setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

        g.setColor(Color.black);
        for (int x = 0; x < WIDTH * SCALE; x += SCALE) {
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }
        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
            g.drawLine(0, y, WIDTH * SCALE, y);
        }

        g.setColor(Color.magenta);
        for (int i = 0; i < snake.length; i++) {
            g.fillRect(snake.snakeX[i] * SCALE, snake.snakeY[i] * SCALE, SCALE, SCALE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        repaint();
    }
}
