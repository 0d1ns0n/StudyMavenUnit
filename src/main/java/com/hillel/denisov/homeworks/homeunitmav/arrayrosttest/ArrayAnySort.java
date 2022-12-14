package com.hillel.denisov.homeworks.homeunitmav.arrayrosttest;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAnySort {
    public static void main(String[] args) {

        int[] array = new int[10];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = count++;
        }
        System.out.println(Arrays.toString(array));
        bubbleSort(array);


    }

    static void bubbleSort2(int[] array) {
        int countIt = 0;
        for (int i = 0; i < array.length - 1; i++) {
            countIt++;
            for (int j = 0; j < array.length - 1 - i; j++) {
                countIt++;
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] =tmp;
                }
            }
        }
        System.out.println("Count: " + countIt);
        System.out.println(Arrays.toString(array));
    }

    static void bubbleSort(int[] array) {
        int countIterations = 0;
        boolean sortArray = false;
        while (!sortArray) {
            countIterations++;
            sortArray = true;
            for (int i = 0; i < array.length - 1; i++) {
                countIterations++;
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    sortArray = false;
                }
            }
        }
        System.out.println("Iterations: " + countIterations);
        System.out.println(Arrays.toString(array));

    }

    static void squareArray() {
        int[] array = new int[]{3, 5, 3, 20, 6};
        System.out.println(sumElement(array) + "\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("write a NUM\n");
        int a = scanner.nextInt();
        System.out.println("write b NUM\n");
        int b = scanner.nextInt();
        int[][] arrayD = new int[a][b];
        doubleArray(arrayD, a, b);
    }

    static int sumElement(int[] index) {
        int countEl = 0;
        int elmnt = 0;
        for (int i = 0; i < index.length; i++) {
            elmnt += index[i];
            countEl++;
        }
        return elmnt / countEl;
    }

    static int doubleArray(int[][] arrays, int a, int b) {
        int ind = 0;
        for (int i = 1; i <= arrays.length - 1; i++) {
            for (int j = 1; j <= arrays[i].length - 1; j++) {
                arrays[i][j] = ind++;
                System.out.print(arrays[i][j] + "\t|\t");
            }
            System.out.println("");
        }
        if (a % b == 0) {
            System.out.println("This a array Square");
        } else {
            System.out.println("no FUCK OFF");
        }
        return 0;
    }
}
