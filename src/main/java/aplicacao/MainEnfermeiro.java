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
//        enfermeiros.setCoren(222);
//		enfermeiros.setNome("Maria");
//		enfermeiros.setSexo("F");
//        enfermeiros.setSenha("1111");
//        enfermeiros.setEspecialidade("Pediatria");
//		enfermeiros.setTelefone("91111-1111");
//		enfermeiros.setDataNasc("1984-01-08");
//		enfermeiros.setUf("CE");
//		EnfermeiroDao.save(enfermeiros);

        //Atualizar o contato
        Enfermeiros enfermeiros2 = new Enfermeiros();
        enfermeiros2.setCoren(222);
        enfermeiros2.setNome("Maria");
        enfermeiros2.setSexo("F");
        enfermeiros2.setSenha("1111");
        enfermeiros2.setEspecialidade("Pediatria");
        enfermeiros2.setTelefone("91111-1111");
        enfermeiros2.setDataNasc("1984-01-08");
        enfermeiros2.setUf("CE");
        EnfermeiroDao.update(enfermeiros2);

//        Deletar o contato pelo ID
//		enfermeirosDao.deleteByPK(121);

        //Visualização dos registros do banco de dados TODOS os registros
        for(Enfermeiros e : EnfermeiroDao.getEnfermeiros()) {
            System.out.println("Coren: "+e.getCoren()+" Enfermeiros(a): "+e.getNome());
        }
    }
}

