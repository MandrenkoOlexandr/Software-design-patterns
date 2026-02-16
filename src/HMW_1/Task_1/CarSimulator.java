package HMW_1.Task_1;

public class CarSimulator {
    private CarBuilder carBuilder;
    private Car car;

    public CarSimulator() {
        this.carBuilder = new CarBuilder();
    }

    public void startSimulation() {
        System.out.println("--- Початок симуляції ---");

        this.car = carBuilder.build();

        if (this.car != null) {
            car.drive();
        }
    }

    public static void main(String[] args) {
        CarSimulator simulator = new CarSimulator();
        simulator.startSimulation();
    }
}
