package view;

import java.text.ParseException;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Data;
import util.Mensagem;
import util.Util;
import util.Valida;

public class AlunoView extends AbstractView {
	Aluno aluno;

	public Aluno informeAluno() {
		aluno = new Aluno();
		aluno.setCodigo(informeCodigo(Mensagem.doAluno));
		aluno.setNome(informeNome(Mensagem.doAluno));
		aluno.setCpf(informeCpf(Mensagem.doAluno));
		aluno.setRg(informeRg(Mensagem.doAluno));
		aluno.setDataNascimento(informeDataNascimento());
		return aluno;

	}

	public Data informeDataNascimento() {// inicio do metodo
		Data data = new Data();
		String string = "";
		int retorno[] = null;

		boolean valido = true;
		while (valido) {// iniico while
			try {
				string = Util.informeMascara("##/##/####",
						Mensagem.informe  + Mensagem.data, Mensagem.cadastro);
				if (!Valida.verificaDataVazio(string)) {
					retorno = Util.quebraData(string);
					String mensagem = Valida.validaData(retorno);
					if (!mensagem.equals("")) {
						JOptionPane.showMessageDialog(null, mensagem,
								Mensagem.erro, 0);
					} else {
						valido = false;
					}
				}// fim if
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}// fim while
		data.setDia(retorno[0]);
		data.setMes(retorno[1]);
		data.setAno(retorno[2]);
		return data;

	}// fim do metodo
}
