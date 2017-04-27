package homework.ch17.prob_9;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.*;


/**
 * Created by 15Cyndaquil on 4/25/2017.
 */
public class EditAddressFX {
    private static GridPane grid = new GridPane();
    private static double rowInt = 4;
    private static double colInt = 8;


    private static TextField firstName = new TextField();
    private static TextField lastName = new TextField();
    private static TextField buildingNum = new TextField();
    private static TextField street = new TextField();
    private static TextField city = new TextField();
    private static TextField state = new TextField();
    private static TextField zip = new TextField();


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
    private static void setTextFeild(){
        firstName.setPromptText("First Name: limited to 16 char");
        lastName.setPromptText("Last Name: limited to 16 char");
        buildingNum.setPromptText("Building Number");
        street.setPromptText("Street: limited to 16 char");
        city.setPromptText("City: limited to 21 char");
        state.setPromptText("State");
        zip.setPromptText("Zip");

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
    private static void setButtons(){
        Button add = new Button("Add");
        Button update = new Button("Update");
        Button list = new Button("Entire Address Book");

        grid.add(add,  1, 3);
        grid.add(update,  5, 3);
        grid.add(list,  6, 3);

        add.setDefaultButton(false);
        update.setDefaultButton(false);
        list.setDefaultButton(false);

        add.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        GridPane.setColumnSpan(list, 2);

        GridPane.setHalignment(add, HPos.CENTER);
        GridPane.setHalignment(update, HPos.CENTER);
        GridPane.setHalignment(list, HPos.CENTER);

        GridPane.setColumnSpan(add, 3);

        add.setOnAction(e->{
            addButton();
        });
    }


    private static void addButton(){
        if(textFieldCheck()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Check inputted text for incorrect input");
            alert.showAndWait();
        }else {
            try {
                StringBuilder firsNameS = new StringBuilder(firstName.getText());
                StringBuilder lastNameS = new StringBuilder(lastName.getText());
                long buildingLong = Integer.valueOf(buildingNum.getText());
                StringBuilder streetS = new StringBuilder(street.getText());
                StringBuilder cityS = new StringBuilder(city.getText());
                StringBuilder stateS = new StringBuilder(state.getText());
                int zipCode = Integer.valueOf(zip.getText());

                AddressInOut.addAddress(firsNameS.toString(), lastNameS.toString(), streetS.toString()
                        , cityS.toString(), stateS.toString(), zipCode, buildingLong);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setContentText("Check Building Number and Zip code");
                alert.showAndWait();
            }
        }

        AddressInOut.saveAddresses();
    }


    private static boolean textFieldCheck(){
        return firstName.getText().equals("")||lastName.getText().equals("")
                ||buildingNum.getText().equals("")||street.getText().equals("")
                ||city.getText().equals("")||state.getText().equals("")||zip.getText().equals("")
                ||firstName.getText().length()>16||lastName.getText().length()>16
                ||street.getText().length()>16||city.getText().length()>21
                ||state.getText().length()!=2;
    }



    public static void setGrid(){
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5,5,5,5))));
        grid.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setCol();
        setRow();
        setText();
        setTextFeild();
        setButtons();
        test();
    }
    public static GridPane getGrid(){
//        grid.setGridLinesVisible(true);
        return grid;
    }

    private static void test(){
        firstName.setText("John");
        lastName.setText("Gafford");
        buildingNum.setText("12914");
        street.setText("Leatherwood Ln");
        city.setText("Woodbridge");
        state.setText("VA");
        zip.setText("22192");
    }
}
