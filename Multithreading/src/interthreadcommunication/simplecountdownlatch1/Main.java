package interthreadcommunication.simplecountdownlatch1;

public class Main {

    public static void main(String[] args) {
        SimpleCountDownLatch countDownLatch = new SimpleCountDownLatch(3);
        SimpleCountDownLatchThread simpleCountDownLatch = new SimpleCountDownLatchThread(countDownLatch);
        SimpleCountDownThread simpleCountDown = new SimpleCountDownThread(countDownLatch);
        simpleCountDownLatch.start();
        simpleCountDown.start();
    }

    private static class SimpleCountDownLatchThread extends Thread {
        private SimpleCountDownLatch simpleCountDownLatch;

        public SimpleCountDownLatchThread(SimpleCountDownLatch simpleCountDownLatch) {
            this.simpleCountDownLatch = simpleCountDownLatch;
        }

        @Override
        public void run() {
            try {
                simpleCountDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class SimpleCountDownThread extends Thread {
        private SimpleCountDownLatch simpleCountDownLatch;

        public SimpleCountDownThread(SimpleCountDownLatch simpleCountDownLatch) {
            this.simpleCountDownLatch = simpleCountDownLatch;
        }

        @Override
        public void run() {
            while (simpleCountDownLatch.count != 0) {
                simpleCountDownLatch.countDown();
            }
        }
    }

    private static class SimpleCountDownLatch {
        private int count;



        public SimpleCountDownLatch(int count) {
            this.count = count;
            if (count < 0) {
                throw new IllegalArgumentException("count cannot be negative");
            }
        }

        /**
         * Causes the current thread to wait until the latch has counted down to zero.
         * If the current count is already zero then this method returns immediately.
         */
        public synchronized void await() throws InterruptedException {
            while (getCount() != 0) {
                wait();
            }
        }

        /**
         *  Decrements the count of the latch, releasing all waiting threads when the count reaches zero.
         *  If the current count already equals zero then nothing happens.
         */
        public synchronized void countDown() {
            if (this.getCount() != 0) {
                count--;
                if (this.getCount() == 0) {
                    notifyAll();
                }
            }
        }

        /**
         * Returns the current count.
         */
        public int getCount() {
            return count;
        }
    }
}
