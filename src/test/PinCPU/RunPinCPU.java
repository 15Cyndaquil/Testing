package test.PinCPU;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Cyndaquil on 6/10/2017.
 */
public class RunPinCPU extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        Button start = new Button("Start");
        start.setMinSize(100,100);
        Button stop = new Button("Stop");
        stop.setMinSize(100,100);
        StartLoopThread loopThread = new StartLoopThread();

        start.setOnAction(event -> {
            Thread go = new Thread(loopThread);
            go.start();
        });

        stop.setOnAction(event -> {
            loopThread.setGo(false);
        });


        pane.addRow(0);
        pane.addColumn(2);
        pane.add(start, 0,0);
        pane.add(stop, 1,0);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}
