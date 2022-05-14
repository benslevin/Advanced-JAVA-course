import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//This class creates sets of objects and implements a few functions on the given set
//The functions are: 2 constructors, union, intersect, isSubset, isMember, insert, delete, iterator, toString
public class Sets<E> {

    private final ArrayList<E> set;

    //Empty constructor - creates an empty Set
    protected Sets() {
        set = new ArrayList<E>();
    }

    //Constructor that gets a set of Objects and creates a Set
    protected Sets(E[] inputArray){
        set = new ArrayList<E>(inputArray.length);
        set.addAll(Arrays.asList(inputArray));
    }

    //The function union creates a single set with all Objects of the 2 sets provided
    protected void union (Sets<E> arr1){
        Iterator<E> it = arr1.iterator();
        while(it.hasNext()){
            E value = it.next();
            if (!this.set.contains(value)){//checks to see if the value already exists in the set
                this.set.add(value);
            }
        }
    }

    //The function intersect creates a single set with only the Objects that are in both the sets provided
    protected void intersect (Sets<E> arr1){
        this.set.removeIf(value -> !arr1.isMember(value));
        if(this.set.size() == 0){
            System.out.println("The set is empty");
        }
    }

    //The function isSubset checks to see if the set provided is a subset
    protected boolean isSubset (Sets<E> arr1){
        Iterator<E> it = arr1.iterator();
        while (it.hasNext()){
            E value = it.next();
            if(!this.set.contains(value)){
                return false;
            }
        }
        return true;
    }

    //The function isMember checks if the item provided is a member of the set
    protected boolean isMember (E item){
        if(this.set.contains(item)) {
            System.out.println("The item: " + item + " is a member of the set");
            return true;
        } else return false;
    }

    //The function insert adds the Object provided to the set provided, if the Object already exists it won't be added
    protected void insert (E item){
        if(!this.set.contains(item)){//Checks if the array contains the item
            this.set.add(item);
        }
    }

    //The function delete removes the Object provided from the set, if the Object doesn't exist, nothing happens
    protected void delete (E item){
        this.set.remove(item);
    }

    //The function iterator creates an iterator to use for the set
    protected Iterator<E> iterator (){
        return this.set.iterator();
    }

    //toString function to print the set
    @Override
    public String toString() {
        return "Sets{" +
                "set=" + set +
                '}';
    }

    //The function returns the first member of the set, for use of the minValue function in the compare class
    protected E returnFirst(){
        if(this.set.size() > 0){
            return this.set.get(0);
        }
        System.out.println("The set is empty");
        return null;
    }
}
