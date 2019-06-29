package command;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.setCommand(new LightCommand(new Light()));
        button.pressButton();
        button.pressButton();
        button.setCommand(new PlayMusicCommand(new MusicPlayer()));
        button.pressButton();
        button.setCommand(new MakeCoffeeCommand(new CoffeeMachine()));
        button.pressButton();
        button.setCommand(new PlayMusicAndTurnLightOffCommand(new MusicPlayer(), new Light()));
        button.pressButton();
        PhoneCommand phoneCommand = new PhoneCommand(new Phone(), "Mike");
        button.setCommand(phoneCommand);
        button.pressButton();
        phoneCommand.setName("Kent");
        button.pressButton();
    }
}
interface Command {
    void execute();
}
class Button {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
class LightCommand implements Command {

    Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchLight();
    }
}
class PlayMusicCommand implements Command {

    MusicPlayer musicPlayer;

    public PlayMusicCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.playMusic();
    }
}
class MakeCoffeeCommand implements Command {

    CoffeeMachine coffeeMachine;

    public MakeCoffeeCommand(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void execute() {
        coffeeMachine.boiled();
        coffeeMachine.makeCoffee();
    }
}
class PlayMusicAndTurnLightOffCommand implements Command {

    MusicPlayer musicPlayer;
    Light light;

    public PlayMusicAndTurnLightOffCommand(MusicPlayer musicPlayer, Light light) {
        this.musicPlayer = musicPlayer;
        this.light = light;
    }

    @Override
    public void execute() {
        musicPlayer.playMusic();
        if(light.isOn) light.switchLight();
    }
}
class PhoneCommand implements Command {

    Phone phone;
    String name;

    public PhoneCommand(Phone phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        phone.makeCall(name);
    }
}
class Light {
    boolean isOn;
    public void switchLight() {
        this.isOn = !this.isOn;
        System.out.println("light is " + (isOn ? "on" : "off"));
    }
}
class MusicPlayer {
    public void playMusic() {
        System.out.println("play music");
    }
}
class CoffeeMachine {
    public void boiled() {
        System.out.println("boiled");
    }
    public void makeCoffee() {
        System.out.println("makeTea");
    }
}
class Phone {
    public void makeCall(String name) {
        System.out.println("call to " + name);
    }
}