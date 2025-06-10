package structuralPattern;

// Component
interface Pizza {
    String getDescription();
    double cost();
}

// Concrete Component
class MargheritaPizza implements Pizza {
    public String getDescription() { return "Margherita Pizza"; }
    public double cost() { return 6.0; }
}

// Decorator
abstract class PizzaDecorator implements Pizza {
    protected Pizza decoratedPizza;
    public PizzaDecorator(Pizza pizza) {
        this.decoratedPizza = pizza;
    }
}

// Concrete Decorators
class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }
    public String getDescription() {
        return decoratedPizza.getDescription() + ", Extra Cheese";
    }
    public double cost() {
        return decoratedPizza.cost() + 1.0;
    }
}

class OlivesDecorator extends PizzaDecorator {
    public OlivesDecorator(Pizza pizza) {
        super(pizza);
    }
    public String getDescription() {
        return decoratedPizza.getDescription() + ", Olives";
    }
    public double cost() {
        return decoratedPizza.cost() + 0.75;
    }
}

// Demo
public class PizzaDecoratorDemo {
    public static void main(String[] args) {
        Pizza pizza = new MargheritaPizza();
        System.out.println(pizza.getDescription() + " $" + pizza.cost());

        Pizza cheesePizza = new CheeseDecorator(pizza);
        System.out.println(cheesePizza.getDescription() + " $" + cheesePizza.cost());

        Pizza deluxePizza = new OlivesDecorator(cheesePizza);
        System.out.println(deluxePizza.getDescription() + " $" + deluxePizza.cost());
    }
}
