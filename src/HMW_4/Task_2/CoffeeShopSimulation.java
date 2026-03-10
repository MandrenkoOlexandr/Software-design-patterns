package HMW_4.Task_2;

interface Espresso {
    double getCost();
    double getPrice();
}

interface Americano {
    double getCost();
    double getPrice();
}

interface Cappuccino {
    double getCost();
    double getPrice();
}

interface Latte {
    double getCost();
    double getPrice();
}

interface CoffeeMachineFactory {
    Espresso createEspresso();
    Americano createAmericano();
    Cappuccino createCappuccino();
    Latte createLatte();
    double getMachineCost();
    double getDailyMaintenanceCost();
    String getManufacturerName();
}

class BasicEspresso implements Espresso {
    public double getCost() { return 10.0; }
    public double getPrice() { return 25.0; }
}

class BasicAmericano implements Americano {
    public double getCost() { return 12.0; }
    public double getPrice() { return 30.0; }
}

class BasicCappuccino implements Cappuccino {
    public double getCost() { return 18.0; }
    public double getPrice() { return 40.0; }
}

class BasicLatte implements Latte {
    public double getCost() { return 20.0; }
    public double getPrice() { return 45.0; }
}

class PremiumEspresso implements Espresso {
    public double getCost() { return 15.0; }
    public double getPrice() { return 45.0; }
}

class PremiumAmericano implements Americano {
    public double getCost() { return 18.0; }
    public double getPrice() { return 55.0; }
}

class PremiumCappuccino implements Cappuccino {
    public double getCost() { return 25.0; }
    public double getPrice() { return 70.0; }
}

class PremiumLatte implements Latte {
    public double getCost() { return 28.0; }
    public double getPrice() { return 80.0; }
}

class BasicMachineFactory implements CoffeeMachineFactory {
    public Espresso createEspresso() { return new BasicEspresso(); }
    public Americano createAmericano() { return new BasicAmericano(); }
    public Cappuccino createCappuccino() { return new BasicCappuccino(); }
    public Latte createLatte() { return new BasicLatte(); }
    public double getMachineCost() { return 10000.0; }
    public double getDailyMaintenanceCost() { return 50.0; }
    public String getManufacturerName() { return "BasicBrew"; }
}

class PremiumMachineFactory implements CoffeeMachineFactory {
    public Espresso createEspresso() { return new PremiumEspresso(); }
    public Americano createAmericano() { return new PremiumAmericano(); }
    public Cappuccino createCappuccino() { return new PremiumCappuccino(); }
    public Latte createLatte() { return new PremiumLatte(); }
    public double getMachineCost() { return 30000.0; }
    public double getDailyMaintenanceCost() { return 100.0; }
    public String getManufacturerName() { return "PremiumRoast"; }
}

public class CoffeeShopSimulation {
    public static void main(String[] args) {
        int days = 90;
        int salesPerDrinkType = 25;

        simulate(new BasicMachineFactory(), days, salesPerDrinkType);
        simulate(new PremiumMachineFactory(), days, salesPerDrinkType);
    }

    private static void simulate(CoffeeMachineFactory factory, int days, int salesPerDrinkType) {
        Espresso espresso = factory.createEspresso();
        Americano americano = factory.createAmericano();
        Cappuccino cappuccino = factory.createCappuccino();
        Latte latte = factory.createLatte();

        double dailyRevenue = (espresso.getPrice() + americano.getPrice() + cappuccino.getPrice() + latte.getPrice()) * salesPerDrinkType;
        double dailyCost = (espresso.getCost() + americano.getCost() + cappuccino.getCost() + latte.getCost()) * salesPerDrinkType;

        double totalRevenue = dailyRevenue * days;
        double totalIngredientsCost = dailyCost * days;
        double totalMaintenance = factory.getDailyMaintenanceCost() * days;

        double netProfit = totalRevenue - totalIngredientsCost - totalMaintenance - factory.getMachineCost();

        System.out.printf("%s Прибуток після %d днів: %.2f\n", factory.getManufacturerName(), days, netProfit);
    }
}