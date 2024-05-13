package myShapes;
import com.google.gson.annotations.Expose;
import javafx.scene.paint.Color;
import myPoint.MyPoint;

import java.util.ArrayList;
public class ShapeData {
    @Expose
    public String className;
    @Expose
    public ArrayList<MyPoint> cordinates = new ArrayList<>();
    @Expose
    public String strColor;
}
