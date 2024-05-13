package myShapes.myPolygon.myTriangle;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.myPolygon.MyPolygon;
import myShapes.myDrawStrategy.myClasses.MyTriangleDrawStrategy;

import java.util.ArrayList;

public class MyTriangle extends MyPolygon{
    public Double[] trianglePoints;
    public MyTriangle(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        this.drawStrategy = new MyTriangleDrawStrategy();
        this.trianglePoints = new Double[6];
        fillTrinaglePoints();
        this.className = "Треугольник";
    }
    public void fillTrinaglePoints(){
        this.trianglePoints[0] = this.cordinates.get(0).x;
        this.trianglePoints[1] = this.cordinates.get(1).y;
        this.trianglePoints[2] = this.cordinates.get(1).x;
        this.trianglePoints[3] = this.cordinates.get(1).y;
        this.trianglePoints[4] = (this.cordinates.get(0).x + this.cordinates.get(1).x) / 2;
        this.trianglePoints[5] = this.cordinates.get(0).y;
    }
    public void updateCordinates(ArrayList<MyPoint> cordinates){
        this.cordinates.clear();
        fillCordinates(cordinates);
        fillTrinaglePoints();
        this.doDrawing();
    }
}
