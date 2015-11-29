package model.obserwowany;

import model.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-11-29.
 */
public class Student {
    private String name = "";
    private Integer mark;


    public Student(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

    //GETTERs and SETTERs:
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getMark() {
        return mark;
    }
    public void setMark(Integer mark) {
        this.mark = mark;
    }

    //methods:
    /*public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update(name);
        }
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }

}
