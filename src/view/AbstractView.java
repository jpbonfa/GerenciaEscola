package view;

import java.text.ParseException;

import javax.swing.JOptionPane;

import util.Mensagem;
import util.Util;
import util.Valida;

public abstract class AbstractView {// uma classe abstrata nao pode ser
									// instanciada

	public int informeCodigo(String parametro) {// inicio do metodo
		int codigo = 0;
		boolean valido = true;
		while (valido) {// inicio do while
			try {// inicio do try
				codigo = Integer.parseInt(JOptionPane
						.showInputDialog(Mensagem.informe + Mensagem.codigo
								+ parametro));
				if (!Valida.verificaIntZero(codigo)) {// inicio do if
					valido = false;
				} else {
					JOptionPane.showMessageDialog(null, Mensagem.informe
							+ Mensagem.codigo + Mensagem.campoObrigatorio,
							Mensagem.erro, 0);

				}// fim do if
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.valorInvalido);

			}// fim do try
		}// fim do while

		return codigo;
	}// fim do metodo

	public String informeNome(String parametro) {// inicio do metodo
		String nome = "";
		boolean valido = true;
		while (valido) {// inicio while
			nome = JOptionPane.showInputDialog(Mensagem.informe + Mensagem.nome
					+ parametro);
			if (!Valida.verificaStringVazio(nome)) {// inicio if
				if (!Valida.verificaNumeros(nome)) {
					valido = false;
				} else {
					JOptionPane.showMessageDialog(null, Mensagem.caracteres,
							Mensagem.erro, 0);

				}
			} else {
				JOptionPane.showMessageDialog(null, Mensagem.informe
						+ Mensagem.nome + Mensagem.campoObrigatorio,
						Mensagem.erro, 0);

			}// fim if

		}// fim while

		return nome;
	}// fim do metodo

	public String informeCpf(String parametro) {// inicio do metodo
		String cpf = "";
		boolean valido = true;
		while (valido) {// iniico while
			try {
				cpf = Util.informeMascara("###.###.###-##", Mensagem.informe
						+ Mensagem.cpf + parametro, Mensagem.cadastro
						+ parametro);
				if (!Valida.verificaCpfVazio(cpf)) {// inicio if
					valido = false;
				} else {
					JOptionPane.showMessageDialog(null, Mensagem.informe
							+ Mensagem.cpf + Mensagem.campoObrigatorio,
							Mensagem.erro, 0);
				}// fim if
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}// fim while

		return cpf;

	}// fim do metodo

	public String informeRg(String parametro) {// inicio do metodo
		String rg = "";
		boolean valido = true;
		while (valido) {// iniico while
			try {
				rg = Util.informeMascara("##.###.###-#", Mensagem.informe
						+ Mensagem.rg + parametro, Mensagem.cadastro
						+ parametro);
				if (!Valida.verificaRgVazio(rg)) {// inicio if
					valido = false;
				} else {
					JOptionPane.showMessageDialog(null, Mensagem.informe
							+ Mensagem.rg + Mensagem.campoObrigatorio,
							Mensagem.erro, 0);
				}// fim if
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}// fim while

		return rg;

	}// fim do metodo

}
