package test;

import com.sun.javafx.binding.StringFormatter;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * Created by 15Cyndaquil on 6/27/2017.
 * Basic Stop watch
 */
public class StopWatch extends Application {
    protected static StringProperty string = new SimpleStringProperty("00:59:55.0");
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField time = new TextField();
        time.setEditable(false);

        time.textProperty().bind(string);
        Pane pane = new Pane();
        HBox hBox = new HBox();
        Button startP = new Button("Start");
        Button reset = new Button("Reset");
        ChangeTimeThread timeThread = new ChangeTimeThread(string);

        startP.setOnAction(e->{
            if(startP.getText().equals("Start")){
                timeThread.setGo(true);
                Thread thread = new Thread(timeThread);
                thread.start();
                startP.setText("Pause");
            }else if(startP.getText().equals("Pause")){
                timeThread.setGo(false);
                startP.setText("Start");
            }
        });
        reset.setOnAction(e->{
            timeThread.setGo(false);
            string.setValue("00:00:00.0");
            if(startP.getText().equals("Pause")){
                startP.setText("Start");
            }
        });
        hBox.getChildren().addAll(time, startP, reset);
        pane.getChildren().addAll(hBox);

        primaryStage.setOnCloseRequest(e->{
            timeThread.setGo(false);
        });
        primaryStage.setScene(new Scene(pane, 240, 25));
        primaryStage.show();
    }
}
 class ChangeTimeThread implements Runnable{
    private StringProperty text;
    private volatile Boolean go;
    private DecimalFormat format = new DecimalFormat("00");
    ChangeTimeThread(StringProperty text){
        this.text = text;
        go = false;
    }

    @Override
    public void run() {
        while(go) {
            StringBuilder text = new StringBuilder(this.text.getValue());
            addTime(text);
            StopWatch.string.setValue(text.toString());

            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void addTime(StringBuilder text){
        int[] index = new int[3];
        setIndexs(index, text);
        if(Integer.valueOf(text.substring(index[2]+1))==9){
            text.replace(index[1]+1, index[2], String.valueOf(format.format(Integer.valueOf(text.substring(index[1]+1, index[2]))+1)));
            text.replace(index[2]+1, text.toString().length(), "0");
            if(Integer.valueOf(text.substring(index[1]+1, index[2]))==60){
                text.replace(index[0]+1, index[1], String.valueOf(format.format(Integer.valueOf(text.substring(index[0]+1, index[1]))+1)));
                text.replace(index[1]+1, index[2], "00");
                System.out.println(text);
                if(Integer.valueOf(text.substring(index[0]+1, index[1]))==60){
                    text.replace(0, index[0]+1, String.format("%s",Integer.valueOf(text.substring(0, index[0]))+1)+":");
                    setIndexs(index, text);
                    text.replace(index[0]+1, index[1], "00");
                }
            }

        }
        text.replace(index[2]+1, text.toString().length(), String.valueOf(Integer.valueOf(text.substring(index[2]+1))+1));
    }
     private void setIndexs(int index[], StringBuilder text) {
         index[0] = text.indexOf(":");
         index[1] = text.lastIndexOf(":");
         index[2] = text.indexOf(".");
     }

    void setGo(Boolean go){
        this.go = go;
    }
}

