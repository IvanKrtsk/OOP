package myShapes.myDrawStrategy.myClasses;

import javafx.scene.shape.Rectangle;
import myShapes.MyShape;
import myShapes.myPolygon.myQuadrilateral.myRectangle.MyRectangle;
import myShapes.myPolygon.myQuadrilateral.myRectangle.mySquare.MySquare;
import myShapes.myDrawStrategy.myInterfaces.DrawStrategy;

public class MyRectangleDrawStrategy implements DrawStrategy {
    public void draw(MyShape shape){
        Rectangle rectangle = (Rectangle)shape.javaShape;
        MyRectangle myRectangle = (MyRectangle)shape;
        rectangle.setX(myRectangle.cordinates.get(0).x);
        rectangle.setY(myRectangle.cordinates.get(0).y);
        rectangle.setWidth(myRectangle.width);
        if (shape instanceof MySquare)
            rectangle.setHeight(myRectangle.width);
        else
            rectangle.setHeight(myRectangle.heigth);
        rectangle.setFill(myRectangle.color);
    }
}
