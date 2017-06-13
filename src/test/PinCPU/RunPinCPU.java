package test.PinCPU;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.StringConverter;


/**
 * Created by Cyndaquil on 6/10/2017.
 * Used to show CPU and RAM Load
 * also used to pin CPU at 100% Load
 */
public class RunPinCPU extends Application {

    final static int SECOND_VARIABLE = 14;

    static DoubleProperty cpuLoadValue = new SimpleDoubleProperty();
    static DoubleProperty ramLoadValue = new SimpleDoubleProperty();
    static StringProperty cpuCurrentValue = new SimpleStringProperty();
    static StringProperty ramCurrentValue = new SimpleStringProperty();
    static XYChart.Data[] chartCPU = new XYChart.Data[SECOND_VARIABLE*60];
    static XYChart.Data[] chartRAM = new XYChart.Data[SECOND_VARIABLE*60];

    @Override
    public void start(Stage primaryStage) throws Exception {
        XYChart.Series cpuChart = new XYChart.Series();
        XYChart.Series ramChart = new XYChart.Series();

        GridPane pane = new GridPane();
        pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button start = new Button("Start CPU Stress Test");
        start.setMinSize(100, 100);

        Button stop = new Button("Stop CPU Stress Test");
        stop.setMinSize(100, 100);

        TextField ramCurrentValueTxt = new TextField();
        ramCurrentValueTxt.textProperty().bind(ramCurrentValue);
        ramCurrentValueTxt.setEditable(false);
        ramCurrentValueTxt.setBackground(Background.EMPTY);

        TextField cpuCurrentValueTxt = new TextField();
        cpuCurrentValueTxt.textProperty().bind(cpuCurrentValue);
        cpuCurrentValueTxt.setEditable(false);
        cpuCurrentValueTxt.setBackground(Background.EMPTY);

        StartLoopThread loopThread = new StartLoopThread(Thread.currentThread());



        NumberAxis yAxis = new NumberAxis("Percentage of CPU Load", 0, 100, 10);
        NumberAxis xAxis = new NumberAxis("Time Seconds",0, SECOND_VARIABLE*60, (int) ((SECOND_VARIABLE*60d)/5d));

        xAxis.setTickLabelFormatter(new StringConverter<Number>() {
            @Override
            public String toString(Number object) {

                return String.valueOf((object.doubleValue()-SECOND_VARIABLE*60)/Double.valueOf(String.valueOf(SECOND_VARIABLE)));
            }

            @Override
            public Number fromString(String string) {
                return null;
            }
        });
        AreaChart<Number, Number> load = new AreaChart<>(xAxis, yAxis);
        load.setTitle("CPU & RAM Loads");
//        load.setAnimated(false);

        cpuChart.setName("CPU Load");
        ramChart.setName("Ram");

        setArray(chartCPU, cpuChart, cpuLoadValue);
        setArray(chartRAM, ramChart, ramLoadValue);

        start.setOnAction(event -> {
            Thread go = new Thread(loopThread);
            go.start();
        });

        stop.setOnAction(event -> loopThread.stop());

        load.getData().add(cpuChart);
        load.getData().add(ramChart);


        VBox currentValues = new VBox();
        currentValues.setAlignment(Pos.CENTER);
        currentValues.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        HBox currentCPU = new HBox();
        currentCPU.setAlignment(Pos.CENTER);
        Label cpu = new Label("CPU: ");
        cpu.setAlignment(Pos.CENTER);
        currentCPU.getChildren().addAll(cpu, cpuCurrentValueTxt);
        cpuCurrentValueTxt.setAlignment(Pos.CENTER_LEFT);
        cpuCurrentValueTxt.setMaxWidth(57);


        HBox currentRAM = new HBox();
        currentRAM.setAlignment(Pos.CENTER);
        currentRAM.getChildren().addAll(new Label("RAM: "), ramCurrentValueTxt);
        ramCurrentValueTxt.setMaxWidth(57);

        currentValues.getChildren().addAll(currentCPU,currentRAM);

        pane.add(start, 0, 0);
        pane.add(stop, 1, 0);
        pane.add(load, 0, 1);
        pane.add(currentValues, 1, 1);


        Thread cpuLoad = new Thread(new ChartUpdateThread(Thread.currentThread()));
        cpuLoad.start();
        primaryStage.setScene(new Scene(pane));
        primaryStage.setX(1913);
        primaryStage.setY(0);
        primaryStage.show();
    }

    private void setArray(XYChart.Data[] data, XYChart.Series chart, DoubleProperty propertyDouble){
        for(int i = 0; i< data.length-1; i++){
            data[i] = new XYChart.Data(i, 0);
            Rectangle rect = new Rectangle(0, 0);
            rect.setVisible(false);
            data[i].setNode(rect);
            chart.getData().add(data[i]);
        }


        data[data.length-1] = new XYChart.Data(SECOND_VARIABLE*60, 0);
        data[data.length-1].YValueProperty().bind(propertyDouble);

        chart.getData().addAll(data[data.length-1]);
    }
}
