package homework.ch17.prob_9;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 15Cyndaquil on 4/25/2017.
 */
public class ViewAllAddressFX {
    private static Pane pane = new Pane();
    private static HBox hBoxSort = new HBox();
    private static HBox hBoxEditButton = new HBox();
    private static VBox vBoxAll = new VBox();

    private static StringBuilder currentSelected = new StringBuilder();
    private static  ArrayList<String> allInCurrentLetter = new ArrayList<>();
    private static ArrayList<String> firstName, lastName;

    public static void showAddress(){
        ViewAddressFX.setGrid(AddressInOut.getFirstNameList().get(Integer.valueOf(currentSelected.toString())).trim()
                ,AddressInOut.getLastNameList().get(Integer.valueOf(currentSelected.toString())).trim()
                ,AddressInOut.getStreetList().get(Integer.valueOf(currentSelected.toString())).trim()
                ,AddressInOut.getStateList().get(Integer.valueOf(currentSelected.toString())).trim()
                ,AddressInOut.getCityList().get(Integer.valueOf(currentSelected.toString())).trim()
                , AddressInOut.getZipList().get(Integer.valueOf(currentSelected.toString()))
                ,AddressInOut.getBuildingLongList().get(Integer.valueOf(currentSelected.toString())));
        Stage viewAddress = new Stage();
        viewAddress.setScene(new Scene(ViewAddressFX.getGrid(), 700, 150));
        viewAddress.showAndWait();
    }

    public static void setPane(){
        firstName = (ArrayList<String>) AddressInOut.getFirstNameList().clone();
        lastName = (ArrayList<String>) AddressInOut.getLastNameList().clone();

        setText("G");
        setHBoxSort();
        vBoxAll.getChildren().add(hBoxSort);
        sethBoxAdddress();
        sethBoxEditButton();


        pane.getChildren().add(vBoxAll);
        AddressDriver.getScene().setRoot(pane);
    }


    private static void setHBoxSort(){
        hBoxSort.setMaxWidth(Double.MAX_VALUE);
        hBoxSort.setSpacing(1);
        hBoxSort.setPadding(new Insets(5));
        hBoxSortButtons();
    }
    private static void hBoxSortButtons(){
        int charValue = "A".charAt(0)-1;
        for(int i=0; i<26; i++){
            Button sort = new Button( String.valueOf((char) (++charValue)));
            hBoxSort.getChildren().add(sort);
        }
    }

    private static void sethBoxAdddress(){
        int currentName = 0;
        for(int i=0; i<25; i++) {
            GridPane grid = new GridPane();
            HBox add1 = new HBox();
            HBox add2 = new HBox();
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(50);
            grid.getColumnConstraints().addAll(col, col);

            RadioButton left = new RadioButton();
            RadioButton right = new RadioButton();

            Text leftT = new Text("");
            Text rightT = new Text("");

            if(currentName<allInCurrentLetter.size()){
                StringBuilder name = new StringBuilder();
                int currentIndex = Integer.valueOf(allInCurrentLetter.get(currentName).substring(allInCurrentLetter.get(currentName).length()-1));

                name.append(firstName.get(currentIndex)+" "+lastName.get(currentIndex));
                leftT.setText(name.toString());
                leftT.setId(String.valueOf(currentIndex));
                left.setId(String.valueOf(currentIndex));
                currentName++;
            }
            if(currentName<allInCurrentLetter.size()){
                StringBuilder name = new StringBuilder();
                int currentIndex = Integer.valueOf(allInCurrentLetter.get(currentName).substring(allInCurrentLetter.get(currentName).length()-1));

                name.append(firstName.get(currentIndex)+" "+lastName.get(currentIndex));
                rightT.setText(name.toString());
                rightT.setId(String.valueOf(currentIndex));
                right.setId(String.valueOf(currentIndex));
                currentName++;
            }


            add1.getChildren().addAll(left, leftT);
            add2.getChildren().addAll(right, rightT);

            grid.add(add1, 0,0);
            grid.add(add2, 1,0);
            vBoxAll.getChildren().add(grid);



            left.setOnAction(e->{
                if(left.isSelected()) {
                    currentSelected.replace(0, currentSelected.length(),"");
                    currentSelected.append(Integer.valueOf(leftT.getId()));
                }
            });
            right.setOnAction(e->{
                if(right.isSelected()) {
                    currentSelected.replace(0, currentSelected.length(),"");
                    currentSelected.append(Integer.valueOf(rightT.getId()));
                }
                if(rightT.getId()!=right.getId()){
                    right.setSelected(false);
                }
            });
        }
    }

    private static void sethBoxEditButton(){
        Button add = new Button("Add Address");
        Button edit = new Button("Edit Address");
        Button view = new Button("View Address");

        hBoxEditButton.getChildren().addAll(add, edit, view);
        vBoxAll.getChildren().add(hBoxEditButton);
        view.setOnAction(e->{
            showAddress();
        });
    }



    private static void setText(String currentLetter){

        for(int i=0; i<lastName.size(); i++){
            if(lastName.get(i).startsWith(currentLetter)){
                allInCurrentLetter.add(lastName.get(i)+i);
            }
        }

        Collections.sort(allInCurrentLetter);
    }
}
