package myShapes.myDrawStrategy.myClasses;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import myShapes.MyShape;
import myShapes.myEllipse.MyEllipse;
import myShapes.myEllipse.myCircumference.MyCircumference;
import myShapes.myDrawStrategy.myInterfaces.DrawStrategy;

public class MyEllipseDrawStrategy implements DrawStrategy{
    public void draw(MyShape shape){
        if(shape instanceof MyCircumference) {
            MyCircumference myCircumference = (MyCircumference)shape;
            Circle circle = (Circle)shape.javaShape;
            circle.setCenterX(myCircumference.getCentre().x);
            circle.setCenterY(myCircumference.getCentre().y);
            circle.setRadius(myCircumference.getRadius());
            circle.setRadius(myCircumference.getRadius());
            circle.setFill(myCircumference.color);
        }else {
            MyEllipse myEllipse = (MyEllipse)shape;
            Ellipse ellipse = (Ellipse)shape.javaShape;
            ellipse.setCenterX(myEllipse.getCentre().x);
            ellipse.setCenterY(myEllipse.getCentre().y);
            ellipse.setRadiusX(myEllipse.getRadiusX());
            ellipse.setRadiusY(myEllipse.getRadiusY());
            ellipse.setFill(myEllipse.color);
        }
    }
}
