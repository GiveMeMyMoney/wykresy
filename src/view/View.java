package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.obserwator.BarChartModel;
import model.obserwator.PieChartModel;
import model.obserwowany.CollectionOfStudents;
import model.obserwowany.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class View extends Application {
    private static Logger logger = Logger.getLogger(View.class.getName());

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 686, 616));
        primaryStage.show();
    }

    private static List<Student> generate(int quantityOfStudent){
        List<Student> students = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < quantityOfStudent; i++) {
            int mark = Math.abs(random.nextInt(10));
            Student student = new Student("student " + String.valueOf(i+1), mark);
            students.add(student);
        }
        return students;
    }


    public static void main(String[] args) {
        launch(args);

        /*CollectionOfStudents collectionOfStudents = new CollectionOfStudents();

        List<Student> students1 = new ArrayList<>();
        students1 = generate(2);

        BarChartModel barChart = new BarChartModel();
        PieChartModel pieChart = new PieChartModel();


        collectionOfStudents.attachToAll(barChart);

        logger.info("1. BarChartModel: " + barChart.toString() + "PieChartModel: " + pieChart.toString());

        collectionOfStudents.notifyAllObservers(students1);

        logger.info("1. BarChartModel: " + barChart.toString() + "PieChartModel: " + pieChart.toString());


        List<Student> students2 = new ArrayList<>();
        students2 = generate(4);

        collectionOfStudents.detachToAll(barChart);
        collectionOfStudents.attachToAll(pieChart);

        collectionOfStudents.notifyAllObservers(students2);

        logger.info("1. BarChartModel: " + barChart.toString() + "PieChartModel: " + pieChart.toString());*/
    }
}
