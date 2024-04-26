package myShapes.myLine;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.myStrategy.myClasses.MyLineDrawStrategy;

import java.util.ArrayList;

public class MyLine extends MyShape {

    public MyLine(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        this.drawStrategy = new MyLineDrawStrategy();
    }
}
