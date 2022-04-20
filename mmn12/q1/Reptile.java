//Class Reptile that inherits from Animal
public abstract class Reptile extends Animal implements Cloneable{

    private boolean crawls;

    // Constructor
    public Reptile(String name, int age, String color, boolean crawls) {
        super(name, age, color);
        this.crawls = crawls;
    }

    // Overriding toString function from Animal + extensions
    @Override
    public String toString() {
        return super.toString() +
                " --> Reptile {crawls - " + crawls +
                "}";
    }

    public boolean isCrawls() {
        return crawls;
    }

    public void setCrawls(boolean crawls) {
        this.crawls = crawls;
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
            Reptile other = (Reptile) obj;
            return (this.crawls == other.crawls);
        }
    }

    // Overriding clone function from Animal
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Reptile cloned = (Reptile)super.clone();
        cloned.setCrawls(cloned.isCrawls());
        return cloned;
    }
}
