//A class to create an Owner for some animals
//Implements getters and setters and clone functions
public class Owner implements Cloneable {

    protected String name;
    protected String phone;

    public Owner() {
        this.name = "default";
        this.phone = "050-8888888";
    }

    public Owner(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
