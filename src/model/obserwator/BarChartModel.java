package model.obserwator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import model.obserwowany.Student;

/**
 * Created by Marcin on 2015-11-29.
 */
public class BarChartModel implements IObserver {
    private BarChart<String, Integer> chart;
    private CategoryAxis categoryAxis;

    public BarChartModel(BarChart<String, Integer> chart, CategoryAxis categoryAxis){
        this.chart = chart;
        this.categoryAxis = categoryAxis;
    }

    @Override
    public void update(ObservableList<Student> students) {
        this.chart.getData().clear();

        //ustawianie nazw X
        ObservableList<String> names = FXCollections.observableArrayList();
        for (Student student : students) {
            names.add(student.getName());
        }
        this.categoryAxis.setCategories(names);

        //ustalanie Y dla kazdego osobnego X.
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for (Student student : students) {
            XYChart.Data<String, Integer> value = new XYChart.Data<>(student.getName(), student.getMark());
            series.getData().add(value);
        }

        this.chart.getData().add(series);
    }

}
