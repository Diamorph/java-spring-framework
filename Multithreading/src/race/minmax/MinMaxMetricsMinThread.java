package race.minmax;

import java.util.Random;

public class MinMaxMetricsMinThread extends Thread {
    private MinMaxMetrics minMaxMetrics;
    private Random random = new Random();

    MinMaxMetricsMinThread(MinMaxMetrics minMaxMetrics) {
        this.minMaxMetrics = minMaxMetrics;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Min: " + minMaxMetrics.getMin());
        }
    }
}
