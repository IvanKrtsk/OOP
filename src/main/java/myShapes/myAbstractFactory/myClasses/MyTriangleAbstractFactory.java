package myShapes.myAbstractFactory.myClasses;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.myAbstractFactory.myInterfaces.ShapeFabric;
import myShapes.myPolygon.myTriangle.MyTriangle;

import java.util.ArrayList;

public class MyTriangleAbstractFactory implements ShapeFabric {
    @Override
    public MyShape createShape(ArrayList<MyPoint> cordinates, Color color) {
        return(new MyTriangle(cordinates, color));
    }
}
