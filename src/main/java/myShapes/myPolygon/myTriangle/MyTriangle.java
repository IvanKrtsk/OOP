package myShapes.myPolygon.myTriangle;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.myPolygon.MyPolygon;
import myShapes.myDrawStrategy.myClasses.MyTriangleDrawStrategy;
import java.util.ArrayList;

public class MyTriangle extends MyPolygon {
    public MyTriangle(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        this.centre.x = (cordinates.get(0).x + cordinates.get(1).x) / 2;
        this.centre.y = (cordinates.get(0).y + cordinates.get(1).y) / 2;
        this.drawStrategy = new MyTriangleDrawStrategy();
    }
}
