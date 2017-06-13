package inventory.gui;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Cyndaquil on 6/12/2017.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Pane pane = new Pane();
        VBox pane = new VBox();

        Button file = new Button("File");
        Button viewItem = new Button("View Item");
        Button addItem = new Button("Add Item");
        Button editItem = new Button("Edit Item");

        Separator horizontal = new Separator();

        horizontal.setOrientation(Orientation.HORIZONTAL);

        file.setBackground(Background.EMPTY);
        viewItem.setBackground(Background.EMPTY);
        addItem.setBackground(Background.EMPTY);
        editItem.setBackground(Background.EMPTY);

        ToolBar toolBar = new ToolBar(
                file,
                new Separator(),
                viewItem,
                new Separator(),
                addItem,
                new Separator(),
                editItem
        );

        toolBar.setMinWidth(Double.MAX_VALUE);
        pane.getChildren().add(toolBar);
        pane.getChildren().add(horizontal);



        Scene scene = new Scene(pane, 400,100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
