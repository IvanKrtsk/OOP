package com.example.oop2lab;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import myPoint.MyPoint;
import myShapes.myEllipse.MyEllipse;
import myShapes.myEllipse.myCircumference.MyCircumference;
import myShapes.myLine.MyLine;
import myShapes.myPolygon.myQuadrilateral.myRectangle.MyRectangle;
import myShapes.myPolygon.myQuadrilateral.myRectangle.mySquare.MySquare;
import myShapes.myPolygon.myTriangle.MyTriangle;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane drawPane;

    @FXML
    private RadioButton lineButton;

    @FXML
    private ToggleGroup radioGroup;

    @FXML
    private RadioButton rectangularButton;

    @FXML
    private RadioButton roundButton;

    @FXML
    private RadioButton squareButton;

    @FXML
    private RadioButton triangleButton;

    @FXML
    void initialize() {
        ArrayList<MyPoint> cordinates = new ArrayList<>();
        MyPoint point = new MyPoint(30, 30);
        MyPoint point1 = new MyPoint(80, 50);
        MyPoint point2 = new MyPoint(200, 130);
        cordinates.add(point);
        cordinates.add(point1);

        MyRectangle myRect = new MyRectangle(MyPoint.getPointArr(point, point1), Color.BLUE);
        Rectangle rect = (Rectangle)myRect.draw();

        point.setCordinates(90, 30);
        point1.setCordinates(130, 70);
        MySquare mySq = new MySquare(MyPoint.getPointArr(point, point1), Color.RED);
        Rectangle square = (Rectangle)mySq.draw();

        point.setCordinates(140, 30);
        point1.setCordinates(190, 55);
        MyLine myLi = new MyLine(MyPoint.getPointArr(point, point1), Color.BLACK);
        Line line = (Line)myLi.draw();

        point.setCordinates(200, 100);
        point1.setCordinates(150, 100);
        point2.setCordinates(200, 130);
        MyEllipse myEl = new MyEllipse(MyPoint.getPointArr(point, point1, point2), Color.PURPLE);
        Ellipse ellipse = (Ellipse)myEl.draw();

        point.setCordinates(400, 100);
        point1.setCordinates(400, 150);
        MyCircumference myCircle = new MyCircumference(MyPoint.getPointArr(point, point1, point2), Color.GREEN);
        Circle circle = (Circle)myCircle.draw();


        point.setCordinates(410, 200);
        point1.setCordinates(480, 200);
        point2.setCordinates(445, 300);
        MyTriangle myTriangle = new MyTriangle(MyPoint.getPointArr(point, point1, point2), Color.YELLOW);
        Polygon triangle = (Polygon)myTriangle.draw();

        drawPane.getChildren().add(rect);
        drawPane.getChildren().add(square);
        drawPane.getChildren().add(line);
        drawPane.getChildren().add(ellipse);
        drawPane.getChildren().add(circle);
        drawPane.getChildren().add(triangle);
    }
}