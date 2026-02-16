package HMW_1.Task_2;

public abstract class Creator {
    public abstract Product createProduct();

    public void someOperation() {
        Product p = createProduct();
        p.doSomething();
    }
}

class ConcreteCreator1 extends Creator {
    @Override
    public Product createProduct() {
        return new Product1();
    }
}

class ConcreteCreator2 extends Creator {
    @Override
    public Product createProduct() {
        return new Product2();
    }
}