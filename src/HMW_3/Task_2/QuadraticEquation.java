package HMW_3.Task_2;


import java.util.*;

class QuadraticEquation extends Equation {
    protected double a;

    public QuadraticEquation(double a, double b, double c, String originalInput) {
        super(b, c, originalInput);
        this.a = a;
    }

    @Override
    public List<Double> solve() {
        if (a == 0) {
            return super.solve();
        }

        double d = b * b - 4 * a * c;
        if (d < 0) {
            return new ArrayList<>();
        }

        if (d == 0) {
            double root = -b / (2 * a);
            return Collections.singletonList(root == -0.0 ? 0.0 : root);
        }

        double root1 = (-b - Math.sqrt(d)) / (2 * a);
        double root2 = (-b + Math.sqrt(d)) / (2 * a);
        return Arrays.asList(root1 == -0.0 ? 0.0 : root1, root2 == -0.0 ? 0.0 : root2);
    }
}
