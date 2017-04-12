package minecraft.crafter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Main extends Application{

    private GridPane grid = new GridPane();

    @Override
    public void start(Stage primaryStage) throws Exception{

        MinecraftItems.setUp();
        createGrid(10,10);
        grid.setHgap(10);
        grid.setVgap(10);

        addComboBoxes();

        grid.setGridLinesVisible(true);
        primaryStage.setTitle("Minecraft Mod Creator");
        primaryStage.setScene(new Scene(grid, 500, 500));
        primaryStage.show();
    }

    private void createGrid(int x, int y){
        for(int col=0; col<y; col++){
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(10);
            column.setHgrow(Priority.ALWAYS);
            column.setFillWidth(true);
            grid.getColumnConstraints().add(column);
        }
        for(int ro=0; ro<x; ro++){
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(10);
            row.setVgrow(Priority.ALWAYS);
            row.setFillHeight(true);
            grid.getRowConstraints().add(row);
        }
    }

    private void addComboBoxes(){

        ObservableList options = FXCollections.observableArrayList(MinecraftItems.getItemLocalNameArray());

        ComboBox topLeft = new ComboBox(options);
        ComboBox topMid = new ComboBox(options);
        ComboBox topRight = new ComboBox(options);

        ComboBox midLeft = new ComboBox(options);
        ComboBox midMid = new ComboBox(options);
        ComboBox midRight = new ComboBox(options);

        ComboBox botLeft = new ComboBox(options);
        ComboBox botMid = new ComboBox(options);
        ComboBox botRight = new ComboBox(options);



        new AutoCompleteComboBoxListener(topLeft);
        new AutoCompleteComboBoxListener(topMid);
        new AutoCompleteComboBoxListener(topRight);

        new AutoCompleteComboBoxListener(midLeft);
        new AutoCompleteComboBoxListener(midMid);
        new AutoCompleteComboBoxListener(midRight);

        new AutoCompleteComboBoxListener(botLeft);
        new AutoCompleteComboBoxListener(botMid);
        new AutoCompleteComboBoxListener(botRight);

        grid.add(topLeft, 1, 1);
        grid.add(topMid, 2, 1);
        grid.add(topRight, 3, 1);

        grid.add(midLeft, 1, 2);
        grid.add(midMid, 2, 2);
        grid.add(midRight, 3, 2);

        grid.add(botLeft, 1, 3);
        grid.add(botMid, 2, 3);
        grid.add(botRight, 3, 3);
    }
}
