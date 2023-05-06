package com.example.fgonpdamagecalculator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fgoNPDamageCalculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("FGO NP Damage Calculator");
        stage.setScene(scene);
        Image icon = new Image("C:\\JavaProject\\FGO NP Damage Calculator\\src\\main\\Icons\\app_icon.png");
        stage.getIcons().add(icon);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();

    }


}