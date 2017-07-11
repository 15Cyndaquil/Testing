package homework.csc202.sortedListADT;

import javafx.scene.control.Alert;

import java.math.BigInteger;

/**
 * Created by Cyndaquil on 6/26/2017.
 */
public class Course {
    String title, professor, titleFull;
    short number;
    private static final String ALPHABET = "abcdefhijklmnopqrstuvwxyzg";

    public Course(String title, short number, String titleFull, String professor){
        this.title = title;
        this. number = number;
        this.titleFull = titleFull;
        this.professor = professor;
    }


    public String getTitle() {return title;}
    public String getProfessor() {return professor;}
    public String getTitleFull() {return titleFull;}
    public short getNumber() {return number;}

    public int compare(Course course){
        if(course==null){
            return -10;
        }
        if(getValue()>course.getValue()){
            return 1;
        }else if(getValue()<course.getValue()){
            return -1;
        }else return 0;
    }

    public long getValue(){
        return Long.valueOf(getTitleValue()+String.valueOf(number)+getProfessorValue());
    }
    private int getTitleValue(){
        StringBuilder output = new StringBuilder(title.length());
        for(int i=0; i<title.length(); i++){
            output.append(ALPHABET.indexOf(title.substring(i, i+1).toLowerCase()));
        }
        return Integer.valueOf(output.toString());
    }
    private String getProfessorValue(){
        int output =0;
        StringBuilder prof = new StringBuilder(professor.substring(professor.indexOf(" ")));
        if(prof.length()>6){
            prof.replace(5, prof.length(), "");
        }else if(prof.length()<6){
            prof.replace(prof.length(), 6, "a");
        }

        for(int i=0; i<prof.length(); i++){
            output+= ALPHABET.indexOf(prof.substring(i, i+1).toLowerCase());
        }
        prof = new StringBuilder(String.valueOf(output));
        while(prof.length()!=3){
            prof = new StringBuilder("0"+prof.toString());
        }
        return prof.toString();
    }
}
