//Class Chameleon that inherits from Animal -> Reptile
//implements the functions: eats, sleeps, changeColor and overrides toString, equals, clone
public class Chameleon extends Reptile implements Cloneable{

    protected Owner owner; // Snakes are pets

    // A constructor with an owner
    public Chameleon(String name, int age, String color, boolean crawls, Owner owner) {
        super(name, age, color, crawls);
        this.owner = owner;
    }

    @Override
    public void eats() {
        System.out.println("Method eats in class Chameleon -> Chameleon eat");
    }

    @Override
    public void sleeps() {
        System.out.println("Method sleeps in class Chameleon -> Chameleon sleep at night");
    }

    // New unique function for class Chameleon
    public void changeColor(){
        System.out.println("Chameleon can change their color to blend with the background");
    }

    // Overriding toString function from Reptile + extensions
    @Override
    public String toString() {
        return super.toString() +
                " --> Chameleon {" +
                "owner=" + owner.getName() +
                '}';
    }

    // Overriding equals function from Reptile + extensions
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
            Chameleon other = (Chameleon) obj;
            return ((this.owner.getName().equals(other.owner.getName()) && (this.owner.getPhone().equals(other.owner.getPhone()))));
        }
    }

    // Overriding clone function from Reptile
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Chameleon cloned = (Chameleon)super.clone();
        cloned.owner = (Owner) owner.clone();
        return cloned;
    }
}
