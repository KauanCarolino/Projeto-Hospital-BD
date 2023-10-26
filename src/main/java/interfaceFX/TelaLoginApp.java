package interfaceFX;

import dao.MedicoDao;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Medicos;

public class TelaLoginApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) {
        stage.setTitle("Tela de Login");
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 300, 200);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Nome de Usuário");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Senha");
        Button confirmButton = new Button("Confirmar");
        confirmButton.setOnAction(e -> {
            String username = usernameField.getText();
            String senha = passwordField.getText();

            // Verificar as credenciais no banco de dados
            Medicos medico = MedicoDao.getMedicoByCredentials(username, senha);

            if (medico != null) {
                exibirTelaBemVindo(username);
            } else {
                // Exibir mensagem de erro ou redirecionar para a tela de erro
                System.out.println("Nome de usuário ou senha inválidos.");
            }
        });

        root.getChildren().addAll(usernameField, passwordField, confirmButton);

        stage.setScene(scene);
        stage.show();
    }

    private void exibirTelaBemVindo(String username) {

        //cria a nova tela de boa vindas
        Stage stage = new Stage();

        //defini o titulo bem vindo
        stage.setTitle("Bem-Vindo");

        //cria a mensagem de boas vindas
        Label welcomeLabel = new Label("Olá, " + username + " seja bem-vindo!");

        //define a caixa de boas vindas
        StackPane layout = new StackPane(welcomeLabel);

        //cria a cena de boa vinda de largura de 300px e altura de 100px
        Scene scene = new Scene(layout, 300, 100);

        //exibe a mensagem de boa vindas
        stage.setScene(scene);
        stage.show();
    }
}