//This class is the thread functionality (worker class)
//This class creates the function for the threads to execute
public class MembersMerge extends Thread {

    private Member m;
    private int threadName;

    //Constructor
    public MembersMerge(int threadName, Member m) {
        this.threadName = threadName;
        this.m = m;
    }

    //This function declares what each thread should do. must be implemented with runnable
    public void run(){
        super.run();
        while(m.getSize() > 1) {
            int[] members = m.getAndRemoveMember(); // storing the numbers to add
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                //System.out.println("Thread " + this.threadName + " extracted " + members[i] + " from the array");
                sum += members[i];
            }
            //System.out.println("\nThread " + this.threadName + " added " + sum + " to the array");
            m.addMember(sum);//member2
        }
    }
}
