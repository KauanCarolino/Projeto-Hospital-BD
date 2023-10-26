package aplicacao;

import dao.EnfermeiroDao;
import dao.MedicoDao;
import model.Medicos;
import dao.PacientesDao;
import model.Pacientes;

import java.util.List;

public class MainMedico {
    public static void main(String[] args) {

        MedicoDao medicoDao = new MedicoDao();
		List<Medicos> medico = medicoDao.getMedicos();

//		Medicos medicos = new Medicos();
//        medicos.setCrm(121);
//		medicos.setNome("Julio");
//		medicos.setSexo("M");
//        medicos.setEspecialidade("Pediatria");
//		medicos.setTelefone("98888-8888");
//		medicos.setDataNasc("1994-04-12");
//		medicos.setUf("CE");
//		MedicoDao.save(medicos);

        //Atualizar o contato
        Medicos medicos2 = new Medicos();
        medicos2.setCrm(121);
		medicos2.setNome("Julio");
		medicos2.setSexo("M");
        medicos2.setSenha("1234");
        medicos2.setEspecialidade("Pediatria");
		medicos2.setTelefone("98888-8888");
		medicos2.setDataNasc("1994-04-12");
		medicos2.setUf("CE");
        MedicoDao.update(medicos2);

        for(Medicos m : MedicoDao.getMedicos()) {
            System.out.println("CRM: "+m.getCrm()+" Medicos: "+m.getNome()+" Especialidade: "+m.getEspecialidade()); //crm, especialidade e o nome
        }

    }
}
