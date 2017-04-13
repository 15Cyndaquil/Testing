package homework.ch13.prob_1;

/**
 * Created by 15Cyndaquil on 4/12/2017.
 */
public class Triangle extends GeometricObject{
    private double sideA, sideB, sideC, angleA, angleB, angleC;

    public Triangle(){
        this.sideC = 1;
        this.sideA = 1;
        this.sideB = 1;
        this.setAngles();
    }

    public Triangle(double sideA, double sideB, double SideC, String color, Boolean filled){
        this.sideC = SideC;
        this.sideA = sideA;
        this.sideB = sideB;
        this.setColor(color);
        this.setFilled(filled);
        this.setAngles();
    }

    private void setAngles(){
        double sideA2 = Math.pow(sideA,2);
        double sideB2 = Math.pow(sideB,2);
        double sideC2 = Math.pow(sideC,2);
        angleA = Math.acos((sideB2+sideC2-sideA2)/(2*sideB*sideC))*((180)/(Math.PI));
        angleB = Math.acos((sideC2+sideA2-sideB2)/(2*sideC*sideA))*((180)/(Math.PI));
        angleC = Math.acos((sideA2+sideB2-sideC2)/(2*sideA*sideB))*((180)/(Math.PI));
    }



    public double getArea(){
        double s = (this.getPerimeter()/2);
        return (Math.sqrt((s*(s- sideA)*(s- sideB)*(s- sideC))));
    }

    public double getPerimeter(){
        return (sideC + sideB + sideA);
    }

    @Override
    public String toString(){
        return   "Side A: "+ sideA +"\n"
                +"Side B: "+ sideB +"\n"
                +"Side C: "+ sideC +"\n"
                +"Area: "+this.getArea()+"\n"
                +"Color: "+this.getColor()+"\n"
                +"Filled: "+this.isFilled()+"\n"
                +"Angle A: "+angleA+"\n"
                +"Angle B: "+angleB+"\n"
                +"Angle C: "+angleC+"\n";
    }
}
