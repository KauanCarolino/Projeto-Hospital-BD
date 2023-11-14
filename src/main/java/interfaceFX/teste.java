package com.example.trampodebd;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class teste extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage){
        stage.setTitle("teste");
        HBox root = new HBox(10);
        Scene scene = new Scene(root,300,250);


        TextField nomeUsuario = new TextField();
        nomeUsuario.setPromptText("Nome de Usuário");

        root.getChildren().addAll(nomeUsuario);
        root.setAlignment(javafx.geometry.Pos.CENTER);



        stage.setScene(scene);
        stage.show();

    }


}
