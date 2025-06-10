package behavioralPattern;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface WeatherStation {
    void registerDevice(DisplayDevice d);
    void removeDevice(DisplayDevice d);
    void notifyDevices(String weatherUpdate);
}

// Observer interface
interface DisplayDevice {
    void update(String weatherUpdate);
}

// Concrete Subject
class WeatherDataCenter implements WeatherStation {
    private List<DisplayDevice> devices = new ArrayList<>();

    public void registerDevice(DisplayDevice d) {
        devices.add(d);
    }

    public void removeDevice(DisplayDevice d) {
        devices.remove(d);
    }

    public void notifyDevices(String weatherUpdate) {
        for (DisplayDevice d : devices) {
            d.update(weatherUpdate);
        }
    }
}

// Concrete Observers
class PhoneDisplay implements DisplayDevice {
    public void update(String weatherUpdate) {
        System.out.println("Phone display: Weather is now " + weatherUpdate);
    }
}

class SmartWatchDisplay implements DisplayDevice {
    public void update(String weatherUpdate) {
        System.out.println("Smartwatch display: Weather update - " + weatherUpdate);
    }
}

// Main class
public class WeatherObserverDemo {
    public static void main(String[] args) {
        WeatherDataCenter station = new WeatherDataCenter();

        DisplayDevice phone = new PhoneDisplay();
        DisplayDevice watch = new SmartWatchDisplay();

        station.registerDevice(phone);
        station.registerDevice(watch);

        station.notifyDevices("Sunny 32°C");
        station.notifyDevices("Rainy 24°C");
    }
}
