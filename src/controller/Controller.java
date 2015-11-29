package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.obserwowany.Student;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Controller implements Initializable {
    private static Logger logger = Logger.getLogger(Controller.class.getName());

    ///"slabe" ladowanie modelu na sztywno. Brak konstr.
    //private Fasade model = Fasade.getInstance();
    //View mam bezposrednio z fxmla.

    //ArrayList<Student> students = new ArrayList<>();

    ///FXML variable region
    @FXML
    private TextField ID_TF_NUMBER;
    @FXML private TableView<Student> ID_TABLE_VIEW;
    @FXML TableColumn<Student,String> COL_STUDENT;
    @FXML TableColumn<Student,String> COL_MARK;
    @FXML CheckBox CB_CHART_1, CB_CHART_2;
    //endregion

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //COL_STUDENT.setCellValueFactory(new PropertyValueFactory<>("Index"));
        //COL_MARK.setCellValueFactory(new PropertyValueFactory<>("Name"));
        //setVehiclesArray();
    }

    //private metod region
    private void setVehiclesArray() {
        /*students = new ArrayList<>(model.getAllStudentFromDB());
        ObservableList<Student> data = FXCollections.observableArrayList(students);
        tableViewStudent.setItems(data);*/
    }


    //endregion


    ///FXML metod region
    @FXML protected void generateBtn() {

    }

    @FXML protected void clearBtn() {

    }
    //endregion

}
