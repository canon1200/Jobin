package behavioralPattern;

// Strategy interface
interface TravelStrategy {
    void travel(String destination);
}

// Concrete Strategies
class BusTravel implements TravelStrategy {
    public void travel(String destination) {
        System.out.println("Travelling to " + destination + " by Bus.");
    }
}

class TrainTravel implements TravelStrategy {
    public void travel(String destination) {
        System.out.println("Travelling to " + destination + " by Train.");
    }
}

// Context
class TravelPlanner {
    private TravelStrategy travelStrategy;

    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void travelTo(String destination) {
        travelStrategy.travel(destination);
    }
}

// Main Class
public class StrategyDemo {
    public static void main(String[] args) {
        TravelPlanner planner = new TravelPlanner();

        planner.setTravelStrategy(new BusTravel());
        planner.travelTo("Bangalore");

        planner.setTravelStrategy(new TrainTravel());
        planner.travelTo("Chennai");
    }
}
