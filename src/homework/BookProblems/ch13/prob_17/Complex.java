package homework.BookProblems.ch13.prob_17;

/**
 * Created by 15Cyndaquil on 4/11/2017.
 */
public class Complex implements Cloneable{
    private double a, b;

    public Complex(){
        this.a = 0;
        this.b = 0;
    }

    public Complex(double a){
        this.a = a;
        this.b = 0;
    }

    public Complex(double a, double b){
        this.a = a;
        this.b = b;
    }

    public String add(Complex two){
        double a=this.a;
        double b=this.b;
        double c=two.a;
        double d=two.b;

        String output = this.toString()+" + "+two.toString()+" = ";
        return output+((a+c)+" + "+(b+d)+"i");
    }

    public String subtract(Complex two){
        double a=this.a;
        double b=this.b;
        double c=two.a;
        double d=two.b;

        String output = this.toString()+" - "+two.toString()+" = ";
        return output+((a-c)+" + "+(b-d)+"i");
    }

    public String multiply(Complex two){
        double a=this.a;
        double b=this.b;
        double c=two.a;
        double d=two.b;

        String output = this.toString()+" * "+two.toString()+" = ";
        return output+(((a*c)-(b*d))+" + "+((b*c)+(a*d))+"i");
    }

    public String divide(Complex two) {
        double a = this.a;
        double b = this.b;
        double c = two.a;
        double d = two.b;

        String output = this.toString()+" / "+two.toString()+" = ";
        return output+((((a*c)+(b*d))/(Math.pow(c,2)+Math.pow(d,2)))
                +" + "
                +(((b*c)-(a*d))/(Math.pow(c,2)+Math.pow(d,2)))+"i");
    }

    public String abs(){
        double a = this.a;
        double b = this.b;

        String output = "|"+this.toString()+"| = ";
        return output+String.valueOf(Math.sqrt(Math.pow(a,2)+Math.pow(b,2)));
    }

    public double getRealPart(){
        return this.a;
    }

    public double getImaginaryPart(){
        return this.b;
    }

    @Override
    public String toString(){
        return "("+this.a+" + "+this.b+"i)";
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
