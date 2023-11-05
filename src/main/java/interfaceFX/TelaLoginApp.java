package com.example.trampodebd;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class TelaLoginApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override

    //define um titulo para minha aplicação
    public void start(Stage stage) {
        stage.setTitle("Login");

        Stage cadastroFuncionario = new Stage();

        CadastroFuncionario instanciaCadastroFuncionario =
                new CadastroFuncionario();

        //cria um caixa na vertical onde o 10 define o espaços entre os elementos
        VBox root = new VBox(10);

        //cria uma cena com todos os elementos onde a largura
        // e 300px e altura 200px
        Scene scene = new Scene(root, 300, 200);

        Label username = new Label("Login");
        TextField nomeUsuario = new TextField();

        Label senha = new Label("Senha");
        TextField password = new TextField();

        Button buttonLogin = new Button("Confirmar");

        Button buttonCadastraSe = new Button("Cadastra-se");
        buttonCadastraSe.setOnAction(e->instanciaCadastroFuncionario.start
        (cadastroFuncionario));



        root.getChildren().addAll(username,nomeUsuario, senha, password,
        buttonLogin,buttonCadastraSe);
        root.setAlignment(Pos.CENTER);

        root.setPadding(new Insets(10));
        stage.setScene(scene);
        stage.show();
    }

}
