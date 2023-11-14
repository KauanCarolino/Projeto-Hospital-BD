package dao;

import factory.ConnectionFactory;
import model.Enfermeiros;
import model.Medicos;
import model.Pacientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnfermeiroDao {
    public static void save(Enfermeiros enfermeiros) {


        String sql = "INSERT INTO enfermeiros(coren, nome, sexo, senha, especialidade, telefone, dataNasc, uf) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

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
            pstm.setString(4, enfermeiros.getSenha());
            pstm.setString(5, enfermeiros.getEspecialidade());
            pstm.setString(6, enfermeiros.getTelefone());
            pstm.setString(7, enfermeiros.getDataNasc());
            pstm.setString(8, enfermeiros.getUf());
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

        String sql = "UPDATE enfermeiros SET nome = ?, sexo = ?, senha = ?, Especialidade = ?, telefone = ?, dataNasc = ?, uf = ? "
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
            pstm.setString(3, enfermeiros.getSenha());
            pstm.setString(4, enfermeiros.getEspecialidade());
            pstm.setString(5, enfermeiros.getTelefone());
            pstm.setString(6, enfermeiros.getDataNasc());
            pstm.setString(7, enfermeiros.getUf());

            //Qual o ID do registro que deseja atualizar
            pstm.setInt(8, enfermeiros.getCoren());

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

    public void deleteByPK(int coren) {

        String sql = "DELETE FROM enfermeiros WHERE coren = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, coren);

            pstm.execute();
            System.out.println("Usuario Removido com Sucesso");
        }catch(Exception e) {
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

    public static Enfermeiros getEnfermeiroByCredentials(String coren, String senha) {
        String sql = "SELECT * FROM enfermeiros WHERE coren = ? AND senha = ?";
        Enfermeiros enfermeiros = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(coren));
            pstm.setString(2, senha);
            rset = pstm.executeQuery();

            if (rset.next()) {
                enfermeiros = new Enfermeiros();
                enfermeiros.setCoren(rset.getInt("coren"));
                enfermeiros.setNome(rset.getString("nome"));
                enfermeiros.setSenha(rset.getString("senha"));
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

        return enfermeiros;
    }

    public static List<Enfermeiros> getEnfermeiros() {
        String sql = "SELECT * FROM enfermeiros";
        List<Enfermeiros> enfermeiros = new ArrayList<Enfermeiros>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Enfermeiros enfermeiro = new Enfermeiros();

                enfermeiro.setCoren(rset.getInt("Coren"));

                enfermeiro.setNome(rset.getString("nome"));

                enfermeiro.setSexo(rset.getString("sexo"));

                enfermeiro.setSenha(rset.getString("senha"));

                enfermeiro.setEspecialidade(rset.getString("Especialidade"));

                enfermeiro.setTelefone(rset.getString("telefone"));

                enfermeiro.setDataNasc(rset.getString("dataNasc"));

                enfermeiro.setUf(rset.getString("uf"));

                enfermeiros.add(enfermeiro);
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

        return enfermeiros;
    }

}