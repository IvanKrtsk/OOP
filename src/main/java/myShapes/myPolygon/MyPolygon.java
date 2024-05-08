package myShapes.myPolygon;

import javafx.scene.paint.Color;
import myShapes.MyShape;
import myPoint.MyPoint;

import java.util.ArrayList;

public abstract class MyPolygon extends MyShape {
    public int vertexCount;
    protected MyPolygon(ArrayList<MyPoint> cordinates, Color color){
        super(cordinates, color);
        setVertexCount(cordinates.size());
        this.javaShape = new javafx.scene.shape.Polygon();
    }
    private void setVertexCount(int vertexCount){
        this.vertexCount = vertexCount;
    }
}
