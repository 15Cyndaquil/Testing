package homework.ch14.prob_29;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;


class FXDisplay {

    private static Pane pane = new Pane();


    private static void setUpBoarders(){
        Line entranceL = new Line(225, 15, 225, 55);
        Line entranceR = new Line(275, 15, 275, 55);

        Line angledSL = new Line(225, 55, 25, 400);
        Line angledSR = new Line(275, 55, 475, 400);

        Line straightSL = new Line(25, 400, 25, 475);
        Line straightSR = new Line(475, 400, 475, 475);

        Line base = new Line(25, 475, 475, 475);

        pane.getChildren().addAll(entranceL, entranceR);
        pane.getChildren().addAll(angledSL, angledSR);
        pane.getChildren().addAll(straightSL, straightSR);
        pane.getChildren().addAll(base);
    }
    
    private static void setUpHolders(){
        Line leftLeft = new Line(81.25, 475, 81.25, 400);
        Line leftMid = new Line(137.5, 475, 137.5, 400);
        Line leftRight = new Line(193.75, 475, 193.75, 400);

        Line mid = new Line(250, 475, 250, 400);

        Line rightLeft = new Line(306.25, 475, 306.25, 400);
        Line rightMid = new Line(362.5, 475, 362.5, 400);
        Line rightRight = new Line(418.75, 475, 418.75, 400);

        pane.getChildren().addAll(leftLeft, leftMid, leftRight);
        pane.getChildren().addAll(mid);
        pane.getChildren().addAll(rightLeft, rightMid, rightRight);
    }

    private static void setUpCircles(){
        Circle line7LeftLeft = new Circle(81.25, 390, 10);
        Circle line7LeftMid = new Circle(137.5, 390, 10);
        Circle line7LeftRight = new Circle(193.75, 390, 10);
        Circle line7Mid = new Circle(250, 390, 10);
        Circle line7RightLeft = new Circle(306.25, 390, 10);
        Circle line7RightMid = new Circle(362.5, 390, 10);
        Circle line7RightRight = new Circle(418.75, 390, 10);

        Circle line6LeftLeft = new Circle(109.375, 340, 10);
        Circle line6LeftMid = new Circle(165.625, 340, 10);
        Circle line6LeftRight = new Circle(221.875, 340, 10);
        Circle line6RightLeft = new Circle(278.125, 340, 10);
        Circle line6RightMid = new Circle(334.375, 340, 10);
        Circle line6RightRight = new Circle(390.625, 340, 10);

        Circle line5LeftLeft = new Circle(137.5, 290, 10);
        Circle line5LeftRight = new Circle(193.75, 290, 10);
        Circle line5Mid= new Circle(250, 290, 10);
        Circle line5RightLeft = new Circle(306.25, 290, 10);
        Circle line5RightRight = new Circle(362.5, 290, 10);

        Circle line4LeftLeft = new Circle(165.625, 240, 10);
        Circle line4LeftRight = new Circle(221.875, 240, 10);
        Circle line4RightLeft = new Circle(278.125, 240, 10);
        Circle line4RightRight = new Circle(334.375, 240, 10);

        Circle line3Left = new Circle(193.75, 190, 10);
        Circle line3Mid= new Circle(250, 190, 10);
        Circle line3Right = new Circle(306.25, 190, 10);

        Circle line2Left = new Circle(221.875, 140, 10);
        Circle line2Right = new Circle(278.125, 140, 10);

        Circle line1Mid= new Circle(250, 90, 10);

        pane.getChildren().addAll(line7LeftLeft ,line7LeftMid, line7LeftRight, line7Mid, line7RightLeft, line7RightMid, line7RightRight);
        pane.getChildren().addAll(line6LeftLeft, line6LeftMid, line6LeftRight, line6RightLeft, line6RightMid, line6RightRight);
        pane.getChildren().addAll(line5LeftLeft, line5LeftRight, line5Mid, line5RightLeft, line5RightRight);
        pane.getChildren().addAll(line4LeftLeft, line4LeftRight, line4RightLeft, line4RightRight);
        pane.getChildren().addAll(line3Left, line3Mid, line3Right);
        pane.getChildren().addAll(line2Left, line2Right);
        pane.getChildren().addAll(line1Mid);
    }

    static Pane getPane(){
        setUpBoarders();
        setUpHolders();
        setUpCircles();
        return pane;
    }
}
