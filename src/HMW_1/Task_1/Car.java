package HMW_1.Task_1;

import java.util.List;

public class Car {
    private Engine engine;
    private List<Wheel> wheels;

    public Car(Engine engine, List<Wheel> wheels) {
        this.engine = engine;
        this.wheels = wheels;
        System.out.println("Автомобіль зібрано!");
    }

    public void drive() {
        System.out.println("Автомобіль їде...");
    }
}