package HMW_7.Task_2;

// Конкретний Будівельник
class PassengerCarBuilder implements CarBuilder {
    private Car car;

    public void reset() { this.car = new Car(); }
    public void setBody(String body) { car.setBodyType(body); }
    public void buildEngine(int hp, double vol, String fuel) { car.setEngine(new Engine(hp, vol, fuel)); }
    public void setTransmission(String type, int gears) { car.setTransmission(type + " " + gears + "-speed"); }
    public void buildWheels(String material, int diameter) { car.setWheels(new Wheels(material, diameter)); }
    public void paint(String color) { car.setColor(color); }
    public Car getResult() { return this.car; }
}