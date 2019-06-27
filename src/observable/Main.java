package observable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.subscribe(new Subscriber1());
        Subscriber2 observer2 = new Subscriber2();
        subject.subscribe(observer2);
        subject.makeChange("hello");
        subject.unsubscribe(observer2);
        subject.makeChange("world");
    }
}
interface Observer {
    void callMe(String data);
}
class Subscriber1 implements Observer {
    public void callMe(String data) {
        System.out.println(data);
    }
}
class Subscriber2 implements Observer {
    public void callMe(String data) {
        System.out.println(data);
    }
}
class Subject {
    List<Observer> list = new ArrayList<>();
    public void subscribe(Observer observer) {
        this.list.add(observer);
    }
    public void unsubscribe(Observer observer) {
        this.list.remove(observer);
    }
    public void makeChange(String newData) {
        this.list.forEach(observer -> observer.callMe(newData));
    }
}