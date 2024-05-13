package myShapes.myEllipse;

import javafx.scene.paint.Color;
import myShapes.MyShape;
import myPoint.MyPoint;
import myShapes.myDrawStrategy.myClasses.MyEllipseDrawStrategy;

import java.util.ArrayList;

public class MyEllipse extends MyShape {
    private double radiusX, radiusY;
    protected MyPoint centre = new MyPoint();
    public MyEllipse(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        setParameters();
    }
    protected void setParameters(){
        countCentre();
        countRadius();
        this.javaShape = new javafx.scene.shape.Ellipse();
        this.drawStrategy = new MyEllipseDrawStrategy();
        this.className = "Эллипс";
    }
    protected void countCentre(){
        this.centre.x = Math.abs((this.cordinates.get(0).x + this.cordinates.get(1).x) / 2);
        this.centre.y = Math.abs((this.cordinates.get(0).y + this.cordinates.get(1).y) / 2);
    }
    public void updateCordinates(ArrayList<MyPoint> cordinates){
        this.cordinates.clear();
        fillCordinates(cordinates);
        countCentre();
        countRadius();
        this.doDrawing();
    }
    public void countRadius(){
        this.radiusX = Math.abs(this.width / 2);
        this.radiusY = Math.abs(this.height / 2);
    }
    public double getRadiusX(){return(this.radiusX);}
    public double getRadiusY(){return(this.radiusY);}
    public MyPoint getCentre(){return(this.centre);}
}
