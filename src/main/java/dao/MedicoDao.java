package dao;

import factory.ConnectionFactory;
import model.Medicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicoDao {
    public static void save(Medicos medicos) {


        String sql = "INSERT INTO medicos(crm, nome, sexo, senha, especialidade, telefone, dataNasc, uf) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criames uma PreparedStatement, para executar uma query
            pstm = conn.prepareStatement(sql);
            //Adicionar os valores que são esperados pela query
            pstm.setInt(1, medicos.getCrm());
            pstm.setString(2, medicos.getNome());
            pstm.setString(3, medicos.getSexo());
            pstm.setString(4, medicos.getSenha());
            pstm.setString(5, medicos.getEspecialidade());
            pstm.setString(6, medicos.getTelefone());
            pstm.setString(7, medicos.getDataNasc());
            pstm.setString(8, medicos.getUf());
            //Executar a query
            pstm.execute();

            System.out.println("Medicos salvos com sucesso!");
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


    public static void update(Medicos medicos) {

        String sql = "UPDATE medicos SET nome = ?, sexo = ?, senha = ?, Especialidade = ?, telefone = ?, dataNasc = ?, uf = ? "
                + "WHERE crm = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //Criar conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criar a classe para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona valores para atualizar
            pstm.setString(1, medicos.getNome());
            pstm.setString(2, medicos.getSexo());
            pstm.setString(3, medicos.getSenha());
            pstm.setString(4, medicos.getEspecialidade());
            pstm.setString(5, medicos.getTelefone());
            pstm.setString(6, medicos.getDataNasc());
            pstm.setString(7, medicos.getUf());

            //Qual o ID do registro que deseja atualizar
            pstm.setInt(8, medicos.getCrm());

            //Executando a query
            pstm.execute();
            System.out.println("Medicos atualizados com sucesso!");

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

    public static Medicos getMedicoByCredentials(String crm, String senha) {
        String sql = "SELECT * FROM medicos WHERE crm = ? AND senha = ?";
        Medicos medico = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(crm));
            pstm.setString(2, senha);
            rset = pstm.executeQuery();

            if (rset.next()) {
                medico = new Medicos();
                medico.setCrm(rset.getInt("crm"));
                medico.setNome(rset.getString("nome"));
                medico.setSenha(rset.getString("senha"));
                // Outros campos
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

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

        return medico;
    }

    public static List<Medicos> getMedicos() {
        String sql = "SELECT * FROM medicos";
        List<Medicos> medicos = new ArrayList<Medicos>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Medicos medico = new Medicos();

                //Recupera o id
                medico.setCrm(rset.getInt("crm"));

                //Recupera o nome
                medico.setNome(rset.getString("nome"));

                medico.setSenha(rset.getString("senha"));

                medico.setSexo(rset.getString("sexo"));

                medico.setTelefone(rset.getString("telefone"));

                medico.setDataNasc(rset.getString("dataNasc"));

                medico.setUf(rset.getString("uf"));

                //medicos.add(medicos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

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

        return medicos;
    }
}