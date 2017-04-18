package homework.ch15.prob_33;

import javafx.animation.PathTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

class FXDisplay {

    private static Pane pane = new Pane();

    private static int count = 0;
    private static int count1 = 0;

    private static int con0, con1, con2, con3, con4, con5, con6, con7;
    private static Text container0 = new Text(String.valueOf(con0));
    private static Text container1 = new Text(String.valueOf(con1));
    private static Text container2 = new Text(String.valueOf(con2));
    private static Text container3 = new Text(String.valueOf(con3));
    private static Text container4 = new Text(String.valueOf(con4));
    private static Text container5 = new Text(String.valueOf(con5));
    private static Text container6 = new Text(String.valueOf(con6));
    private static Text container7 = new Text(String.valueOf(con7));

    private static double arcDuration = 4;
    private static double bounceDuration = 0.1;


    private static void setUpBoarders(){
        Line entranceL = new Line(220, 15, 220, 55);
        Line entranceR = new Line(280, 15, 280, 55);

        Line angledSL = new Line(220, 55, 25, 400);
        Line angledSR = new Line(280, 55, 475, 400);

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

    private static void setUpText(){

        container0.setLayoutX(49);
        container1.setLayoutX(102);
        container2.setLayoutX(158);
        container3.setLayoutX(215);
        container4.setLayoutX(272);
        container5.setLayoutX(328);
        container6.setLayoutX(384);
        container7.setLayoutX(441);

        container0.setLayoutY(440);
        container1.setLayoutY(440);
        container2.setLayoutY(440);
        container3.setLayoutY(440);
        container4.setLayoutY(440);
        container5.setLayoutY(440);
        container6.setLayoutY(440);
        container7.setLayoutY(440);

        container0.setTextAlignment(TextAlignment.CENTER);
        container1.setTextAlignment(TextAlignment.CENTER);
        container2.setTextAlignment(TextAlignment.CENTER);
        container3.setTextAlignment(TextAlignment.CENTER);
        container4.setTextAlignment(TextAlignment.CENTER);
        container5.setTextAlignment(TextAlignment.CENTER);
        container6.setTextAlignment(TextAlignment.CENTER);
        container7.setTextAlignment(TextAlignment.CENTER);

        pane.getChildren().addAll(container0, container1, container2);
        pane.getChildren().addAll(container3, container4, container5);
        pane.getChildren().addAll(container6, container7);
    }

    private static void animation(int i){

        Circle bean = new Circle(250, 0, 10, Color.AQUA);
        Line first = new Line(250, 0, 250, 70);
        first.setOpacity(0);

        Line bounce = new Line(250, 70, 250, 67);
        Arc arc = new Arc(250, 140, 30, 73,90,-1000);
        arc.setOpacity(0);
        if(fiftyFifty()){
            arc.setLength(1000);
        } else {
            arc.setLength(-1000);
        }

        PathTransition go = new PathTransition();
        go.setDelay(Duration.millis(i*150));
        go.setPath(first);
        go.setNode(bean);
        go.setDuration(Duration.seconds(.5));

        go.setOnFinished(event0-> {
            go.setPath(bounce);
            go.setDuration(Duration.seconds(bounceDuration));
            go.play();

            go.setOnFinished(event1 -> {
                go.setDuration(Duration.seconds(arcDuration));
                go.setPath(arc);
                go.play();
            });
        });

        DoubleProperty yValue = new SimpleDoubleProperty();
        DoubleProperty xValue = new SimpleDoubleProperty();

        yValue.bind(bean.translateYProperty());
        xValue.bind(bean.translateXProperty());
        go.currentTimeProperty().addListener(e->{

            double currentTime;
            StringBuilder currentTimeString = new StringBuilder(e.toString());
            currentTimeString.replace(0, currentTimeString.indexOf("value: ")+7, "");
            currentTimeString.replace(currentTimeString.length()-4, currentTimeString.length(), "");
            currentTime = Double.valueOf(currentTimeString.toString());

            if((currentTime>940&&currentTime<=1060)&&!(Math.floor(yValue.intValue())>=419)){

                go.stop();
                if(arc.getLength()<0){
                    arc.setCenterX(arc.getCenterX()+28.125);
                }else {
                    arc.setCenterX(arc.getCenterX()-28.125);
                }
                if(fiftyFifty()){
                    arc.setLength(1000);
                }else {
                    arc.setLength(-1000);
                }

                arc.setCenterY(arc.getCenterY()+50);

                bounce.setEndX(arc.getCenterX());
                bounce.setStartX(arc.getCenterX());
                bounce.setEndY(arc.getCenterY()-73);
                bounce.setStartY(arc.getCenterY()-70);



                go.setPath(bounce);
                go.setDuration(Duration.seconds(bounceDuration));
                go.setDelay(Duration.seconds(0));
                go.play();

                go.setOnFinished(event0 -> {
                    go.setDuration(Duration.seconds(arcDuration));
                    go.setPath(arc);
                    go.setDelay(Duration.seconds(0));
                    go.play();
                });
            }  else if(Math.floor(yValue.intValue())==419){
                go.stop();
                int x = xValue.intValue();
                if(count%2!=0){
                    addAll();
                }else if(x<=-168.875&&x>=-225.125){
                    con0++;
                    addAll();
                } else if(x<=-112.875&&x>=-169.125){
                    con1++;
                    addAll();
                } else if(x<=-56.375&&x>=-112.625){
                    con2++;
                    addAll();
                } else if(x<=0.125&&x>=-56.125){
                    con3++;
                    addAll();
                } else if(x>=-0.125&&x<=56.125){
                    con4++;
                    addAll();
                } else if(x>=56.375&&x<=112.625){
                    con5++;
                    addAll();
                } else if(x>=112.875&&x<=169.125){
                    con6++;
                    addAll();
                } else if(x>=168.875&&x<=225.125){
                    con7++;
                    addAll();
                }
                bean.setVisible(false);

                count++;

            }

            container0.setText(String.valueOf(con0));
            container1.setText(String.valueOf(con1));
            container2.setText(String.valueOf(con2));
            container3.setText(String.valueOf(con3));
            container4.setText(String.valueOf(con4));
            container5.setText(String.valueOf(con5));
            container6.setText(String.valueOf(con6));
            container7.setText(String.valueOf(con7));
        });

        pane.getChildren().addAll(first, bean, arc);


        PathTransition again = new PathTransition();
        again.setDuration(Duration.millis(22500));
        again.setNode(new Circle(1,1,10,Color.RED));
        again.setPath(new Line(1,1,1,100));
        again.setAutoReverse(true);
        go.play();
        go.setDelay(Duration.seconds(0));
        again.play();
        again.setOnFinished(e->{
            if(count1==0) {
                goAnimation();
            }else  if(count1==149){
                count1=-1;
            }
            count1++;
        });

    }

    private static boolean fiftyFifty(){
        return (int) (Math.random() * 2) == 0;
    }

    static Pane getPane(){
        goAnimation();
        return pane;
    }

    static void setUpPane(){
        setUpBoarders();
        setUpHolders();
        setUpCircles();
        setUpText();
    }

    private static void addAll(){
//        System.out.println(con0+con1+con2+con3+con4+con5+con6+con7);
    }

    private static void goAnimation(){
        for(int i=0; i<150; i++){
            animation(i);
        }
    }

}

