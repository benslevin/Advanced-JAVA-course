//Class Dolphin that inherits from Animal -> Mammal
//implements the functions: eats, sleeps, swim and overrides toString, equals, clone
public class Dolphin extends Mammal implements Cloneable{

    private boolean hasSonar;

    public Dolphin(String name, int age, String color, boolean hasSonar) {
        super(name, age, color);
        this.hasSonar = hasSonar;
    }

    public boolean isHasSonar() {
        return hasSonar;
    }

    public void setHasSonar(boolean hasSonar) {
        this.hasSonar = hasSonar;
    }

    @Override
    public void eats() {
        System.out.println("Method eats in class Dolphin -> Dolphin eat fish");
    }

    @Override
    public void sleeps() {
        System.out.println("Method sleeps in class Dolphin -> Dolphins sleep during the night");
    }

    // New unique function for class Dolphin
    public void swim(){
        System.out.println("Dolphins swim");
    }

    // Overriding toString function from Mammal + extensions
    @Override
    public String toString() {
        return super.toString() +
                " --> Dolphin{" +
                "has sonar - " + hasSonar +
                '}';
    }

    // Overriding equals function from Mammal + extensions
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
            Dolphin other = (Dolphin) obj;
            return ((this.hasSonar == other.hasSonar));
        }
    }

    // Overriding clone function from Mammal
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Dolphin cloned = (Dolphin)super.clone();
        cloned.setHasSonar(cloned.isHasSonar());
        return cloned;
    }
}

