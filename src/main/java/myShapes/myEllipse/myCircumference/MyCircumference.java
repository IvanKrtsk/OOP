package myShapes.myEllipse.myCircumference;

import javafx.scene.paint.Color;
import myShapes.myEllipse.MyEllipse;
import myPoint.MyPoint;
import myShapes.myDrawStrategy.myClasses.MyEllipseDrawStrategy;

import java.util.ArrayList;

public class MyCircumference extends MyEllipse {
    public double radius;

    public MyCircumference(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        setParameters();
    }
    protected void setParameters(){
        this.centre.x = Math.abs((this.cordinates.get(0).x + this.cordinates.get(1).x) / 2);
        this.centre.y = Math.abs((this.cordinates.get(0).y + this.cordinates.get(1).y) / 2);
        this.radius = extractRadius();
        this.javaShape = new javafx.scene.shape.Circle();
        this.drawStrategy = new MyEllipseDrawStrategy();
    }
    private double extractRadius(){return(Math.abs(this.centre.x - cordinates.get(0).x));}
}
