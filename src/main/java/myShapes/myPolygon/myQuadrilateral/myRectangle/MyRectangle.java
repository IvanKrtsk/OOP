package myShapes.myPolygon.myQuadrilateral.myRectangle;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.myPolygon.myQuadrilateral.MyQuadrilateral;
import myPatterns.myDrawStrategy.myClasses.MyRectangleDrawStrategy;

import java.util.ArrayList;

public class MyRectangle extends MyQuadrilateral{

    public MyRectangle(ArrayList<MyPoint> cordinates, Color fillColor, Color strokeColor, double strokeWidth){
        super(cordinates, fillColor, strokeColor, strokeWidth);
        this.drawStrategy = new MyRectangleDrawStrategy();
        this.className = "Прямоугольник";
    }
}
