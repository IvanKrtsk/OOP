package myShapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import myPoint.MyPoint;
import myShapes.myDrawStrategy.myInterfaces.DrawStrategy;

import java.util.ArrayList;

public abstract class MyShape {
    public DrawStrategy drawStrategy;
    public ArrayList<MyPoint> cordinates;
    public Color color;
    public javafx.scene.shape.Shape javaShape;
    protected MyPoint centre = new MyPoint();
    protected MyShape(ArrayList<MyPoint> cordinates, Color color){
        setParameters(cordinates, color);
    }
    private void setParameters(ArrayList<MyPoint> cordinates, Color color){
        this.cordinates = new ArrayList<>();
        for (int i = 0; i < cordinates.size(); i++){
            this.cordinates.add(cordinates.get(i));
        }
        this.color = color;
    }
    public void doDrawing(){
        drawStrategy.draw(this);
    }
    public MyPoint getCentre(){return(this.centre);}
//    public void setCentre(double newX, double newY){this.centre.x = newX; this.centre.y = newY;}
}
