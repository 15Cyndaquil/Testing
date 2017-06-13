package inventory.gui;

import javafx.scene.layout.Pane;

/**
 * Created by Cyndaquil on 6/12/2017.
 */
public class AddProductScene {

    private Pane pane;

    public void start() {
        setUpPane();


    }

    private void setUpPane() {
        pane = new Pane();
    }


    public Pane getPane() {
        return pane;
    }
}
