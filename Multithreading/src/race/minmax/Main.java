package race.minmax;

public class Main {
    public static void main(String[] args) {
        MinMaxMetrics minMaxMetrics = new MinMaxMetrics();

        MinMaxMetricsMinThread minMaxMetricsMinThread = new MinMaxMetricsMinThread(minMaxMetrics);
        minMaxMetricsMinThread.setName("Min Thread");
        MinMaxMetricsMaxThread minMaxMetricsMaxThread = new MinMaxMetricsMaxThread(minMaxMetrics);
        minMaxMetricsMinThread.setName("Max Thread");
        MinMaxMetricsAddSample minMaxMetricsAddSample = new MinMaxMetricsAddSample(minMaxMetrics);
        minMaxMetricsMinThread.setName("Add Thread");

        minMaxMetricsAddSample.start();
        minMaxMetricsMinThread.start();
        minMaxMetricsMaxThread.start();

    }
}
