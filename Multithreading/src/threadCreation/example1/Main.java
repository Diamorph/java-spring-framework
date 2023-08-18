package threadCreation.example1;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Intentional Exception");
//                System.out.println("We are now in Thread " + Thread.currentThread().getName());
//                System.out.println("Current Thread priority: " +Thread.currentThread().getPriority());
            }
        });
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread" + t.getName() + " the error is " + e.getMessage());
            }
        });
        thread.setName("New Worker Thread");

//        thread.setPriority(Thread.MAX_PRIORITY);
//
//        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
//        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
//        Thread.sleep(10000);
    }
}