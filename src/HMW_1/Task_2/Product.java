package HMW_1.Task_2;

public interface Product {
    void doSomething();
}

class Product1 implements Product {
    @Override
    public void doSomething() {
        System.out.println("Product1 виконує дію");
    }
}

class Product2 implements Product {
    @Override
    public void doSomething() {
        System.out.println("Product2 виконує дію");
    }
}
