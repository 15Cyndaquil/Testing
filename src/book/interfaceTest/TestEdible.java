package book.interfaceTest;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

import java.io.Serializable;

public class TestEdible {
    public static void main(String[] args) throws CloneNotSupportedException{
        Object[] objects = {new Tiger(), new Chicken(), new Apple(), new Orange()};
        for (Object object : objects) {
            if (object instanceof Edible)
                System.out.println(((Edible) object).howToEat());

            if (object instanceof Animal) {
                System.out.println(((Animal) object).sound());
            }
        }
        Tiger test = new Tiger();
        Tiger test2 = (Tiger) test.clone();

        System.out.println(test2.sound());
    }

}


abstract class Animal{
    /**
     * Return animal sound
     */
    public abstract String sound();
}

class Chicken extends Animal implements Edible {
    @Override
    public String howToEat() {
        return "Chicken: Fry it";
    }

    @Override
    public String sound() {
        return "Chicken: cock-a-doodle-doo";
    }
}

class Tiger extends Animal implements Cloneable{
    @Override
    public String sound() {
        return "Tiger: RROOAARR";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

abstract class Fruit implements Edible {
    // Data fields, constructors, and methods omitted here
}

class Apple extends Fruit {
    @Override
    public String howToEat() {
        return "Apple: Make apple cider";
    }
}

class Orange extends Fruit {
    @Override
    public String howToEat() {return "Orange: Make orange juice";}
}
