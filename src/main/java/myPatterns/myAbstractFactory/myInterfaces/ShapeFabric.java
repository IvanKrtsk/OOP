package myPatterns.myAbstractFactory.myInterfaces;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.MyShape;

import java.util.ArrayList;

public interface ShapeFabric {
    MyShape createShape(ArrayList<MyPoint> cordinates, Color fillColor, Color strokeColor, double strokeWidth);
}
