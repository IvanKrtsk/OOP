package com.example.oop2lab;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import myPoint.MyPoint;
import myShapes.MyShape;
import myShapes.ShapeData;
import myShapes.myAbstractFactory.myClasses.*;
import myShapes.myAbstractFactory.myInterfaces.ShapeFabric;
import com.google.gson.Gson;


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
    @FXML
    private Button deserializeButton;
    @FXML
    private Button serializeButton;
    @FXML
    private RadioButton binRadioButton;
    @FXML
    private RadioButton jsonRadioButton;
    @FXML
    private ToggleGroup serGroup;
    @FXML
    private ColorPicker colorMenu;


    private double startX, startY, endX, endY;
    private final MyLineAbstractFactory lineFactory = new MyLineAbstractFactory();
    private final MyEllipseAbstractFactory ellipseFactory = new MyEllipseAbstractFactory();
    private final MyCircumferenceAbstractFactory circumferenceFactory = new MyCircumferenceAbstractFactory();
    private final MyRectangleAbstractFactory rectangleFactory = new MyRectangleAbstractFactory();
    private final MySquareAbstractFactory squareFactory = new MySquareAbstractFactory();
    private final MyTriangleAbstractFactory triangleFactory = new MyTriangleAbstractFactory();
    private ShapeFabric fabricInterface;
    private RadioButton selectedRadioButton, serSelectedRadioButton;
    private Boolean isActivated = false, isShiftPressed = false;
    public Shape javaSelectedShape;
    public MyShape mySelectedShape;
    private List<MyShape> shapeList = new LinkedList<>();

    private void setNewCordinates(){
        double deltaX = endX - startX, deltaY = endY - startY;
        mySelectedShape.updateCordinates(MyPoint.getPointArr(new MyPoint(mySelectedShape.cordinates.get(0).x + deltaX, mySelectedShape.cordinates.get(0).y + deltaY), new MyPoint(mySelectedShape.cordinates.get(1).x + deltaX, mySelectedShape.cordinates.get(1).y + deltaY)));
    }
    private MyShape checkShape(){
        for (int i = 0; i < shapeList.size(); i++) {
            javaSelectedShape = shapeList.get(i).javaShape;
            if (javaSelectedShape.contains(startX - javaSelectedShape.getLayoutX(), startY - javaSelectedShape.getLayoutY())) {
                isActivated = true;
                return(shapeList.get(i));
            }
        }
         return(null);
    }

    @FXML
    void initialize() {
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
            mySelectedShape = checkShape();
        });

        drawPane.setOnMouseReleased(event -> {
            endX = event.getX();
            if(endX < 0)
                endX = 0;
            endY = event.getY();
            if(isShiftPressed && isActivated && (mySelectedShape != null)) {
                setNewCordinates();
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

                    drawPane.getChildren().add(shape.javaShape);
                }
            }
        });

        radioGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
                selectedRadioButton = (RadioButton) newValue;
        });

        serGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
                serSelectedRadioButton = (RadioButton) newValue;
        });

        mainPane.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case SHIFT:
                    isShiftPressed = true;
                    break;
                case DELETE:
                    if(isActivated && mySelectedShape != null) {
                        shapeList.remove(mySelectedShape);
                        drawPane.getChildren().remove(mySelectedShape.javaShape);
                        mySelectedShape = null;
                        isActivated = false;
                    }
                    break;
            }
        });

        mainPane.setOnKeyReleased((KeyEvent event) -> {
            switch (event.getCode()) {
                case SHIFT:
                    isShiftPressed = false;
            }
        });

        serializeButton.setOnMouseClicked(mouseEvent -> {
            if(serSelectedRadioButton != null) {
                if(serSelectedRadioButton.getText().contains("Bin")) {
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("shapes.dat"))) {
                        for (MyShape shape : shapeList) {
                            oos.writeObject(shape);
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }else {
                    Gson gson = new GsonBuilder()
                            .excludeFieldsWithoutExposeAnnotation()
                            .create();
                    try (FileWriter writer = new FileWriter("shapes.json")) {
                            gson.toJson(shapeList, writer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        deserializeButton.setOnMouseClicked(mouseEvent -> {
            if(serSelectedRadioButton != null) {
                if (serSelectedRadioButton.getText().contains("Bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("shapes.dat"))) {
                        while (true) {
                            try {
                                MyShape shape = (MyShape) ois.readObject();
                                MyShape myShape;
                                fabricInterface = (ShapeFabric) shapeMap.get(shape.className);
                                myShape = fabricInterface.createShape(shape.cordinates, shape.color);
                                myShape.doDrawing();
                                shapeList.add(myShape);
                                drawPane.getChildren().add(myShape.javaShape);
                            } catch (EOFException e) {
                                break;
                            }
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        System.err.println("Ошибка при десериализации: " + ex.getMessage());
                    }
                }else{
                    Gson gson = new GsonBuilder()
                            .excludeFieldsWithoutExposeAnnotation()
                            .create();
                    try (JsonReader reader = new JsonReader(new FileReader("shapes.json"))) {
                        Type shapeListType = new TypeToken<ArrayList<ShapeData>>(){}.getType();
                        ArrayList<ShapeData> tmpShapeList = gson.fromJson(reader, shapeListType);
                        for (ShapeData shapeData: tmpShapeList) {
                            fabricInterface = (ShapeFabric) shapeMap.get(shapeData.className);
                            MyShape myShape = fabricInterface.createShape(shapeData.cordinates, Color.web(shapeData.strColor));
                            myShape.doDrawing();
                            shapeList.add(myShape);
                            drawPane.getChildren().add(myShape.javaShape);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }
}
