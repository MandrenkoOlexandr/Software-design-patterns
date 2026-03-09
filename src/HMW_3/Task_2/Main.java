package HMW_3.Task_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Створюємо сканер для читання вводу з консолі
        Scanner consoleScanner = new Scanner(System.in);

        System.out.print("Введіть назву файлу для обробки (наприклад, input01.txt): ");
        String fileName = consoleScanner.nextLine().trim();

        if (!fileName.isEmpty()) {
            processFile(fileName);
        } else {
            System.out.println("Назву файлу не введено.");
        }

        consoleScanner.close();
    }

    private static void processFile(String fileName) {
        System.out.println("\n=== Обробка файлу: " + fileName + " ===");
        List<Equation> equations = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                double[] coeffs = new double[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    coeffs[i] = Double.parseDouble(parts[i]);
                }

                Equation eq = createEquation(coeffs, line);
                if (eq != null) equations.add(eq);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + fileName + " не знайдено.");
            return;
        }

        analyzeEquations(equations);
    }

    private static Equation createEquation(double[] coeffs, String line) {
        if (coeffs.length == 2) {
            return new Equation(coeffs[0], coeffs[1], line);
        } else if (coeffs.length == 3) {
            return new QuadraticEquation(coeffs[0], coeffs[1], coeffs[2], line);
        } else if (coeffs.length == 5) {
            return new BiQuadraticEquation(coeffs[0], coeffs[2], coeffs[4], line);
        }
        return null;
    }

    private static void analyzeEquations(List<Equation> equations) {
        Map<Integer, List<Equation>> groupedByRoots = new HashMap<>();
        List<Equation> infiniteRoots = new ArrayList<>();

        for (int i = 0; i <= 4; i++) {
            groupedByRoots.put(i, new ArrayList<>());
        }

        for (Equation eq : equations) {
            List<Double> roots = eq.solve();
            if (roots == null) {
                infiniteRoots.add(eq);
            } else {
                int count = roots.size();
                groupedByRoots.computeIfAbsent(count, k -> new ArrayList<>()).add(eq);
            }
        }

        System.out.println("1) Рівняння, що не мають розв'язків: " + groupedByRoots.get(0));
        System.out.println("2) Рівняння, що мають 1 розв'язок: " + groupedByRoots.get(1));
        System.out.println("3) Рівняння, що мають 2 розв'язки: " + groupedByRoots.get(2));
        System.out.println("4) Рівняння, що мають 3 розв'язки: " + groupedByRoots.get(3));
        System.out.println("5) Рівняння, що мають 4 розв'язки: " + groupedByRoots.get(4));
        System.out.println("6) Рівняння з нескінченною кількістю розв'язків: " + infiniteRoots);

        List<Equation> oneRootEqs = groupedByRoots.get(1);
        if (oneRootEqs != null && !oneRootEqs.isEmpty()) {
            Equation minEq = null, maxEq = null;
            double minRoot = Double.MAX_VALUE;
            double maxRoot = -Double.MAX_VALUE;

            for (Equation eq : oneRootEqs) {
                double root = eq.solve().get(0);
                if (root < minRoot) { minRoot = root; minEq = eq; }
                if (root > maxRoot) { maxRoot = root; maxEq = eq; }
            }

            System.out.println("\nСеред рівнянь з рівно 1 розв'язком:");
            System.out.println("  -> З найменшим розв'язком (" + minRoot + "): " + minEq);
            System.out.println("  -> З найбільшим розв'язком (" + maxRoot + "): " + maxEq);
        } else {
            System.out.println("\nРівнянь з рівно 1 розв'язком не знайдено, тому min/max не обчислюється.");
        }
    }
}