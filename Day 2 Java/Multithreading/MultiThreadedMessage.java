public class MultiThreadedMessage {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("Hello from Thread 1!");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Hello from Thread 2!");
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Hello from Thread 3!");
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
