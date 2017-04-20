package homework.ch16.prob_29;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Driver extends Application {
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(CalendarDisplayFX.getGrid(), 500, 500);
        CalendarDisplayFX.setGrid();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Calendar");
        primaryStage.show();
    }

}
