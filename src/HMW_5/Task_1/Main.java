package HMW_5.Task_1;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        PassengerCarBuilder builder = new PassengerCarBuilder();

        // Виготовляємо SUV
        director.makeSUV(builder);
        Car mySuv = builder.getResult();
        System.out.println(mySuv);

        // Виготовляємо седан
        director.makeCitySedan(builder);
        Car mySedan = builder.getResult();
        System.out.println(mySedan);
    }
}
