package HMW_6.Task_2;

// 3. Клас Автомобіль з підтримкою глибокого клонування
class Car implements Cloneable {
    private String bodyType;
    private Engine engine;
    private String transmission;
    private Wheels wheels;
    private String color;

    // Конструктор за замовчуванням
    public Car() {
    }

    // Сетери для Будівельника
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Car clone() {
        try {
            Car clonedCar = (Car) super.clone();
            // КРИТИЧНО: Глибоке копіювання складних об'єктів
            if (this.engine != null) {
                clonedCar.setEngine(this.engine.clone());
            }
            if (this.wheels != null) {
                clonedCar.setWheels(this.wheels.clone());
            }
            return clonedCar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Не повинно статися
        }
    }

    @Override
    public String toString() {
        return String.format("Car: %s, %s, Trans: %s, Wheels: %s, Color: %s",
                bodyType, engine, transmission, wheels, color);
    }
}
