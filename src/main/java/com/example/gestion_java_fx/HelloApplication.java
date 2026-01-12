package com.example.gestion_java_fx;

import com.example.gestion_java_fx.repository.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 440);
        stage.setTitle("Application de Gestion d'Assurance");
        stage.setScene(scene);
        stage.show();

        Database database = new Database();
        database.getConnection();
    }
}
