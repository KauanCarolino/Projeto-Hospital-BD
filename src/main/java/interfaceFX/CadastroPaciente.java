package com.example.trampodebd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaCadastroPaciente extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage paciente) throws Exception {
        paciente.setTitle("cadastro paciente");
        VBox root= new VBox(10);

        /*cria uma cena com todos os elementos, onde a largura e 300px e
        altura 200px respctivamente*/
        Scene scene = new Scene(root, 300,350);

       //caixa nome prontuario
        Label PRONTUARIO = new Label("Prontuario");
        TextField prontuario = new TextField();


        //caixa nome
        Label name = new Label("Nome");
        TextField nome = new TextField();



        //caixa SEXO
        Label SEXO = new Label("Sexo");
        TextField sexo = new TextField();



        //caixa telefone
        Label TELEFONE = new Label("Telefone");
        TextField telefone = new TextField();


        //caixa data de nascimento


        //caixa UF
        Label UF  = new Label("UF");
        TextField uf = new TextField();

        Label DATANASCIMENTO = new Label("Data de nascimento");
        DatePicker dataNascimento = new DatePicker();

        Button botaoCadastrar = new Button("Cadastrar");

        /*mostra as caixas com usuario, senha e o
        demais paramentros*/
        root.getChildren().addAll(PRONTUARIO,prontuario,name,nome,SEXO,sexo,
        UF,uf,TELEFONE,telefone,DATANASCIMENTO);
        root.getChildren().add(dataNascimento);
        root.getChildren().add(botaoCadastrar);
        root.setAlignment(javafx.geometry.Pos.CENTER);

         //faz com que as caixas sejam exibidas
        paciente.setScene(scene);
        paciente.show();
    }
}

