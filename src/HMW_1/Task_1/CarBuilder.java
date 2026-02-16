package HMW_1.Task_1;

import java.util.ArrayList;
import java.util.List;

public class CarBuilder {

    public Car build() {
        Engine engine = new Engine();

        List<Wheel> wheels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            wheels.add(new Wheel());
        }

        return new Car(engine, wheels);
    }
}
