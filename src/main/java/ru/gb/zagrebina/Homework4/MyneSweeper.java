package ru.gb.zagrebina.Homework4;


import java.util.Random;
import java.util.Scanner;
public class MyneSweeper {

//final - константы инициализируются вне метода, в классе

    public static final int WIDTH = 10;//ширина игровового поля
    public static final int HEIGHT = 10;//высота
    public static final int MINES_COUNT = 20;//кол-во мин
    public static final int MINE = 1000;//это одна мина
    public static final int EMPTY =0;//это пустое место(где в массиве нули)
    public static final int CELL_CLOSE = 0;//закрытая ячейка
    public static final int CELL_OPEN = 1;//открытая ячейка
    public static final int CELL_FLAG = -1; //ЯЧЕЙКА С ФЛАГОМ
    // почему именно -1? Просто мы так решили. Сами закодировали ячейку
    //сделаем переменные для раскраски цифр в игровом поле
    public static final String ANSI_RESET = "\u001B[0m";//это константа для раскраски
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void main(String [] args){
        boolean userWin =  play();//Alt+enter(метод создался)
        if (userWin){
            System.out.println("Поздравляем с победой!");
        }else {
            System.out.println("БАБАХ");
        }

    }

    public static boolean play() {
        boolean win = true;
        boolean isPassMove;
        int[][] board = generateBoard();//создаем массив, который хранит игровое поле
        int[][] moves = new int[HEIGHT][WIDTH];//массив с ходами игрока
        do {
            isPassMove = move(board, moves);//метод для ходов
            win = isWin(moves);
        } while (isPassMove && !win);//проверяем если пользователь прошел ход и не победил
        return isPassMove;//если прошел все и не подорвался, вернет true
    }

    public static boolean isWin(int[][] moves) {
        int openCell = 0;//считает кол-во открытых ячеек
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (moves[i][j] == CELL_OPEN) {
                    openCell++;
                }
            }
        }
        return openCell + MINES_COUNT == HEIGHT * WIDTH;//если выполнится этоусловие,
        //вернется true, победа
    }

    public static boolean move(int[][] board, int[][] moves) {
        Scanner scanner = new Scanner(System.in);
        printBoard(board, moves);//для добавления второго массива в передаваемые данные: Alt+Enter и добавить
        //для того чтобы сделать ход, запрашиваем строку и столбец
        int row, line;
        while (true){
            System.out.print("Ваш ход (столбец, строка, например А1): ");
            String move = scanner.nextLine();
            row = move.charAt(0) - 'A';//вытаскиваем символ по индексу( отдельно 1 и А)
            line = move.charAt(1) - '0';//символы можно вычетать и прибавлять
            //если вычтем букву, то получим координату(см метод printBoard)
            if (row<WIDTH && row>=0 && line<HEIGHT && line >=0){
                break;//то все в порядке.ВЫходим из бесконечного цикла

            }
            System.out.println("Введите координаты внутри игрового поля");
        }
        //тут проверяем наткнулись ли мы на мину
        if (board[line][row] != MINE){
            moves[line][row] = CELL_OPEN;
            return true;
        }
        return false;
    }

    /*1*/   public static int[][] generateBoard() {
        int[][] board = new int[HEIGHT][WIDTH];//создали. По умолчанию заполняется нулями
        Random random = new Random();//заполним минами
        int mines = 0;//int mines = MINES;
        while (mines< MINES_COUNT){//while (mines>0)
            //мины расставляются по 1 поочереди
            int x, y;//координаты ячейки
            do {
                //границы от 0 до (х)ширины/(у)высоты
                x = random.nextInt(HEIGHT);
                y = random.nextInt(WIDTH);
            } while (board[x][y]==1000);//есть мина или нет
            //крутимся внутри цикла если это верно(если там 1000,то ищем новые числа - координаты, если там не 1000 то вышли
            //из цикла и присвоили туда тысячу
            board[x][y]=1000;
            mines ++;
            //mines = --//затем /увеличиваем /уменьшаем счетчик
        }
//теперь надо раскидать числа, сколько мин окружают каждую ячейку
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j]== MINE){
                    continue;//пропуск и дальше идем к следующей итерации цикла
                }
                int mCount = 0;//колличество мин
                for (int k = i-1; k <=i+1; k++) {
                    for (int l = j-1; l <j+1; l++) {
                        //доюавим проверку невыхода за рамки
                        if (k<0 || k>=HEIGHT || l<0 || l>= WIDTH){
                            continue;
                        }
                        if (board[k][l]==MINE){
                            mCount++;
                        }
                    }

                }
                //после того как мы пробежали эти два цикла(к и л) мы записали кол-во мин в цикл board[i][j]
                board[i][j] = mCount;
            }
        }

        return board;
    }

    public static void printBoard(int[][] board, int[][] moves) {
        //метод, печатает нашу доску для игры
        System.out.print("   ");//печатаем 4 пробела
        for (char i = 'A'; i <'A' + WIDTH; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < HEIGHT; i++) {
            System.out.printf("%3d", i);
            for (int j = 0; j < WIDTH; j++) {
                /*прежде чем ограть. Все поле закрыто и пользовате должен
                 * нажать кнопку для игры. Ниже проверяем закрыто поле или нет*/
                if (moves[i][j]== CELL_CLOSE){
                    System.out.print("[]");//печатаем если поле закрыто
                    continue;
                }
                if (moves[i][j]== CELL_FLAG) {//печатаем флажок, если думаем что там мина

                    System.out.print("P");
                    continue;
                }

                String colorCode = getColorCode(board[i][j]);//вызов метода раскраски
                System.out.print(colorCode);
                if (board[i][j] == EMPTY) {
                    System.out.print(" .");
                } else if (board[i][j] == MINE) {
                    System.out.print(" *");
                } else {
                    System.out.printf("%2d", board[i][j]);//печать числа и сколько на это нужно знаков
                }
                System.out.print(ANSI_RESET);//важно сделать резет чтобы не было все в перемешку
                //это была команда сброс. Чтобы дальше код не печатался этим цветом
            }
            System.out.println();
        }
    }

    public static String getColorCode(int i) {
        switch (i) {
            case EMPTY:
                return ANSI_WHITE;
            case MINE:
                return ANSI_PURPLE;
            case 1:
                return ANSI_BLUE;
            case 2:
                return ANSI_GREEN;
            case 3:
                return ANSI_RED;
            case 4:
                return ANSI_CYAN;
            default:
                return ANSI_YELLOW;
        }
    }
}

