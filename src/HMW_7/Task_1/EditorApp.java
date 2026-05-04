package HMW_7.Task_1;

public class EditorApp {
    public static void main(String[] args) {
        // Отримуємо єдиний екземпляр менеджера
        TextFileManager manager = TextFileManager.getInstance();

        // Робота з файлом
        String fileName = "src/HMW_7/Task_1/notes.txt";
        manager.writeFile(fileName, "Привіт! Це текст для перевірки шаблону Одинак.");

        String content = manager.readFile(fileName);
        System.out.println("Вміст файлу: " + content);

        // Перевірка: чи дійсно це один і той самий об'єкт?
        TextFileManager anotherManager = TextFileManager.getInstance();
        System.out.println("Це один і той самий об'єкт? " + (manager == anotherManager));
    }
}
