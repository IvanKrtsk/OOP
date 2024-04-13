package myShapes;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import java.util.ArrayList;

public abstract class MyShape {
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
    protected abstract javafx.scene.shape.Shape draw();
}
