package HMW_6.Task_2;

// 1. Компонент Двигун з підтримкою прототипу
class Engine implements Cloneable {
    private int power;
    private double volume;
    private String fuelType;

    public Engine(int power, double volume, String fuelType) {
        this.power = power;
        this.volume = volume;
        this.fuelType = fuelType;
    }

    // Геттери/сеттери для демонстрації зміни копії
    public void setPower(int power) { this.power = power; }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Engine(this.power, this.volume, this.fuelType);
        }
    }

    @Override
    public String toString() {
        return String.format("Engine[HP: %d, Vol: %.1f, Fuel: %s]", power, volume, fuelType);
    }
}

