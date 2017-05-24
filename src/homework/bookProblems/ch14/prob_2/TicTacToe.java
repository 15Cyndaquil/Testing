package homework.bookProblems.ch14.prob_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Optional;


public class TicTacToe extends Application {
    private Boolean circle = true;

    private RowConstraints rowMain = new RowConstraints();
    private ColumnConstraints columnMain = new ColumnConstraints();

    private Button topLeft = new Button();
    private Button topMid = new Button();
    private Button topRight = new Button();

    private Button midLeft = new Button();
    private Button midMid = new Button();
    private Button midRight = new Button();

    private Button botLeft = new Button();
    private Button botMid = new Button();
    private Button botRight = new Button();

    private GridPane grid = new GridPane();
    private String gridButton[] = new String[9];
    private String gridButtonValue[] = new String[9];

    @Override
    public void start(Stage primaryStage){
        for(int i=0; i<gridButton.length; i++){
            gridButton[i] = String.valueOf(i);
        }
        for(int i=0; i<gridButtonValue.length; i++){
            gridButtonValue[i] = "";
        }
        grid.setGridLinesVisible(true);

        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10,10,10,10)));
        Scene scene = new Scene(grid, 250, 250, Color.BLACK);
        primaryStage.setScene(scene);

        columnMain.setPercentWidth(33.33);
        rowMain.setPercentHeight(33.33);

        grid.getRowConstraints().addAll(rowMain, rowMain, rowMain);
        grid.getColumnConstraints().addAll(columnMain, columnMain, columnMain);

        //Set Button Boarders
        topLeft.setBorder(border);
        topMid.setBorder(border);
        topRight.setBorder(border);

        midLeft.setBorder(border);
        midMid.setBorder(border);
        midRight.setBorder(border);

        botLeft.setBorder(border);
        botMid.setBorder(border);
        botRight.setBorder(border);

        //Set Button Width/Height
        buttonWidth(topLeft, scene.getWidth());
        buttonWidth(topMid, scene.getWidth());
        buttonWidth(topRight, scene.getWidth());

        buttonWidth(midLeft, scene.getWidth());
        buttonWidth(midMid, scene.getWidth());
        buttonWidth(midRight, scene.getWidth());

        buttonWidth(botLeft, scene.getWidth());
        buttonWidth(botMid, scene.getWidth());
        buttonWidth(botRight, scene.getWidth());

        buttonHeight(topLeft, scene.getHeight());
        buttonHeight(topMid, scene.getHeight());
        buttonHeight(topRight, scene.getHeight());

        buttonHeight(midLeft, scene.getHeight());
        buttonHeight(midMid, scene.getHeight());
        buttonHeight(midRight, scene.getHeight());

        buttonHeight(botLeft, scene.getHeight());
        buttonHeight(botMid, scene.getHeight());
        buttonHeight(botRight, scene.getHeight());

        //Button Actions
        topLeft.setOnAction(event -> buttonAction(topLeft));
        topMid.setOnAction(event -> buttonAction(topMid));
        topRight.setOnAction(event -> buttonAction(topRight));

        midLeft.setOnAction(event -> buttonAction(midLeft));
        midMid.setOnAction(event -> buttonAction(midMid));
        midRight.setOnAction(event -> buttonAction(midRight));

        botLeft.setOnAction(event -> buttonAction(botLeft));
        botMid.setOnAction(event -> buttonAction(botMid));
        botRight.setOnAction(event -> buttonAction(botRight));

        scene.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> {

            buttonWidth(topLeft, newSceneWidth);
            buttonWidth(topMid, newSceneWidth);
            buttonWidth(topRight, newSceneWidth);

            buttonWidth(midLeft, newSceneWidth);
            buttonWidth(midMid, newSceneWidth);
            buttonWidth(midRight, newSceneWidth);

            buttonWidth(botLeft, newSceneWidth);
            buttonWidth(botMid, newSceneWidth);
            buttonWidth(botRight, newSceneWidth);
        });
        scene.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> {
            buttonHeight(topLeft, newSceneHeight);
            buttonHeight(topMid, newSceneHeight);
            buttonHeight(topRight, newSceneHeight);

            buttonHeight(midLeft, newSceneHeight);
            buttonHeight(midMid, newSceneHeight);
            buttonHeight(midRight, newSceneHeight);

            buttonHeight(botLeft, newSceneHeight);
            buttonHeight(botMid, newSceneHeight);
            buttonHeight(botRight, newSceneHeight);
        });

//      Set Grid
        grid.add(topLeft, 0,0);
        grid.add(topMid, 1,0);
        grid.add(topRight, 2,0);


        grid.add(midLeft, 0,1);
        grid.add(midMid, 1,1);
        grid.add(midRight, 2,1);


        grid.add(botLeft, 0,2);
        grid.add(botMid, 1,2);
        grid.add(botRight, 2,2);


        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.show();
    }

    private void buttonAction(Button button){
        Boolean circleBT = circle;
        if(circleBT){
            String oImage = "homework/bookProblems/ch14/prob_2/o.gif";
            button.setGraphic(new ImageView(oImage));
            gridButtonValue[grid.getChildren().indexOf(button)-1] = "O";
            circle=false;
        }else {
            String xImage = "homework/bookProblems/ch14/prob_2/x.gif";
            button.setGraphic(new ImageView(xImage));
            gridButtonValue[grid.getChildren().indexOf(button)-1] = "X";
            circle=true;
        }
        checkBoard();
    }

    private void buttonHeight(Button button, Number scene){
        button.setMinHeight(scene.doubleValue()*(rowMain.getPercentHeight()/100));
    }

    private void buttonWidth(Button button, Number scene){
        button.setMinWidth(scene.doubleValue()*(columnMain.getPercentWidth()/100));
    }
    
    private void checkBoard(){
        Boolean topRow = gridButtonValue[0].equals(gridButtonValue[1])&&gridButtonValue[0].equals(gridButtonValue[2])&&!gridButtonValue[0].equals("");
        Boolean midRow = gridButtonValue[3].equals(gridButtonValue[4])&&gridButtonValue[3].equals(gridButtonValue[5])&&!gridButtonValue[3].equals("");
        Boolean botRow = gridButtonValue[6].equals(gridButtonValue[7])&&gridButtonValue[6].equals(gridButtonValue[8])&&!gridButtonValue[6].equals("");

        Boolean col1 = gridButtonValue[0].equals(gridButtonValue[3])&&gridButtonValue[0].equals(gridButtonValue[6])&&!gridButtonValue[0].equals("");
        Boolean col2 = gridButtonValue[1].equals(gridButtonValue[4])&&gridButtonValue[1].equals(gridButtonValue[7])&&!gridButtonValue[1].equals("");
        Boolean col3 = gridButtonValue[2].equals(gridButtonValue[5])&&gridButtonValue[2].equals(gridButtonValue[8])&&!gridButtonValue[2].equals("");

        Boolean diag1 = gridButtonValue[0].equals(gridButtonValue[4])&&gridButtonValue[0].equals(gridButtonValue[8])&&!gridButtonValue[0].equals("");
        Boolean diag2 = gridButtonValue[2].equals(gridButtonValue[4])&&gridButtonValue[2].equals(gridButtonValue[6])&&!gridButtonValue[2].equals("");

        if(topRow){
            resetBoardAlert(gridButtonValue[0]);
        }
        if(midRow){
            resetBoardAlert(gridButtonValue[3]);
        }
        if(botRow){
            resetBoardAlert(gridButtonValue[6]);
        }

        if(col1){
            resetBoardAlert(gridButtonValue[0]);
        }
        if(col2){
            resetBoardAlert(gridButtonValue[1]);
        }
        if(col3){
            resetBoardAlert(gridButtonValue[2]);
        }

        if(diag1){
            resetBoardAlert(gridButtonValue[0]);
        }
        if(diag2){
            resetBoardAlert(gridButtonValue[2]);
        }
    }

    private void resetBoardAlert(String winner){
        Alert reset = new Alert(Alert.AlertType.CONFIRMATION);
        reset.setTitle("Reset The Board?");
        reset.setHeaderText("The "+winner+" Player has won.\nWould you like to reset the board");
        reset.setResizable(false);
        reset.setContentText("Select Ok to reset the board, Cancel to close the App");
        Optional<ButtonType> result = reset.showAndWait();
        if(ButtonType.OK == result.get()){
            resetBoard();
        }else if(result.get()==ButtonType.CANCEL){
            System.exit(0);
        }
    }

    private void resetBoard(){
        for(int i=0; i<gridButtonValue.length; i++){
            gridButtonValue[i] = "";
        }

        topLeft.setGraphic(null);
        topMid.setGraphic(null);
        topRight.setGraphic(null);

        midLeft.setGraphic(null);
        midMid.setGraphic(null);
        midRight.setGraphic(null);

        botLeft.setGraphic(null);
        botMid.setGraphic(null);
        botRight.setGraphic(null);
    }
}
