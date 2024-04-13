package myShapes.myPolygon.myTriangle;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import myPoint.MyPoint;
import myShapes.myPolygon.MyPolygon;

import java.util.ArrayList;

public class MyTriangle extends MyPolygon {
    public MyTriangle(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
    }
    public javafx.scene.shape.Shape draw(){
        Polygon trinagle = new Polygon();
        trinagle.getPoints().addAll(new Double[]{
            this.cordinates.get(0).x, this.cordinates.get(0).y,
            this.cordinates.get(1).x, this.cordinates.get(1).y,
            this.cordinates.get(2).x, this.cordinates.get(2).y,
        });
        trinagle.setFill(this.color);
        return(trinagle);
    }
}
