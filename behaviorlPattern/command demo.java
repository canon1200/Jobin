package behavioralPattern;

// Command Interface
interface Command {
    void execute();
}

// Receiver Classes
class Light {
    public void turnOn() {
        System.out.println("Light turned ON");
    }
    public void turnOff() {
        System.out.println("Light turned OFF");
    }
}

class Fan {
    public void turnOn() {
        System.out.println("Fan started");
    }
    public void turnOff() {
        System.out.println("Fan stopped");
    }
}

class AirConditioner {
    public void turnOn() {
        System.out.println("AC turned ON");
    }
    public void turnOff() {
        System.out.println("AC turned OFF");
    }
}

// Concrete Command Classes
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}

class FanOnCommand implements Command {
    private Fan fan;
    public FanOnCommand(Fan fan) { this.fan = fan; }
    public void execute() { fan.turnOn(); }
}

class ACOnCommand implements Command {
    private AirConditioner ac;
    public ACOnCommand(AirConditioner ac) { this.ac = ac; }
    public void execute() { ac.turnOn(); }
}

// Invoker Class
class RemoteControl {
    private Command command;
    public void setCommand(Command command) { this.command = command; }
    public void pressButton() { command.execute(); }
}

// Main Class
public class SmartHomeCommandDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        RemoteControl remote = new RemoteControl();

        remote.setCommand(new LightOnCommand(light));
        remote.pressButton(); // Output: Light turned ON

        remote.setCommand(new FanOnCommand(fan));
        remote.pressButton(); // Output: Fan started

        remote.setCommand(new ACOnCommand(ac));
        remote.pressButton(); // Output: AC turned ON
    }
}
