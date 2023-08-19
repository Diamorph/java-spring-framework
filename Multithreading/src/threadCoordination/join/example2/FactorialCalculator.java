package threadCoordination.join.example2;

import java.math.BigInteger;

public class FactorialCalculator {
    private final long inputNumber;
    private BigInteger result = BigInteger.ZERO;
    private boolean isFinished = false;

    public FactorialCalculator(long inputNumber) {
        this.inputNumber = inputNumber;
    }

    public BigInteger factorial(long n) throws InterruptedException {
        BigInteger tempResult = BigInteger.ONE;
        for (long i = n; i > 0; i--) {
            if (Thread.currentThread().isInterrupted()) {
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

    public long getInputNumber() {
        return inputNumber;
    }

    public void calculate() throws InterruptedException {
        this.result = factorial(inputNumber);
        this.isFinished = true;
    }
}
