package virtualthreads.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int NUMBER_OF_VIRTUAL_THREADS = 100;

    // virtual thread
    public static void main(String[] args) throws InterruptedException {
        List<Thread> virtualThreads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_VIRTUAL_THREADS; i++) {
            Thread virtualThread = Thread.ofVirtual().unstarted(new BlockingTask());
            virtualThreads.add(virtualThread);
        }

        for (Thread virtualThread : virtualThreads) {
            virtualThread.start();
        }

        for (Thread virtualThread : virtualThreads) {
            virtualThread.join();
        }
//
//        Thread virtualThread = Thread.ofVirtual().unstarted(runnable);
//
//        virtualThread.start();
//        virtualThread.join();
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Inside thread: " + Thread.currentThread() + " before blocking call");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Inside thread: " + Thread.currentThread() + " after blocking call");
        }
    }

    // platform thread creation
//    public static void main(String[] args) throws InterruptedException {
//        Runnable runnable = () -> System.out.println("Inside thread: " + Thread.currentThread());
//
////        Thread platformThread = new Thread(runnable);
//        Thread platformThread = Thread.ofPlatform().unstarted(runnable);
//
//        platformThread.start();
//        platformThread.join();
//    }
}
