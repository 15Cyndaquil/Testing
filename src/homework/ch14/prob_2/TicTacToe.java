package homework.ch14.prob_2;

import com.sun.glass.ui.Size;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by 15Cyndaquil on 4/13/2017.
 */
public class TicTacToe extends Application {
    @Override
    public void start(Stage primaryStage){
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 666, 666);
        primaryStage.setScene(scene);

        ColumnConstraints columnMain = new ColumnConstraints();
        ColumnConstraints columnBetween = new ColumnConstraints();
        columnMain.setPercentWidth(30);
        columnBetween.setPercentWidth(5.5);
        RowConstraints rowMain = new RowConstraints();
        RowConstraints rowBetween = new RowConstraints();
        rowMain.setPercentHeight(30);
        rowBetween.setPercentHeight(5.5);

        grid.getRowConstraints().addAll(rowMain, rowBetween, rowMain, rowBetween, rowMain);
        grid.getColumnConstraints().addAll(columnMain, columnBetween, columnMain, columnBetween, columnMain);
        grid.setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), null,null)));

        Button topLeft = new Button();
        Button topMid = new Button();
        Button topRight = new Button();

        Button midLeft = new Button();
        Button midMid = new Button();
        Button midRight = new Button();

        Button botLeft = new Button();
        Button botMid = new Button();
        Button botRight = new Button();

//      Created Boarders between Buttons
        Rectangle b1 = new Rectangle();
        Rectangle b2 = new Rectangle();
        Rectangle b3 = new Rectangle();
        Rectangle b4 = new Rectangle();
        Rectangle b5 = new Rectangle();
        Rectangle b6 = new Rectangle();
        Rectangle b11 = new Rectangle();
        Rectangle b12 = new Rectangle();
        Rectangle b13 = new Rectangle();
        Rectangle b14 = new Rectangle();
        Rectangle b15 = new Rectangle();
        Rectangle b21 = new Rectangle();
        Rectangle b22 = new Rectangle();
        Rectangle b23 = new Rectangle();
        Rectangle b24 = new Rectangle();
        Rectangle b25 = new Rectangle();

        b1.setFill(Color.BLACK);
        b2.setFill(Color.BLACK);
        b3.setFill(Color.BLACK);
        b4.setFill(Color.BLACK);
        b5.setFill(Color.BLACK);
        b6.setFill(Color.BLACK);

        b11.setFill(Color.BLACK);
        b12.setFill(Color.BLACK);
        b13.setFill(Color.BLACK);
        b14.setFill(Color.BLACK);
        b15.setFill(Color.BLACK);

        b21.setFill(Color.BLACK);
        b22.setFill(Color.BLACK);
        b23.setFill(Color.BLACK);
        b24.setFill(Color.BLACK);
        b25.setFill(Color.BLACK);

        topLeft.setBackground(new Background(
                new BackgroundImage(
                        new Image("homework/ch14/prob_2/o.gif"),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));


        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                System.out.println("Width: " + newSceneWidth);
                topLeft.setMinWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));
                topMid.setMinWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));
                topRight.setMinWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));

                midLeft.setMinWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));
                midMid.setMinWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));
                midRight.setMinWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));

                botLeft.setMinWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));
                botMid.setMinWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));
                botRight.setMinWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));

                b1.setWidth((newSceneWidth.doubleValue()*columnBetween.getPercentWidth()/100));
                b2.setWidth((newSceneWidth.doubleValue()*columnBetween.getPercentWidth()/100));
                b3.setWidth((newSceneWidth.doubleValue()*columnBetween.getPercentWidth()/100));
                b4.setWidth((newSceneWidth.doubleValue()*columnBetween.getPercentWidth()/100));
                b5.setWidth((newSceneWidth.doubleValue()*columnBetween.getPercentWidth()/100));
                b6.setWidth((newSceneWidth.doubleValue()*columnBetween.getPercentWidth()/100));

                b11.setWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));
                b12.setWidth((newSceneWidth.doubleValue()*columnBetween.getPercentWidth()/100));
                b13.setWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));
                b14.setWidth((newSceneWidth.doubleValue()*columnBetween.getPercentWidth()/100));
                b15.setWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));

                b21.setWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));
                b22.setWidth((newSceneWidth.doubleValue()*columnBetween.getPercentWidth()/100));
                b23.setWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));
                b24.setWidth((newSceneWidth.doubleValue()*columnBetween.getPercentWidth()/100));
                b25.setWidth((newSceneWidth.doubleValue()*columnMain.getPercentWidth()/100));
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                System.out.println("Height: "+newSceneHeight);
                topLeft.setMinHeight(newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100));
                topMid.setMinHeight(newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100));
                topRight.setMinHeight(newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100));

                midLeft.setMinHeight(newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100));
                midMid.setMinHeight(newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100));
                midRight.setMinHeight(newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100));

                botLeft.setMinHeight(newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100));
                botMid.setMinHeight(newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100));
                botRight.setMinHeight(newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100));

                b1.setHeight((newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100)));
                b2.setHeight((newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100)));
                b3.setHeight((newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100)));
                b4.setHeight((newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100)));
                b5.setHeight((newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100)));
                b6.setHeight((newSceneHeight.doubleValue()*(rowMain.getPercentHeight()/100)));

                b11.setHeight((newSceneHeight.doubleValue()*(rowBetween.getPercentHeight()/100)));
                b12.setHeight((newSceneHeight.doubleValue()*(rowBetween.getPercentHeight()/100)));
                b13.setHeight((newSceneHeight.doubleValue()*(rowBetween.getPercentHeight()/100)));
                b14.setHeight((newSceneHeight.doubleValue()*(rowBetween.getPercentHeight()/100)));
                b15.setHeight((newSceneHeight.doubleValue()*(rowBetween.getPercentHeight()/100)));

                b21.setHeight((newSceneHeight.doubleValue()*(rowBetween.getPercentHeight()/100)));
                b22.setHeight((newSceneHeight.doubleValue()*(rowBetween.getPercentHeight()/100)));
                b23.setHeight((newSceneHeight.doubleValue()*(rowBetween.getPercentHeight()/100)));
                b24.setHeight((newSceneHeight.doubleValue()*(rowBetween.getPercentHeight()/100)));
                b25.setHeight((newSceneHeight.doubleValue()*(rowBetween.getPercentHeight()/100)));
            }
        });

//      Set Grid
        grid.add(topLeft, 0,0);
        grid.add(b1, 1,0);
        grid.add(topMid, 2,0);
        grid.add(b2, 3,0);
        grid.add(topRight, 4,0);

        grid.add(b11, 0,1);
        grid.add(b12, 1,1);
        grid.add(b13, 2,1);
        grid.add(b14, 3,1);
        grid.add(b15, 4,1);

        grid.add(midLeft, 0,2);
        grid.add(b3, 1,2);
        grid.add(midMid, 2,2);
        grid.add(midRight, 4,2);
        grid.add(b4, 3,2);

        grid.add(b21, 0,3);
        grid.add(b22, 1,3);
        grid.add(b23, 2,3);
        grid.add(b24, 3,3);
        grid.add(b25, 4,3);

        grid.add(botLeft, 0,4);
        grid.add(b5, 1,4);
        grid.add(botMid, 2,4);
        grid.add(botRight, 4,4);
        grid.add(b6, 3,4);

        primaryStage.setTitle("Tic-Tac-Toe");

        primaryStage.show();
    }
}
