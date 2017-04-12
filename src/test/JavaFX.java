package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by 15Cyndaquil on 4/11/2017.
 */
public class JavaFX extends Application{
    private static Scene scene;
    @Override
    public void start(Stage primaryStage) {
        MainScreen.mainScreenSetup();


        scene = new Scene(MainScreen.getGrid(), 500, 500);

        primaryStage.setTitle("Try JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
