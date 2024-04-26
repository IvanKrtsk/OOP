package myShapes;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.myStrategy.myInterfaces.DrawStrategy;

import java.util.ArrayList;

public abstract class MyShape {
    public DrawStrategy drawStrategy;
    public ArrayList<MyPoint> cordinates;
    public Color color;
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
    public javafx.scene.shape.Shape doDrawing(){
        return(drawStrategy.draw(this.cordinates, this.color));
    }
}
