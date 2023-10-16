package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Pacientes;

public class PacientesDao {

	/*
	 *CRUD
	 *C: CREATE (CRIAÇÃO)
	 *R: READ (LEITURA)
	 *U: UPDATE (aATUALIZAÇÃO)
	 *D: DELETE (APAGAR)
	 */

	public void save(Pacientes pacientes) {


		String sql = "INSERT INTO pacientes(nome, cpf, sexo, telefone, dataNasc, endereco, uf) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			//Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();

			//Criames uma PreparedStatement, para executar uma query
			pstm =  conn.prepareStatement(sql);
			//Adicionar os valores que são esperados pela query
			pstm.setString(1, pacientes.getNome());
			pstm.setString(2, pacientes.getCpf());
			pstm.setString(3, pacientes.getSexo());
			pstm.setString(4, pacientes.getTelefone());
			pstm.setString(5, pacientes.getDataNasc());
			pstm.setString(6, pacientes.getEndereco());
			pstm.setString(7, pacientes.getUf());
			//Executar a query
			pstm.execute();

			System.out.println("Pacientes salvo com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {

			//Fechar as conexões
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

	public void update(Pacientes paciente) {

		String sql = "UPDATE pacientes SET nome = ?, cpf = ?, sexo = ?, telefone = ?, dataNasc = ?, endereco = ?, uf = ? "
				+ "WHERE prontuario = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			//Criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();

			//Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);

			//Adiciona valores para atualizar
			pstm.setString(1, paciente.getNome());
			pstm.setString(2, paciente.getCpf());
			pstm.setString(3, paciente.getSexo());
			pstm.setString(4, paciente.getTelefone());
			pstm.setString(5, paciente.getDataNasc());
			pstm.setString(6, paciente.getEndereco());
			pstm.setString(7, paciente.getUf());

			//Qual o ID do registro que deseja atualizar
			pstm.setInt(8, paciente.getProntuario());

			//Executando a query
			pstm.execute();
			System.out.println("Pacientes atualizado com sucesso!");
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

	public void deleteByPK(int prontuario) {

		String sql = "DELETE FROM pacientes WHERE prontuario = ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, prontuario);
            
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

    public static List<Pacientes> getPacientes() {
        String sql = "SELECT * FROM pacientes";
        List<Pacientes> pacientes = new ArrayList<Pacientes>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            
            pstm = conn.prepareStatement(sql);
            
            rset = pstm.executeQuery();

            while (rset.next()) {
                Pacientes paciente = new Pacientes();
                
                //Recupera o id
                paciente.setProntuario(rset.getInt("Prontuario"));
                
                //Recupera o nome
                paciente.setNome(rset.getString("nome"));
                
              //Recupera a idade
                paciente.setCpf(rset.getString("cpf"));

				paciente.setSexo(rset.getString("sexo"));

				paciente.setTelefone(rset.getString("telefone"));

				paciente.setDataNasc(rset.getString("dataNasc"));

				paciente.setEndereco(rset.getString("endereco"));

				paciente.setUf(rset.getString("uf"));

				pacientes.add(paciente);
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
        
        return pacientes;
    }
}