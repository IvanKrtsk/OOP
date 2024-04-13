package myShapes.myEllipse.myCircumference;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import myShapes.myEllipse.MyEllipse;
import myPoint.MyPoint;

import java.util.ArrayList;

public class MyCircumference extends MyEllipse {
    public double radius;

    public MyCircumference(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        setParameters();
    }
    protected void setParameters(){
        this.centre = this.cordinates.get(0);
        this.radius = extractRadius();
    }

    private double extractRadius(){
        return(MyPoint.getDistance(this.centre, this.cordinates.get(1)));
    }
    @Override
    public javafx.scene.shape.Shape draw(){
        Circle circle = new Circle();
        circle.setCenterX(this.centre.x);
        circle.setCenterY(this.centre.y);
        circle.setRadius(this.radius);
        return(circle);
    }
}
