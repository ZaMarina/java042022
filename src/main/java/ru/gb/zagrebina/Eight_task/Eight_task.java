package ru.gb.zagrebina.Eight_task;
import java.util.Arrays;

public class Eight_task {
    public static void main(String[] args) {
        int[] task8 = {1, 5, 6, 8, 4};
        mixtArray(task8, 3);

    }

    public static void mixtArray(int[] array8, int number) {
        System.out.println(Arrays.toString(array8));
        if (number > 0) {
            for (int j = 0; j < number; j++) {
                int element = array8[array8.length - 1];
                for (int i = array8.length - 1; i >= 1; i--) {
                    array8[i] = array8[i - 1];
                }
                array8[0] = element;

            }
            System.out.println(Arrays.toString(array8));
        } else {
            for (int j = number; j <= -1; j++) {
                int element = array8[0];
                for (int i = 1; i < array8.length; i++) {
                    array8[i - 1] = array8[i];
                }
                array8[array8.length - 1] = element;

            }
        }
    }
}