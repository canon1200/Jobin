package structuralPattern;

import java.util.*;

// Component
interface Graphic {
    void draw();
}

// Leaf
class Circle implements Graphic {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("Drawing Circle with color: " + color);
    }
}

// Leaf
class Square implements Graphic {
    private int size;

    public Square(int size) {
        this.size = size;
    }

    public void draw() {
        System.out.println("Drawing Square of size: " + size);
    }
}

// Composite
class GraphicGroup implements Graphic {
    private List<Graphic> elements = new ArrayList<>();

    public void add(Graphic g) {
        elements.add(g);
    }

    public void remove(Graphic g) {
        elements.remove(g);
    }

    public void draw() {
        System.out.println("Drawing Graphic Group:");
        for (Graphic g : elements) {
            g.draw();
        }
    }
}

// Demo
public class CompositeGraphicDemo {
    public static void main(String[] args) {
        // Leaf elements
        Circle redCircle = new Circle("Red");
        Square bigSquare = new Square(10);

        // Composite
        GraphicGroup group = new GraphicGroup();
        group.add(redCircle);
        group.add(bigSquare);

        // Another group
        Circle blueCircle = new Circle("Blue");
        GraphicGroup group2 = new GraphicGroup();
        group2.add(blueCircle);
        group2.add(group);

        // Draw all
        group2.draw();
    }
}
