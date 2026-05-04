package HMW_7.Task_2;

public class Main {
    public static void main(String[] args) {
        // Отримуємо єдиного директора
        Director director = Director.getInstance();

        // Використовуємо його з конкретним будівельником
        PassengerCarBuilder builder = new PassengerCarBuilder();

        director.makeSUV(builder);
        Car suv = builder.getResult();
        System.out.println("Збудовано: " + suv);

        // Перевірка на Одинака
        Director secondDirectorReference = Director.getInstance();
        System.out.println("Це один і той самий директор? " + (director == secondDirectorReference));
    }
}