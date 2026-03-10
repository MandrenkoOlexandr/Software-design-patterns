package HMW_4.Task_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

interface Bus {
    long getPurchaseCost();
    long getOperatingCostPerKm();
}

interface Tram {
    long getPurchaseCost();
    long getOperatingCostPerKm();
}

interface Trolleybus {
    long getPurchaseCost();
    long getOperatingCostPerKm();
}

class VolvoBus implements Bus {
    public long getPurchaseCost() { return 6_000_000; }
    public long getOperatingCostPerKm() { return 20; }
}
class VolvoTram implements Tram {
    public long getPurchaseCost() { return 10_000_000; }
    public long getOperatingCostPerKm() { return 7; }
}
class VolvoTrolleybus implements Trolleybus {
    public long getPurchaseCost() { return 7_000_000; }
    public long getOperatingCostPerKm() { return 13; }
}

class SkodaBus implements Bus {
    public long getPurchaseCost() { return 4_500_000; }
    public long getOperatingCostPerKm() { return 25; }
}
class SkodaTram implements Tram {
    public long getPurchaseCost() { return 9_000_000; }
    public long getOperatingCostPerKm() { return 8; }
}
class SkodaTrolleybus implements Trolleybus {
    public long getPurchaseCost() { return 6_800_000; }
    public long getOperatingCostPerKm() { return 12; }
}

class HyundaiBus implements Bus {
    public long getPurchaseCost() { return 5_500_000; }
    public long getOperatingCostPerKm() { return 20; }
}
class HyundaiTram implements Tram {
    public long getPurchaseCost() { return 9_500_000; }
    public long getOperatingCostPerKm() { return 6; }
}
class HyundaiTrolleybus implements Trolleybus {
    public long getPurchaseCost() { return 7_000_000; }
    public long getOperatingCostPerKm() { return 11; }
}

interface TransportFactory {
    String getBrandName();
    Bus createBus();
    Tram createTram();
    Trolleybus createTrolleybus();
}

class VolvoFactory implements TransportFactory {
    public String getBrandName() { return "Volvo"; }
    public Bus createBus() { return new VolvoBus(); }
    public Tram createTram() { return new VolvoTram(); }
    public Trolleybus createTrolleybus() { return new VolvoTrolleybus(); }
}

class SkodaFactory implements TransportFactory {
    public String getBrandName() { return "Skoda"; }
    public Bus createBus() { return new SkodaBus(); }
    public Tram createTram() { return new SkodaTram(); }
    public Trolleybus createTrolleybus() { return new SkodaTrolleybus(); }
}

class HyundaiFactory implements TransportFactory {
    public String getBrandName() { return "Hyundai"; }
    public Bus createBus() { return new HyundaiBus(); }
    public Tram createTram() { return new HyundaiTram(); }
    public Trolleybus createTrolleybus() { return new HyundaiTrolleybus(); }
}

public class CityTender {

    public static long calculateTenderCost(TransportFactory factory, int a, int t, int tr, int nThousands) {
        long totalKm = nThousands * 1000L;

        Bus bus = factory.createBus();
        Tram tram = factory.createTram();
        Trolleybus trolleybus = factory.createTrolleybus();

        long costBuses = a * (bus.getPurchaseCost() + bus.getOperatingCostPerKm() * totalKm);
        long costTrams = t * (tram.getPurchaseCost() + tram.getOperatingCostPerKm() * totalKm);
        long costTrolleybuses = tr * (trolleybus.getPurchaseCost() + trolleybus.getOperatingCostPerKm() * totalKm);

        return costBuses + costTrams + costTrolleybuses;
    }

    public static void main(String[] args) {
        int A = 15;
        int T = 10;
        int Tr = 20;
        int N = 500;

        System.out.println("=== Тендер на закупівлю транспорту для міста Х ===");
        System.out.printf("Потреба: %d автобусів, %d трамваїв, %d тролейбусів.\n", A, T, Tr);
        System.out.printf("Очікуваний пробіг: %d тис. км на кожну одиницю.\n\n", N);

        List<TransportFactory> factories = Arrays.asList(
                new VolvoFactory(),
                new SkodaFactory(),
                new HyundaiFactory()
        );

        TransportFactory bestFactory = null;
        long minCost = Long.MAX_VALUE;

        for (TransportFactory factory : factories) {
            long totalCost = calculateTenderCost(factory, A, T, Tr, N);
            System.out.printf("Виробник %-8s : %d грн\n", factory.getBrandName(), totalCost);

            if (totalCost < minCost) {
                minCost = totalCost;
                bestFactory = factory;
            }
        }

        // Оголошуємо переможця
        System.out.println("\n--------------------------------------------------");
        System.out.printf("РЕКОМЕНДАЦІЯ МЕРУ: Найвигідніше заключити контракт із %s.\n", bestFactory.getBrandName());
        System.out.printf("Загальні витрати (закупівля + експлуатація) складуть: %d грн.\n", minCost);
        System.out.println("--------------------------------------------------");
    }
}
