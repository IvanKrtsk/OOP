package myShapes.myPolygon;

import javafx.scene.paint.Color;
import myShapes.MyShape;
import myPoint.MyPoint;

import java.util.ArrayList;

public abstract class MyPolygon extends MyShape{
    protected MyPolygon(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        this.javaShape = new javafx.scene.shape.Polygon();
    }
}
