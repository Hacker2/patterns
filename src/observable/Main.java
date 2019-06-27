package observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.subscribe(new Subscriber1());
        Subscriber2 observer2 = new Subscriber2();
        subject.subscribe(observer2);
        subject.makeChange("hello");
        subject.unsubscribe(observer2);
        subject.makeChange("world");

        Subject2 subject2 = new Subject2();
        subject2.addObserver(new Subscriber3());
        Subscriber4 subscriber4 = new Subscriber4();
        subject2.setChanged();
        subject2.addObserver(subscriber4);
        subject2.notifyObservers("test string");
        subject2.deleteObserver(subscriber4);
        subject2.notifyObservers("test string");
    }
}
interface MyObserver {
    void callMe(String data);
}
class Subscriber1 implements MyObserver {
    public void callMe(String data) {
        System.out.println(data);
    }
}
class Subscriber2 implements MyObserver {
    public void callMe(String data) {
        System.out.println(data);
    }
}
class Subject {
    List<MyObserver> list = new ArrayList<>();
    public void subscribe(MyObserver myObserver) {
        this.list.add(myObserver);
    }
    public void unsubscribe(MyObserver myObserver) {
        this.list.remove(myObserver);
    }
    public void makeChange(String newData) {
        this.list.forEach(myObserver -> myObserver.callMe(newData));
    }
}
class Subject2 extends Observable {
    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}
class Subscriber3 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}
class Subscriber4 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}