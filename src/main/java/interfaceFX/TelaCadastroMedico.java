package interfaceFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Medicos;

import static dao.MedicoDao.save;

public class TelaCadastroMedico extends Application {
    public static void main(String[] args) {
        launch (args);
    }

    @Override
    public void start(Stage medico){
        medico.setTitle("cadastro medico");

        VBox root  = new VBox(10);
        Scene scene = new Scene(root, 300,350);

        TextField crm = new TextField();
        crm.setPromptText("CRM");

        // Caixa nome
        TextField nome = new TextField();
        nome.setPromptText("Nome");

        // Caixa nome senha
        PasswordField senha = new PasswordField();
        senha.setPromptText("Senha");

        // Caixa SEXO
        TextField sexo = new TextField();
        sexo.setPromptText("Sexo");

        // Caixa especialidade
        TextField especialidade = new TextField();
        especialidade.setPromptText("Especialidade");

        // Caixa telefone
        TextField telefone = new TextField();
        telefone.setPromptText("Telefone");

        // Caixa data de nascimento
        TextField dataNascimento = new TextField();
        dataNascimento.setPromptText("Data de Nascimento");

        // Caixa UF
        TextField UF = new TextField();
        UF.setPromptText("UF");

        Button botaoCadastrar = new Button("cadastrar");
        botaoCadastrar.setOnAction(event -> {
            Medicos medicos = new Medicos();
            medicos.setCrm(Integer.parseInt(crm.getText()));
            medicos.setNome(nome.getText());
            medicos.setSexo(sexo.getText());
            medicos.setSenha(senha.getText());
            medicos.setEspecialidade(especialidade.getText());
            medicos.setTelefone(telefone.getText());
            medicos.setDataNasc(dataNascimento.getText());
            medicos.setUf(UF.getText());

            save(medicos); // Chama o método save para inserir o Medicos no banco de dados
        });

        root.getChildren().addAll(crm,nome,sexo,senha,especialidade,telefone, dataNascimento, UF);
        root.getChildren().add(botaoCadastrar);
        root.setAlignment(javafx.geometry.Pos.CENTER);
        medico.setScene(scene);
        medico.show();
    }
}