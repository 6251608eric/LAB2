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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * This is scene 3
 */
public class Scene3 extends Application implements secondaryButtons {

    //implements the constructor and methods from CodeScene3
    public CodeScene3 codeScene3 = new CodeScene3();
    public static Scene scene;

    @Override
    public void back(Stage stage) {
        stage.setScene(HelloApplication.scene);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Path path = new Path();
        //Moving to the starting point
        MoveTo moveTo = new MoveTo(450.0f, 450.0f);
        //Instantiating the LineTo class
        LineTo lineTo1 = new LineTo(700.0f, 450.0f);
        LineTo lineTo2 = new LineTo(700.0f, 600.0f);
        LineTo lineTo3 = new LineTo(450.0f, 450.0f);
        //instantiating the CurveTo class
        CubicCurveTo cubicCurveTo = new CubicCurveTo();
        cubicCurveTo.setX(450.0f);
        cubicCurveTo.setY(600.0f);
        cubicCurveTo.setControlX1(575.0f);
        cubicCurveTo.setControlX2(575.0f);
        cubicCurveTo.setControlY1(500.0f);
        cubicCurveTo.setControlY2(700.0f);
        //Adding the path elements to Observable list of the Path class
        path.getElements().addAll(moveTo, lineTo1, lineTo2, cubicCurveTo, lineTo3);

        VBox vBox = new VBox();
        HBox hbox = new HBox(10);
        hbox.setSpacing(200);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(100);
        Button back = new Button("Back");
        Button code = new Button("View Code");
        hbox.getChildren().addAll(code, back);
        vBox.getChildren().addAll(path, hbox);
        hbox.setAlignment(Pos.CENTER);

        //implements the constructor and methods from CodeScene3
        code.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    codeScene3.setScene(scene);
                    codeScene3.setString("src/main/java/com/eric/part1/Scene3.java");
                    codeScene3.start(stage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //back button to go back to main scene and dialogue confirmation
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
