package myShapes.myLine;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.myDrawStrategy.myClasses.MyLineDrawStrategy;

import java.util.ArrayList;

public class MyLine extends MyShape {
    public MyLine(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        this.drawStrategy = new MyLineDrawStrategy();
        this.javaShape = new javafx.scene.shape.Line();
        this.className = "Линия";
    }
}
