package test;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * Created by 15Cyndaquil on 4/11/2017.
 */
public class MainScreen {
    private static GridPane grid;

    public static void mainScreenSetup(){
        grid = new GridPane();
        for(int col=0; col<10; col++){
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(10);
            column.setHgrow(Priority.ALWAYS);
            column.setFillWidth(true);
            grid.getColumnConstraints().add(column);
        }
        for(int ro=0; ro<10; ro++){
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(10);
            row.setVgrow(Priority.ALWAYS);
            row.setFillHeight(true);
            grid.getRowConstraints().add(row);
        }
        grid.setGridLinesVisible(true);
    }

    public static GridPane getGrid(){return grid;}
}
