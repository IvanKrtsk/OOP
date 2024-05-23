package myShapes;

import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myPatterns.myDrawStrategy.myInterfaces.DrawStrategy;

import java.util.ArrayList;

public abstract class MyShape{
    public DrawStrategy drawStrategy;
    public ArrayList<MyPoint> cordinates;
    protected double width, height;
    public Color fillColor;
    public Color strokeColor;
    public double strokeWidth;
    public javafx.scene.shape.Shape javaShape;
    public String className;
    protected MyShape(ArrayList<MyPoint> cordinates, Color fillColor, Color strokeColor, double strokeWidth){
        setParameters(cordinates, fillColor, strokeColor, strokeWidth);
    }
    private void setParameters(ArrayList<MyPoint> cordinates, Color fillColor, Color strokeColor, double strokeWidth){
        this.cordinates = new ArrayList<>();
        fillCordinates(cordinates);
        this.width = countWidth();
        this.height = countHeight();
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }
    public void updateCordinates(ArrayList<MyPoint> cordinates){
        this.cordinates.clear();
        fillCordinates(cordinates);
        this.doDrawing();
    }
    public void updateColor(Color color){
        this.fillColor = color;
        this.javaShape.setFill(fillColor);
    }
    public void updateStrokeWidth(double strokeWidth){
        this.strokeWidth = strokeWidth;
        this.javaShape.setStrokeWidth(strokeWidth);
    }
    public void updateStrokeColor(Color strokeColor){
        this.strokeColor = strokeColor;
        this.javaShape.setStroke(strokeColor);
    }
    protected void fillCordinates(ArrayList<MyPoint> cordinates){
        for (int i = 0; i < cordinates.size(); i++){
            this.cordinates.add(cordinates.get(i));
        }
    }
    protected double countWidth(){return(cordinates.get(0).x - cordinates.get(1).x);}
    protected double countHeight(){return(cordinates.get(0).y - cordinates.get(1).y);}
    public double getWidth(){return(this.width);}
    public double getHeight(){return(this.height);}
    public void doDrawing(){
        drawStrategy.draw(this);
    }
}
