package javaStudy.java.泛型.PECS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dhslegen
 */
public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Garfield> garfields = new ArrayList<>();

        animals.add(new Animal());
        cats.add(new Cat());
        garfields.add(new Garfield());

        // Incompatible types. Found: 'java.util.List<javaStudy.java.泛型.PECS.Main.Animal>', required: 'java.util.List<? extends javaStudy.java.泛型.PECS.Main.Cat>'
        // List<? extends Cat> extendsCatFromAnimals = animals;
        List<? super Cat> superCatFromAnimals = animals;
        List<?> fromCats = animals;

        List<? extends Cat> extendsCatFromCats = cats;
        List<? super Cat> superCatFromCats = cats;

        List<? extends Cat> extendsCatFromGarfields = garfields;
        // Incompatible types. Found: 'java.util.List<javaStudy.java.泛型.PECS.Main.Garfield>', required: 'java.util.List<? super javaStudy.java.泛型.PECS.Main.Cat>'
        // List<? super Cat> superCatFromGarfields = garfields;

        // 'add(capture<? extends javaStudy.java.泛型.PECS.Main.Cat>)' in 'java.util.List' cannot be applied to '(javaStudy.java.泛型.PECS.Main.Animal)'
        // extendsCatFromCats.add(new Animal());
        // extendsCatFromCats.add(new Cat());
        // extendsCatFromCats.add(new Garfield());

        // 'add(capture<? super javaStudy.java.泛型.PECS.Main.Cat>)' in 'java.util.List' cannot be applied to '(javaStudy.java.泛型.PECS.Main.Animal)'
        // superCatFromCats.add(new Animal());
        superCatFromCats.add(new Cat());
        superCatFromAnimals.add(new Garfield());

        Object o = extendsCatFromCats.get(0);
        Cat cat = extendsCatFromCats.get(0);
        // Incompatible types. Found: 'capture<? extends javaStudy.java.泛型.PECS.Main.Cat>', required: 'javaStudy.java.泛型.PECS.Main.Garfield'
        // Garfield garfield = extendsCatFromGarfields.get(0);

        Garfield copy = copy(animals, garfields);
        Animal animal = animals.get(0);
        Garfield garfield = garfields.get(0);
    }

    public static <T> T copy(List<? super T> dest, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dest.set(i, src.get(i));
        }
        return src.get(0);
    }

    static class Animal {
    }

    static class Cat extends Animal {
    }

    static class Garfield extends Cat {
    }

}
