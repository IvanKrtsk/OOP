package myShapes.myPolygon.myTriangle;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.myPolygon.MyPolygon;
import myShapes.myStrategy.myClasses.MyTriangleDrawStrategy;
import java.util.ArrayList;

public class MyTriangle extends MyPolygon {
    public MyTriangle(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        this.drawStrategy = new MyTriangleDrawStrategy();
    }
}
