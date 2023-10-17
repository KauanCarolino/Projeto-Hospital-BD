package aplicacao;


import dao.PacientesDao;
import model.Pacientes;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		PacientesDao pacientesDao = new PacientesDao();
//		List<Pacientes> pacientes = pacientesDao.getPacientes();

//		Pacientes paciente = new Pacientes();
//		paciente.setNome("Kauan");
//		paciente.setCpf("12345678900");
//		paciente.setSexo("M");
//		paciente.setTelefone("91234-5678");
//		paciente.setDataNasc("2004-08-24");
//		paciente.setEndereco("Rua das Pedras");
//		paciente.setUf("CE");
//		pacientesDao.save(paciente);
		
			
		//Atualizar o contato 
//		Pacientes paciente2 = new Pacientes();
//		paciente2.setNome("Kauan");
//		paciente2.setCpf("12345678900");
//		paciente2.setSexo("M");
//		paciente2.setTelefone("99999-9991");
//		paciente2.setDataNasc("2004-08-24");
//		paciente2.setEndereco("Rua das Pedras");
//		paciente2.setUf("CE");
//		paciente2.setProntuario(1);//Número da Chave primária
//		pacientesDao.update(paciente2);


		//Deletar o contato pelo ID
//		pacientesDao.deleteByPK(1);

		//Visualização dos registros do banco de dados TODOS os registros
		for(Pacientes p : PacientesDao.getPacientes()) {
			System.out.println("Prontuario: "+p.getProntuario()+" Pacientes: "+p.getNome());
		}

	}

}
