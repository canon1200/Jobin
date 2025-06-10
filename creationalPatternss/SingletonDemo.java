package creationalPatternss;

class Logger {
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {}

    // Public method to get the singleton instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to simulate logging
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

// Demo class
public class LoggerSingletonDemo {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("System started");
        logger2.log("User logged in");

        System.out.println("Are both logger instances same? " + (logger1 == logger2));
    }
}
