package interfaceFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Pacientes;
import dao.PacientesDao;

public class TelaCadastroPaciente extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Cadastro de Paciente");

        VBox root = new VBox(10);
        Scene scene = new Scene(root, 300, 350);

        TextField nome = new TextField();
        nome.setPromptText("Nome");

        TextField cpf = new TextField();
        cpf.setPromptText("CPF");

        TextField sexo = new TextField();
        sexo.setPromptText("Sexo");

        TextField telefone = new TextField();
        telefone.setPromptText("Telefone");

        TextField dataNascimento = new TextField();
        dataNascimento.setPromptText("Data de Nascimento");

        TextField endereco = new TextField();
        endereco.setPromptText("Endereço");

        TextField uf = new TextField();
        uf.setPromptText("UF");

        Button botaoCadastrar = new Button("Cadastrar");
        botaoCadastrar.setOnAction(event -> {
            Pacientes paciente = new Pacientes();
            paciente.setNome(nome.getText());
            paciente.setCpf(cpf.getText());
            paciente.setSexo(sexo.getText());
            paciente.setTelefone(telefone.getText());
            paciente.setDataNasc(dataNascimento.getText());
            paciente.setEndereco(endereco.getText());
            paciente.setUf(uf.getText());

            PacientesDao dao = new PacientesDao();
            dao.save(paciente); // Chama o método save para inserir o paciente no banco de dados
        });

        root.getChildren().addAll(nome, cpf, sexo, telefone, dataNascimento, endereco, uf, botaoCadastrar);
        root.setAlignment(javafx.geometry.Pos.CENTER);
        stage.setScene(scene);
        stage.show();
    }
}
