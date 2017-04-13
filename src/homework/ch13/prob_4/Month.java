package homework.ch13.prob_4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Cyndaquil on 4/12/2017.
 */
public class Month {
    private String month;
    private int monthInt, daysInMonth;
    private ArrayList<String> monthList = new ArrayList<>(Arrays.asList(
            "January", "Jan"
            , "February", "Feb"
            , "March", "Mar"
            , "April", "Apr"
            , "May"
            , "June", "Jun"
            , "July", "Jul"
            , "August", "Aug"
            , "September", "Sep", "Sept"
            , "October", "Oct"
            , "November", "Nov"
            , "December", "Dec"));

    public Month() {
        month = "January";
        monthInt = 1;
        daysInMonth = 31;
    }

    public Month(String month) throws MonthNotRealException {
        Boolean error = true;
        this.monthInt = 0;
        for (int i = 0; i < monthList.size(); i++) {
            if (monthList.get(i).toString().toLowerCase().equals(month.toLowerCase())) {
                error = false;
                //Switch case for selecting month
                switch (monthList.get(i).toString()) {
                    case "Jan":
                        this.month = "January";
                        monthInt = 1;
                        daysInMonth = 31;
                        break;
                    case "January":
                        this.month = "January";
                        this.monthInt = 1;
                        daysInMonth = 31;
                        break;
                    case "Feb":
                        this.month = "February";
                        this.monthInt = 2;
                        daysInMonth = 28;
                        break;
                        case "February":
                        this.month = "February";
                        this.monthInt = 2;
                        daysInMonth = 28;
                        break;
                    case "Mar":
                        this.month = "March";
                        this.monthInt = 3;
                        daysInMonth = 31;
                        break;
                    case "March":
                        this.month = "March";
                        this.monthInt = 3;
                        daysInMonth = 31;
                        break;
                    case "Apr":
                        this.month = "April";
                        this.monthInt = 4;
                        daysInMonth = 30;
                        break;
                    case "April":
                        this.month = "April";
                        this.monthInt = 4;
                        daysInMonth = 30;
                        break;
                    case "May":
                        this.month = "May";
                        this.monthInt = 6;
                        daysInMonth = 31;
                        break;
                    case "Jun":
                        this.month = "June";
                        this.monthInt = 6;
                        daysInMonth = 30;
                        break;
                    case "June":
                        this.month = "June";
                        this.monthInt = 6;
                        daysInMonth = 30;
                        break;
                    case "Jul":
                        this.month = "July";
                        this.monthInt = 7;
                        daysInMonth = 31;
                        break;
                    case "July":
                        this.month = "July";
                        this.monthInt = 7;
                        daysInMonth = 31;
                        break;
                    case "Aug":
                        this.month = "August";
                        this.monthInt = 8;
                        daysInMonth = 31;
                        break;
                    case "August":
                        this.month = "August";
                        this.monthInt = 8;
                        daysInMonth = 31;
                        break;
                    case "Sep":
                        this.month = "September";
                        this.monthInt = 9;
                        daysInMonth = 30;
                        break;
                    case "Sept":
                        this.month = "September";
                        this.monthInt = 9;
                        daysInMonth = 30;
                        break;
                    case "September":
                        this.month = "September";
                        this.monthInt = 9;
                        daysInMonth = 30;
                        break;
                    case "Oct":
                        this.month = "October";
                        this.monthInt = 10;
                        daysInMonth = 31;
                        break;
                    case "October":
                        this.month = "October";
                        this.monthInt = 10;
                        daysInMonth = 31;
                        break;
                    case "Nov":
                        this.month = "November";
                        this.monthInt = 11;
                        daysInMonth = 30;
                        break;
                    case "November":
                        this.month = "November";
                        this.monthInt = 11;
                        daysInMonth = 30;
                        break;
                    case "Dec":
                        this.month = "December";
                        this.monthInt = 12;
                        daysInMonth = 31;
                        break;
                    case "December":
                        this.month = "December";
                        this.monthInt = 12;
                        daysInMonth = 31;
                        break;
                    default:
                        this.month = monthList.get(i);
                        System.out.println("Month Integer not set");
                        break;
                }
            }
        }
        if (error == true) {
            throw new MonthNotRealException(month + " is not a valid month.");
        }
    }

    public int getMonthInt(){return monthInt;}

    public int getDaysInMonth(){return daysInMonth;}

    public String toString() {
        return month;
    }
}
