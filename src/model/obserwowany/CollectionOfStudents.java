package model.obserwowany;

import javafx.collections.ObservableList;
import model.Observer;
import model.obserwator.IObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Marcin on 2015-11-29.
 */

/// moze mozna by podziedziczyc po MyArrayList<E> extends ArrayList<E> ?
public class CollectionOfStudents {
    //private List<Student> students = new ArrayList<>();
    private List<IObserver> observers = new ArrayList<>();

    public CollectionOfStudents() {
    }

    //methods
    /*public List<Student> getStudents() {
        return students;
    }
    public void addAllStudents(List<Student> students) {
        this.students.addAll(students);
    }
    public void removeAllStudents(List<Student> students) {
        this.students.removeAll(students);
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(Student student) {
        students.remove(student);
    }

    public int getSize() {
        return students.size();
    }*/

    /*public void generate(int quantityOfStudent){
        students.clear();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < quantityOfStudent; i++) {
            int mark = Math.abs(random.nextInt(10));
            Student student = new Student("student " + String.valueOf(i+1), mark);
            students.add(student);
        }
    }*/

    //Observe method
    public void attachToAll(IObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void detachToAll(IObserver observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    public void notifyAllObservers(ObservableList<Student> students){
        for (IObserver observer : observers) {
            observer.update(students);
        }
    }

}
