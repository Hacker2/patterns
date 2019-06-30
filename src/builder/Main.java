package builder;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Mike", 22);
        person.print();

        PersonBuilder personBuilder = new PersonBuilderImpl();
        Person2 person2 = personBuilder.setName("Mike").setAge(22).build();
        person2.print();
    }
}
class Person2 {
    String name;
    int age;
    double salary;

    public void print() {
        System.out.println(name + " " + age + " " + salary);
    }
}
interface PersonBuilder {
    PersonBuilder setName(String name);
    PersonBuilder setAge(int age);
    PersonBuilder setSalary(double salary);
    Person2 build();
}
class PersonBuilderImpl implements PersonBuilder {
    Person2 person2 = new Person2();
    public Person2 build() {
        return person2;
    }

    @Override
    public PersonBuilder setName(String name) {
        person2.name = name;
        return this;
    }

    @Override
    public PersonBuilder setAge(int age) {
        person2.age = age;
        return this;
    }

    @Override
    public PersonBuilder setSalary(double salary) {
        person2.salary = salary;
        return this;
    }
}
class Person {
    String name;
    int age;
    double salary;

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(double salary) {
        this.salary = salary;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int age, double salary) {
        this.age = age;
        this.salary = salary;
    }

    public Person(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void print() {
        System.out.println(name + " " + age + " " + salary);
    }
}