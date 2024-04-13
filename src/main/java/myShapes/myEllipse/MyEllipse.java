package myShapes.myEllipse;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import myShapes.MyShape;
import myPoint.MyPoint;

import java.util.ArrayList;

public class MyEllipse extends MyShape {
    public double width, height;
    public MyPoint centre;
    public MyEllipse(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        setParameters();
    }
    protected void setParameters(){
        this.centre = this.cordinates.get(0);
        this.width = extractWidth();
        this.height = extractHeight();
    }

    private double extractWidth(){
        return(MyPoint.getDistance(this.centre, cordinates.get(1)));
    }

    private double extractHeight(){
        return(MyPoint.getDistance(this.centre, cordinates.get(2)));
    }
    public javafx.scene.shape.Shape draw(){
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(this.centre.x);
        ellipse.setCenterY(this.centre.y);
        ellipse.setRadiusX(this.width);
        ellipse.setRadiusY(this.height);
        ellipse.setFill(this.color);
        return(ellipse);
    }
}
