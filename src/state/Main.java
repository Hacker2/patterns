package state;

public class Main {
    public static void main(String[] args) {
        GumMachine gumMachine = new GumMachine();
        gumMachine.turnCrank();
        gumMachine.insertQuarter();
        gumMachine.insertQuarter();
        gumMachine.turnCrank();

        State state = new NoQuarterState();
        state.turnCrank();
        state.insertQuarter();
        state.insertQuarter();
        state.turnCrank();
    }
}
enum GumMachineState {
    SOLD_OUT, NO_QUARTER, HAS_QUARTER
    ,WINNER;
}
class GumMachine {
    int count = 10;
    GumMachineState state = GumMachineState.NO_QUARTER;
    void insertQuarter() {
        if (state.equals(GumMachineState.HAS_QUARTER)) {
            System.out.println("you can't insert another quarter");
        } else if(state.equals(GumMachineState.NO_QUARTER)) {
            state = GumMachineState.HAS_QUARTER;
        } else if(state.equals(GumMachineState.SOLD_OUT)) {
            System.out.println("no gums");
        }
        else if (state.equals(GumMachineState.WINNER)) {
            System.out.println("you are winner you don't need quarter");
        }
    }
//    void ejectQuarter() {
//        if (state.equals(GumMachineState.HAS_QUARTER) || state.equals(GumMachineState.SOLD_OUT)) {
//            System.out.println("eject quarter");
//            state = GumMachineState.NO_QUARTER;
//        } else if(state.equals(GumMachineState.NO_QUARTER)) {
//            System.out.println("there is no quarter");
//        }
//    }
    void turnCrank() {
        if (state.equals(GumMachineState.HAS_QUARTER)) {
            if(count <= 0) {
                state = GumMachineState.SOLD_OUT;
            } else {
                System.out.println("selling...");
                state = GumMachineState.NO_QUARTER;
                count--;
            }
        } else if(state.equals(GumMachineState.NO_QUARTER)) {
            System.out.println("you didn't insert quarter");
        }
        else if (state.equals(GumMachineState.WINNER)) {
            System.out.println("selling...");
            state = GumMachineState.NO_QUARTER;
        }
    }
}
abstract class State {
    protected State state;
    int count = 10;
    abstract void insertQuarter();
    abstract void turnCrank();
}
class StateContext extends State {

    @Override
    void insertQuarter() {
        state.insertQuarter();
    }

    @Override
    void turnCrank() {
        state.turnCrank();
    }
}
class HasQuarterState extends State {

    @Override
    public void insertQuarter() {
        System.out.println("you can't insert another quarter");
    }
    @Override
    public void turnCrank() {
        if(count <= 0) {
            state = new SoldOutState();
        } else {
            System.out.println("selling...");
            state = new NoQuarterState();
            count--;
        }
    }
}
class NoQuarterState extends State {

    @Override
    public void insertQuarter() {
        state = new HasQuarterState();
    }
    @Override
    public void turnCrank() {
        System.out.println("you didn't insert quarter");
    }
}
class SoldOutState extends State {
    @Override
    public void insertQuarter() {
        System.out.println("no gums");
    }
    @Override
    public void turnCrank() { }
}


//enum LightStates {
//    ON, OFF
//    , MIDDLE
//}
//class Light {
//    LightStates currentState = LightStates.OFF;
//    boolean lightOn() {
//        if(currentState.equals(LightStates.OFF)) {
//            currentState = LightStates.ON;
//            return true;
//        }
//        return false;
//    }
//    boolean lightOf() {
//        if(currentState.equals(LightStates.ON)) {
//            currentState = LightStates.OFF;
//            return true;
//        }
//        return false;
//    }
//}