package com.example.oop2lab;

import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.myAbstractFactory.myClasses.*;
import myShapes.myAbstractFactory.myInterfaces.ShapeFabric;

public class HelloController {
    @FXML
    private Pane mainPane;
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
    private Boolean isActivated = false, isShiftPressed = false;
    public Shape javaSelectedShape;
    public MyShape mySelectedShape;

/*    private ArrayList<MyPoint> getCordinates(){
        if(mySelectedShape instanceof MyLine)
    }*/

    @FXML
    void initialize() {
        System.out.println(drawPane.getLayoutX());
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
            System.out.println("X: " + startX + "; Y: " + startY);

            if(isShiftPressed) {
                for (int i = 0; i < shapeList.size(); i++) {
                    javaSelectedShape = shapeList.get(i).javaShape;
                    if (javaSelectedShape.contains(startX, startY)) {
                        mySelectedShape = shapeList.get(i);
                        System.out.println(javaSelectedShape + "is selected");
                        isActivated = true;
                        break;
                    }
                }
            }
        });

        drawPane.setOnMouseReleased(event -> {
            endX = event.getX();
            if(endX < 0)
                endX = 0;
            endY = event.getY();
            if(isShiftPressed && isActivated) {
                // доделать геттеры и сеттеры на центр фигуры и прописать логику перемещения для javaselectedshape и myselectedshape
                javaSelectedShape.relocate(endX, endY);
                System.out.println("JavaSelectedShape: x=" + javaSelectedShape.getLayoutX() + " y=" + javaSelectedShape.getLayoutY());
                isActivated = false;
            }else{
                if (selectedRadioButton != null) {
                    point.setCordinates(startX, startY);
                    point1.setCordinates(endX, endY);
                    fabricInterface = (ShapeFabric) shapeMap.get(selectedRadioButton.getText());
                    MyShape shape = fabricInterface.createShape(MyPoint.getPointArr(point, point1), Color.color(Math.random(), Math.random(), Math.random()));
                    shape.doDrawing();
                    shapeList.add(shape);

//                напомнить про то, что пробовали у Object, но метод не статический, поэтому не было, а у экземпляра есть getClass()
//                System.out.println(shape.getClass());

                    System.out.println(shape.javaShape);
                    drawPane.getChildren().add(shape.javaShape);
                }
            }
        });

        radioGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
                selectedRadioButton = (RadioButton) newValue;
        });

        drawPane.setOnMouseClicked(event -> {

        });

        mainPane.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case SHIFT:
                    isShiftPressed = true;
            }
        });

        mainPane.setOnKeyReleased((KeyEvent event) -> {
            switch (event.getCode()) {
                case SHIFT:
                    isShiftPressed = false;
            }
        });
    }
}