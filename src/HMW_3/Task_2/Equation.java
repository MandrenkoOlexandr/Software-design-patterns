package HMW_3.Task_2;

import java.util.*;

class Equation {
    protected double b, c;
    protected String originalInput;

    public Equation(double b, double c, String originalInput) {
        this.b = b;
        this.c = c;
        this.originalInput = originalInput;
    }

    public List<Double> solve() {
        if (b == 0) {
            return c == 0 ? null : new ArrayList<>(); // null = нескінченність, порожній = немає
        }
        double root = -c / b;
        return Collections.singletonList(root == -0.0 ? 0.0 : root);
    }

    @Override
    public String toString() {
        return "[" + originalInput + "]";
    }
}
