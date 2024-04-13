module com.example.oop2lab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop2lab to javafx.fxml;
    exports com.example.oop2lab;
}