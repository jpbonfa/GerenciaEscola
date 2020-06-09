package view;

import javax.swing.JOptionPane;

import model.Professor;

import util.Mensagem;
import util.Valida;

public class ProfessorView extends AbstractView {

	Professor professor;

	public Professor informeProfessor() {
		professor = new Professor();
		professor.setCodigo(informeCodigo(Mensagem.doProfessor));
		professor.setNome(informeNome(Mensagem.doProfessor));
		professor.setCpf(informeCpf(Mensagem.doProfessor));
		professor.setRg(informeRg(Mensagem.doProfessor));
		professor.setMateria(informeMateria());
		return professor;
	}

	public String informeMateria() {// inicio do metodo
		String materia = "";
		boolean valido = true;
		while (valido) {// iniico while

			materia = JOptionPane.showInputDialog(Mensagem.informe
					+ Mensagem.materia + Mensagem.doProfessor);
			if (!Valida.verificaStringVazio(materia)) {// inicio if
				valido = false;
			} else {
				JOptionPane.showMessageDialog(null, Mensagem.informe
						+ Mensagem.materia + Mensagem.campoObrigatorio,
						Mensagem.erro, 0);
			}// fim if

		}// fim while

		return materia;

	}// fim do metodo
}
