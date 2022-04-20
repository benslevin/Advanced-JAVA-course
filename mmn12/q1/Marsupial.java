//Class Marsupial that inherits from Animal
public abstract class Marsupial extends Animal implements Cloneable{

    private boolean hasPocket;

    // Constructor
    public Marsupial(String name, int age, String color, boolean hasPocket) {
        super(name, age, color);
        this.hasPocket = hasPocket;
    }

    public boolean isHasPocket() {
        return hasPocket;
    }

    public void setHasPocket(boolean hasPocket) {
        this.hasPocket = hasPocket;
    }

    // Overriding toString function from Animal + extensions
    @Override
    public String toString() {
        return super.toString() +
                " --> Marsupial {Has pocket - " + hasPocket +
                "}";
    }

    // Overriding equals function from Animal + extensions
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (! super.equals(obj)) {
            return false;
        }
        else {
            Marsupial other = (Marsupial) obj;
            return (this.hasPocket == other.hasPocket);
        }
    }

    // Overriding clone function from Animal
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Marsupial cloned = (Marsupial)super.clone();
        cloned.setHasPocket(cloned.isHasPocket());
        return cloned;
    }
}
