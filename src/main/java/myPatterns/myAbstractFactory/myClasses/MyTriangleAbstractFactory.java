package myPatterns.myAbstractFactory.myClasses;

import javafx.scene.paint.Color;
import myPatterns.myAbstractFactory.myInterfaces.ShapeFabric;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.myPolygon.myTriangle.MyTriangle;

import java.util.ArrayList;

public class MyTriangleAbstractFactory implements ShapeFabric {
    @Override
    public MyShape createShape(ArrayList<MyPoint> cordinates, Color fillColor, Color strokeColor, double strokeWidth) {
        return(new MyTriangle(cordinates, fillColor, strokeColor, strokeWidth));
    }
}
