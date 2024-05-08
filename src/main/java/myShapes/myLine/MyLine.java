package myShapes.myLine;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.myDrawStrategy.myClasses.MyLineDrawStrategy;

import java.util.ArrayList;

public class MyLine extends MyShape {
    public MyLine(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        this.centre.x = (cordinates.get(0).x + cordinates.get(1).x) / 2;
        this.centre.y = (cordinates.get(0).y + cordinates.get(1).y) / 2;
        this.drawStrategy = new MyLineDrawStrategy();
        this.javaShape = new javafx.scene.shape.Line();
    }
}
