package model;

import model.obserwowany.Student;

import java.util.List;

/**
 * Created by Marcin on 2015-11-29.
 */
public class BarChart extends Observer {

    public BarChart(List<Student> students) {
        super(students);

    }

    public BarChart() {
    }
}
