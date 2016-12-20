
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Shared shared = new Shared();

        Runnable threadJob = new MyRunnable("1.txt", shared);
        Runnable threadJob2 = new MyRunnable("2.txt", shared);
        Runnable threadJob3 = new MyRunnable("3.txt", shared);

        Thread t= new Thread(threadJob);
        Thread t2=new Thread(threadJob2);
        Thread t3=new Thread(threadJob3);

        t.start();
        t2.start();
        t3.start();

        t.join();
        t2.join();
        t3.join();

        /*for(String key : shared.set) {
            System.out.println(key);
        }*/
    }
}
