package HMW_5.Task_1;

class Director {
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
