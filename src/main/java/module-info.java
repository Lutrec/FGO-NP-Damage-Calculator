module com.example.damagecalculator {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.example.damagecalculator to javafx.fxml;
    exports com.example.damagecalculator;
}