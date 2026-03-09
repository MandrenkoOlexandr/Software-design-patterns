package HMW_3.Task_1;

abstract class Coffee {
    protected String name;
    protected double cost;
    protected double price;

    public String getName() { return name; }
    public double getProfit() { return price - cost; }

    @Override
    public String toString() {
        return String.format("%s (Прибуток: %.2f)", name, getProfit());
    }
}