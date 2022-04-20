//Class Koala that inherits from Animal -> Marsupial
//implements the functions: eats, sleeps, climb and overrides toString, equals, clone
public class Koala extends Marsupial implements Cloneable{

    public Koala(String name, int age, String color, boolean hasPocket) {
        super(name, age, color, hasPocket);
    }

    @Override
    public void eats() {
        System.out.println("Method eats in class koala -> koalas eat eucalyptus leaves");
    }

    @Override
    public void sleeps() {
        System.out.println("Method sleeps in class koala -> koalas sleep 20 hours a day");
    }

    // New unique function for class Koala
    public void climb(){
        System.out.println("koala climb trees");
    }

    // Overriding toString function from Marsupial + extensions
    @Override
    public String toString() {
        return super.toString() +
                " --> Koala { }";
    }

    // Overriding equals function from Marsupial + extensions
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // Overriding clone function from Marsupial
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Koala cloned = (Koala)super.clone();
        return cloned;
    }
}
