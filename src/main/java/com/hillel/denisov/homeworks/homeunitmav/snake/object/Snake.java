package com.hillel.denisov.homeworks.homeunitmav.snake.object;

import com.hillel.denisov.homeworks.homeunitmav.snake.SnakeFrame;

public class Snake {
    public int length = 2;
    public int runBody = 0;
    public int[] snakeX = new int[300];
    public int[] snakeY = new int[300];

    public Snake(int x1, int y1, int x2, int y2) {
        snakeX[0] = x1;
        snakeX[1] = x2;
        snakeY[0] = y1;
        snakeY[1] = y2;
    }

    public void move() {
        for (int i = length; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        if (runBody == 0) {     //UP
            snakeY[0]--;
        }
        if (runBody == 2) {      //DOWN
            snakeY[0]++;
        }
        if (runBody == 1) {      //RIGHT
            snakeX[0]++;
        }
        if (runBody == 3) {      //DOWN
            snakeX[0]--;
        }

        if (snakeY[0] > SnakeFrame.HEIGHT - 1) {
            snakeY[0] = 0;
        }
        if (snakeY[0] < 0) {
            snakeY[0] = SnakeFrame.HEIGHT - 1;
        }
        if (snakeX[0] > SnakeFrame.WIDTH - 1) {
            snakeX[0] = 0;
        }
        if (snakeX[0] < 0) {
            snakeX[0] = SnakeFrame.WIDTH - 1;
        }
    }
}
