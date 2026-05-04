package HMW_6.Task_1;

public class Main {
    public static void main(String[] args) {
        BiQuadraticEquation original = new BiQuadraticEquation(1, -5, 4, "x^4 - 5x^2 + 4 = 0");

        // Клонування
        BiQuadraticEquation copy = original.clone();

        System.out.println("Оригінал: " + original + " Розв'язки: " + original.solve());
        System.out.println("Копія:    " + copy + " Розв'язки: " + copy.solve());

        // Перевірка, що це різні об'єкти
        System.out.println("Це один і той самий об'єкт? " + (original == copy));
    }
}
