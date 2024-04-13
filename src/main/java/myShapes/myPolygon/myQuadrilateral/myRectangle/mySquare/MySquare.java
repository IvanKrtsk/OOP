package myShapes.myPolygon.myQuadrilateral.myRectangle.mySquare;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import myPoint.MyPoint;
import myShapes.myPolygon.myQuadrilateral.myRectangle.MyRectangle;

import java.util.ArrayList;

public class MySquare extends MyRectangle {

    public MySquare(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
    }

    public javafx.scene.shape.Shape draw(){
        Rectangle square = new Rectangle();
        square.setX(this.cordinates.get(0).x);
        square.setY(this.cordinates.get(0).y);
        square.setWidth(this.width);
        square.setHeight(this.heigth);
        square.setFill(this.color);
        return(square);
    }
}
