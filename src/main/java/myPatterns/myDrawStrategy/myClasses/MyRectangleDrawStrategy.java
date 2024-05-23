package myPatterns.myDrawStrategy.myClasses;

import javafx.scene.shape.Rectangle;
import myShapes.MyShape;
import myShapes.myPolygon.myQuadrilateral.myRectangle.MyRectangle;
import myShapes.myPolygon.myQuadrilateral.myRectangle.mySquare.MySquare;
import myPatterns.myDrawStrategy.myInterfaces.DrawStrategy;

public class MyRectangleDrawStrategy implements DrawStrategy{
    public void draw(MyShape shape){
        Rectangle rectangle = (Rectangle)shape.javaShape;
        MyRectangle myRectangle = (MyRectangle)shape;
        rectangle.setX(myRectangle.cordinates.get(0).x);
        rectangle.setY(myRectangle.cordinates.get(0).y);
        rectangle.setWidth(Math.abs(myRectangle.getWidth()));
        if (shape instanceof MySquare)
            rectangle.setHeight(Math.abs(myRectangle.getWidth()));
        else
            rectangle.setHeight(Math.abs(myRectangle.getHeight()));
        rectangle.setFill(myRectangle.fillColor);
        rectangle.setStroke(myRectangle.strokeColor);
        rectangle.setStrokeWidth(myRectangle.strokeWidth);
    }
}
