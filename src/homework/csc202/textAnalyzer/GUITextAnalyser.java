package homework.csc202.textAnalyzer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by 15Cyndaquil on 7/5/2017.
 */
public class GUITextAnalyser extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox pane = new VBox();
        pane.setSpacing(10);
        HBox buttons = new HBox();
        buttons.setSpacing(5);

        TextField textInput = new TextField();
        textInput.setPromptText("Input Text Here");
        TextArea output = new TextArea("Analysis result");
        output.setEditable(false);
        output.setPrefHeight(50);
        Button length = new Button("Length");
        Button vowels = new Button("Vowels");
        Button upper = new Button("Uppercase");
        Button latin = new Button("Latin Alphabet");

        buttons.getChildren().addAll(length, vowels, upper, latin);
        pane.getChildren().addAll(textInput, output, buttons);

        length.setOnAction(e->{
            if(!textInput.getText().equals("")){
                TextAnalyzer text = new TextAnalyzer(textInput.getText());
                output.setText("The length of the text is "+text.length());
            }else {
                output.setText("No Text Inputted");
            }
        });
        vowels.setOnAction(e->{
            if(!textInput.getText().equals("")){
                TextAnalyzer text = new TextAnalyzer(textInput.getText());
                output.setText("There are "+text.numberOfVowels()+" vowels ");
            }else {
                output.setText("No Text Inputted");
            }
        });
        upper.setOnAction(e->{
            if(!textInput.getText().equals("")){
                TextAnalyzer text = new TextAnalyzer(textInput.getText());
                output.setText("There are "+text.numberOfUppercase()+" uppercase Letters in the Text");
            }else {
                output.setText("No Text Inputted");
            }
        });
        latin.setOnAction(e->{
            if(!textInput.getText().equals("")){
                TextAnalyzer text = new TextAnalyzer(textInput.getText());
                if(text.numberOfLatinAlphabetic()>1){
                    output.setText("There are " + text.numberOfLatinAlphabetic() + " Latin alphabetic letters");
                }else output.setText("There are " + text.numberOfLatinAlphabetic() + " Latin alphabetic letter");
            }else {
                output.setText("No Text Inputted");
            }
        });

        primaryStage.setScene(new Scene(pane, 384, 115));

        //Set Button Widths
        length.setMinWidth((primaryStage.getScene().getWidth()-17)/4);
        vowels.setMinWidth((primaryStage.getScene().getWidth()-17)/4);
        upper.setMinWidth((primaryStage.getScene().getWidth()-17)/4);
        latin.setMinWidth((primaryStage.getScene().getWidth()-17)/4);

        primaryStage.show();
    }
}
