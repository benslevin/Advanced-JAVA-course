import java.util.ArrayList;

//This class is the monitor of the program
//This class implements the get, remove and add members to the group, uses synchronized so the threads don't overrun each other
public class Member {

    private ArrayList<Integer> arrayList;
    private int done = 0;
    private int numOfMembers = 0;

    //Constructor
    public Member(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    //Getter for last number that checks that we calculated all the members of the array
    public synchronized int getLastMember(){
        while(done < numOfMembers - 1){
            try{
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return arrayList.get(0);
    }

    //Setting the number of members to keep track of the number of action needed
    public void setNumOfMembers(int number){
        numOfMembers = number;
    }

    //Getting size of array
    public synchronized int getSize(){
        return arrayList.size();
    }

    //This function returns a member from the list and removes it from the group
    public synchronized int[] getAndRemoveMember(){
        int[] members = new int[2];
        for(int i = 0; i < 2; i++){
            int number = arrayList.get(0);
            members[i] = number;
            arrayList.remove(0);
        }
        return members;
    }

    //This function add a new member to the list
    public synchronized void addMember(int number){
        arrayList.add(number);
        done++;//counter for number of members removed from the group
        notifyAll();//wakes up all the waiting threads, so they can continue working
    }

    //Prints the array
    public void printArray(){
        int counter = 0;
        for (Integer n : arrayList) {
            if (counter < arrayList.size() - 1){
                System.out.print(n + ", ");
                counter++;
            } else {
                System.out.print(n);
            }
        }
        System.out.print("}");
    }
}


