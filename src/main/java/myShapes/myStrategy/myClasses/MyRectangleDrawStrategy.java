package myShapes.myStrategy.myClasses;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import myPoint.MyPoint;
import myShapes.myStrategy.myInterfaces.DrawStrategy;

import java.util.ArrayList;

public class MyRectangleDrawStrategy implements DrawStrategy {
    public javafx.scene.shape.Shape draw(ArrayList<MyPoint> cordinates, Color color){
        Rectangle rectangle = new Rectangle();
        rectangle.setX(cordinates.get(0).x);
        rectangle.setY(cordinates.get(0).y);
        rectangle.setWidth(Math.abs(cordinates.get(0).x - cordinates.get(1).x));
        rectangle.setHeight(Math.abs(cordinates.get(0).y - cordinates.get(1).y));
        rectangle.setFill(color);
        return(rectangle);
    }
}
