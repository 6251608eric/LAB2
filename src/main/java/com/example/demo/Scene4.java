package com.eric.part1;

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

    public CodeScene3 codeScene3 = new CodeScene3();
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


        scene = new Scene(vBox, 800, 400);
        stage.setScene(scene);
        stage.show();
    }
}