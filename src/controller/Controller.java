package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.obserwator.BarChartModel;
import model.obserwator.PieChartModel;
import model.obserwowany.CollectionOfStudents;
import model.obserwowany.Student;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Controller implements Initializable {
    private static Logger logger = Logger.getLogger(Controller.class.getName());

    ///brzydki model z braku czasu
    private CollectionOfStudents collectionOfStudents;
    private BarChartModel barChart;
    private PieChartModel pieChart;
    private ObservableList<Student> students;
    private List<Student> studentList = new ArrayList<>();
    //View mam bezposrednio z fxmla.

    //ArrayList<Student> students = new ArrayList<>();

    ///FXML variable region
        @FXML
        private TextField ID_TF_NUMBER;
        @FXML private TableView<Student> ID_TABLE_VIEW;
        @FXML TableColumn<Student,String> COL_STUDENT;
        @FXML TableColumn<Student,String> COL_MARK;
        @FXML CheckBox CB_CHART_1, CB_CHART_2;
        //wykresy
        @FXML
        private BarChart<String, Integer> ID_BAR_CHART;
        @FXML
        private CategoryAxis ID_BAR_CHART_AXIS_X;
        @FXML
        private PieChart ID_PIE_CHART;
    //endregion

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //podpiecie Modelu
        collectionOfStudents = new CollectionOfStudents();
        pieChart = new PieChartModel(ID_PIE_CHART);
        barChart = new BarChartModel(ID_BAR_CHART, ID_BAR_CHART_AXIS_X);

        CB_CHART_1.setSelected(true);
        CB_CHART_2.setSelected(true);

        //ustawienie TableView
        COL_STUDENT.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        COL_MARK.setCellValueFactory(new PropertyValueFactory<Student, String>("mark"));
        setStudentsArray();
    }

    //private metod region
    private void setStudentsArray() {
        students = FXCollections.observableArrayList(studentList);
        ID_TABLE_VIEW.setItems(students);
    }

    private boolean validateInteger(String text)
    {
        if(text.matches("\\d*"))
            return false;
        else if (text.matches("\"\"")) { //nie lapie ""
            return true;
        } else {
            return true;
        }

    }

    private void generateListOfStudents(){
        if (validateInteger(ID_TF_NUMBER.getText())) {
            JOptionPane.showMessageDialog(null, "Please set an Integer into column \"Index number\"");
            ID_TF_NUMBER.setPromptText("Only Integer!");
            return;
        }
        Integer quantityOfStudent = Integer.valueOf(ID_TF_NUMBER.getText());
        if (ID_TF_NUMBER.getText().isEmpty()) {
            quantityOfStudent = 0;
        }
        studentList.clear();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < quantityOfStudent; i++) {
            int mark = Math.abs(random.nextInt(6)+1);
            Student student = new Student("student " + String.valueOf(i+1), mark);
            studentList.add(student);
        }
    }

    private boolean whichCheckBoxesAreSelected() {
        boolean flag = false; //jezeli zaden CB nie jest zaznaczony nie rob nic = oszczednosc operacji.
        if (CB_CHART_1.isSelected()) {
            flag = true;
            collectionOfStudents.attachToAll(barChart);
        } else {
            collectionOfStudents.detachToAll(barChart);
        }
        if (CB_CHART_2.isSelected()) {
            flag = true;
            collectionOfStudents.attachToAll(pieChart);
        } else  {
            collectionOfStudents.detachToAll(pieChart);
        }
        return flag;
    }




    //endregion


    ///FXML metod region
    @FXML protected void generateBtn() {
        generateListOfStudents();
        setStudentsArray();
        if (whichCheckBoxesAreSelected()) {
            collectionOfStudents.notifyAllObservers(students);
        } else {
            logger.info("Zaden CB nie zaznaczony");
        }
    }

    @FXML protected void clearBtn() {

    }
    //endregion

}
