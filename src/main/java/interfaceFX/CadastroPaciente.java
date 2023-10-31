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
        TextField prontuario = new TextField();
        prontuario.setPromptText("Prontuario");

        //caixa nome
        TextField nome = new TextField();
        nome.setPromptText("Nome");


        //caixa SEXO
        TextField sexo = new TextField();
        sexo.setPromptText("Sexo");

       
        //caixa telefone
        TextField telefone = new TextField();
        telefone.setPromptText("Telefone");

        //caixa data de nascimento
        DatePicker dataNascimento = new DatePicker();
        dataNascimento.setPromptText("Data de Nascimento");

        //caixa UF
        TextField UF = new TextField();
        UF.setPromptText("UF");

        Button botaoCadastrar = new Button("Cadastrar");


        /*mostra as caixas com usuario, senha e o
        demais paramentros*/
        root.getChildren().addAll(prontuario,nome,sexo,
                telefone,dataNascimento,UF,botaoCadastrar);



        //faz com que as caixas sejam exibidas
        paciente.setScene(scene);
        paciente.show();
    }
}

