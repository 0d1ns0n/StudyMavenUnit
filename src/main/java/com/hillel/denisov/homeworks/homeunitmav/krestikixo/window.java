package com.hillel.denisov.homeworks.homeunitmav.krestikixo;

import javax.swing.*;
import java.awt.*;

public class window {
    public static void main(String[] args) {
        System.out.println("Start games X0");
        JFrame window = new JFrame("Xor0games");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(500, 600);
        window.setLayout(new BorderLayout());
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        Xor0Game game = new Xor0Game();
        window.add(game);
        System.out.println("Good game, lets to see y");
    }
}
