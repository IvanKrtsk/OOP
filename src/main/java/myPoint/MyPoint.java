package myPoint;

import javafx.scene.effect.Light;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyPoint {
    public double x, y;
    public MyPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static double getDistance(MyPoint p1, MyPoint p2){
        return(Math.sqrt((Math.pow((p2.x - p1.x), 2)) + Math.pow((p2.y - p1.y), 2)));
    }

    public static ArrayList<MyPoint> getPointArr(MyPoint... arr){
        ArrayList<MyPoint> array = new ArrayList<>();
        for (MyPoint point: arr) {
            MyPoint newPoint = new MyPoint(point.x, point.y);
            array.add(newPoint);
        }
        return(array);
    }

    public void setCordinates(double x, double y){
        this.x = x;
        this.y = y;
    }
}
