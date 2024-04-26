package myShapes.myStrategy.myClasses;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import myPoint.MyPoint;
import myShapes.myStrategy.myInterfaces.DrawStrategy;

import java.util.ArrayList;

public class MyTriangleDrawStrategy implements DrawStrategy {
    public javafx.scene.shape.Shape draw(ArrayList<MyPoint> cordinates, Color color){
        Polygon trinagle = new Polygon();
        trinagle.getPoints().addAll(new Double[]{
                cordinates.get(0).x, cordinates.get(1).y,
                cordinates.get(1).x, cordinates.get(1).y,
                ((cordinates.get(0).x + cordinates.get(1).x) / 2), cordinates.get(0).y,
        });
        trinagle.setFill(color);
        return(trinagle);
    }
}
