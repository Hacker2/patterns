package facade;

public class Main {
    public static void main(String[] args) {
        LivingRoom livingRoom = new LivingRoom();
        livingRoom.pressButton();

        BadroomRoom badroomRoom = new BadroomRoom();
        badroomRoom.pressButton();
    }
}
class Tv {
    void playChannel(String channel) {
        System.out.println("play channel " + channel);
    }
}
class AirConditioning {
    void setTemperature(String temperature) {
        System.out.println("set temperature " + temperature);
    }
}
class Light {
    void turnLight() {
        System.out.println("run light");
    }
}
class ButtonFacade {
    Tv tv = new Tv();
    AirConditioning airConditioning = new AirConditioning();
    Light light = new Light();
    void pressButton(String channel, String temperature) {
        light.turnLight();
        tv.playChannel(channel);
        airConditioning.setTemperature(temperature);
    }
}
//class Room {
//    Tv tv = new Tv();
//    AirConditioning airConditioning = new AirConditioning();
//    Light light = new Light();
//}
//class LivingRoom extends Room {
class LivingRoom {
    ButtonFacade buttonFacade = new ButtonFacade();
    void pressButton() {
        buttonFacade.pressButton("5", "20");
//        light.turnLight();
//        tv.playChannel("5");
//        airConditioning.setTemperature("20");
    }
}
//class BadroomRoom extends Room {
class BadroomRoom {
    ButtonFacade buttonFacade = new ButtonFacade();
    void pressButton() {
        buttonFacade.pressButton("10", "30");
//        light.turnLight();
//        tv.playChannel("10");
//        airConditioning.setTemperature("30");
    }
}