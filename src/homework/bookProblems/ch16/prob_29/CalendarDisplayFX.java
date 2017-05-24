package homework.bookProblems.ch16.prob_29;

import homework.bookProblems.ch13.prob_4.Calendar;
import homework.bookProblems.ch13.prob_4.Month;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.util.Scanner;


class CalendarDisplayFX {
    private static GridPane grid = new GridPane();
    private static double rowAmt = 9;
    private static double colAmt = 7;
    private static LocalDate date = LocalDate.now();
    private static Month month = new Month(date.getMonthValue());
    private static Calendar current = new Calendar(date.getDayOfMonth(), month.toString(), date.getYear());

    private static Text monthText = new Text();

    private static void setRow() {
        for (int i = 0; i < rowAmt; i++){
            RowConstraints row = new RowConstraints();
            row.setPercentHeight((1/rowAmt)*100);
            grid.getRowConstraints().addAll(row);
        }
    }
    private static void setCol() {
        for (int i = 0; i < colAmt; i++){
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth((1/colAmt)*100);
            grid.getColumnConstraints().addAll(col);
        }
    }
    private static void addMonth(){
        monthText.setText(current.getMonth()+", "+current.getYear());
        grid.add(monthText, 2, 0);
        GridPane.setColumnSpan(monthText, 3);
        GridPane.setHalignment(monthText, HPos.CENTER);
    }
    private static void addWeekDays(){
        Text sunday = new Text("Sunday");
        Text monday = new Text("Monday");
        Text tuesday = new Text("Tuesday");
        Text wednesday = new Text("Wednesday");
        Text thursday = new Text("Thursday");
        Text friday = new Text("Friday");
        Text saturday = new Text("Saturday");

        grid.add(sunday,0,1);
        grid.add(monday,1,1);
        grid.add(tuesday,2,1);
        grid.add(wednesday,3,1);
        grid.add(thursday,4,1);
        grid.add(friday,5,1);
        grid.add(saturday,6,1);

        GridPane.setHalignment(sunday, HPos.CENTER);
        GridPane.setHalignment(monday, HPos.CENTER);
        GridPane.setHalignment(tuesday, HPos.CENTER);
        GridPane.setHalignment(wednesday, HPos.CENTER);
        GridPane.setHalignment(thursday, HPos.CENTER);
        GridPane.setHalignment(friday, HPos.CENTER);
        GridPane.setHalignment(saturday, HPos.CENTER);
    }
    private static void addDays(){
        boolean currentMonth = false;
        int gridRow = 2;
        int gridCol = 0;
        StringBuilder calendar = new StringBuilder(534);
        calendar.append(current.monthToString());
        calendar.replace(0, calendar.indexOf("+",200)+1, "");
        calendar.replace(calendar.indexOf("+",200)-1, calendar.lastIndexOf("+")+1, "");
        while(calendar.indexOf("|")!=-1){
            int index = calendar.indexOf("|");
            calendar.replace(index, index+1,"");
        }
        Scanner scan = new Scanner(calendar.toString());
        while(scan.hasNextInt()){
            int currentDay = scan.nextInt();
            Text addDay = new Text(String.valueOf(currentDay));
            grid.add(addDay, gridCol, gridRow);
            GridPane.setHalignment(addDay, HPos.CENTER);

            if(currentDay!=1&&!currentMonth){
                addDay.setOpacity(.5);
            }else if(currentDay==1&&!currentMonth){
                currentMonth=true;
            }else if(currentDay == 1){
                currentMonth=false;
                addDay.setOpacity(.5);
            }else if(currentDay==date.getDayOfMonth()&&current.getMonth().equalsIgnoreCase(date.getMonth().toString())&&
                    current.getYear()==date.getYear()){
                grid.getChildren().remove(addDay);
                addDay.setUnderline(true);
                addDay.setFill(Color.WHITE);

                Rectangle outerBoarder = new Rectangle();
                outerBoarder.heightProperty().bind(grid.heightProperty().divide(rowAmt));
                outerBoarder.widthProperty().bind(grid.widthProperty().divide(colAmt));
                outerBoarder.setFill(Color.BLACK);
                outerBoarder.setOpacity(.2);
                grid.add(outerBoarder, gridCol, gridRow);
                GridPane.setFillHeight(outerBoarder, true);
                GridPane.setFillWidth(outerBoarder, true);

                grid.add(addDay, gridCol, gridRow);


            }
            if(gridCol==6){
                gridCol=0;
                gridRow++;
            }else {
                gridCol++;
            }
        }


    }
    private static void addButtons(){
        Button next = new Button("Next Month");
        Button pre = new Button("Previous Month");

        next.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        pre.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        grid.add(next, 4, 8);
        grid.add(pre, 1, 8);

        GridPane.setColumnSpan(next, 2);
        GridPane.setColumnSpan(pre, 2);

        next.setOnAction(e->{
            grid.getChildren().removeAll(grid.getChildren());
            current.setMonth(current.getNextMonthString());
            month.setMonth(current.getNextMonthString());
            addMonth();
            addWeekDays();
            addDays();
            addButtons();
        });

        pre.setOnAction(e->{
            grid.getChildren().removeAll(grid.getChildren());
            current.setMonth(current.getPreMonthString());
            month.setMonth(current.getPreMonthString());
            addMonth();
            addWeekDays();
            addDays();
            addButtons();
        });
    }



    static void setGrid() {
        current.setMonth(month.toString());
        grid.setBorder(new Border(new BorderStroke(
                  Color.WHITE
                , BorderStrokeStyle.SOLID
                , CornerRadii.EMPTY
                , new BorderWidths(10,10,10,10))));
        grid.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
        setCol();
        setRow();
        addMonth();
        addWeekDays();
        addDays();
        addButtons();
    }
    static GridPane getGrid() {
        return grid;
    }
}
