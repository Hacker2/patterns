package abstractfactory;


public class Main {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new MercedesFactory();
        Car car = abstractFactory.getCar();
        car.drive();
        Bike bike = abstractFactory.getBike();
        bike.drive();
        abstractFactory = new BmwFactory();
        car = abstractFactory.getCar();
        car.drive();
        bike = abstractFactory.getBike();
        bike.drive();
    }
}
interface Car {
    void drive();
}
interface Bike {
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
class MercedesBike implements Bike {
    public void drive() {
        System.out.println("drive mercedes bike");
    }
}
class BmwBike implements Bike {
    public void drive() {
        System.out.println("drive bmw bike");
    }
}
abstract class AbstractFactory {
    abstract Car getCar();
    abstract Bike getBike();
}
class MercedesFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new Mercedes();
    }

    @Override
    public Bike getBike() {
        return new MercedesBike();
    }
}
class BmwFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new Bmw();
    }

    @Override
    public Bike getBike() {
        return new BmwBike();
    }
}