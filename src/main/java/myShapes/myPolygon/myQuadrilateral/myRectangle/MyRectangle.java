package myShapes.myPolygon.myQuadrilateral.myRectangle;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.myPolygon.myQuadrilateral.MyQuadrilateral;
import myShapes.myDrawStrategy.myClasses.MyRectangleDrawStrategy;

import java.util.ArrayList;

public class MyRectangle extends MyQuadrilateral {

    public MyRectangle(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        this.drawStrategy = new MyRectangleDrawStrategy();
    }
}
