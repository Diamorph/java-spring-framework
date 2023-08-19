package threadCoordination.join.example3;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger result = ComplexCalculation.calculateResult(BigInteger.TEN, BigInteger.TEN, new BigInteger("25"), new BigInteger("2"));
        System.out.println(result);
    }
}
