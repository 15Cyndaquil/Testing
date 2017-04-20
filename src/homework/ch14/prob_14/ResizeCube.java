package homework.ch14.prob_14;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 * Created by 15Cyndaquil on 4/18/2017.
 */
public class ResizeCube extends Application{
    Point2D topLeft = new Point2D(10, 20);
    Point2D topRight = new Point2D(30, 20);
    Point2D topTop = new Point2D(20, 10);
    Point2D topBot = new Point2D(20, 30);

    Point2D botLeft = new Point2D(10, 20);
    Point2D botRight = new Point2D(30, 20);
    Point2D botTop = new Point2D(20, 10);
    Point2D botBot = new Point2D(20, 30);

    @Override
    public void start(Stage primaryStage){

        double[] topSquare = {
                 topLeft.getX(), topLeft.getY()
                ,topTop.getX(),topTop.getY()
                ,topRight.getX(), topRight.getY()
                ,topBot.getX(), topBot.getY()
                ,topLeft.getX(), topLeft.getY()};

        Polyline cube = new Polyline(topSquare);
        Pane pane = new Pane();
        pane.getChildren().addAll(cube);

//        pane.widthProperty().addListener((observable, oldWidth, newWidth)->{
//            double test = newWidth.doubleValue()/100;
//            cube.getPoints().set(0, test);
//            cube.getPoints().set(2, test*2);
//            cube.getPoints().set(4, test*4);
//            cube.getPoints().set(6, test*6);
//            cube.getPoints().set(8, test*8);
//            cube.getPoints().set(10, test*10);
//            cube.getPoints().set(12, test*12);
//            cube.getPoints().set(14, test*14);
//        });
//
//        pane.heightProperty().addListener((observable, odlHeight, newHeight)->{
//            double test = newHeight.doubleValue()/100;
//            cube.getPoints().set(1, test);
//            cube.getPoints().set(3, test*2);
//            cube.getPoints().set(5, test*4);
//            cube.getPoints().set(7, test*6);
//            cube.getPoints().set(9, test*8);
//            cube.getPoints().set(11, test*10);
//            cube.getPoints().set(13, test*12);
//            cube.getPoints().set(15, test*14);
//        });

        primaryStage.setScene(new Scene(pane, 100, 100));
        primaryStage.show();

    }
}
