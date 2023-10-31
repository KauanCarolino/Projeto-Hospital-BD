package interfaceFX;

import dao.EnfermeiroDao;
import dao.MedicoDao;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Enfermeiros;
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
        usernameField.setPromptText("Coren ou Crm");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Senha");

        Button confirmButton = new Button("Logar-se");

        Button botaoCadastro = new Button("Cadastra-se");

        confirmButton.setOnAction(e -> {
            String username = usernameField.getText();
            String senha = passwordField.getText();

            // Verificar as credenciais no banco de dados
            Medicos medico = MedicoDao.getMedicoByCredentials(username, senha);
            Enfermeiros enfermeiro = EnfermeiroDao.getEnfermeiroByCredentials(username, senha);
            if (medico != null) {
                exibirTelaBemVindo(medico.getNome());
            } else if (enfermeiro != null) {
                exibirTelaBemVindo(enfermeiro.getNome());
            } else {
                // Exibir mensagem de erro ou redirecionar para a tela de erro
                System.out.println("Coren/Crm ou senha inválidos.");
            }
        });

        botaoCadastro.setOnAction(e->escolherFuncionario());
        //exibe as caixas de texto nomeUsuario, senha e os 2 botões
        root.getChildren().addAll(usernameField,passwordField,confirmButton,botaoCadastro);
        root.setAlignment(javafx.geometry.Pos.CENTER);

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

    public void escolherFuncionario(){

        VBox root = new VBox(10);
        Scene scene = new Scene(root, 300, 200);
        Stage enfermeiro = new Stage();
        Stage medico = new Stage();

        TelaCadastroEnfermeiro instanciaEnfermeiro = new TelaCadastroEnfermeiro();
        TelaCadastroMedico instanciamedico = new TelaCadastroMedico();

        Button botaoEnfermeiro = new Button("Enfermeiro");
        botaoEnfermeiro.setOnAction(e->instanciaEnfermeiro.start(enfermeiro));

        Button  botaoMedico = new Button("medico");
        botaoMedico.setOnAction(e->instanciamedico.start(medico));

        root.getChildren().addAll(botaoEnfermeiro,botaoMedico);
        root.setAlignment(javafx.geometry.Pos.CENTER);

        medico.setScene(scene);
        medico.show();

        enfermeiro.setScene(scene);
        enfermeiro.show();

    }
}