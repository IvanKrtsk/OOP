package myShapes.myEllipse.myCircumference;

import javafx.scene.paint.Color;
import myShapes.myEllipse.MyEllipse;
import myPoint.MyPoint;
import myPatterns.myDrawStrategy.myClasses.MyEllipseDrawStrategy;

import java.util.ArrayList;

public class MyCircumference extends MyEllipse{
    private double radius;
    public MyCircumference(ArrayList<MyPoint> cordinates, Color fillColor, Color strokeColor, double strokeWidth){
        super(cordinates, fillColor, strokeColor, strokeWidth);
        setParameters();
    }
    protected void setParameters(){
        countCentre();
        countRadius();
        this.javaShape = new javafx.scene.shape.Circle();
        this.drawStrategy = new MyEllipseDrawStrategy();
        this.className = "Круг";
    }
    public void countRadius(){
        this.radius = Math.abs(this.width / 2);
    }
    public double getRadius(){return(this.radius);}
}
