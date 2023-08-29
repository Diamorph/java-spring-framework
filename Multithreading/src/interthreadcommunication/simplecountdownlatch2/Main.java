package interthreadcommunication.simplecountdownlatch2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        SimpleCountDownLatch simpleCountDownLatch = new SimpleCountDownLatch(3);
        SimpleCountDownLatchThread simpleCountDownLatchThread = new SimpleCountDownLatchThread(simpleCountDownLatch);
        SimpleCountDownThread simpleCountDownThread = new SimpleCountDownThread(simpleCountDownLatch);

        simpleCountDownLatchThread.start();
        simpleCountDownThread.start();
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

        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
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
        public void await() throws InterruptedException {
            lock.lock();
            try {
                while (getCount() != 0) {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }

        /**
         *  Decrements the count of the latch, releasing all waiting threads when the count reaches zero.
         *  If the current count already equals zero then nothing happens.
         */
        public void countDown() {
            lock.lock();
            try {
                if (this.getCount() != 0) {
                    count--;
                    if (this.getCount() == 0) {
                        condition.signalAll();
                    }
                }
            } finally {
                lock.unlock();
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
