package HMW_6.Task_1;

import java.util.*;

class Equation implements Cloneable {
    protected double b, c;
    protected String originalInput;

    public Equation(double b, double c, String originalInput) {
        this.b = b;
        this.c = c;
        this.originalInput = originalInput;
    }

    // Конструктор копіювання (альтернатива clone)
    public Equation(Equation target) {
        if (target != null) {
            this.b = target.b;
            this.c = target.c;
            this.originalInput = target.originalInput;
        }
    }

    public List<Double> solve() {
        if (b == 0) {
            return c == 0 ? null : new ArrayList<>();
        }
        double root = -c / b;
        return Collections.singletonList(root == -0.0 ? 0.0 : root);
    }

    @Override
    public Equation clone() {
        try {
            return (Equation) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Equation(this.b, this.c, this.originalInput);
        }
    }

    @Override
    public String toString() {
        return "Equation[" + originalInput + "]";
    }
}