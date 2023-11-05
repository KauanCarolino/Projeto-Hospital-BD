package com.example.trampodebd;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

    public class TelaPrincipal extends Application {
        public static void main(String[] args) {
            launch(args);
        }

        public void start(Stage stage) throws Exception {
            stage.setTitle("Tela principal");

            VBox root = new VBox();
            Scene scene = new Scene(root, 300, 200);
            Label pesquisar = new Label("pesquisar: ");
            TextField textField = new TextField();
            root.setSpacing(10);


            Button botaoPesquisar = new Button("pesquisar");

            Button botaoNovoPct = new Button("novo paciente");
            root.setAlignment(javafx.geometry.Pos.CENTER);

            root.getChildren().addAll(pesquisar, textField, botaoPesquisar, botaoNovoPct);

            stage.setScene(scene);
            stage.show();

        }
        public void acaoDoBotao(){
            HBox root = new HBox();
            Scene scene = new Scene(root,300,200);
            Stage paciente = new Stage();

            TelaCadastroPaciente instanciaTelaCadastroPaciente =
                    new TelaCadastroPaciente();

            Button botaoPesquisar = new Button();

            Button botaoNovoPaciente = new Button();
            botaoNovoPaciente.setOnAction(e-> {
                try {
                    instanciaTelaCadastroPaciente.start
                            (paciente);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
            root.getChildren().addAll(botaoPesquisar,botaoNovoPaciente);
        }
    }