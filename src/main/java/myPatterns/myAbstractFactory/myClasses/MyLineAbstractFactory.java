package myPatterns.myAbstractFactory.myClasses;

import javafx.scene.paint.Color;
import myPatterns.myAbstractFactory.myInterfaces.ShapeFabric;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.myLine.MyLine;

import java.util.ArrayList;

public class MyLineAbstractFactory implements ShapeFabric {
    public MyShape createShape(ArrayList<MyPoint> cordinates, Color fillColor, Color strokeColor, double strokeWidth) {
        return(new MyLine(cordinates, fillColor, strokeColor, strokeWidth));
    }
}