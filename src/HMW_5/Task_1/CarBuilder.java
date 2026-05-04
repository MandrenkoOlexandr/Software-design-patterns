package HMW_5.Task_1;

// Інтерфейс Будівельника
interface CarBuilder {
    void reset();

    void setBody(String body);

    void buildEngine(int hp, double vol, String fuel);

    void setTransmission(String type, int gears);

    void buildWheels(String material, int diameter);

    void paint(String color);

    Car getResult();
}
