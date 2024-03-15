module com.example.oop1lab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop1lab to javafx.fxml;
    exports com.example.oop1lab;
}