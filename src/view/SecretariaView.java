package view;

import javax.swing.JOptionPane;

import util.Mensagem;
import util.Valida;
import model.Secretaria;

public class SecretariaView extends AbstractView {// inicio da classe

	Secretaria secretaria;

	public Secretaria informeSecretaria() {// inicio do metodo
		secretaria = new Secretaria();
		secretaria.setCodigo(informeCodigo(Mensagem.daSecretaria));
		secretaria.setNome(informeNome(Mensagem.daSecretaria));
		secretaria.setCpf(informeCpf(Mensagem.daSecretaria));
		secretaria.setRg(informeRg(Mensagem.daSecretaria));
		secretaria.setRamal(informeRamal());
		return secretaria;

	}// fim do metodo

	public String informeRamal() {// inicio do metodo
		String ramal = "";
		boolean valido = true;
		while (valido) {// inicio do while

			ramal = JOptionPane.showInputDialog(Mensagem.informe
					+ Mensagem.ramal + Mensagem.daSecretaria);
			if (!Valida.verificaStringVazio(ramal)) {// inicio do if
				valido = false;
			} else {
				JOptionPane.showMessageDialog(null, Mensagem.informe
						+ Mensagem.ramal + Mensagem.campoObrigatorio,
						Mensagem.erro, 0);

			}// fim do if

		}// fim do while

		return ramal;
	}// fim do metodo
}
