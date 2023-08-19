package threadCoordination.join.example1;

import java.math.BigInteger;

public class FactorialThread extends Thread {
    private final long inputNumber;
    private BigInteger result = BigInteger.ZERO;
    private boolean isFinished = false;

    public FactorialThread(long inputNumber) {
        this.inputNumber = inputNumber;
    }

    public BigInteger factorial(long n) throws InterruptedException {
        BigInteger tempResult = BigInteger.ONE;
        for (long i = n; i > 0; i--) {
            if (currentThread().isInterrupted()) {
                throw new InterruptedException("Thread was interrupted");
            }
            tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
        }
        return tempResult;
    }

    public BigInteger getResult() {
        return result;
    }

    public boolean isFinished() {
        return isFinished;
    }

    @Override
    public void run() {
        try {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        } catch (InterruptedException e) {
            System.out.println("Exiting blocking thread");
        }
    }
}
