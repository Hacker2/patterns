package factorymethod;

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = new MercedesFactory();
        carFactory.createCar();
        carFactory = new BmwFactory();
        carFactory.createCar();
//        MercedesFactory mercedesFactory = new MercedesFactory();
//        mercedesFactory.createCar();
//        BmwFactory bmwFactory = new BmwFactory();
//        bmwFactory.createCar();
    }
}
interface Car {
    void drive();
}
class Mercedes implements Car {
    public void drive() {
        System.out.println("drive mercedes");
    }
}
class Bmw implements Car {
    public void drive() {
        System.out.println("drive bmw");
    }
}
abstract class CarFactory {
    abstract Car getCar();
    public void createCar() {
        Car car = getCar();
        car.drive();
    }
}
class MercedesFactory extends CarFactory {
    protected Car getCar() {
        return new Mercedes();
    }
}
class BmwFactory extends CarFactory {
    protected Car getCar() {
        return new Bmw();
    }
}
//class MercedesFactory {
//    public void createCar() {
//        Car car = new Mercedes();
//        car.drive();
//    }
//}
//class BmwFactory {
//    public void createCar() {
//        Car car = new Bmw();
//        car.drive();
//    }
//}