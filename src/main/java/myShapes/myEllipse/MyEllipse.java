package myShapes.myEllipse;

import javafx.scene.paint.Color;
import myShapes.MyShape;
import myPoint.MyPoint;
import myShapes.myDrawStrategy.myClasses.MyEllipseDrawStrategy;

import java.util.ArrayList;

public class MyEllipse extends MyShape {
    public double radiusX, radiusY;
    public MyEllipse(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        setParameters();
    }
    protected void setParameters(){
        this.centre.x = Math.abs((this.cordinates.get(0).x + this.cordinates.get(1).x) / 2);
        this.centre.y = Math.abs((this.cordinates.get(0).y + this.cordinates.get(1).y) / 2);
        this.radiusX = extractWidth();
        this.radiusY = extractHeight();
        this.javaShape = new javafx.scene.shape.Ellipse();
        this.drawStrategy = new MyEllipseDrawStrategy();
    }
    private double extractWidth(){return(Math.abs(this.centre.x - this.cordinates.get(0).x));}
    private double extractHeight(){return(Math.abs(this.centre.y - this.cordinates.get(0).y));}
}
