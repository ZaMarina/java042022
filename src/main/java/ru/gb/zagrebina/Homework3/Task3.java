package ru.gb.zagrebina.Homework3;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {

        exchangeNum();
        hundredElements();
        mathOperations();
        drawSquare();
      usersArray(8, 3);
searchMaxMin();
//Задание 7
        int[] task7 = {1, 5, 6, 8, 9, 1, 8, 3, 7, 2, 4, 0};//false
        //int [] task7 = {1,5,6,8,7,1,8,5,7,2,4,0};//true
        equalHalves(task7);
        System.out.println(Arrays.toString(task7));// перервод в строку
        System.out.println(equalHalves(task7));
    //    Задание 8
        int[] task8 = {1, 5, 6, 8, 4};
        mixtArray(task8, 2);

    }

    public static void drawSquare() {
        int[][] square = new int[5][5];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if (i == j || j == (square.length - i - 1)) {
                    System.out.print("0 ");
                } else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void mathOperations() {
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 6) {
                numbers[i] *= 2;
            }
            System.out.print(numbers[i] + " ");
        }
    }

    public static void hundredElements() {
        int[] hundred = new int[100];
        for (int i = 0; i < hundred.length; i++) {
            hundred[i] = i + 1;
            System.out.println(hundred[i]);
        }
    }

    public static void exchangeNum() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(2);
            System.out.print("Элемент " + i + "-" + arr[i] + ";");

            if (arr[i] == 0) {
                arr[i] = 1;
            } else
                arr[i] = 0;
            System.out.println("Элемент " + i + "-" + arr[i] + ";");
        }
    }

    public static int usersArray(int len, int initialValue) {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = initialValue;
            System.out.println(a[i] + " ");
        }
        return a[len];
    }

    public static void searchMaxMin() {
        int[] myArr = new int[10];

        int min = myArr[0];
        int max = myArr[0];
        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = new Random().nextInt(100);
            System.out.print(myArr[i] + " ");
            if (myArr[i] < min) {
                min = myArr[i];
            }
            if (myArr[i] > max) {
                max = myArr[i];
            }

        }
        System.out.println("Minimal: " + min + ". Maximal: " + max);
    }

    public static boolean equalHalves(int[] array) {

        int leftSum = 0, rightSum = 0;

        for (int i = 0; i < array.length; i++) {
            leftSum += array[i];
        }
        for (int j = 0; j < array.length; j++) {
            rightSum += array[j];
            if (rightSum == leftSum - rightSum) {
                return true;

            }

        }

        return false;
    }

    public static void mixtArray(int[] array8, int number) {
        System.out.println(Arrays.toString(array8));
        int last = array8.length - 1;

        for (int i = 0; i < array8.length; i++) {

                array8[i] = array8[i+number];
            }

        System.out.println(Arrays.toString(array8));
            }

//        if (n > 0) {
//            for (int j = 1; j < n; j++) {
//                int element = array8[array8.length - 1];
//                for (int i = 0; i < array8.length - 2; i--) {
//                    array8[i + 1] = array8[i];
//                }
//                array8[0] = element;
//            }
//        } else {
//            for (int j = n; j <= -1; j++) {
//                int element = array8[0];
//                for (int i = 1; i < array8.length; i++) {
//                    array8[i - 1] = array8[i];
//                }
//                array8[array8.length - 1] = element;
//                System.out.println(Arrays.toString(array8));
//
//            }
        }








