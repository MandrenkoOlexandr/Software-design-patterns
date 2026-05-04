package HMW_7.Task_2;

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