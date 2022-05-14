import java.util.Iterator;

//This class is not a generic class with a generic function that compares 2 persons through their IDs'
public class Comparing {

    //Generic function to compare persons from the Person class
    protected static <E extends Comparable<E>> E minValue(Sets<E> set) {
        E minValue = set.returnFirst();//setting first index in the set a min value
        Iterator<E> it = set.iterator();//iterating through the set
        while(it.hasNext()) {
            E value = it.next();
            if (value.compareTo(minValue) < 0) {//if this index of the set is smaller in ID to the minValue, set new minValue
                minValue = value;
            }
        }
        return minValue;
    }
}
