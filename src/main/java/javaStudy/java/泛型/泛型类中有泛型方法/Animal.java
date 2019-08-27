package javaStudy.java.泛型.泛型类中有泛型方法;

public class Animal extends Holder<Animal> {
    public Animal(Animal animal) {
        super(animal);
    }

    public Animal() {
        super();
    }
}
