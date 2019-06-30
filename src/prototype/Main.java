package prototype;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
//        Person person = new Person();
        Address secondAddress = new Address();
        secondAddress.number = 11;
        Person person = new Person(33, secondAddress);
        person.name = "Mike";
        person.age = 22;
        Address address = new Address();
        address.street = "Ocean st";
        address.number = 55;
        person.address = address;
//        Person person2 = person;
//        Person person2 = person.copy();
//        Person person2 = person.clone();
        Person person2 = new Person(person);
        person2.name = "Kent";
        person2.address.number = 66;
        person2.secondAddress.number = 77;
        System.out.println(person.name);
        System.out.println(person.address.number);
        System.out.println(person2.address.number);
        System.out.println(person.height);
        System.out.println(person2.height);
        System.out.println(person.secondAddress.number);
        System.out.println(person2.secondAddress.number);

        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>(list);
    }
}
class Address implements Cloneable {
    String street;
    int number;

    public Address() { }

    public Address(Address address) {
        this.street = address.street;
        this.number = address.number;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address)super.clone();
    }
}
class Person implements Cloneable {
    String name;
    int age;
    Address address;
    final Address secondAddress;
    final int height;

    public Person(int height, Address address) {
        System.out.println("constructor");
        this.height = height;
        this.secondAddress = address;
    }

    public Person(Person person) {
        name = person.name;
        age = person.age;
        address = new Address(person.address);
        secondAddress = new Address(person.secondAddress);
        height = person.height;
    }

//    public Person copy() {
//        Person person = new Person();
//        person.name = name;
//        person.age = age;
//        return person;
//    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person clone = (Person)super.clone();
        clone.address = address.clone();
//        clone.secondAddress = address.clone();
        return clone;
    }
}