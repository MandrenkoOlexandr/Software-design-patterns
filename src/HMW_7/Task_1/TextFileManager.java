package HMW_7.Task_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TextFileManager {
    // volatile гарантує правильну роботу з пам'яттю в багатопотоковому середовищі
    private static volatile TextFileManager instance;

    // Приватний конструктор унеможливлює створення об'єктів через new
    private TextFileManager() {
        System.out.println("Система керування файлами ініціалізована.");
    }

    // Глобальна точка доступу
    public static TextFileManager getInstance() {
        if (instance == null) {
            synchronized (TextFileManager.class) {
                if (instance == null) {
                    instance = new TextFileManager();
                }
            }
        }
        return instance;
    }

    // Метод для читання файлу
    public String readFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            return "Помилка при читанні файлу: " + e.getMessage();
        }
    }

    // Метод для запису у файл
    public void writeFile(String path, String content) {
        try {
            Files.write(Paths.get(path), content.getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Файл успішно збережено: " + path);
        } catch (IOException e) {
            System.err.println("Помилка при записі: " + e.getMessage());
        }
    }
}