package HMW_3.Task_1;

import java.util.ArrayList;
import java.util.List;

public class MechMatCoffeeShop {
    public static void main(String[] args) {
        CoffeeFactory factory = new CoffeeFactory();
        List<Coffee> soldCoffees = new ArrayList<>();

        // Імітуємо робочий день
        String[] orders = {"еспресо", "латте", "капучіно", "латте", "американо"};

        double totalProfit = 0;

        System.out.println("--- Журнал замовлень ТРЦ MechMat Mall ---");
        for (String order : orders) {
            Coffee coffee = factory.createCoffee(order);
            soldCoffees.add(coffee);
            totalProfit += coffee.getProfit();
            System.out.println("Продано: " + coffee);
        }

        System.out.println("-----------------------------------------");
        System.out.printf("Загальний прибуток за зміну: %.2f грн.\n", totalProfit);
    }
}
