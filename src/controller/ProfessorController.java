package controller;

import intfc.ServiceInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Professor;
import util.Mensagem;
import view.ProfessorView;

public class ProfessorController implements ServiceInterface {// inicio da
																// classe

	private String nomeArquivo = "professor.txt";
	private ProfessorView view = new ProfessorView();

	public void cadastrar() {
		gravarProfessor(view.informeProfessor());
	}

	public void listar() {
		String msg = "Lista de professores:\n\n";
		for (Professor professor : buscarTodos()) {
			msg += Mensagem.codigo + Mensagem.doProfessor
					+ professor.getCodigo() + "\n";
			msg += Mensagem.nome + Mensagem.doProfessor + professor.getNome()
					+ "\n";
			msg += Mensagem.cpf + Mensagem.doProfessor + professor.getCpf()
					+ "\n";
			msg += Mensagem.rg + Mensagem.doProfessor + professor.getRg()
					+ "\n";
			msg += Mensagem.salario + Mensagem.doProfessor
					+ professor.getSalario() + "\n\n";
			msg += Mensagem.materia + Mensagem.doProfessor
					+ professor.getMateria() + "\n\n";
		}
		if (msg.equals("Lista de professores:")) {
			JOptionPane.showMessageDialog(null, Mensagem.semRegistro,
					Mensagem.erro, 0);

		} else {
			JOptionPane.showMessageDialog(null, msg, Mensagem.sucesso, 3);
		}
	}

	public void gravarProfessor(Professor professor) {// inicio do metodo
		try {// inicio do try
				// gera um objeto do tipo File(arquivo fisico), onde sera
				// informado
				// nome fisico do arquivo.
			File arquivo = new File(nomeArquivo);

			// gera um objeto do tipo FileOutputStream(arquivo logico
			// temporario)
			// utilizado para gerar o arquivo fisico
			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);

			// gera um objeto auxiliar do tipo PrintStream para gravação do
			// dados do arquivo
			PrintStream gravador = new PrintStream(arquivoOutput);

			// processo de gravação dos dados
			gravador.print(professor.getCodigo());
			gravador.print(";");
			gravador.print(professor.getNome());
			gravador.print(";");
			gravador.print(professor.getCpf());
			gravador.print(";");
			gravador.print(professor.getRg());
			gravador.print(";");
			gravador.print(professor.getSalario());
			gravador.print(";");
			gravador.print(professor.getMateria());
			gravador.println("");

			// procedimentos finais de gravação do arquivo
			gravador.close();
			arquivoOutput.close();
			JOptionPane.showMessageDialog(null, Mensagem.professor
					+ Mensagem.gravado, Mensagem.sucesso, 2);

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroArquivo,
					Mensagem.erro, 0);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroFechaArquivo,
					Mensagem.erro, 0);
			e.printStackTrace();
		}// fim do try

	}// fim do metodo

	public ArrayList<Professor> buscarTodos() {// inicio do metodo

		// Lista de objetos do tipo professor retornado na leitura do
		// arquivio
		ArrayList<Professor> listaProfessor = new ArrayList<Professor>();

		try {// inico do try
				// Gera um objeto InputStream para leitura do arquivo fisico
			InputStream is = new FileInputStream(nomeArquivo);

			// gera um objeto InputStreamReader para armazenar os bytes do
			// arquivo fisico
			InputStreamReader isr = new InputStreamReader(is);

			// gera um objeto auxiliar BufferedReader para ler os dados do
			// arquivo
			BufferedReader leitor = new BufferedReader(isr);

			String texto = leitor.readLine();

			while (texto != null) {// inicio do while
				Professor professor = new Professor();
				String dados[] = texto.split(";");
				professor.setCodigo(Integer.parseInt(dados[0]));
				professor.setNome(dados[1]);
				professor.setCpf(dados[2]);
				professor.setRg(dados[3]);
				professor.setSalario(Double.parseDouble(dados[4]));
				professor.setMateria(dados[5]);
				listaProfessor.add(professor);

				texto = leitor.readLine();
			}// fim do while

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroEncontrarArquivo,
					Mensagem.erro, 0);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroLerArquivo,
					Mensagem.erro, 0);
			e.printStackTrace();
		}// fim do try

		return listaProfessor;
	}// fim do metodo

	@Override
	public void consultar() {
		String nome = view.informeNome(Mensagem.doProfessor);
		String msg = "Lista de professores:\n\n";
		for (Professor professor : buscarTodos()) {
			if (professor.getNome().startsWith(nome)) {
				msg += Mensagem.codigoDo + Mensagem.professor
						+ professor.getCodigo() + "\n";
				msg += Mensagem.nomeDo + Mensagem.professor
						+ professor.getNome() + "\n";
				msg += Mensagem.cpfDo + Mensagem.professor + professor.getCpf()
						+ "\n";
				msg += Mensagem.rgDo + Mensagem.professor + professor.getRg()
						+ "\n";
				msg += Mensagem.salarioDo + Mensagem.professor
						+ professor.getSalario() + "\n";
				msg += Mensagem.materiaDo + Mensagem.professor
						+ professor.getMateria() + "\n\n";

			}
		}
		if (msg.equals("Lista de professores:")) {
			JOptionPane.showMessageDialog(null, Mensagem.semRegistro,
					Mensagem.erro, 0);

		} else {
			JOptionPane.showMessageDialog(null, msg, Mensagem.sucesso, 3);
		}

	}

}// fim da classe
