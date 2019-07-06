package momento;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Originator.Memento> savedStates = new ArrayList<>();

        Originator originator = new Originator();
        originator.set("State1");
        originator.set("State2");
        savedStates.add(originator.saveToMemento());
        originator.set("State3");
        savedStates.add(originator.saveToMemento());
        originator.set("State4");

        originator.restoreFromMemento(savedStates.get(0));
        System.out.println(originator.state);
    }
}
class Originator {
    String state;

    public void set(String state) {
        this.state = state;
    }

    public Originator.Memento saveToMemento() {
        return new Originator.Memento(this.state);
    }

    public void restoreFromMemento(Originator.Memento memento) {
        this.state = memento.getSavedState();
    }

    public static class Memento {
        private final String state;

        public Memento(String stateToSave) {
            state = stateToSave;
        }

        private String getSavedState() {
            return state;
        }
    }
}