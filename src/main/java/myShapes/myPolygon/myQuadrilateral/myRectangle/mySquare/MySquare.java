package myShapes.myPolygon.myQuadrilateral.myRectangle.mySquare;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.myPolygon.myQuadrilateral.myRectangle.MyRectangle;
import myPatterns.myDrawStrategy.myClasses.MyRectangleDrawStrategy;

import java.util.ArrayList;

public class MySquare extends MyRectangle{
    public MySquare(ArrayList<MyPoint> cordinates, Color fillColor, Color strokeColor, double strokeWidth){
        super(cordinates, fillColor, strokeColor, strokeWidth);
        this.drawStrategy = new MyRectangleDrawStrategy();
        this.className = "Квадрат";
    }
}
