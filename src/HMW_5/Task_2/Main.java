package HMW_5.Task_2;

public class Main {
    public static void main(String[] args) {
        IStringBuilder builder = new MyStringBuilder();

        CustomString result = builder
                .append("Привіт")
                .append(" Світ")
                .insert(7, "прекрасний ")
                .build();

        // Результат: "Привіт прекрасний Світ"
        System.out.println(result);
    }
}