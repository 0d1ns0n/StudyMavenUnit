package com.hillel.denisov.homeworks.homeunitmav;
//добавьте метод  который будет считать среднее арифметическое элементов массива FIN
//        сделайте метод который будет принимать на вход двумерную матрицу(двумерный массив)у и проверять является ли она квадратной
//        тестовом классе создайте тестовую матрицу и передайте её в метод тестируемого класса

import java.util.Arrays;
import java.util.Scanner;

public class HomeUnitMVN {
    public static void main(String[] args) {
        int[] array = new int[]{3,5,3,20,6};
        System.out.println(sumElement(array) + "\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("write a NUM\n");
        int a = scanner.nextInt();
        System.out.println("write b NUM\n");
        int b = scanner.nextInt();
        int[][] arrayD = new int[a][b];
        doubleArray(arrayD,a,b);

    }
    static int sumElement(int[] index){
        int countEl = 0;
        int elmnt = 0;
        for (int i = 0; i < index.length; i++) {
            elmnt += index[i];
            countEl++;
        }
        return elmnt/countEl;
    }
    static int doubleArray(int[][] arrays, int a, int b){
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (a%2 == 0 || b%2 == 0){
                    System.out.println("Array " + Arrays.deepToString(arrays) + "DOUBLE");
                } else {
                    System.out.println("NOT DOUBLE");
                }
            }

        }
        return 0;
    }
}
