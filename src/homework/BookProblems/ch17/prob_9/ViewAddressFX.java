package homework.BookProblems.ch17.prob_9;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


/**
 * Created by 15Cyndaquil on 4/25/2017.
 */
public class ViewAddressFX {
    private static GridPane grid = new GridPane();
    private static double rowInt = 4;
    private static double colInt = 7;


    private static Text firstName = new Text();
    private static Text lastName = new Text();
    private static Text buildingNum = new Text();
    private static Text street = new Text();
    private static Text city = new Text();
    private static Text state = new Text();
    private static Text zip = new Text();


    private static void setRow(){
        RowConstraints row = new RowConstraints();
        row.setPercentHeight(1/rowInt*100);
        for(int i=0; i<rowInt; i++){
            grid.getRowConstraints().add(row);
        }
    }
    private static void setCol(){
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(1/colInt*100);
        for(int i=0; i<colInt; i++){
            grid.getColumnConstraints().add(col);
        }
    }
    private static void setText(){
        Text firstName = new Text("First Name");
        Text lastName = new Text("Last Name");
        Text buildingNum = new Text("Building Number");
        Text street = new Text("Street");
        Text city = new Text("City");
        Text state = new Text("State");
        Text zip = new Text("Zip");

        grid.add(firstName, 0,0);
        grid.add(lastName, 4,0);
        grid.add(buildingNum, 0, 1);
        grid.add(street, 3,1);
        grid.add(city, 0,2);
        grid.add(state, 3,2);
        grid.add(zip, 5,2);

        GridPane.setHalignment(firstName, HPos.RIGHT);
        GridPane.setHalignment(street, HPos.RIGHT);
        GridPane.setHalignment(city, HPos.RIGHT);
        GridPane.setHalignment(state, HPos.RIGHT);
        GridPane.setHalignment(zip, HPos.RIGHT);

        GridPane.setValignment(firstName, VPos.CENTER);
        GridPane.setValignment(street, VPos.CENTER);
        GridPane.setValignment(city, VPos.CENTER);
        GridPane.setValignment(state, VPos.CENTER);
        GridPane.setValignment(zip, VPos.CENTER);
    }
    private static void setTextFeild(String firstNameS, String lastNameS,String streetS, String stateS, String cityS, int zipI, long buildingL){
        firstName.setText(firstNameS);
        lastName.setText(lastNameS);
        street.setText(streetS);
        buildingNum.setText(String.valueOf(buildingL));
        city.setText(cityS);
        state.setText(stateS);
        zip.setText(String.valueOf(zipI));

        grid.add(firstName, 1,0);
        grid.add(lastName, 5,0);
        grid.add(buildingNum, 1,1);
        grid.add(street, 4,1);
        grid.add(city, 1,2);
        grid.add(state, 4,2);
        grid.add(zip, 6,2);

        GridPane.setColumnSpan(firstName, 3);
        GridPane.setColumnSpan(lastName, 3);
        GridPane.setColumnSpan(buildingNum, 2);
        GridPane.setColumnSpan(street, 4);
        GridPane.setColumnSpan(city, 2);

        GridPane.setFillWidth(firstName, true);
        GridPane.setFillWidth(lastName, true);
        GridPane.setFillWidth(street, true);
        GridPane.setFillWidth(city, true);
        GridPane.setFillWidth(state, true);
        GridPane.setFillWidth(zip, true);
    }


    public static void setGrid(String firstName, String lastName,String street, String state, String city, int zip, long building){
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5,5,5,5))));
        grid.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setCol();
        setRow();
        setText();
        setTextFeild(firstName, lastName, street, state, city, zip, building);
    }
    public static GridPane getGrid(){
//        grid.setGridLinesVisible(true);
        return grid;
    }
}
