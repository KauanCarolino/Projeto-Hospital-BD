package aplicacao;

import dao.EnfermeiroDao;
import dao.MedicoDao;
import model.Medicos;
import dao.PacientesDao;
import model.Pacientes;

public class MainMedico {
    public static void main(String[] args) {

        MedicoDao medicoDao = new MedicoDao();
//		List<Pacientes> pacientes = pacientesDao.getPacientes();

//		Enfermeiros enfermeiros = new Enfermeiros();
//        enfermeiros.setCoren(121);
//		enfermeiros.setNome("Julio");
//		enfermeiros.setSexo("M");
//        enfermeiros.setEspecialidade("Pediatria");
//		enfermeiros.setTelefone("98888-8888");
//		enfermeiros.setDataNasc("1994-04-12");
//		enfermeiros.setUf("CE");
//		EnfermeiroDao.save(enfermeiros);

        //Atualizar o contato
//        Enfermeiros enfermeiros2 = new Enfermeiros();
//        enfermeiros2.setCoren(121);
//		enfermeiros2.setNome("Julio");
//		enfermeiros2.setSexo("M");
//        enfermeiros2.setEspecialidade("Legista");
//		enfermeiros2.setTelefone("98888-8888");
//		enfermeiros2.setDataNasc("1994-04-12");
//		enfermeiros2.setUf("CE");
//        enfermeiros2.setCoren(121);//Número da Chave primária
//        EnfermeiroDao.update(enfermeiros2);

        for(Medicos m : MedicoDao.getMedicos()) {
            System.out.println("CRM: "+m.getCrm()+" Medicos: "+m.getNome()+" Especialidade: "+m.getEspecialidade()); //crm, especialidade e o nome
        }

    }
}

