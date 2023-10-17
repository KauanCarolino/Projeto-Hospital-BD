package aplicacao;

import dao.EnfermeiroDao;
import dao.PacientesDao;
import model.Enfermeiros;
import model.Pacientes;

import java.util.List;

public class MainEnfermeiro {
    public static void main(String[] args) {

        EnfermeiroDao enfermeirosDao = new EnfermeiroDao();
		List<Enfermeiros> pacientes = EnfermeiroDao.getEnfermeiros();

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

//        Deletar o contato pelo ID
//		enfermeirosDao.deleteByPK(121);

        //Visualização dos registros do banco de dados TODOS os registros
        for(Enfermeiros e : EnfermeiroDao.getEnfermeiros()) {
            System.out.println("Coren: "+e.getCoren()+" Enfermeiros: "+e.getNome());
        }
    }
}

