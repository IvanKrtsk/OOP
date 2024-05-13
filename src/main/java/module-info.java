module com.example.oop2lab {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.oop2lab to javafx.fxml;
    exports com.example.oop2lab;
    exports myShapes to com.google.gson;
    exports myPoint to com.google.gson;
}