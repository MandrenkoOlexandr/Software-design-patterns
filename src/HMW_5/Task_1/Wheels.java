package HMW_5.Task_1;

// Колеса
class Wheels {
    private String material;
    private int diameter;

    public Wheels(String material, int diameter) {
        this.material = material;
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return material + " R" + diameter;
    }
}