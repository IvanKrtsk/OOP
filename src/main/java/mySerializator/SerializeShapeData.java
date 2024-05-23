package mySerializator;
import com.google.gson.annotations.Expose;
import myPoint.MyPoint;
import myShapes.MyShape;

import java.io.*;
import java.util.ArrayList;

public class SerializeShapeData implements Serializable {
    @Expose
    public String className;
    @Expose
    public ArrayList<MyPoint> cordinates = new ArrayList<>();
    @Expose
    public String strFillColor;
    @Expose
    public String strStrokeColor;
    @Expose
    public double strokeWidth;
    public SerializeShapeData(MyShape myShape){
        this.className = myShape.className;
        for (MyPoint cordinate : myShape.cordinates)
            this.cordinates.add(cordinate);
        this.strFillColor = myShape.fillColor.toString();
        this.strStrokeColor = myShape.strokeColor.toString();
        this.strokeWidth = myShape.strokeWidth;
    }
}
