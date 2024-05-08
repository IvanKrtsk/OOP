package myShapes.myDrawStrategy.myClasses;

import javafx.scene.shape.Line;
import myShapes.MyShape;
import myShapes.myDrawStrategy.myInterfaces.DrawStrategy;

public class MyLineDrawStrategy implements DrawStrategy {
    public void draw(MyShape shape){
        Line line = (Line)shape.javaShape;
        System.out.println(shape.cordinates.get(0).x + " " + shape.cordinates.get(0).y);
        line.setStartX(shape.cordinates.get(0).x);
        line.setStartY(shape.cordinates.get(0).y);
        line.setEndX(shape.cordinates.get(1).x);
        line.setEndY(shape.cordinates.get(1).y);
        line.setFill(shape.color);
    }
}
