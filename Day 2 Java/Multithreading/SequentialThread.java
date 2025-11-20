public class SequentialThread {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("T1 started");
            try { 
                Thread.sleep(2000); 
            } 
            catch (InterruptedException e) {}
            System.out.println("T1 finished");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("T2 started");
            try { 
                Thread.sleep(1000); 
                } 
            catch (InterruptedException e) {}
            System.out.println("T2 finished");
        });

        t1.start();  // Starting T1

        try {
            t1.join(); // Wait for T1 to finish
        }
        catch (InterruptedException e) {}

        t2.start();   // Starting second thread after T1 is done
    }
}
