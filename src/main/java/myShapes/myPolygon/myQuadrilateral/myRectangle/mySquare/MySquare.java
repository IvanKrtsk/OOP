package myShapes.myPolygon.myQuadrilateral.myRectangle.mySquare;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.myPolygon.myQuadrilateral.myRectangle.MyRectangle;
import myShapes.myStrategy.myClasses.MyRectangleDrawStrategy;
import myShapes.myStrategy.myClasses.MySquareDrawStrategy;

import java.util.ArrayList;

public class MySquare extends MyRectangle {
    public MySquare(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        this.drawStrategy = new MySquareDrawStrategy();
    }
}
