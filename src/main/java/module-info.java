module com.example.damagecalculator {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.example.fgonpdamagecalculator to javafx.fxml;
    exports com.example.fgonpdamagecalculator;
}