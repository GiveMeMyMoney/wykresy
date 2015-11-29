package model;

import model.obserwowany.CollectionOfStudents;
import model.obserwowany.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by Marcin on 2015-11-29.
 */
public class PieChart extends Observer {

    public PieChart(List<Student> students) {
        super(students);

    }

    public PieChart() {
    }
}
