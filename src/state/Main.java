package state;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GumMachine gumMachine = new GumMachine();
        gumMachine.turnCrank();
        gumMachine.insertQuarter();
        gumMachine.insertQuarter();
        gumMachine.turnCrank();

        GumMachine2 gumMachine2 = new GumMachine2();
        gumMachine2.turnCrank();
        gumMachine2.insertQuarter();
        gumMachine2.insertQuarter();
        gumMachine2.turnCrank();
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


class GumMachine2 {
    int count = 10;
    State state = new NoQuarterState();
    void insertQuarter() {
        state.insertQuarter(this);
    }
    void turnCrank() {
        state.turnCrank(this);
    }
}
abstract class State {
    int count = 10;
    abstract void insertQuarter(GumMachine2 gumMachine);
    abstract void turnCrank(GumMachine2 gumMachine);
}
class HasQuarterState extends State {

    @Override
    public void insertQuarter(GumMachine2 gumMachine) {
        System.out.println("you can't insert another quarter");
    }
    @Override
    public void turnCrank(GumMachine2 gumMachine) {
        if(count <= 0) {
            gumMachine.state = new SoldOutState();
        } else {
            System.out.println("selling...");
            gumMachine.state = new NoQuarterState();
            count--;
        }
    }
}
class NoQuarterState extends State {

    @Override
    public void insertQuarter(GumMachine2 gumMachine) {
        if(new Random().nextBoolean()) {
            gumMachine.state = new WinnerState();
            System.out.println("return quarter");
        } else {
            gumMachine.state = new HasQuarterState();
        }
    }
    @Override
    public void turnCrank(GumMachine2 gumMachine) {
        System.out.println("you didn't insert quarter");
    }
}
class SoldOutState extends State {
    @Override
    public void insertQuarter(GumMachine2 gumMachine) {
        System.out.println("no gums");
    }
    @Override
    public void turnCrank(GumMachine2 gumMachine) { }
}
class WinnerState extends State {
    @Override
    public void insertQuarter(GumMachine2 gumMachine) {
        System.out.println("You're winner, you don't have to pay");
    }
    @Override
    public void turnCrank(GumMachine2 gumMachine) {
        System.out.println("you have gum for free");
        gumMachine.state = new NoQuarterState();
    }
}