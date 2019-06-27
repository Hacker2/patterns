package strategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        //List<Flyable> cars = new ArrayList<>();
        cars.add(new Toyta(new FlyCar()));
        cars.add(new Ferrary(new FlyCar()));
        cars.add(new Tractor(new NoFly()));
        cars.forEach(Car::fly);
    }
}
abstract class Car {
    Flyable flyable;
    public Car(Flyable flyable) {
        this.flyable = flyable;
    }
    public void fly() {
        flyable.fly();
    }
    public abstract void run();
    public void stop() {
        System.out.println("stop");
    }
    /*public void fly() {
        System.out.println("fly");
    }*/
}
interface Flyable {
    void fly();
}
class FlyCar implements Flyable {
    public void fly() {
        System.out.println("fly");
    }
}
class NoFly implements Flyable {
    public void fly() {
        System.out.println("ca't fly, do nothing");
    }
}
class Toyta extends Car {
    public Toyta(Flyable flyable) {
        super(flyable);
    } //implements Flyable {
    @Override
    public void run() {
        System.out.println("300 km/h");
    }
//    public void fly() {
//        System.out.println("fly");
//    }
}
class Ferrary extends Car {
    public Ferrary(Flyable flyable) {
        super(flyable);
    } //implements Flyable {
    @Override
    public void run() {
        System.out.println("500 km/h");
    }
//    public void fly() {
//        System.out.println("fly");
//    }
}
class Tractor extends Car {
    public Tractor(Flyable flyable) {
        super(flyable);
    }

    @Override
    public void run() {
        System.out.println("50 km/h");
    }
}