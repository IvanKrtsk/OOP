package com.example.oop2lab;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.myAbstractFactory.myClasses.*;
import myShapes.myAbstractFactory.myInterfaces.ShapeFabric;

public class HelloController {

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
    private RadioButton ellipseButton;

    private double startX, startY, endX, endY;
    private MyLineAbstractFactory lineFactory = new MyLineAbstractFactory();
    private MyEllipseAbstractFactory ellipseFactory = new MyEllipseAbstractFactory();
    private MyCircumferenceAbstractFactory circumferenceFactory = new MyCircumferenceAbstractFactory();
    private MyRectangleAbstractFactory rectangleFactory = new MyRectangleAbstractFactory();
    private MySquareAbstractFactory squareFactory = new MySquareAbstractFactory();
    private MyTriangleAbstractFactory triangleFactory = new MyTriangleAbstractFactory();
    private ShapeFabric fabricInterface;
    private RadioButton selectedRadioButton;

    @FXML
    void initialize() {
        List<MyShape> shapeList = new LinkedList<>();
        MyPoint point = new MyPoint();
        MyPoint point1 = new MyPoint();

        Map<String, Object> shapeMap = new HashMap<>();
        shapeMap.put("Линия", lineFactory);
        shapeMap.put("Квадрат", squareFactory);
        shapeMap.put("Прямоугольник", rectangleFactory);
        shapeMap.put("Круг", circumferenceFactory);
        shapeMap.put("Треугольник", triangleFactory);
        shapeMap.put("Эллипс", ellipseFactory);

        drawPane.setOnMousePressed(event -> {
            startX = event.getX();
            startY = event.getY();
        });

        drawPane.setOnMouseReleased(event -> {
            endX = event.getX();
            if(endX < 0)
                endX = 0;
            endY = event.getY();
            if(selectedRadioButton != null) {
                point.setCordinates(startX, startY);
                point1.setCordinates(endX, endY);
                fabricInterface = (ShapeFabric) shapeMap.get(selectedRadioButton.getText());
                MyShape shape = fabricInterface.createShape(MyPoint.getPointArr(point, point1), Color.color(Math.random(), Math.random(), Math.random()));
                shapeList.add(shape);
                drawPane.getChildren().add(shape.doDrawing());
            }
        });

        radioGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
                selectedRadioButton = (RadioButton) newValue;
        });
    }
}