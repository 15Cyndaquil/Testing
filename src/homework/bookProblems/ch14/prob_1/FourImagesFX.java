package homework.bookProblems.ch14.prob_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * Created by 15Cyndaquil on 4/13/2017.
 */
public class FourImagesFX extends Application{
    @Override
    public void start(Stage primaryStage){
        GridPane grid = new GridPane();
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(50);
        RowConstraints row = new RowConstraints();
        row.setPercentHeight(50);

        grid.getColumnConstraints().addAll(col,col);
        grid.getRowConstraints().addAll(row, row);


        ImageView topRight = new ImageView(new Image("homework/bookProblems/ch14/prob_1/4.jpg"));
        ImageView topLeft = new ImageView(new Image("homework/bookProblems/ch14/prob_1/flag5.gif"));
        ImageView bottomRight = new ImageView(new Image("homework/bookProblems/ch14/prob_1/flag4.gif"));
        ImageView bottomLeft = new ImageView(new Image("homework/bookProblems/ch14/prob_1/flag6.gif"));

        grid.add(topLeft, 0,0);
        grid.add(topRight, 0,1);
        grid.add(bottomLeft, 1,0);
        grid.add(bottomRight, 1,1);

        grid.setGridLinesVisible(true);
        primaryStage.setTitle("Four Images");
        primaryStage.setScene(new Scene(grid, 500, 500));
        primaryStage.show();
    }
}
