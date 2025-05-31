module com.example.inicodelab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.inicodelab to javafx.fxml;
    exports com.example.inicodelab;
}