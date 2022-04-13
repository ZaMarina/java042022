package ru.gb.zagrebina.homework1;

public class HomeWorkApp {

    public static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign(int a, int b){
        int sum = a+b;
        if (sum >=0){
            System.out.println("Сумма: " + sum + ". Сумма положительная");
        } else {
            System.out.println("Сумма: " + sum + ". Сумма отрицательная");
        }
    }

    public static void printColor(){
        int value = 1;

        if (value<=0){
            System.out.println("Red");
        } else if (value>0 && value<=100){
            System.out.println("Yellow");
        }else{
            System.out.println("Green");
        }
    }

    public static void compareNumbers(){
        int a = 5, b = 14;
        if (a >= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void main(String[] args) {
        printThreeWords();

        checkSumSign(8, -17);
        printColor();
        compareNumbers();

    }
}
