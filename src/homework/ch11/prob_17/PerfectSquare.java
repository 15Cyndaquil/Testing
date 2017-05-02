package homework.ch11.prob_17;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class PerfectSquare extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        VBox show = new VBox();

        TextField input = new TextField();
        input.setPromptText("Input an Integer");

        Button getSquare = new Button("Get the number that when multiplied by inputted number is a perfect square");
        getSquare.setDefaultButton(true);
        getSquare.setOnAction(event->{
            try{
                showSquare(Integer.valueOf(input.getText()));
            }catch (NumberFormatException exc){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Inputted information is not an integer");
                alert.showAndWait();
            }
        });

        show.getChildren().addAll(input, getSquare);
        pane.getChildren().add(show);
        primaryStage.setScene(new Scene(pane));
        pane.requestFocus();
        primaryStage.show();
    }

    private void showSquare(int input) {
        int m = input;
        int n = 1;
        double root = Math.sqrt(m * n);

        while (Math.floor(root) != root) {
            root = Math.sqrt(m * ++n);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Inputed int: "
                + m + "\nSmallest int for perfect square: "
                + n + "\nInput * Smallest int = " + (m * n));
        alert.showAndWait();
    }
}
