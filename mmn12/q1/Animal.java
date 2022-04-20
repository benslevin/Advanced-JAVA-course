//Class animals is an abstract that other classes inherit from, with the functions eats, sleeps
//and overrides toString, equals, clone
public abstract class Animal implements Cloneable{

    private String name;
    private int age;
    private String color;

    // Constructor
    public Animal(String name, int age, String color) {
        this.name = name;
        if(age >= 0) { // Negative age is not valid
            this.age = age;
        } else {
            System.out.println("Illegal age value, the age is set to 1.");
            this.age = 1;// Default value
        }
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 0) {
            this.age = age;
        } else {
            System.out.println("Invalid input for age value");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Abstract functions
    abstract void eats(); // Abstract function that the Classes that inherit from Animal need to implement
    abstract void sleeps();// Abstract function that the Classes that inherit from Animal need to implement

    // Overriding toString function from Object + extensions
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    // Overriding equals function from Object + extensions
    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Animal)){
            return false;
        }
        Animal other = (Animal) obj;
        return ((this.age == other.age) && (this.name.equals(other.name)) && (this.color.equals(other.color)));
    }

    // Overriding clone function from Object
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Animal cloned = (Animal)super.clone();
        return cloned;
    }
}
