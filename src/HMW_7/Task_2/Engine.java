package HMW_7.Task_2;

// Двигун
class Engine {
    private int power;
    private double volume;
    private String fuelType;

    public Engine(int power, double volume, String fuelType) {
        this.power = power;
        this.volume = volume;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return String.format("Engine[HP: %d, Vol: %.1f, Fuel: %s]", power, volume, fuelType);
    }
}
