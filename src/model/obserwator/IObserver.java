package model.obserwator;

import javafx.collections.ObservableList;
import model.obserwowany.Student;


/**
 * Created by Marcin on 2015-11-29.
 */
public interface IObserver {
    void update(ObservableList<Student> students);
}
