//Class Snake that inherits from Animal -> Reptile
//implements the functions: eats, sleeps, poisonous and overrides toString, equals, clone
public class Snake extends Reptile implements Cloneable{

    protected Owner owner; // Snakes are pets
    private boolean isPoisonous;

    // A constructor with an owner
    public Snake(String name, int age, String color, boolean crawls, Owner owner, boolean isPoisonous) {
        super(name, age, color, crawls);
        this.owner = owner;
        this.isPoisonous = isPoisonous;
    }

    public boolean isPoisonous() {
        return isPoisonous;
    }

    public void setPoisonous(boolean poisonous) {
        isPoisonous = poisonous;
    }

    @Override
    public void eats() {
        System.out.println("Method eats in class Snake -> Snakes eat their food whole");
    }

    @Override
    public void sleeps() {
        System.out.println("Method sleeps in class Snake -> Snakes sleep during the day");
    }

    // New unique function for class Snake
    public void poisonous(){
        System.out.println("Some snakes are poisonous and some are not, you should be careful of the flashy ones");
    }

    // Overriding toString function from Reptile + extensions
    @Override
    public String toString() {
        return super.toString() +
                " --> Snake{" +
                "owner=" + owner.getName() +
                ", is poisonous - " + isPoisonous +
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
            Snake other = (Snake) obj;
            return ((this.owner.getName().equals(other.owner.getName()) && (this.owner.getPhone().equals(other.owner.getPhone())))
                    && (this.isPoisonous == other.isPoisonous));
        }
    }

    // Overriding clone function from Reptile
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Snake cloned = (Snake) super.clone();
        cloned.owner = (Owner) owner.clone();
        cloned.setPoisonous(cloned.isPoisonous());
        return cloned;
    }
}
