package myShapes.myPolygon;

import javafx.scene.paint.Color;
import myShapes.MyShape;
import myPoint.MyPoint;

import java.util.ArrayList;

public abstract class MyPolygon extends MyShape{
    protected MyPolygon(ArrayList<MyPoint> cordinates, Color fillColor, Color strokeColor, double strokeWidth){
        super(cordinates, fillColor, strokeColor, strokeWidth);
        this.javaShape = new javafx.scene.shape.Polygon();
    }
}
