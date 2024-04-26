package myShapes.myAbstractFactory.myClasses;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.myAbstractFactory.myInterfaces.ShapeFabric;
import myShapes.myEllipse.myCircumference.MyCircumference;

import java.util.ArrayList;

public class MyCircumferenceAbstractFactory implements ShapeFabric {
    @Override
    public MyShape createShape(ArrayList<MyPoint> cordinates, Color color) {
        return(new MyCircumference(cordinates, color));
    }
}
