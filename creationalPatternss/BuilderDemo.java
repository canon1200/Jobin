package creationalPatternss;

// Product
class Computer {
    private String CPU;
    private String RAM;
    private boolean hasGraphicsCard;

    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.hasGraphicsCard = builder.hasGraphicsCard;
    }

    public String toString() {
        return "Computer with " + CPU + ", " + RAM + (hasGraphicsCard ? ", Graphics Card" : "");
    }

    // Builder
    static class ComputerBuilder {
        private String CPU;
        private String RAM;
        private boolean hasGraphicsCard;

        public ComputerBuilder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public ComputerBuilder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public ComputerBuilder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

// Main class
public class BuilderComputerDemo {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.ComputerBuilder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setGraphicsCard(true)
            .build();

        System.out.println(gamingPC);
    }
}
