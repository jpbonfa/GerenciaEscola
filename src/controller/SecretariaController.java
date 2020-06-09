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

import model.Secretaria;
import util.Mensagem;
import view.SecretariaView;

public class SecretariaController implements ServiceInterface {

	public String nomeArquivo = "secretaria txt";
	private SecretariaView view = new SecretariaView();

	@Override
	public void cadastrar() {
		gravarSecretaria(view.informeSecretaria());

	}

	@Override
	public void listar() {
		String msg = "Lista de secretaria:\n\n";
		for (Secretaria secretaria : buscarTodos()) {
			msg += Mensagem.codigo + Mensagem.daSecretaria
					+ secretaria.getCodigo() + "\n";
			msg += Mensagem.codigo + Mensagem.daSecretaria
					+ secretaria.getNome() + "\n";
			msg += Mensagem.codigo + Mensagem.daSecretaria
					+ secretaria.getCpf() + "\n";
			msg += Mensagem.codigo + Mensagem.daSecretaria + secretaria.getRg()
					+ "\n";
			msg += Mensagem.salario + Mensagem.daSecretaria
					+ secretaria.getSalario() + "\n\n";
			msg += Mensagem.ramal + Mensagem.daSecretaria
					+ secretaria.getRamal() + "\n\n";
		}
		if (msg.equals("Lista de secretaria:")) {
			JOptionPane.showMessageDialog(null, "N�o existem registros",
					Mensagem.erro, 0);

		} else {
			JOptionPane.showMessageDialog(null, msg, Mensagem.sucesso, 3);
		}
	}

	public void gravarSecretaria(Secretaria secretaria) {// inicio do metodo
		try {// inicio do try
				// gera um objeto do tipo File(arquivo fisico), onde sera
				// informado
				// nome fisico do arquivo.
			File arquivo = new File(nomeArquivo);

			// gera um objeto do tipo FileOutputStream(arquivo logico
			// temporario)
			// utilizado para gerar o arquivo fisico
			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);

			// gera um objeto auxiliar do tipo PrintStream para grava��o do
			// dados do arquivo
			PrintStream gravador = new PrintStream(arquivoOutput);

			// processo de grava��o dos dados
			gravador.print(secretaria.getCodigo());
			gravador.print(";");
			gravador.print(secretaria.getNome());
			gravador.print(";");
			gravador.print(secretaria.getCpf());
			gravador.print(";");
			gravador.print(secretaria.getRg());
			gravador.print(";");
			gravador.print(secretaria.getSalario());
			gravador.print(";");
			gravador.print(secretaria.getRamal());
			gravador.println("");

			// procedimentos finais de grava��o do arquivo
			gravador.close();
			arquivoOutput.close();
			JOptionPane.showMessageDialog(null, Mensagem.secretaria
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

	public ArrayList<Secretaria> buscarTodos() {// inicio do metodo

		// Lista de objetos do tipo secretaria retornado na leitura do
		// arquivio
		ArrayList<Secretaria> listaSecretaria = new ArrayList<Secretaria>();

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
				Secretaria secretaria = new Secretaria();
				String dados[] = texto.split(";");
				secretaria.setCodigo(Integer.parseInt(dados[0]));
				secretaria.setNome(dados[1]);
				secretaria.setCpf(dados[2]);
				secretaria.setRg(dados[3]);
				secretaria.setSalario(Double.parseDouble(dados[4]));
				secretaria.setRamal(dados[5]);
				listaSecretaria.add(secretaria);

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

		return listaSecretaria;
	}// fim do metodo

	public void consultar() {
		String nome = view.informeNome(Mensagem.daSecretaria);
		String msg = "Lista de secretarias:\n\n";
		for (Secretaria secretaria : buscarTodos()) {
			if (secretaria.getNome().startsWith(nome)) {
				msg += Mensagem.codigoDa + Mensagem.secretaria
						+ secretaria.getCodigo() + "\n";
				msg += Mensagem.nomeDa + Mensagem.secretaria
						+ secretaria.getNome() + "\n";
				msg += Mensagem.cpfDa + Mensagem.secretaria
						+ secretaria.getCpf() + "\n";
				msg += Mensagem.rgDa + Mensagem.secretaria + secretaria.getRg()
						+ "\n";
				msg += Mensagem.salarioDa + Mensagem.secretaria
						+ secretaria.getSalario() + "\n";
				msg += Mensagem.ramalDa + Mensagem.secretaria
						+ secretaria.getRamal() + "\n";

			}
		}
		if (msg.equals("Lista de secretaria:")) {
			JOptionPane.showMessageDialog(null, "N�o existem registros",
					Mensagem.erro, 0);

		} else {
			JOptionPane.showMessageDialog(null, msg, Mensagem.sucesso, 3);
		}

	}

}
