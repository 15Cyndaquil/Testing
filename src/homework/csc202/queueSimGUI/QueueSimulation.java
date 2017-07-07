package homework.csc202.queueSimGUI;

import homework.csc202.lab07QueueSimulationV2.QueueV2Tester;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

import java.io.File;
import java.text.DecimalFormat;

/**
 * Created by 15Cyndaquil on 7/5/2017.
 */
public class QueueSimulation extends Application {
    private static Label hour, day;
    private static TextField hourIn, dayIn;
    private static Button start, stop;
    private static TextArea output;
    private static ImageView currentCustomer;
    private static File[] images = new File[13];
    private static ImageView[] queue = new ImageView[10];
    private static volatile boolean go;
    private static SimpleObjectProperty<Image>[] queueImages = new SimpleObjectProperty[10];
    private static SimpleIntegerProperty[] queueImage = new SimpleIntegerProperty[10];
    private static QueueUpdateThread thread;

    @Override
    public void start(Stage primaryStage) throws Exception {
        File dir = new File("src/homework/csc202/queueSimGUI");
        setImageFile(dir);
        setQueueImage();


        for(int i=0; i<10; i++) {
            final int x =i;
            queueImage[i] = new SimpleIntegerProperty();
            queueImage[x].addListener(e -> {
                queueImages[x].setValue(new Image(images[queueImage[x].get()].toURI().toString()));
            });
        }

        primaryStage.setOnCloseRequest(e->{
            if(thread!=null) thread.stop();
        });


        primaryStage.setScene(new Scene(setPane(), 594, 315));
        primaryStage.show();
    }

    //Set Main Display
    private static VBox setPane(){
        VBox pane = new VBox();
        pane.setPadding(new Insets(5,5,5,5));
        pane.getChildren().addAll(setDisplay(), setSpace(), setQueue());
        startAction();
        stopAction();
        return pane;
    }

    //Methods for Main Display
    private static HBox setDisplay(){
        HBox display = new HBox();
        display.getChildren().add(new ImageView(images[12].toURI().toString()));
        display.getChildren().add(setInQueue());
        display.getChildren().add(setInput(100));
        display.setAlignment(Pos.CENTER);
        return display;
    }
    private static Box setSpace(){
        Box space = new Box(594, 50, 0);
        space.setOpacity(0);
        return space;
    }
    private static VBox setInQueue(){
        ImageView bAbove = new ImageView(images[11].toURI().toString());
        currentCustomer = new ImageView();
        currentCustomer.imageProperty().bind(queueImages[0]);
        ImageView bBelow = new ImageView(images[11].toURI().toString());
        bAbove.setFitHeight(46);
        bBelow.setFitHeight(46);

        return new VBox(bAbove, currentCustomer, bBelow);
    }
    private static HBox setQueue(){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        for(int i=0; i<10; i++){
            hBox.getChildren().add(queue[i]);
        }
        return hBox;
    }
    private static Pane setInput(double width){
        hour = new Label("Hours"); day = new Label("Days");
        hourIn = new TextField("8"); dayIn = new TextField("1");
        start = new Button("Start"); stop = new Button("Stop");
        output = new TextArea("Results");


        hour.setPrefWidth(width);
        day.setPrefWidth(width);
        hourIn.setPrefWidth(width);
        dayIn.setPrefWidth(width);
        start.setPrefWidth(width);
        stop.setPrefWidth(width);
        output.setPrefWidth(width*2);
        output.setPrefHeight(100);
        output.setEditable(false);

        VBox main = new VBox();

        HBox hourBox = new HBox();
        HBox dayBox = new HBox();
        HBox button = new HBox();
        hourBox.getChildren().addAll(hour, hourIn);
        dayBox.getChildren().addAll(day, dayIn);
        button.getChildren().addAll(start, stop);
        main.getChildren().addAll(hourBox, dayBox, button, output);

        return new Pane(main);
    }
    private static void setImageFile(File dir){
        for(int i=0; i<=10; i++){
            images[i] = new File(dir, i+".png");
        }
        images[11] = new File(dir, "blank.png");
        images[12] = new File(dir, "desk.png");
    }
    private static void setQueueImage(){
        for(int i=0; i<10; i++){
            queueImages[i] = new SimpleObjectProperty<>(new Image(images[11].toURI().toString()));
            queue[i] = new ImageView();
            queue[i].imageProperty().bind(queueImages[i]);
        }
    }



    //Methods for Buttons
    private static void startAction() {
        start.setOnAction(e -> {
            go = true;
            output.setText("");
            DecimalFormat format = new DecimalFormat("0.00");
            StringBuilder outputText = new StringBuilder();
            try {
                int days = Integer.valueOf(dayIn.getText());
                for(int i=0; i<days; i++) {
                    int hours = Integer.valueOf(hourIn.getText());

                    QueueV2Tester sim = new QueueV2Tester(hours, 1, 3);
                    sim.runSimulation();
                    if (thread != null) {
                        thread.stop();
                    }
                    thread = new QueueUpdateThread(hours, days, images, queueImage, sim, go);
                    Thread test = new Thread(thread);
                    test.start();



                    outputText.append("Day: "+(i+1)+"\n");
                    outputText.append("Avg waiting time = " + format.format(sim.getAverageWaitTime()) + "\n");
                    outputText.append("Max waiting time = " + sim.getLongestWaitTime() + "\n");
                    outputText.append("Total customers = " + sim.getTotalCustomers() + "\n");
                    outputText.append("No. of customers left = " + sim.getLeft()+"\n\n");
                }
                output.setText(outputText.toString());
            } catch (NumberFormatException exc) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setHeaderText("Input error");
                error.setContentText("Check Hours and Days input one is not a valid input");
                error.show();
                exc.printStackTrace();
            }
        });
    }
    private static void stopAction(){
        stop.setOnAction(e->{
            thread.stop();
            for(int i=0; i<10; i++){
                queueImage[i].setValue(11);
            }
        });
    }
}
