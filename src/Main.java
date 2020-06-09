import javax.swing.JOptionPane;

import model.Aluno;
import model.Data;
import model.Faxineira;
import model.Professor;
import model.Secretaria;
import util.Mensagem;
import view.MenuView;
import controller.AlunoController;
import controller.FaxineiraController;
import controller.ProfessorController;
import controller.SecretariaController;

public class Main {// inicio da classe

	public void testaGravaProfessor() {// inicio do metodo
		Professor professor = new Professor();

		professor.setCodigo(1);
		professor.setNome("João");
		professor.setCpf("123.123.123.12");
		professor.setRg("12.122.123.7");
		professor.setSalario(5000.00);
		professor.setMateria("Portugues");

		ProfessorController controller = new ProfessorController();
		controller.gravarProfessor(professor);

		JOptionPane.showMessageDialog(null, Mensagem.professor
				+ Mensagem.gravado, Mensagem.sucesso, 1);

	}// fim do metodo

	public void listarProfessores() {// inicio do metodo
		ProfessorController controller = new ProfessorController();
		for (Professor professor : controller.buscarTodos()) {// inicio do for
			System.out.println(Mensagem.codigo + Mensagem.doProfessor
					+ professor.getCodigo());
			System.out.println(Mensagem.nome + Mensagem.doProfessor
					+ professor.getNome());
			System.out.println(Mensagem.cpf + Mensagem.doProfessor
					+ professor.getCpf());
			System.out.println(Mensagem.rg + Mensagem.doProfessor
					+ professor.getRg());
			System.out.println(Mensagem.salario + Mensagem.doProfessor
					+ professor.getSalario());
			System.out.println(Mensagem.materia + Mensagem.doProfessor
					+ professor.getMateria());

		}// fim do for
	}// fim do metodo

	public void testaGravarSecretaria() {// inicio do metodo
		Secretaria secretaria = new Secretaria();

		secretaria.setCodigo(1);
		secretaria.setNome("Denise");
		secretaria.setCpf("423.220.719.24");
		secretaria.setRg("12.638.376.7");
		secretaria.setSalario(1200.00);
		secretaria.setRamal("2805");

		SecretariaController controller = new SecretariaController();
		controller.gravarSecretaria(secretaria);

	}// fim do metodo

	public void listarSecretaria() {// inicio do metodo
		SecretariaController controller = new SecretariaController();
		for (Secretaria secretaria : controller.buscarTodos()) {// inicio do for
			System.out.println(Mensagem.codigo + Mensagem.daSecretaria
					+ secretaria.getCodigo());
			System.out.println(Mensagem.nome + Mensagem.daSecretaria
					+ secretaria.getNome());
			System.out.println(Mensagem.cpf + Mensagem.daSecretaria
					+ secretaria.getCpf());
			System.out.println(Mensagem.rg + Mensagem.daSecretaria
					+ secretaria.getRg());
			System.out.println(Mensagem.salario + Mensagem.daSecretaria
					+ secretaria.getSalario());
			System.out.println(Mensagem.ramal + Mensagem.daSecretaria
					+ secretaria.getRamal());

		}// fim do for
	}// fim do metodo

	public void testaGravarFaxineira() {// inicio do metodo
		Faxineira faxineira = new Faxineira();

		faxineira.setCodigo(1);
		faxineira.setNome("Jandira");
		faxineira.setCpf("532.452.342.32");
		faxineira.setRg("23.321.675.1");
		faxineira.setSalario(1200.00);
		faxineira.setSetor("Leste");

		FaxineiraController controller = new FaxineiraController();
		controller.gravarFaxineira(faxineira);

	}// fim do metodo

	public void listarFaxineira() {// inicio do metodo
		FaxineiraController controller = new FaxineiraController();
		for (Faxineira faxineira : controller.buscarTodos()) {// inicio do for
			System.out.println(Mensagem.codigo + Mensagem.daFaxineira
					+ faxineira.getCodigo());
			System.out.println(Mensagem.nome + Mensagem.daFaxineira
					+ faxineira.getNome());
			System.out.println(Mensagem.cpf + Mensagem.daFaxineira
					+ faxineira.getCpf());
			System.out.println(Mensagem.rg + Mensagem.daFaxineira
					+ faxineira.getRg());
			System.out.println(Mensagem.salario + Mensagem.daFaxineira
					+ faxineira.getSalario());
			System.out.println(Mensagem.setor + Mensagem.daFaxineira
					+ faxineira.getSetor());

		}// fim do for
	}// fim do metodo

	public void testaGravaAluno() {// inicio do metodo
		Aluno aluno = new Aluno();
		Data data = new Data(11, 05, 2015);

		aluno.setCodigo(1);
		aluno.setNome("João");
		aluno.setCpf("123.123.123.12");
		aluno.setRg("12.122.123.7");
		aluno.setDataNascimento(data);

		AlunoController controller = new AlunoController();
		controller.gravarAluno(aluno);

	}// fim do metodo

	public static void main(String[] args) {

		MenuView menu = new MenuView();
		menu.menuPrincipal();

	}
}
