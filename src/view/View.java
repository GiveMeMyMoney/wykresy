package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.BarChart;
import model.Observer;
import model.PieChart;
import model.obserwowany.CollectionOfStudents;

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


    public static void main(String[] args) {
        CollectionOfStudents collectionOfStudents = new CollectionOfStudents();

        Observer chart1 = new Observer();
        Observer chart2 = new Observer();

        logger.info("1. BarChart: " + chart1.toString() + "PieChart: " + chart2.toString());


        collectionOfStudents.generate(2);   //generuje od nowa students w CollectionOfStudents

        logger.info("COS: " + collectionOfStudents.toString());

        collectionOfStudents.attachToAll(chart1);  //podlaczam 1 wykres
        //collectionOfStudents.attachToAll(chart2);

        logger.info("2. BarChart: " + chart1.toString() + "PieChart: " + chart2.toString()); //tu nie powinno jeszcze byc nic bo nie poinformowalem (notifyAllObservers())

        collectionOfStudents.notifyAllObservers();  //informuje o zmianie i powinno wypisac i tak wypisuje

        logger.info("3. BarChart: " + chart1.toString() + "PieChart: " + chart2.toString());    //wypisuje w chart1 a w chart2 pusto czyli jest ok

        collectionOfStudents.detachToAll(chart1);   //dolaczam wykres1
        collectionOfStudents.attachToAll(chart2);   //podlaczam wykres2

        collectionOfStudents.generate(4); //generuje od nowa students w CollectionOfStudents

        collectionOfStudents.notifyAllObservers();  //daje powiadomienie w ktorym powinno zmienic tylko wykres2(4studentów)
                        ///////////////////////////// a w wykres 1 stare wartosci czyli 2 studentow.
                                    //////////////// i tak robi bo patrze w debuga cala sciezke

        //i tu nagle z dupy wykres 1 ma nowe dane czyli 4 studentow(zamiast 2) a wykres 2 jest ok bo ma 4 ktorych powinien miec.
        logger.info("4. BarChart: " + chart1.toString() + "PieChart: " + chart2.toString());

        //kurde mol :(



        launch(args);
    }
}
