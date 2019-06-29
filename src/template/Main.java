package template;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
//        coffee.makeCoffee();
        coffee.makeBevarage();
        Tea tea = new Tea();
//        tea.makeTea();
        tea.makeBevarage();
    }
}
//class Coffee {
//    void boilWater() {
//        System.out.println("Boil water");
//    }
//    void addCoffee() {
//        System.out.println("coffee");
//    }
//    void addSugar() {
//        System.out.println("sugar");
//    }
//    void addMilk() {
//        System.out.println("milk");
//    }
//    public void makeCoffee() {
//        boilWater();
//        addCoffee();
//        addSugar();
//        addMilk();
//    }
//}
//class Tea {
//    void boilWater() {
//        System.out.println("Boil water");
//    }
//    void addTea() {
//        System.out.println("tea bag");
//    }
//    void addSugar() {
//        System.out.println("sugar");
//    }
//    void addLemon() {
//        System.out.println("lemon");
//    }
//    public void makeTea() {
//        boilWater();
//        addTea();
//        addSugar();
//        addLemon();
//    }
//}
abstract class Bevarage {
    void boilWater() {
        System.out.println("Boil water");
    }
    abstract void brew();
    void addSugar() {
        System.out.println("sugar");
    }
    abstract void addCondiments();
    public final void makeBevarage() {
        boilWater();
        brew();
        addSugar();
        addCondiments();
        hookMethod();
    }
    void hookMethod() {}
}
class Coffee extends Bevarage {
    void brew() {
        System.out.println("coffee");
    }
    void addCondiments() {
        System.out.println("milk");
    }
}
class Tea extends Bevarage {
    void brew() {
        System.out.println("tea bag");
    }
    void addCondiments() {
        System.out.println("lemon");
    }
    @Override
    void hookMethod() {
        System.out.println("add syrup");
    }
}