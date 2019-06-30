package adapter;


public class Main {
    public static void main(String[] args) {
        FahrenheitTemperature fahrenheitTemperature = new FahrenheitTemperature(100);
        WheatherCast wheatherCast = new WheatherCast();
        wheatherCast.showWheather(fahrenheitTemperature);

        //Europe
        fahrenheitTemperature = new CelsiusTemperature(fahrenheitTemperature);
        wheatherCast.showWheather(fahrenheitTemperature);
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