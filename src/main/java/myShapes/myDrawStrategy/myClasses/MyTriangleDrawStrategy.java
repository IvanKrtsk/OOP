package myShapes.myDrawStrategy.myClasses;

import javafx.scene.shape.Polygon;
import myShapes.MyShape;
import myShapes.myDrawStrategy.myInterfaces.DrawStrategy;
import myShapes.myPolygon.myTriangle.MyTriangle;

public class MyTriangleDrawStrategy implements DrawStrategy{
    public void draw(MyShape shape){
        Polygon triangle = (Polygon)shape.javaShape;
        MyTriangle myTriangle = (MyTriangle)shape;
        triangle.getPoints().clear();
        triangle.getPoints().addAll(myTriangle.trianglePoints);
        triangle.setFill(shape.color);
    }
}
