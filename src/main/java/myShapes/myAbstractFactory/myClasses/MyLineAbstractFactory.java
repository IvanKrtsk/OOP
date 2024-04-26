package myShapes.myAbstractFactory.myClasses;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.myAbstractFactory.myInterfaces.ShapeFabric;
import myShapes.myLine.MyLine;

import java.util.ArrayList;

public class MyLineAbstractFactory implements ShapeFabric {
    public MyShape createShape(ArrayList<MyPoint> cordinates, Color color) {
        return(new MyLine(cordinates, color));
    }
}