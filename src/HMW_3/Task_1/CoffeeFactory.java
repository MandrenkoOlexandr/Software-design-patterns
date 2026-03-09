package HMW_3.Task_1;

class CoffeeFactory {
    public Coffee createCoffee(String type) {
        return switch (type.toLowerCase()) {
            case "еспресо" -> new Espresso();
            case "американо" -> new Americano();
            case "капучіно" -> new Cappuccino();
            case "латте" -> new Latte();
            default -> throw new IllegalArgumentException("Невідомий тип напою: " + type);
        };
    }
}
