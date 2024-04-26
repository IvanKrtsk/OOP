package myShapes.myStrategy.myClasses;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import myPoint.MyPoint;
import myShapes.myStrategy.myInterfaces.DrawStrategy;

import java.util.ArrayList;

public class MySquareDrawStrategy implements DrawStrategy {

    @Override
    public Shape draw(ArrayList<MyPoint> cordinates, Color color) {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(cordinates.get(0).x);
        rectangle.setY(cordinates.get(0).y);
        rectangle.setWidth(Math.abs(cordinates.get(0).x - cordinates.get(1).x));
        rectangle.setHeight(rectangle.getWidth());
        rectangle.setFill(color);
        return(rectangle);
    }
}
