package myPatterns.myAbstractFactory.myClasses;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.MyShape;
import myPatterns.myAbstractFactory.myInterfaces.ShapeFabric;
import myShapes.myEllipse.MyEllipse;

import java.util.ArrayList;

public class MyEllipseAbstractFactory implements ShapeFabric {
    @Override
    public MyShape createShape(ArrayList<MyPoint> cordinates, Color fillColor, Color strokeColor, double strokeWidth) {
        return(new MyEllipse(cordinates, fillColor, strokeColor, strokeWidth));
    }
}
