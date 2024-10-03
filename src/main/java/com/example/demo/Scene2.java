package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

/**
 * This is scene 2
 * The shape was made by recreating it in Adobe Illustrator and then converting the shape as an SVGPath file, and extracting it
 * to this document.
 */
public class Scene2 extends Application implements secondaryButtons {
    public CodeScene1 codeScene1 = new CodeScene1();
    public static Scene scene;

    @Override
    public void back(Stage stage) {
        stage.setScene(HelloApplication.scene);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //creating the svg, extracting the SVG coords from adobe illustrator
        SVGPath svg = new SVGPath();
        svg.setFill(Color.TRANSPARENT);
        svg.setStroke(Color.BLACK);
        String string = "M241.58,184.14H57.94C-18.65,122.93-18.65,61.71,57.94.5h183.64c-86.29,66.07-86.29,127.28,0,183.64Z";
        svg.setContent(string);

        VBox vBox = new VBox();
        HBox hbox = new HBox(10);
        hbox.setSpacing(200);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(100);
        Button back = new Button("Back");
        Button code = new Button("View Code");
        hbox.getChildren().addAll(code, back);
        vBox.getChildren().addAll(svg, hbox);
        hbox.setAlignment(Pos.CENTER);

        //button handler to view the code, source code is taken from the CodeScene1 class,
        //uses a method form CodeScene1 to switch scenes
        code.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    codeScene1.setScene(scene);
                    codeScene1.setString("src/main/java/com/eric/part1/Scene2.java");
                    codeScene1.start(stage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //button handler to go back to the main scene with a confirmation dialogue
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ButtonType buttonType = new ButtonType("OK");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Are you sure you want to go back?");
                Optional<ButtonType> result = alert.showAndWait();


                if (result.get() == buttonType.OK) {

                    back(stage);
                }
            }
        });

        scene = new Scene(vBox, 800, 400);
        stage.setScene(scene);
        stage.show();
    }

}
