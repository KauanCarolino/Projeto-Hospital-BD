package dao;

import factory.ConnectionFactory;
import model.Enfermeiros;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EnfermeiroDao {
    public static void save(Enfermeiros enfermeiros) {


        String sql = "INSERT INTO enfermeiros(coren, nome, sexo, especialidade, telefone, dataNasc, uf) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criames uma PreparedStatement, para executar uma query
            pstm = conn.prepareStatement(sql);
            //Adicionar os valores que são esperados pela query
            pstm.setInt(1, enfermeiros.getCoren());
            pstm.setString(2, enfermeiros.getNome());
            pstm.setString(3, enfermeiros.getSexo());
            pstm.setString(4, enfermeiros.getEspecialidade());
            pstm.setString(5, enfermeiros.getTelefone());
            pstm.setString(6, enfermeiros.getDataNasc());
            pstm.setString(7, enfermeiros.getUf());
            //Executar a query
            pstm.execute();

            System.out.println("Enfermeiros salvos com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //Fechar as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void update(Enfermeiros enfermeiros) {

        String sql = "UPDATE enfermeiros SET nome = ?, sexo = ?, Especialidade = ?, telefone = ?, dataNasc = ?, uf = ? "
                + "WHERE coren = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //Criar conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criar a classe para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona valores para atualizar
            pstm.setString(1, enfermeiros.getNome());
            pstm.setString(2, enfermeiros.getSexo());
            pstm.setString(3, enfermeiros.getEspecialidade());
            pstm.setString(4, enfermeiros.getTelefone());
            pstm.setString(5, enfermeiros.getDataNasc());
            pstm.setString(6, enfermeiros.getUf());

            //Qual o ID do registro que deseja atualizar
            pstm.setInt(7, enfermeiros.getCoren());

            //Executando a query
            pstm.execute();
            System.out.println("Enfermeiros atualizados com sucesso!");

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(pstm != null) {
                    pstm.close();
                }

                if(conn != null) {
                    conn.close();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


}