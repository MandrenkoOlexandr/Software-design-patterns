package HMW_6.Task_2;

// 2. Компонент Колеса з підтримкою прототипу
class Wheels implements Cloneable {
    private String material;
    private int diameter;

    public Wheels(String material, int diameter) {
        this.material = material;
        this.diameter = diameter;
    }

    @Override
    public Wheels clone() {
        try {
            return (Wheels) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Wheels(this.material, this.diameter);
        }
    }

    @Override
    public String toString() {
        return material + " R" + diameter;
    }
}
