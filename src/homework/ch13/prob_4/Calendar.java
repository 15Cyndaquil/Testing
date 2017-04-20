package homework.ch13.prob_4;

/**
 * Created by 15Cyndaquil on 4/12/2017.
 */
public class Calendar extends Month{
    private int currentDay;
    private long currentYear;
    private String  currentWeekDay;
    private Month currentMonth;

    public Calendar(){
        currentYear = 1582;
        currentDay = 1;
        currentMonth = new Month();
        currentWeekDay = "Monday";
    }

    public Calendar(int currentDay, Month currentMonth, long currentYear){
        this.currentDay = currentDay;
        this.currentMonth = currentMonth;
        this.currentYear = currentYear;
        this.currentWeekDay = weekDay(currentDay);
    }

    public StringBuilder monthToString(){
        StringBuilder output = new StringBuilder();
        output.append("+-----------------------------------------+\n");
        output.append(String.format("| %-8s %-"+(10-currentMonth.toString().length())+"s%s, %s %"+(int) (18-String.valueOf(currentYear).length())+"s|%n","","",currentMonth,currentYear,""));
        output.append("+-----------------------------------------+\n");
        output.append("| Sun | Mon | Tue | Wed | Thu | Fri | Sat |\n");
        output.append("+-----------------------------------------+\n");
        int i=1;
        switch (weekDay(1)) {
            case "Sunday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, i++, i++, i++, i++, i++));
                break;
            case "Monday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", "", i++, i++, i++, i++, i++, i++));
                break;
            case "Tuesday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", "", "", i++, i++, i++, i++, i++));
                break;
            case "Wednesday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", "", "", "", i++, i++, i++, i++));
                break;
            case "Thursday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", "", "", "", "", i++, i++, i++));
                break;
            case "Friday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", "", "", "", "", "", i++, i++));
                break;
            case "Saturday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", "", "", "", "", "", "", i++));
                break;

            default:
                break;
        }
        while( i<=(currentMonth.getDaysInMonth()-7)){
            output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n",i++,i++,i++,i++,i++,i++,i++));
        }
        switch (currentMonth.getDaysInMonth()-i) {
            case 0:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, "", "", "", "", "", ""));
                break;
            case 1:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, "", "", "", "", ""));
                break;
            case 2:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, i++, "", "", "", ""));
                break;
            case 3:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, i++, i++, "", "", ""));
                break;
            case 4:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, i++, i++, i++, "", ""));
                break;
            case 5:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, i++, i++, i++, i++, ""));
                break;
            default:
                break;
        }
        output.append("+-----------------------------------------+");
        return output;
    }

    public String getCurrentWeekDay(){return currentWeekDay;}



    private Boolean isLeapYear(long currentYear) {
        if (currentYear % 4 == 0 && currentYear % 100 != 0) {
            return true;
        } else {
            if (currentYear % 400 == 0) {
                return true;
            }
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

    private String weekDay(int currentDay) {
        String output;
        int yearPast = (int) (currentYear)-1582;
        double daysPast = ((yearPast * 365) + howManyLeapYears()+daysSinceJanuary1(currentDay)-1);
        daysPast = (daysPast)%7;
        switch ((int) daysPast) {
            case 3:
                output = "Monday";
                break;
            case 4:
                output = "Tuesday";
                break;
            case 5:
                output = "Wednesday";
                break;
            case 6:
                output = "Thursday";
                break;
            case 0:
                output = "Friday";
                break;
            case 1:
                output = "Saturday";
                break;
            case 2:
                output = "Sunday";
                break;
            default:
                output = null;
                break;
        }
        return output;
    }

    private long daysSinceJanuary1(int currentDay){
        long output = 0;
        int leapYear = 0;
        if(isLeapYear(currentYear)){
            leapYear++;
        }
        switch (currentMonth.getMonthInt()){
            case 1:
                output = currentDay;
                break;
            case 2:
                output = currentDay+31;
                break;
            case 3:
                output = currentDay+59+leapYear;
                break;
            case 4:
                output = currentDay+90+leapYear;
                break;
            case 5:
                output = currentDay+120+leapYear;
                break;
            case 6:
                output = currentDay+151+leapYear;
                break;
            case 7:
                output = currentDay+181+leapYear;
                break;
            case 8:
                output = currentDay+212+leapYear;
                break;
            case 9:
                output = currentDay+243+leapYear;
                break;
            case 10:
                output = currentDay+273+leapYear;
                break;
            case 11:
                output = currentDay+304+leapYear;
                break;
            case 12:
                output = currentDay+334+leapYear;
                break;
        }
        return output;
    }
}
