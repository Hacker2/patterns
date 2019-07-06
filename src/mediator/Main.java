package mediator;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Chat chat = new ChatImpl();
        Colleague colleague = new ColleagueImpl(chat, "first");
        Colleague colleague1 = new ColleagueImpl(chat,"second");
        Colleague colleague2 = new ColleagueImpl(chat,"third");
        chat.addColleague(colleague);
        chat.addColleague(colleague1);
        chat.addColleague(colleague2);
        colleague.sendMessage("hello world");
    }
}
interface Chat {
    void sendMessage(String message, Colleague colleague);
    void addColleague(Colleague colleague);
}
class ChatImpl implements Chat {

    List<Colleague> colleagues = new ArrayList<>();

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague me) {
        for(Colleague colleague: colleagues) {
            if(colleague != me) {
                colleague.printMessage(message);
            }
        }
    }
}

abstract class Colleague {
    Chat chat;
    String name;

    public Colleague(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    abstract void sendMessage(String message);
    abstract void printMessage(String message);
}
class ColleagueImpl extends Colleague {

    public ColleagueImpl(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void printMessage(String message) {
        System.out.println(name + " " + message);
    }
}