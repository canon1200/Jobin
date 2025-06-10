package structuralPattern;

// Implementor
interface Device {
    void turnOn();
    void turnOff();
}

// Concrete Implementors
class TV implements Device {
    public void turnOn() {
        System.out.println("TV is turned ON");
    }

    public void turnOff() {
        System.out.println("TV is turned OFF");
    }
}

class Radio implements Device {
    public void turnOn() {
        System.out.println("Radio is turned ON");
    }

    public void turnOff() {
        System.out.println("Radio is turned OFF");
    }
}

// Abstraction
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    abstract void pressPowerButton();
}

// Refined Abstractions
class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    public void pressPowerButton() {
        System.out.println("Basic Remote: Toggling power");
        device.turnOn();
    }
}

class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void pressPowerButton() {
        System.out.println("Advanced Remote: Turning off and on for reset");
        device.turnOff();
        device.turnOn();
    }
}

// Demo
public class BridgeDeviceDemo {
    public static void main(String[] args) {
        Device tv = new TV();
        Device radio = new Radio();

        RemoteControl basicRemote = new BasicRemote(tv);
        RemoteControl advancedRemote = new AdvancedRemote(radio);

        basicRemote.pressPowerButton();
        advancedRemote.pressPowerButton();
    }
}
