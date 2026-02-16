package HMW_1.Task_2;

public class Main {
    public static void main(String[] args) {
        Creator creator1 = new ConcreteCreator1();
        creator1.someOperation();

        Creator creator2 = new ConcreteCreator2();
        creator2.someOperation();
    }
}