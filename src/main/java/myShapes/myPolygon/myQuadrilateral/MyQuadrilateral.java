package myShapes.myPolygon.myQuadrilateral;

import javafx.scene.paint.Color;
import myShapes.myPolygon.MyPolygon;
import myPoint.MyPoint;
import myShapes.myStrategy.myClasses.MyRectangleDrawStrategy;

import java.util.ArrayList;

public abstract class MyQuadrilateral extends MyPolygon {
    public double width, heigth;

    protected MyQuadrilateral(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        setParameters();
    }

    private void setParameters(){
        this.width = Math.abs(this.cordinates.get(0).x - this.cordinates.get(1).x);
        this.heigth = Math.abs(this.cordinates.get(0).y - this.cordinates.get(1).y);
    }
}
