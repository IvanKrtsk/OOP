package myPatterns.myAbstractFactory.myClasses;

import javafx.scene.paint.Color;
import myPatterns.myAbstractFactory.myInterfaces.ShapeFabric;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.myPolygon.myQuadrilateral.myRectangle.mySquare.MySquare;

import java.util.ArrayList;

public class MySquareAbstractFactory implements ShapeFabric {
    @Override
    public MyShape createShape(ArrayList<MyPoint> cordinates, Color fillColor, Color strokeColor, double strokeWidth) {
        return(new MySquare(cordinates, fillColor, strokeColor, strokeWidth));
    }
}
