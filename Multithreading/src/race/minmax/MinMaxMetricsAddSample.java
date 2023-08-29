package race.minmax;

import java.util.Random;

public class MinMaxMetricsAddSample extends Thread {
    private MinMaxMetrics minMaxMetrics;
    private Random random = new Random();

    MinMaxMetricsAddSample(MinMaxMetrics minMaxMetrics) {
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
            minMaxMetrics.addSample(random.nextLong(1000000) - 500000);
        }
    }
}
