package ru.gb.zagrebina.Homework5;

public class Task5 {
    public static void main(String[] args) {

        Employee [] workers = new Employee[5];
        workers[0] = new Employee("Marina Smirnova", "secretary", "MS@.com", "192473649", 30000, 25);
        workers[1] = new Employee("Ivan Petrov", "welder", "IP@.com", "951378955", 35000, 50);
        workers[2] = new Employee("Vera Pavlova", "accountant", "VP@.com", "913572361", 40000, 43);
        workers[3] = new Employee("Aleksey Lesov", "mechanic", "AL@.com", "121531947", 37000, 36);
        workers[4] = new Employee("Oleg Rublev", "director", "OR@.com", "715896341", 70000, 41);


for (int i =0; i< workers.length;i++){
    if (workers[i].getAge()>40){
        workers[i].printInfo();
    }
}
    }
}
