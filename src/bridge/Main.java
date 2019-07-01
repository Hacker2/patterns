package bridge;

public class Main {
    public static void main(String[] args) {
        Car car = new ToyotaCar();
        car.drive();
        Car car2 = new AudiCar();
        car2.drive();
        Track track = new ToyotaTrack();
        track.drive();

        Vehicle vehicle = new Car2(new Toyota());
        vehicle.drive();
        Vehicle vehicle2 = new Car2(new Audi());
        vehicle2.drive();
        Vehicle vehicle3 = new Track2(new Toyota());
        vehicle3.drive();
    }
}
interface Car { void drive();}
interface Track { void drive();}
interface Bike { void drive();}

class ToyotaCar implements Car {
    @Override
    public void drive() {
        System.out.println("drive car toyota");
    }
}

class ToyotaTrack implements Track {
    @Override
    public void drive() {
        System.out.println("drive track toyota");
    }
}

class AudiCar implements Car {
    @Override
    public void drive() {
        System.out.println("drive car audi");
    }
}

class MercedesCar implements Car {
    @Override
    public void drive() {
        System.out.println("drive car marcedes");
    }
}


abstract class Vehicle {
    Model model;

    public Vehicle(Model model) {
        this.model = model;
    }

    abstract void drive();
}
class Car2 extends Vehicle {
    public Car2(Model model) {
        super(model);
    }

    @Override
    void drive() {
        model.drive("drive car");
    }
}
class Track2 extends Vehicle {
    public Track2(Model model) {
        super(model);
    }

    @Override
    void drive() {
        model.drive("drive track");
    }
}
interface Model { void drive(String str);}
class Toyota implements Model {
    @Override
    public void drive(String str) {
        System.out.println(str + " toyota");
    }
}
class Audi implements Model {
    @Override
    public void drive(String str) {
        System.out.println(str + " audi");
    }
}