package race.condition;

public class LockCondition {

    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        incrementingThread.start();
        decrementingThread.start();

        incrementingThread.join();
        decrementingThread.join();
    }

    public static class DecrementingThread extends Thread {
        private InventoryCounter inventoryCounter;
        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.decrement();
            }
        }
    }

    public static class IncrementingThread extends Thread {
        private InventoryCounter inventoryCounter;
        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.increment();
            }
        }
    }

    private static class InventoryCounter {
        Object lock = new Object();
        private int items = 0;

//        public synchronized increment() {
//            items++;
//        }
//
//        public synchronized decrement() {
//            items--;
//        }
//
//        public synchronized int getItems() {
//            return items;
//        }

        public void increment() {
            synchronized (lock) {
                items++;
            }
        }

        public void decrement() {
            synchronized (lock) {
                items--;
            }
        }

        public int getItems() {
            synchronized (lock) {
                return items;
            }
        }
    }
}
