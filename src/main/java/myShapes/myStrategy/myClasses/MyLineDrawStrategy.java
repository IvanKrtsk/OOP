package myShapes.myStrategy.myClasses;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import myPoint.MyPoint;
import myShapes.myStrategy.myInterfaces.DrawStrategy;

import java.util.ArrayList;

public class MyLineDrawStrategy implements DrawStrategy {
    @Override
    public javafx.scene.shape.Shape draw(ArrayList<MyPoint> cordinates, Color color){
        Line line = new Line();
        line.setStartX(cordinates.get(0).x);
        line.setStartY(cordinates.get(0).y);
        line.setEndX(cordinates.get(1).x);
        line.setEndY(cordinates.get(1).y);
        line.setFill(color);
        return (line);
    }
}
