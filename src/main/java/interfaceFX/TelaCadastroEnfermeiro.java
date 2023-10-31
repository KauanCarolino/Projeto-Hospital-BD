package interfaceFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Enfermeiros;

import java.time.LocalDate;

import static dao.EnfermeiroDao.save;

public class TelaCadastroEnfermeiro extends Application {
    public static void main(String [] args) {
        launch(args);
    }

    public void start(Stage enfermeiro){
        // Título da minha tela
        enfermeiro.setTitle("Cadastro Enfermeiro");

        // Caixa vertical com todos os elementos
        VBox root = new VBox(10);

        // Cria uma cena com todos os elementos, onde a largura e 300px e altura 350px respectivamente
        Scene scene = new Scene(root, 300, 350);

        // Caixa nome coren
        TextField coren = new TextField();
        coren.setPromptText("Coren");

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

        Button botaoCadastrar = new Button("Cadastrar");
        botaoCadastrar.setOnAction(event -> {
            Enfermeiros enfermeiros = new Enfermeiros();
            enfermeiros.setCoren(Integer.parseInt(coren.getText()));
            enfermeiros.setNome(nome.getText());
            enfermeiros.setSexo(sexo.getText());
            enfermeiros.setSenha(senha.getText());
            enfermeiros.setEspecialidade(especialidade.getText());
            enfermeiros.setTelefone(telefone.getText());
            enfermeiros.setDataNasc(dataNascimento.getText());
            enfermeiros.setUf(UF.getText());

            save(enfermeiros); // Chama o método save para inserir o enfermeiro no banco de dados
        });

        // Adiciona os elementos à caixa
        root.getChildren().addAll(coren, nome, senha, sexo, especialidade,
                telefone, dataNascimento, UF, botaoCadastrar);

        // Exibe a tela
        enfermeiro.setScene(scene);
        enfermeiro.show();
    }
}
