package HMW_5.Task_2;

// Продукт, який ми будуємо (в даному випадку рядок)
class CustomString {
    private final String content;

    public CustomString(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}

