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
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import java.util.Optional;

/**
 * This is scene 4
 */
public class Scene4 extends Application implements secondaryButtons {

    // to access the source code and implement methods from CodeScene2
    public CodeScene2 codeScene2 = new CodeScene2();
    public static Scene scene;

    @Override
    public void back(Stage stage) {
        stage.setScene(HelloApplication.scene);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Rectangle rect = new Rectangle();

        //Adding coordinates to the Rectangle
        rect.setX(0);
        rect.setY(0);
        rect.setHeight(100);
        rect.setWidth(200);
        //Setting the fill color for the Rectangle
        rect.setFill(Color.LIGHTGRAY);

        rect.setStroke(Color.BLACK);


        Rectangle rect2 = new Rectangle();

        //Adding coordinates to the Rectangle
        rect2.setX(0);
        rect2.setY(0);
        rect2.setHeight(100);
        rect2.setWidth(200);
        //Setting the fill color for the Rectangle
        rect2.setFill(Color.TRANSPARENT);

        rect2.setStroke(Color.BLACK);

        //Creating shear transformation
        javafx.scene.transform.Shear shear = new javafx.scene.transform.Shear(0.5,0.5);

        //Adding the transformation to the rectangle
        rect2.getTransforms().add(shear);



        //Creating a Group object
        Group root = new Group(rect, rect2);
        //rect.setX(275);
        //rect.setY(100);
        //rect2.setX(300);
        //rect2.setY(-50);


        VBox vBox = new VBox();
        HBox hbox = new HBox(10);
        hbox.setSpacing(200);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(100);
        Button back = new Button("Back");
        Button code = new Button("View Code");
        hbox.getChildren().addAll(code, back);
        vBox.getChildren().addAll(root, hbox);
        hbox.setAlignment(Pos.CENTER);

        //takes the string from CodeScene2 and puts into new scene
        code.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    codeScene2.setScene(scene);
                    codeScene2.setString("src/main/java/com/eric/part1/Scene4.java");
                    codeScene2.start(stage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // back button and confirmation dialogue box
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
