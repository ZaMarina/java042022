package ru.gb.zagrebina.Homework5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;
//конструктор
    public Employee(String fullName, String position, String email, String telephone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;

    }
    //метод
    public void printInfo() {
        System.out.println("ФИО: " + fullName + ". Должность: " + position + ". e-mail: " + email + ". телефон: " + telephone +". Зарплата: " + salary + ". Возраст: " + age);
    }

    //
    public int getAge() {
        return age;
    }


}
