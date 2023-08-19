package threadCoordination.join.example2;

public class FactorialThread extends Thread {

    protected FactorialCalculator factorialCalculator;

    public FactorialThread(FactorialCalculator factorialCalculator) {
        this.factorialCalculator = factorialCalculator;
    }

    @Override
    public void run() {
        try {
            this.factorialCalculator.calculate();
        } catch (InterruptedException e) {
            System.out.println("Thread for calculation " +  factorialCalculator.getInputNumber() + " was interrupted");
        }
    }

    public void printInfo() {
        if (factorialCalculator.isFinished()) {
            System.out.println("Factorial of " + factorialCalculator.getInputNumber() + " is " + factorialCalculator.getResult());
        } else {
            System.out.println("The calculation for " +  factorialCalculator.getInputNumber() + " is still in progress");
            interrupt();
        }
    }
}
