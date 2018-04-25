package sample.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class ControllerChart1 {


    @FXML
    private AreaChart<?, ?> areChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    public void initialize() {
        areChart.setTitle("Revenue");
        areChart.setLegendSide(Side.BOTTOM);
        XYChart.Series seriesChart = new XYChart.Series();
        seriesChart.setName("2018");
        seriesChart.getData().addAll(new XYChart.Data("1", 50));
        seriesChart.getData().addAll(new XYChart.Data("2", 66));
        seriesChart.getData().addAll(new XYChart.Data("3", 30));
        seriesChart.getData().addAll(new XYChart.Data("4", 78));
        seriesChart.getData().addAll(new XYChart.Data("5", 100));
        seriesChart.getData().addAll(new XYChart.Data("6", 89));
        seriesChart.getData().addAll(new XYChart.Data("7", 56));
        seriesChart.getData().addAll(new XYChart.Data("8", 50));
        seriesChart.getData().addAll(new XYChart.Data("9", 78));
        seriesChart.getData().addAll(new XYChart.Data("10", 64));
        seriesChart.getData().addAll(new XYChart.Data("11", 97));
        seriesChart.getData().addAll(new XYChart.Data("12", 88));

        areChart.getData().addAll(seriesChart);
    }
}
