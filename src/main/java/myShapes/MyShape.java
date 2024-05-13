package myShapes;

import com.google.gson.annotations.Expose;
import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.myDrawStrategy.myInterfaces.DrawStrategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class MyShape implements Serializable {
    public DrawStrategy drawStrategy;
    @Expose
    public ArrayList<MyPoint> cordinates;
    protected double width, height;
    public Color color;
    public javafx.scene.shape.Shape javaShape;
    @Expose
    public String className;
    @Expose
    public String strColor;
    protected MyShape(ArrayList<MyPoint> cordinates, Color color){
        setParameters(cordinates, color);
    }
    private void setParameters(ArrayList<MyPoint> cordinates, Color color){
        this.cordinates = new ArrayList<>();
        fillCordinates(cordinates);
        this.width = countWidth();
        this.height = countHeight();
        this.color = color;
        this.strColor = color.toString();
    }
    public void updateCordinates(ArrayList<MyPoint> cordinates){
        this.cordinates.clear();
        fillCordinates(cordinates);
        this.doDrawing();
    }
    protected void fillCordinates(ArrayList<MyPoint> cordinates){
        for (int i = 0; i < cordinates.size(); i++){
            this.cordinates.add(cordinates.get(i));
        }
    }
    protected double countWidth(){return(cordinates.get(0).x - cordinates.get(1).x);}
    protected double countHeight(){return(cordinates.get(0).y - cordinates.get(1).y);}
    public double getWidth(){return(this.width);}
    public double getHeight(){return(this.height);}
    public void doDrawing(){
        drawStrategy.draw(this);
    }
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeObject(className);
        oos.writeObject(cordinates);
        this.strColor = color.toString();
        oos.writeObject(strColor);
    }
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        className = (String)ois.readObject();
        cordinates = (ArrayList<MyPoint>)ois.readObject();
        color = Color.web((String)ois.readObject());
    }
}
