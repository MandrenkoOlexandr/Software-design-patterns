package HMW_6.Task_2;

public class PrototypeMain {
    public static void main(String[] args) {
        // Створюємо оригінал за допомогою Директора і Будівельника (з попередньої задачі)
        PassengerCarBuilder builder = new PassengerCarBuilder();
        Director director = new Director();

        director.makeSUV(builder);
        Car originalSuv = builder.getResult();

        // Клонуємо SUV для створення "Sport Edition"
        Car sportSuv = originalSuv.clone();
        sportSuv.setColor("Red"); // Змінюємо колір

        System.out.println("Оригінал: " + originalSuv);
        System.out.println("Клон (Sport): " + sportSuv);
        System.out.println("Це різні об'єкти? " + (originalSuv != sportSuv));
    }
}
