package com.example.oop2lab;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import myPatterns.myAbstractFactory.myClasses.*;
import myPoint.MyPoint;
import myShapes.MyShape;
import mySerializator.SerializeShapeData;
import myPatterns.myAbstractFactory.myInterfaces.ShapeFabric;
import com.google.gson.Gson;


public class OOPController {
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
    @FXML
    private ColorPicker strokeColorMenu;
    @FXML
    private Slider strokeSlider;


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
    private List<SerializeShapeData> serializeShapeList = new LinkedList<>();
    private void convertShapesToSerialize(){
        serializeShapeList.clear();
        for (MyShape shapeToSerialize: shapeList) {
            serializeShapeList.add(new SerializeShapeData(shapeToSerialize));
        }
    }
    public void doBinDeserialize(Map<String, Object> shapeMap) {
        List<SerializeShapeData> deserializeList = new LinkedList<>();
        try {
            FileInputStream fileIn = new FileInputStream("shapes.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializeList = (List<SerializeShapeData>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        for (SerializeShapeData shape: deserializeList) {
            fabricInterface = (ShapeFabric) shapeMap.get(shape.className);
            MyShape myShape = fabricInterface.createShape(shape.cordinates, Color.web(shape.strFillColor), Color.web(shape.strStrokeColor), strokeSlider.getValue());
            myShape.doDrawing();
            shapeList.add(myShape);
            drawPane.getChildren().add(myShape.javaShape);
        }
    }
    public void doJsonDeserialize(Map<String, Object> shapeMap){
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        try (JsonReader reader = new JsonReader(new FileReader("shapes.json"))) {
            Type shapeListType = new TypeToken<ArrayList<SerializeShapeData>>(){}.getType();
            ArrayList<SerializeShapeData> tmpShapeList = gson.fromJson(reader, shapeListType);
            for (SerializeShapeData shapeData: tmpShapeList) {
                fabricInterface = (ShapeFabric) shapeMap.get(shapeData.className);
                MyShape myShape = fabricInterface.createShape(shapeData.cordinates, Color.web(shapeData.strFillColor), Color.web(shapeData.strStrokeColor), strokeSlider.getValue());
                myShape.doDrawing();
                shapeList.add(myShape);
                drawPane.getChildren().add(myShape.javaShape);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setNewCordinates(){
        double deltaX = endX - startX, deltaY = endY - startY;
        mySelectedShape.updateCordinates(MyPoint.getPointArr(new MyPoint(mySelectedShape.cordinates.get(0).x + deltaX, mySelectedShape.cordinates.get(0).y + deltaY), new MyPoint(mySelectedShape.cordinates.get(1).x + deltaX, mySelectedShape.cordinates.get(1).y + deltaY)));
    }
    private void selectShape(){
        clearJavaSelectedShape();
        for (int i = 0; i < shapeList.size(); i++) {
            javaSelectedShape = shapeList.get(i).javaShape;
            if (javaSelectedShape.contains(startX - javaSelectedShape.getLayoutX(), startY - javaSelectedShape.getLayoutY())) {
                isActivated = true;
                mySelectedShape = shapeList.get(i);
                javaSelectedShape.getStrokeDashArray().addAll(25d, 10d);
                colorMenu.setValue(mySelectedShape.fillColor);
                strokeColorMenu.setValue(mySelectedShape.strokeColor);
                strokeSlider.setValue(mySelectedShape.strokeWidth);
            }else
                clearJavaSelectedShape();
        }
    }
    private void clearJavaSelectedShape(){
        if(javaSelectedShape != null){
            javaSelectedShape.getStrokeDashArray().clear();
            javaSelectedShape = null;
        }
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

        colorMenu.setValue(Color.RED);
        strokeColorMenu.setValue(Color.BLACK);
        strokeSlider.setValue(5);

        drawPane.setOnMousePressed(event -> {
            startX = event.getX();
            startY = event.getY();
            selectShape();
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
                    MyShape shape = fabricInterface.createShape(MyPoint.getPointArr(point, point1), colorMenu.getValue(), strokeColorMenu.getValue(), strokeSlider.getValue());
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
                case ESCAPE:
                    clearJavaSelectedShape();
            }
        });

        mainPane.setOnKeyReleased((KeyEvent event) -> {
            switch (event.getCode()) {
                case SHIFT:
                    isShiftPressed = false;
            }
        });

        colorMenu.setOnAction(event -> {
            if(isActivated && mySelectedShape != null){
                mySelectedShape.updateColor(colorMenu.getValue());
            }
        });

        strokeColorMenu.setOnAction(event -> {
            if(isActivated && mySelectedShape != null){
                mySelectedShape.updateStrokeColor(strokeColorMenu.getValue());
            }
        });

        strokeSlider.valueChangingProperty().addListener((obs, wasChanging, isNowChanging) ->{
            if (!isNowChanging) {
                if(isActivated && mySelectedShape != null){
                    mySelectedShape.updateStrokeWidth(strokeSlider.getValue());
                }
            }
        });

        serializeButton.setOnMouseClicked(mouseEvent -> {
            if(serSelectedRadioButton != null) {
                if(serSelectedRadioButton.getText().contains("Bin")) {
                    convertShapesToSerialize();
                    FileOutputStream fileOut = null;
                    try {
                        fileOut = new FileOutputStream("shapes.dat");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(serializeShapeList);
                        out.close();
                        fileOut.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    Gson gson = new GsonBuilder()
                            .excludeFieldsWithoutExposeAnnotation()
                            .create();
                    try (FileWriter writer = new FileWriter("shapes.json")) {
                        convertShapesToSerialize();
                        gson.toJson(serializeShapeList, writer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        deserializeButton.setOnMouseClicked(mouseEvent -> {
            if(serSelectedRadioButton != null) {
                if (serSelectedRadioButton.getText().contains("Bin")) {
                    doBinDeserialize(shapeMap);
                }else{
                    doJsonDeserialize(shapeMap);
                }
            }
        });
    }
}