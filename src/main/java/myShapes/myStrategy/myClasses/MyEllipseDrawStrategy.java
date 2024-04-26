package myShapes.myStrategy.myClasses;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import myPoint.MyPoint;
import myShapes.myStrategy.myInterfaces.DrawStrategy;

import java.util.ArrayList;

public class MyEllipseDrawStrategy implements DrawStrategy {
    public javafx.scene.shape.Shape draw(ArrayList<MyPoint> cordinates, Color color){
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(Math.abs((cordinates.get(0).x + cordinates.get(1).x) / 2));
        ellipse.setCenterY(Math.abs((cordinates.get(0).y + cordinates.get(1).y) / 2));
        ellipse.setRadiusX(Math.abs((cordinates.get(0).x - cordinates.get(1).x) / 2));
        ellipse.setRadiusY(Math.abs((cordinates.get(0).y - cordinates.get(1).y) / 2));
        ellipse.setFill(color);
        return(ellipse);
    }
}
