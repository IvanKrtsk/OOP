package com.example.oop2lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class OOPApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OOPApplication.class.getResource("OOP.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 500);
        stage.setTitle("OOP2lab Krotsyuk Ivan") ;
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}