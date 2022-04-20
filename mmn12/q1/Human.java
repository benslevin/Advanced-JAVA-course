//Class Human that inherits from Animal -> Mammal
//implements the functions: eats, sleeps, programs and overrides toString, equals, clone
public class Human extends Mammal implements Cloneable{

    protected Owner parent;
    private String gender;

    public Human(String name, int age, String color, Owner parent, String gender) {
        super(name, age, color);
        this.parent = parent;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void eats() {
        System.out.println("Method eats in class Human -> Humans are carnivores");
    }

    @Override
    public void sleeps() {
        System.out.println("Method sleeps in class Human -> Human sleep during the day and during the night (depends on the Human)");
    }

    // New unique function for class Human
    public void programs(){
        System.out.println("Some Humans program");
    }

    // Overriding toString function from Mammal + extensions
    @Override
    public String toString() {
        return super.toString() +
                " --> Human{" +
                "parent=" + parent.getName() +
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
            Human other = (Human) obj;
            return ((this.parent.getName().equals(other.parent.getName())) && (this.parent.getPhone().equals(other.parent.getPhone()))
                    && (this.gender.equals(other.gender)));
        }
    }

    // Overriding clone function from Mammal
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Human cloned = (Human)super.clone();
        cloned.parent = (Owner) parent.clone();
        cloned.setGender(cloned.getGender());
        return cloned;
    }
}
