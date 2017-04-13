package homework.ch13.prob_4;

/**
 * Created by 15Cyndaquil on 4/12/2017.
 */
public class Calendar {
    private int currentDay;
    private long currentYear;
    private String  currentMonth, currentWeekDay;

    public Calendar(){
        currentYear = 1582;
        currentDay = 1;
        currentMonth = "January";
        currentWeekDay = "Monday";
    }

    public Calendar(int currentDay, String currentMonth, long currentYear){
        this.currentDay = currentDay;
        this.currentMonth = currentMonth;
        this.currentYear = currentYear;
        this.currentWeekDay = setCurrentWeekDay();
    }

    public String monthToString(){
        int lengthToMid = (int)(23-((currentMonth.length()+String.valueOf(currentDay).length())/2));
        StringBuilder output = new StringBuilder();
        output.append("+-----------------------------------------+\n");
        output.append(String.format("| %"+lengthToMid+"s, %-"+(37-lengthToMid)+"s |%n",currentMonth,currentYear));
        output.append("+-----------------------------------------+\n");
        output.append("| Sun | Mon | Tue | Wed | Thu | Fri | Sat |\n");
        output.append("+-----------------------------------------+\n");
        output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n",1,2,3,4,5,6,7));




        return output.toString();
    }



    private Boolean isLeapYear(long currentYear){
        if(currentYear%4==0&&currentYear%100!=0){
            return true;
        }else if(currentYear%400==0){
            return true;
        }
        return false;
    }

    private long howManyLeapYears(){
        long output = 0;
        for(long i=1582; i<currentYear; i++){
            if(isLeapYear(i)){
                output++;
            }
        }
        return output;
    }

    private String setCurrentWeekDay() {
        String output;
        long daysPast = ((currentYear - 1582) * 365 + howManyLeapYears()) / 7;
        daysPast = (daysPast - (int) (daysPast)) * 7;
        switch ((int) daysPast) {
            case 0:
                output = "Monday";
                break;
            case 1:
                output = "Tuesday";
                break;
            case 2:
                output = "Wednesday";
                break;
            case 3:
                output = "Thursday";
                break;
            case 4:
                output = "Friday";
                break;
            case 5:
                output = "Saturday";
                break;
            case 6:
                output = "Sunday";
                break;
            default:
                output = null;
                break;
        }
        return output;
    }
}
