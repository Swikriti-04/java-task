    class NamedThread implements Runnable {
        private String threadName;

        public NamedThread(String name) {
            this.threadName = name;
            System.out.println("Creating " + threadName);
        }

        @Override
        public void run() {
            System.out.println("Running " + threadName);
            try {
                for (int i = 4; i > 0; i--) {
                    System.out.println(threadName + ": " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
            System.out.println(threadName + " exiting.");
        }
    }

    public class RunnableThread {
        public static void main(String[] args) {
            Thread threadA = new Thread(new NamedThread("Thread-A"));
            Thread threadB = new Thread(new NamedThread("Thread-B"));

            threadA.start();
            threadB.start();
        }
    }