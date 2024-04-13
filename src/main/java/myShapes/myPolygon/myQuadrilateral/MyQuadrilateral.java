package myShapes.myPolygon.myQuadrilateral;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
    }

    public javafx.scene.shape.Shape draw(){
        Rectangle rect = new Rectangle();
        rect.setX(this.cordinates.get(0).x);
        rect.setY(this.cordinates.get(0).y);
        rect.setWidth(this.width);
        rect.setHeight(this.heigth);
        rect.setFill(this.color);
        return(rect);
    }
}
