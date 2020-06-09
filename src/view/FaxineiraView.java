package view;

import javax.swing.JOptionPane;

import model.Faxineira;
import util.Mensagem;
import util.Valida;

public class FaxineiraView extends AbstractView {// inicio da classe
	Faxineira faxineira;

	public Faxineira informeFaxineira() {// inicio do metodo
		faxineira = new Faxineira();

		faxineira.setCodigo(informeCodigo(Mensagem.daFaxineira));
		faxineira.setNome(informeNome(Mensagem.daFaxineira));
		faxineira.setCpf(informeCpf(Mensagem.daFaxineira));
		faxineira.setRg(informeRg(Mensagem.daFaxineira));
		faxineira.setSetor(informeSetor());
		return faxineira;

	}// fim do metodo

	public String informeSetor() {// inicio do metodo
		String Setor = "";
		boolean valido = true;
		while (valido) {// inicio do while

			Setor = JOptionPane.showInputDialog(Mensagem.informe
					+ Mensagem.setor + Mensagem.daFaxineira);
			if (!Valida.verificaStringVazio(Setor)) {// inicio do if
				valido = false;
			} else {
				JOptionPane.showMessageDialog(null, Mensagem.informe
						+ Mensagem.setor + Mensagem.campoObrigatorio,
						Mensagem.erro, 0);

			}// fim do if

		}// fim do while

		return Setor;
	}// fim do metodo
}
