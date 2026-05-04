package HMW_6.Task_1;

import java.util.*;

class BiQuadraticEquation extends QuadraticEquation {

    public BiQuadraticEquation(double a, double b, double c, String originalInput) {
        super(a, b, c, originalInput);
    }

    @Override
    public List<Double> solve() {
        List<Double> yRoots = super.solve();
        if (yRoots == null) return null;

        Set<Double> xRoots = new TreeSet<>();
        for (Double y : yRoots) {
            if (y > 0) {
                xRoots.add(Math.sqrt(y));
                xRoots.add(-Math.sqrt(y));
            } else if (y == 0.0) {
                xRoots.add(0.0);
            }
        }
        return new ArrayList<>(xRoots);
    }

    @Override
    public BiQuadraticEquation clone() {
        return (BiQuadraticEquation) super.clone();
    }
}