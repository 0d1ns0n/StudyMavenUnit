package com.hillel.denisov.homeworks.homeunitmav.notebok;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window  extends JFrame implements ActionListener {
    private static JPanel j = new JPanel();
    private static ArrayList <JButton> list = new ArrayList<>();
    private static int [][] table = new int[20][20];
    private static int lvl = 80;
    public JButton start = new JButton("go");

    public Window(){
        setTitle("menu");
    setSize(680,680);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    start.addActionListener(this);
    j.setLayout(null);
    start.setBounds(340,600,70,30);
    j.add(start);
    add(j);
    fulling(table);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (start.getActionCommand().equals("go") ){

        }
    }

    void clear(){

    }
    static void fulling(int [][] arrays){
        int count = 0;
        for (int i = 0; i < arrays.length ; i++) {
            for (int k = 0; k < arrays[i].length; k++) {
                int a = rand();
                int b = rand();
                if(arrays[a][b] == 0 && count<= lvl) {
                    arrays[a][b] = 999;
                    count++;
                }
                System.out.print("\t"+arrays[i][k]);
            }
        }
            System.out.println();
        }



    static int rand(){

        return (int)(Math.random()* 20);
    }

    public static void main(String[] args) {
        JFrame jFrame = new Window();
        jFrame.setVisible(true);   ммисмчт
    }
}
