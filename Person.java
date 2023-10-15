//1 уровень сложности: 1)Создать класс Person.

//2) В нем добавить такие поля:

//    а) Имя человека (выбрать самостоятельно тип данных)
//    б) Возраст человека (выбрать самостоятельно тип данных)
//    в) Рост (выбрать самостоятельно тип данных)
//    г) Вес (выбрать самостоятельно тип данных)данных

//3) Добавить конструктор. Можно конструктор сгенерировать, но лучше написать самому

//4) Добавить методы:
//    a) Инфо о человеке. Печатает информацию о человеке - сколько лет, его имя рост и все.
//    б) Идти на работу. Если возраст меньше 18 или больше 70, то пишет "отдыхаю дома", иначе "работаю"

//            5) Создать несколько объектов и заполнить их

//    Доп. задание:

//            6) Добавить поле "money" и создать метод getMoney, который делает return money (То есть просто возвращает количество денег у человека). Мы это тему еще не проходили, поэтому подсказки в личные сообщения просите спокойно.
//            7) перед int money переменной поставить ключевое слово private. Описать, чт
package ConstructorPerson;


import java.util.Objects;

public abstract class Person {
    private String name;
    private int age;
    private double height;
    private double weight;
    private int money;
    private Gender gender;
    private Person dad;

    //конструктор класса Персон


    public Person(String name, int age, double height, double weight, int money, int years, Gender gender, Person dad) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.money = money;
        this.gender = gender;
        this.dad = dad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMoney() {
        return money;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Person getDad() {
        return dad;
    }

    public void setDad(Person dad) {
        this.dad = dad;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " age");
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Money: " + money + " euro");
    }

    public void goToWork() {
        if (age < 18 || age > 70) {
            System.out.println("Relaxing home");

        } else System.out.println("Working");


    }


    public void die() {
    System.out.println("Человек погиб");
}
    public abstract void die(int years);

    public void setMoney(int money) {
        this.money = money;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Double.compare(height, person.height) == 0 && Double.compare(weight, person.weight) == 0 && money == person.money && Objects.equals(name, person.name) && gender == person.gender && Objects.equals(dad, person.dad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height, weight, money, gender, dad);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", money=" + money +
                ", gender=" + gender +
                ", dad=" + dad +
                '}';
    }
}













