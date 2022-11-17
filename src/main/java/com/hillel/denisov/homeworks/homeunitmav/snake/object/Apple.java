package com.hillel.denisov.homeworks.homeunitmav.snake.object;

import com.hillel.denisov.homeworks.homeunitmav.snake.SnakeFrame;

public class Apple {
    public int posX;
    public int posY;

    public Apple(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void randomPos() {

        posX = Math.abs((int) (Math.random() * SnakeFrame.WIDTH - 1));
        posY = Math.abs((int) (Math.random() * SnakeFrame.HEIGHT - 1));
    }
}
