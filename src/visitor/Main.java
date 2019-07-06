package visitor;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        AnimalVisitor soundVisitor = new SoundVisitor();
        dog.accept(soundVisitor);

        AnimalVisitor eatVisitor = new EatVisitor();
        dog.accept(eatVisitor);

        Animal tiger = new Tiger();
        tiger.accept(soundVisitor);
    }
}

interface Animal {
    void accept(AnimalVisitor animalVisitor);
}

class Dog implements Animal {
    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.action(this);
    }
}

class Cat implements Animal {
    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.action(this);
    }
}

class Tiger implements Animal {
    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.action(this);
    }
}

interface AnimalVisitor {
    void action(Dog animal);
    void action(Cat animal);
    void action(Tiger animal);
}

class SoundVisitor implements AnimalVisitor {
    @Override
    public void action(Dog animal) {
        System.out.println("wof");
    }
    @Override
    public void action(Cat animal) {
        System.out.println("mao");
    }

    @Override
    public void action(Tiger animal) {
        System.out.println("RRRR");
    }
}

class EatVisitor implements AnimalVisitor {
    @Override
    public void action(Dog animal) {
        System.out.println("eat meat");
    }
    @Override
    public void action(Cat animal) {
        System.out.println("eat fish");
    }

    @Override
    public void action(Tiger animal) {
        System.out.println("eat zebras");
    }

}

//interface Animal {
//    void makeSound();
//    void eat();
//}

//class Dog implements Animal {
//
//    @Override
//    public void makeSound() {
//        System.out.println("wof");
//    }
//
//    @Override
//    public void eat() {
//        System.out.println("eat meat");
//    }
//}
//
//class Cat implements Animal {
//
//    @Override
//    public void makeSound() {
//        System.out.println("mao");
//    }
//
//    @Override
//    public void eat() {
//        System.out.println("eat fish");
//    }
//}