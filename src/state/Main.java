package state;

public class Main {
    public static void main(String[] args) {

    }
}
enum LightStates {
    ON, OFF
    , MIDDLE
}
class Light {
    LightStates currentState = LightStates.OFF;
    boolean lightOn() {
        if(currentState.equals(LightStates.OFF)) {
            currentState = LightStates.ON;
            return true;
        }
        return false;
    }
    boolean lightOf() {
        if(currentState.equals(LightStates.ON)) {
            currentState = LightStates.OFF;
            return true;
        }
        return false;
    }
}