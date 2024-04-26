package myShapes.myAbstractFactory.myClasses;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.myAbstractFactory.myInterfaces.ShapeFabric;
import myShapes.myPolygon.myQuadrilateral.myRectangle.MyRectangle;

import java.util.ArrayList;

public class MyRectangleAbstractFactory implements ShapeFabric {
    @Override
    public MyShape createShape(ArrayList<MyPoint> cordinates, Color color) {
        return(new MyRectangle(cordinates, color));
    }
}
