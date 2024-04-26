package myShapes.myStrategy.myInterfaces;

import javafx.scene.paint.Color;
import myPoint.MyPoint;

import java.util.ArrayList;

public interface DrawStrategy {
    javafx.scene.shape.Shape draw(ArrayList<MyPoint> cordinates, Color color);
}
