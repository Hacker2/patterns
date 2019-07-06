package adapter;


public class Main {
    public static void main(String[] args) {
        FahrenheitTemperature fahrenheitTemperature = new FahrenheitTemperature(100);
        WheatherCast wheatherCast = new WheatherCast();
        wheatherCast.showWheather(fahrenheitTemperature);

        //Europe
        fahrenheitTemperature = new CelsiusTemperature(fahrenheitTemperature);
        wheatherCast.showWheather(fahrenheitTemperature);

        AmericanSocket socket = new SimpleAmericanSocket();
        Radio radio = new Radio();
        EuropeanSocket europeanSocket = new SocketAdapter(socket);
        radio.playMusic(europeanSocket);
    }
}

interface EuropeanSocket {
    void getPower();
}
interface AmericanSocket {
    void getPower();
}
class SimpleAmericanSocket implements AmericanSocket {
    public void getPower() {
        System.out.println("current is 110");
    }
}
class SocketAdapter implements EuropeanSocket {
    AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public void getPower() {
        americanSocket.getPower();
    }
}
class Radio {
    void playMusic(EuropeanSocket europeanSocket) {
        europeanSocket.getPower();
    }
}

class FahrenheitTemperature {

    int temperature;

    public FahrenheitTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
class CelsiusTemperature extends FahrenheitTemperature {

    public CelsiusTemperature(FahrenheitTemperature temperature) {
        super(temperature.getTemperature());
    }

    @Override
    public int getTemperature() {
        return (temperature - 32) * 5/9;
    }
}
class WheatherCast {
    public void showWheather(FahrenheitTemperature temperature) {
        System.out.println("temperature is " + temperature.getTemperature());
    }
}
//class FahrenheitToCelsiusConverter {
//    static int convert(int i) {
//        return (i - 32) * 5/9;
//    }
//}