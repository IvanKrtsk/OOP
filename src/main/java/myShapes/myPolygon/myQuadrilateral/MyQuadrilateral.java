package myShapes.myPolygon.myQuadrilateral;

import javafx.scene.paint.Color;
import myShapes.myPolygon.MyPolygon;
import myPoint.MyPoint;

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
        this.centre.x = (this.cordinates.get(0).x + this.cordinates.get(1).x) / 2;
        this.centre.y = (this.cordinates.get(0).y + this.cordinates.get(1).y) / 2;
        this.javaShape = new javafx.scene.shape.Rectangle();
    }
}
