package com.example.trampodebd;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CadastroFuncionario extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage cadastroFuncionario){
        cadastroFuncionario.setTitle("Cadastro Funcionario");
        VBox root = new VBox(10);
        Scene scene = new Scene(root,300,470);


        Label COREN = new Label("Coren");
        TextField coren = new TextField();

        Label CRM = new Label("CRM");
        TextField crm = new TextField();

        //caixa nome
        Label name = new Label("Nome");
        TextField nome = new TextField();



        //caixa SEXO
        Label SEXO = new Label("Sexo");
        TextField sexo = new TextField();



        //caixa telefone
        Label TELEFONE = new Label("Telefone");
        TextField telefone = new TextField();




        //caixa UF
        Label UF  = new Label("UF");
        TextField uf = new TextField();

        Label DATANASCIMENTO = new Label("Data de nascimento");
        DatePicker dataNascimento = new DatePicker();

        Button botaoCadastrar = new Button("Cadastrar");

        root.getChildren().addAll(COREN,coren,CRM,crm,name,nome,SEXO,sexo,
        UF,uf,TELEFONE,telefone,DATANASCIMENTO);
        root.getChildren().add(dataNascimento);
        root.getChildren().add(botaoCadastrar);
        root.setAlignment(javafx.geometry.Pos.CENTER);

        root.setPadding(new Insets(10));

        cadastroFuncionario.setScene(scene);
        cadastroFuncionario.show();
    }
}
