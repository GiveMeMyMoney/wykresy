package model.obserwator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import model.obserwowany.Student;

/**
 * Created by Marcin on 2015-11-29.
 */
public class PieChartModel implements IObserver {
    private PieChart chart;

    public PieChartModel(PieChart chart){
        this.chart = chart;
    }

    @Override
    public void update(ObservableList<Student> students) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (Student student : students) {
            String name = student.getName();
            double mark = student.getMark();
            pieChartData.add(new PieChart.Data(name, mark));
        }

        this.chart.setData(pieChartData);
    }

}
