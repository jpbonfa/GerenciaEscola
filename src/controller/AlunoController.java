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

import model.Aluno;
import model.Data;
import util.Mensagem;
import util.Util;
import view.AlunoView;

public class AlunoController implements ServiceInterface {
	public String nomeArquivo = "aluno txt";
	private AlunoView view = new AlunoView();

	@Override
	public void cadastrar() {

		gravarAluno(view.informeAluno());
	}

	@Override
	public void listar() {
		String msg = "Lista de alunos:\n\n";
		for (Aluno aluno : buscarTodos()) {
			msg += Mensagem.codigoDo + Mensagem.aluno + aluno.getCodigo()
					+ "\n";
			msg += Mensagem.nome + Mensagem.aluno + aluno.getNome() + "\n";
			msg += Mensagem.cpf + Mensagem.aluno + aluno.getCpf() + "\n";
			msg += Mensagem.rgDo + Mensagem.aluno + aluno.getRg() + "\n";
			msg += Mensagem.dataDo + Mensagem.aluno + aluno.getDataNascimento()
					+ "\n";

		}
		if (msg.equals("Lista de alunos:")) {
			JOptionPane.showMessageDialog(null, Mensagem.semRegistro,
					Mensagem.erro, 0);

		} else {
			JOptionPane.showMessageDialog(null, msg, Mensagem.sucesso, 3);
		}
	}

	@Override
	public void consultar() {
		String nome = view.informeNome(Mensagem.doAluno);
		String msg = "Lista de alunos:\n\n";
		for (Aluno aluno : buscarTodos()) {
			if (aluno.getNome().startsWith(nome)) {
				msg += Mensagem.codigo + Mensagem.doAluno + aluno.getCodigo()
						+ "\n";
				msg += Mensagem.nome + Mensagem.doAluno + aluno.getNome()
						+ "\n";
				msg += Mensagem.cpf + Mensagem.doAluno + aluno.getCpf() + "\n";
				msg += Mensagem.rg + Mensagem.doAluno + aluno.getRg() + "\n";
				msg += Mensagem.data + Mensagem.doAluno
						+ aluno.getDataNascimento() + "\n";

			}
		}
		if (msg.equals("Lista de alunos:")) {
			JOptionPane.showMessageDialog(null, Mensagem.semRegistro,
					Mensagem.erro, 0);

		} else {
			JOptionPane.showMessageDialog(null, msg, Mensagem.sucesso, 3);
		}

	}

	public void gravarAluno(Aluno aluno) {// inicio do metodo
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
			gravador.print(aluno.getCodigo());
			gravador.print(";");
			gravador.print(aluno.getNome());
			gravador.print(";");
			gravador.print(aluno.getCpf());
			gravador.print(";");
			gravador.print(aluno.getRg());
			gravador.print(";");
			gravador.print(aluno.getDataNascimento());
			gravador.println("");

			// procedimentos finais de gravação do arquivo
			gravador.close();
			arquivoOutput.close();
			JOptionPane.showMessageDialog(null, Mensagem.aluno
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

	public ArrayList<Aluno> buscarTodos() {// inicio do metodo

		// Lista de objetos do tipo Aluno retornado na leitura do
		// arquivio
		ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();

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
				Aluno aluno = new Aluno();
				String dados[] = texto.split(";");
				aluno.setCodigo(Integer.parseInt(dados[0]));
				aluno.setNome(dados[1]);
				aluno.setCpf(dados[2]);
				aluno.setRg(dados[3]);

				Data data = new Data();
				int aux[] = Util.quebraData(dados[4]);
				data.setDia(aux[0]);
				data.setMes(aux[1]);
				data.setAno(aux[2]);
				aluno.setDataNascimento(data);

				// aluno.setDataNascimento(data)(dados[5]);
				listaAluno.add(aluno);

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

		return listaAluno;
	}// fim do metodo

}
