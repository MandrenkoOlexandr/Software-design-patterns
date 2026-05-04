package HMW_5.Task_1;

class Car {
    private String bodyType;
    private Engine engine;
    private String transmission;
    private Wheels wheels;
    private String color;

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
    public String toString() {
        return String.format("Car: %s, %s, Trans: %s, Wheels: %s, Color: %s",
                bodyType, engine, transmission, wheels, color);
    }
}
