package homework.csc202.MultiThreadingProgram;

/**
 * Created by 15Cyndaquil on 6/13/2017.
 */
public class OneIntToPassThrough {
    int i;
    public OneIntToPassThrough(){
        i=0;
    }

    public void add(){
        i++;
    }

    public int getInt(){
        return i;
    }
}
