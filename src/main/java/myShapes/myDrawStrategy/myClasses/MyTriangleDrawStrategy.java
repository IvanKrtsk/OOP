package myShapes.myDrawStrategy.myClasses;

import javafx.scene.shape.Polygon;
import myShapes.MyShape;
import myShapes.myDrawStrategy.myInterfaces.DrawStrategy;

public class MyTriangleDrawStrategy implements DrawStrategy {
    public void draw(MyShape shape){
        Polygon trinagle = (Polygon)shape.javaShape;
        trinagle.getPoints().addAll(new Double[]{
                shape.cordinates.get(0).x, shape.cordinates.get(1).y,
                shape.cordinates.get(1).x, shape.cordinates.get(1).y,
                ((shape.cordinates.get(0).x + shape.cordinates.get(1).x) / 2), shape.cordinates.get(0).y,
        });
        trinagle.setFill(shape.color);
    }
}
