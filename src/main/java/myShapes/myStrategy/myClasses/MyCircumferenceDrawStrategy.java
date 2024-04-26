package myShapes.myStrategy.myClasses;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import myPoint.MyPoint;
import myShapes.myStrategy.myInterfaces.DrawStrategy;

import java.util.ArrayList;

public class MyCircumferenceDrawStrategy implements DrawStrategy {
    public javafx.scene.shape.Shape draw(ArrayList<MyPoint> cordinates, Color color){
        Circle circle = new Circle();
        circle.setCenterX(Math.abs((cordinates.get(0).x + cordinates.get(1).x) / 2));
        circle.setCenterY(Math.abs((cordinates.get(0).y + cordinates.get(1).y) / 2));
        circle.setRadius(Math.abs((cordinates.get(0).x - cordinates.get(1).x) / 2));
        circle.setFill(color);
        return(circle);
    }
}
