package homework.bookProblems.ch15.prob_33;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Driver extends Application{
    @Override
    public void start(Stage primaryStage){
        FXDisplay.setUpPane();



        primaryStage.setScene(new Scene(FXDisplay.getPane(), 500, 500));
        primaryStage.setTitle("Bean Machine");
        primaryStage.show();
    }
}
