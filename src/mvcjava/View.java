/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcjava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends Application {
    private Label label;
    private Button button;
    private Controller controller;

    @Override
    public void start(Stage primaryStage) {
        label = new Label();
        button = new Button("Haz Click Aquí");

        button.setOnAction(event -> controller.handleButtonClick());

        VBox root = new VBox(label, button);
        Scene scene = new Scene(root, 200, 100);

        primaryStage.setTitle("Ejemplo MVC ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void updateData(String data) {
        label.setText(data);
    }

    void setStage(Stage primaryStage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
