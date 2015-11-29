package model;

import model.obserwowany.CollectionOfStudents;
import model.obserwowany.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcin on 2015-11-29.
 */

/**
 * Klasy które OBSERWUJA
 */
public class Observer {
    private List<Student> students = new ArrayList<>();

    public Observer(List<Student> students) {
        this.students = students;
    }
    public Observer() {
    }


    public void update(List<Student> students) {
        this.students.clear();
        this.students = students;
    }

    @Override
    public String toString() {
        return "Observer{" +
                "students=" + this.students +
                '}';
    }
}
