//Class Kangaroo that inherits from Animal -> Marsupial
//implements the functions: eats, sleeps, hop and overrides toString, equals, clone
public class Kangaroo extends Marsupial implements Cloneable{

    public Kangaroo(String name, int age, String color, boolean hasPocket) {
        super(name, age, color, hasPocket);
    }

    @Override
    public void eats() {
        System.out.println("Method eats in class Kangaroo -> Kangaroos are herbivore");
    }

    @Override
    public void sleeps() {
        System.out.println("Method sleeps in class Kangaroo -> Kangaroos sleep at night");
    }

    // New unique function for class Kangaroo
    public void hop(){
        System.out.println("Kangaroos hop");
    }

    // Overriding toString function from Marsupial + extensions
    @Override
    public String toString() {
        return super.toString() +
                " --> Kangaroo { }";
    }

    // Overriding equals function from Marsupial + extensions
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // Overriding clone function from Marsupial
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Kangaroo cloned = (Kangaroo)super.clone();
        return cloned;
    }
}
