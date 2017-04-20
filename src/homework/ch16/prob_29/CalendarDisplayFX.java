package homework.ch16.prob_29;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Created by 15Cyndaquil on 4/19/2017.
 */
public class CalendarDisplayFX {
    private static GridPane grid = new GridPane();
    private static double rowAmt = 9;
    private static double colAmt = 7;

    private static void setRow() {
        for (int i = 0; i < rowAmt; i++){
            RowConstraints row = new RowConstraints();
            row.setPercentHeight((1/rowAmt)*100);
            grid.getRowConstraints().addAll(row);
        }
    }
    private static void setCol() {
        for (int i = 0; i < colAmt; i++){
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth((1/colAmt)*100);
            grid.getColumnConstraints().addAll(col);
        }
    }
    private static void addMonth(){
        Text month = new Text();

        month.setText("Month");
        grid.add(month, 2, 0);
        GridPane.setColumnSpan(month, 3);
        GridPane.setHalignment(month, HPos.CENTER);
    }
    private static void addDays(){
        Text sunday = new Text("Sunday");
        Text monday = new Text("Monday");
        Text tuesday = new Text("Tuesday");
        Text wednesday = new Text("Wednesday");
        Text thursday = new Text("Thursday");
        Text friday = new Text("Friday");
        Text saturday = new Text("Saturday");

        grid.add(sunday,0,1);
        grid.add(monday,1,1);
        grid.add(tuesday,2,1);
        grid.add(wednesday,3,1);
        grid.add(thursday,4,1);
        grid.add(friday,5,1);
        grid.add(saturday,6,1);

        GridPane.setHalignment(sunday, HPos.CENTER);
        GridPane.setHalignment(monday, HPos.CENTER);
        GridPane.setHalignment(tuesday, HPos.CENTER);
        GridPane.setHalignment(wednesday, HPos.CENTER);
        GridPane.setHalignment(thursday, HPos.CENTER);
        GridPane.setHalignment(friday, HPos.CENTER);
        GridPane.setHalignment(saturday, HPos.CENTER);
    }



    public static void setGrid() {
        setCol();
        setRow();
        addMonth();
        addDays();
    }

    public static GridPane getGrid() {
        grid.setGridLinesVisible(true);
        return grid;
    }
}
