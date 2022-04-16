package ru.gb.zagrebina.homeWork2;

import com.sun.source.tree.IfTree;

public class Task2 {

    public static void main(String[] args) {
        System.out.println(checkSumma(8, 50));
        checkNumber(7);
       System.out.println(numbersSign(-3));
        printYourVersion("Hi! Anything new?", 4);
        System.out.println(Years(1992));
    }

    public static String checkSumma(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return "true";
        } else {
            return "false";
        }
    }

    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Вы ввели положительное число");
        } else {
            System.out.println("Вы ввели отрицательное число");
        }
    }

    public static boolean numbersSign(int num) {
        if (num < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printYourVersion(String words, int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.println(words);
        }
    }

    public static boolean Years(int year) {

        System.out.println("Является ли год Високосным?");
        if (year % 4 ==0) {
            if (year % 100 ==0){
                if (year % 400 ==0){
                    return true;
                }
            }else
                return true;

        }return false;
    }
}






