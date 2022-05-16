package ru.gb.zagrebina.Homework7;

public class Plate {
    private int food;
    //Cat c;
    public Plate(int food) {
        setFood(food);
    }


    public void decreaseFood(int n){
       // this.food = food;
               if ((food-n)>=0) {
                   food-=n;

        }else {
            System.out.println("В тарелке недостаточно корма");

        }

    }
    public void inPutFood(int add){
        food+=add;
        System.out.println("Добавим в тарелку " + add + " корма");
    }
    public void info() {
        System.out.println("В тарелке " + food + " корма");

    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if (food>=0) {
            this.food = food;
        }else {
            System.out.println("В тарелке недостаточно корма");
        }
    }
}
