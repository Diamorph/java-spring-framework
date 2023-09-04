package race.condition;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperations {
    public static void main(String[] args) throws InterruptedException {
        AtomicInventoryCounter atomicInventoryCounter = new AtomicInventoryCounter();
        AtomicIncrementingThread atomicIncrementingThread = new AtomicIncrementingThread(atomicInventoryCounter);
        AtomicDecrementingThread atomicDecrementingThread = new AtomicDecrementingThread(atomicInventoryCounter);

        atomicIncrementingThread.start();
        atomicDecrementingThread.start();

        atomicIncrementingThread.join();
        atomicDecrementingThread.join();

        System.out.println("We currently have: " + atomicInventoryCounter.getItems() + " items");
    }

    public static class AtomicDecrementingThread extends Thread {
        private AtomicInventoryCounter inventoryCounter;
        public AtomicDecrementingThread(AtomicInventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.decrement();
            }
        }
    }

    public static class AtomicIncrementingThread extends Thread {
        private AtomicInventoryCounter inventoryCounter;
        public AtomicIncrementingThread(AtomicInventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.increment();
            }
        }
    }

    private static class AtomicInventoryCounter {
        private AtomicInteger items = new AtomicInteger(0);

        public void increment() {
            items.incrementAndGet();
        }

        public void decrement() {
            items.decrementAndGet();
        }

        public int getItems() {
            return items.get();
        }
    }
}
