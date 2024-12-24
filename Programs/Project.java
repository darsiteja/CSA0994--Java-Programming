import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class VegetablePricePrediction {

    public static void main(String[] args) {
        // Data for vegetable prices
        String[] days = {"Day 1", "Day 2", "Day 3", "Day 4", "Day 5"};
        String[] vegetables = {"Tomato", "Potato", "Onion"};
        double[][] prices = {
            {30.0, 32.0, 35.0, 40.0, 42.0}, // Tomato prices
            {20.0, 22.0, 24.0, 26.0, 28.0}, // Potato prices
            {50.0, 48.0, 52.0, 55.0, 60.0}  // Onion prices
        };

        // Create a dataset manually
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int vegIndex = 0; vegIndex < vegetables.length; vegIndex++) {
            for (int dayIndex = 0; dayIndex < days.length; dayIndex++) {
                dataset.addValue(prices[vegIndex][dayIndex], vegetables[vegIndex], days[dayIndex]);
            }
        }

        // Create the chart
        JFreeChart lineChart = ChartFactory.createLineChart(
            "Vegetable Price Prediction",
            "Days",
            "Price (₹)",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        // Display the chart
        JFrame frame = new JFrame("Vegetable Price Prediction");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        frame.add(chartPanel);
        frame.setVisible(true);
    }
}
