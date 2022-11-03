package com.hillel.denisov.homeworks.homeunitmav.krestikixo;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class test extends JComponent {
    int[][] arrayFin;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[][] arrays = new int[3][3];
//        System.out.println("_________");
//        int count = 0;
//        for (int i = 0; i <= arrays.length - 1; i++) {
//            for (int j = 0; j <= arrays[i].length - 1; j++) {
//                arrays[i][j] = count++;
//                System.out.print("|" + arrays[i][j] + "|");
//            }
//            System.out.println();
//        }
//        System.out.print("_________");
//        int[][] array = new int[3][3];
//    //    arrays[0][0] = "x";
//        System.out.println();
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.print("|" + array[i][j] + "|");
//            }
//            System.out.println();
//        }
//    }
//    static String check(Scanner sc){
//        while(true){
//            System.out.println("Write your charter");
//            if(sc.hasNext("x") || sc.hasNext("0")){
//                return sc.nextLine();
//            }else {
//                System.out.println("wrong, only charter x or 0");
//                sc.next();
//            }
//        }
//    }
//    static void table(){
//        int[][] arrays = new int[3][3];
//        System.out.println("_________");
//        int count = 0;
//        for (int i = 0; i <= arrays.length - 1; i++) {
//            for (int j = 0; j <= arrays[i].length - 1; j++) {
//                arrays[i][j] = count++;
//                System.out.print("|" + arrays[i][j] + "|");
//            }
//            System.out.println();
//        }
//        System.out.print("_________");
//
//
//    }
//    static String switches(Scanner sc,int [][] array){
//        while (true){
//            System.out.println("Gamer, write your symbol on table 0 - 8");
//            switch(sc.nextInt()){
//                case 0 -> {array [1][1] = Integer.parseInt("x");
//                }
//                case 1 -> {}
//                case 2 -> {}
//                case 3 -> {}
//                case 4 -> {}
//                case 5 -> {}
//                case 6 -> {}
//                case 7 -> {}
//                case 8 -> {}
//            }
//        }
//    }
public static void main(String[] args) {

    int[][] array = new int[3][3];
    for (int i = 0; i < 3; i++) {
            array[i][i] =9;
            array[i][2-i] = 5;
            System.out.print(array[i].toString()+ "\t");
    }


}
}
