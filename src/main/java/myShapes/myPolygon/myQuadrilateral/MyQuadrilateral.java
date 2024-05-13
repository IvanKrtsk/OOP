package myShapes.myPolygon.myQuadrilateral;

import javafx.scene.paint.Color;
import myShapes.myPolygon.MyPolygon;
import myPoint.MyPoint;

import java.util.ArrayList;

public abstract class MyQuadrilateral extends MyPolygon{
    protected MyQuadrilateral(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        fixCordinates();
        this.javaShape = new javafx.scene.shape.Rectangle();
    }
    private void fixCordinates(){
        double startX, startY;
        startX = Math.min(this.cordinates.get(0).x, this.cordinates.get(1).x);
        startY = Math.min(this.cordinates.get(0).y, this.cordinates.get(1).y);
        this.cordinates.clear();
        this.cordinates.add(new MyPoint(startX, startY));
        this.cordinates.add(new MyPoint(startX + Math.abs(getWidth()), startY - Math.abs(getHeight())));
    }
    public double getWidth() {return(super.getWidth());}
    public double getHeight() {return(super.getHeight());}
}
