package homework.csc202.lab09ListADTLL;

import java.text.DecimalFormat;

/**
 * Created by 15Cyndaquil on 6/15/2017.
 */
public class Node {
    private Node node;
    private String classType, className, profName;
    private int classNum, index;
    private DecimalFormat indexFormat= new DecimalFormat("00");

    public Node(Node node){
        this.index = node.getIndex();
        this.node = node.getNode();
        this.classType = node.getClassType();
        this.className = node.getClassName();
        this.profName = node.getProfName();
        this.classNum = node.getClassNum();
    }
    public Node(String classType, int classNum, String className, String profName){
        this.classType = classType;
        this.classNum = classNum;
        this.className = className;
        this.profName = profName;
        node = null;
    }
    public Node(Node data, Node node){
        this.classType = data.getClassType();
        this.classNum = data.getClassNum();
        this.className = data.getClassName();
        this.profName = data.getProfName();
        this.node = node;
    }





    public void setNode(Node node){this.node=node;}
    public void setIndex(int index){this.index = index;}
    public Node getNode() {return node;}
    public String getClassType() {return classType;}
    public String getClassName() {return className;}
    public String getProfName() {return profName;}
    public int getClassNum() {return classNum;}
    public int getIndex(){return index;}

    public void println(){
        System.out.println(classType+classNum+"-"+indexFormat.format(index)+" "+className+" "+profName);
    }
}
