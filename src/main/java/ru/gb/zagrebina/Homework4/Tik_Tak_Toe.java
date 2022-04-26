package ru.gb.zagrebina.Homework4;

import java.util.Random;
import java.util.Scanner;

public class Tik_Tak_Toe {
    public static char[][] field;
    public static final int SIZE = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void main(String[] args) {
        game();
    }
    public static void game() {

        initField();
        printField();

        while (true) {
            gamersMove();
            printField();
            computerMove();
            printField();
            if (checkWin(DOT_X)) {
                System.out.println("Вы победили! Поздравляю!");

                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья");

                break;
            }
            if (checkWin(DOT_O)) {
                System.out.println("Вы победили! Поздравляю!");

                break;
            }

        }
        System.out.println("игра закончена!");
    }

    public static void initField() {
        field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printField() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void gamersMove() {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        do {
            System.out.println("Введите координаты ячейки в формате Х У");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        field[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        //проверяет возможность установки  в ячейку фишки
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE){
            return false;
        }
        return field[y][x] == DOT_EMPTY;

    }

    public static void computerMove() {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Ход компьютера в точку: " + (x + 1) + " " + (y + 1));
        field[y][x] = DOT_O;
    }

    public static boolean isFieldFull() {
        //метод проверяет полное заполнение поля
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkLine(int start_x, int next_x, int start_y, int next_y,char symb) {
        for (int i = 0; i < SIZE; i++) {

                if (field[start_x + i * next_x][start_y + i * next_y] != symb) return false;

                    }
        return true;
    }
    public static boolean checkWin ( char symb){
        for (int i = 0; i < SIZE; i++){

                //строка
                if (checkLine(i, 0, 0, 1, symb)) return true;

                //столбец
                if (checkLine(0, 1, i, 0, symb)) return true;

                //диагонали
                if (checkLine(0, 1, 0, 1, symb)) return true;
                if (checkLine(0, 1, SIZE - 1, -1, symb)) return true;

        }
        return false;
    }

}
