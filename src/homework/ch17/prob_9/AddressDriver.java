package homework.ch17.prob_9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddressDriver extends Application {
    private static Scene scene;
    @Override
    public void start(Stage primaryStage) {
        AddressInOut.loadAddresses();
        EditAddressFX.setGrid();
        scene = new Scene(EditAddressFX.getGrid(), 655,550);
        ViewAllAddressFX.setPane();
        EditAddressFX.getGrid().requestFocus();

//        primaryStage.setAlwaysOnTop(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Scene getScene(){
        return scene;
    }
}
