package ru.gb.zagrebina.Homework5;


//принципы ООП
//0 - абстракция(отекаем все лишнее)ВЫбираем только то что нам сейас нужно
//1 - Инкапсуляция(сокрытие данных внутри класса)


public class User {//класс(чертеж)->объект
    //класс это чертеж
    //объект это деталь, которая создана по чертежу
    //чтобы ограничить доступ к нашему классу
    //чтобы его никто не сломал. Мы ставим модификатор доступа
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private boolean male;
   //private char male;
    //для того чтобы получить доступ к тому или инному полю пишут специальные методы
//методы публичные

    //конструкторы
    //public User(){} //конструктор по умолчанию
    //конструкторов может быть сколько угодно, должны отличаться параметрами
    //создадим конструтор для всех полей:
    public User(String firstName, String lastName, String email, int age, boolean male){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
       // this.age = age;здесь нет проверки на рамки возраста, поэтому вызовем метод set
       setAge(age);
        this.male = male;
    }
    //не указав эти параметры экземпляр класса мы создать не можем
//создадим еще один конструктор
//    public User(String firstName, String lastName, int age) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = "";
//        setAge(age);
//        this.male = true;
//    }
    public User(String firstName, String lastName, int age) {
      //можно вызывать конструктор внутри конструктора
        //Для этого обращаемся к наиболее полному
        this(firstName, lastName, "", age, true);//вызов this должен быть первой строкой
        System.out.println();
    }
//через цепочку конструкторов проще вносить изменения
    //геттеры - метод для чтения(get)
    // сеттер - метод для записи(set)
//каждый сет  гет только для одного свойства
    //для создания геттера и сеттера нажимаем Ali+ Insert/выбираем геттеры и сетеры
    //выбираем нужные поля, нажимаем ОК

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;//this.Указатель ссылается на текущий экземпляр класса
    //this ссылается на самого себя.
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getFirstName(){
    return firstName;
    }
    public int getAge(){
        return age;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setAge(int age){
        if (age>=0 && age<150) {//на метод наложим ограничение(возраст от 0 до 150)
            this.age = age;
        }
    }
}
