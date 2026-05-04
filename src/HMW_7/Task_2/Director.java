package HMW_7.Task_2;

public class Director {

    // Приватний конструктор — ніхто не може створити об'єкт через new Director()
    private Director() {
        System.out.println("Головний Директор заводу заступив на зміну.");
    }

    // Статичний внутрішній клас, який ініціалізує екземпляр при першому зверненні
    private static class Holder {
        private static final Director INSTANCE = new Director();
    }

    // Глобальна точка доступу до Директора
    public static Director getInstance() {
        return Holder.INSTANCE;
    }

    // Методи конструювання автомобілів
    public void makeSUV(CarBuilder builder) {
        builder.reset();
        builder.setBody("SUV");
        builder.buildEngine(250, 3.0, "Diesel");
        builder.setTransmission("Automatic", 8);
        builder.buildWheels("Alloy", 20);
        builder.paint("Black");
    }

    public void makeCitySedan(CarBuilder builder) {
        builder.reset();
        builder.setBody("Sedan");
        builder.buildEngine(120, 1.6, "Petrol");
        builder.setTransmission("Manual", 5);
        builder.buildWheels("Steel", 15);
        builder.paint("White");
    }
}