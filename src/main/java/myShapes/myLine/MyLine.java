package myShapes.myLine;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import myPoint.MyPoint;
import myShapes.MyShape;

import java.util.ArrayList;

public class MyLine extends MyShape {

    public MyLine(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
    }

    public javafx.scene.shape.Shape draw(){
        Line line = new Line();
        line.setStartX(this.cordinates.get(0).x);
        line.setStartY(this.cordinates.get(0).y);
        line.setEndX(this.cordinates.get(1).x);
        line.setEndY(this.cordinates.get(1).y);
        line.setFill(this.color);
        return (line);
    }
}
