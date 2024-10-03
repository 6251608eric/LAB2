package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main Class where the primary menu scene and stage are set
 * @author Eric, Fadi, Daniel
 */
public class HelloApplication extends Application {

    public static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        Label lbl1 = new Label("Main Screen");
        lbl1.setFont(new Font("Arial", 20));
        HBox hbox = new HBox(10);
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(lbl1, hbox);
        hbox.setAlignment(Pos.CENTER);

        Button button = new Button("View SVG");
        Button button2 = new Button("View Path Shape");
        Button button3 = new Button("View Shear Transform");

        hbox.getChildren().addAll(button, button2, button3);

        scene = new Scene(vbox, 800, 400);
        stage.setTitle("Main Screen");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}