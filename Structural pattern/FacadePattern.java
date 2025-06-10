package structuralPattern;

// Subsystem classes
class TV {
    public void on() { System.out.println("TV is turned ON"); }
    public void setInput(String input) { System.out.println("TV input set to " + input); }
}

class SoundSystem {
    public void on() { System.out.println("Sound system is ON"); }
    public void setVolume(int level) { System.out.println("Volume set to " + level); }
}

class Lights {
    public void dim() { System.out.println("Lights are dimmed"); }
}

// Facade
class HomeTheaterFacade {
    private TV tv;
    private SoundSystem sound;
    private Lights lights;

    public HomeTheaterFacade() {
        tv = new TV();
        sound = new SoundSystem();
        lights = new Lights();
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch: " + movie);
        lights.dim();
        tv.on();
        tv.setInput("HDMI");
        sound.on();
        sound.setVolume(10);
        System.out.println(movie + " is now playing...");
    }
}

// Demo
public class HomeTheaterFacadeDemo {
    public static void main(String[] args) {
        HomeTheaterFacade theater = new HomeTheaterFacade();
        theater.watchMovie("Inception");
    }
}
