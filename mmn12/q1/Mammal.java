//Class Mammal that inherits from Animal
public abstract class Mammal extends Animal implements Cloneable{

    // Constructor
    public Mammal(String name, int age, String color) {
        super(name, age, color);
    }

    // Overriding toString function from Animal + extensions
    @Override
    public String toString() {
        return super.toString() + " --> Mammal{ }";
    }

    // Overriding equals function from Animal, no new variable
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // Overriding clone function from Animal
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Mammal cloned = (Mammal)super.clone();
        return cloned;
    }
}
