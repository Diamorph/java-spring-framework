package interthreadcommunication.example1;

public class InterThreadCommunication extends Thread {
    private boolean isComplete = false;

    public static void main(String[] args) {
        InterThreadCommunication communication = new InterThreadCommunication();
        communication.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        communication.complete();
    }

    public synchronized void waitUntilComplete() throws InterruptedException {
        while (!isComplete()) {
            this.wait();
        }
        System.out.println("Completed");
    }

    public void complete() {
        synchronized (this) {
            isComplete = true;
            this.notify();
        }
    }

    @Override
    public void run() {
        try {
            waitUntilComplete();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
