package view;

import javax.swing.JOptionPane;

import util.Mensagem;
import controller.AlunoController;
import controller.FaxineiraController;
import controller.ProfessorController;
import controller.SecretariaController;

public class MenuView {// inicio da classe

	public void menuPrincipal() {// inicio do metodo
		boolean valido = true;
		int opcao = 0;
		while (valido) {// inicio do while
			try {// inicio do try
				opcao = Integer.parseInt(JOptionPane
						.showInputDialog(Mensagem.informe + Mensagem.opcao));
				switch (opcao) {// inicio switch
				case 1:
					menuCadastro("professor");
					break;
				case 2:
					menuCadastro("secretaria");
					break;
				case 3:
					menuCadastro("faxineira");
					break;
				case 4:
					menuCadastro("aluno");
					break;
				case 9:
					System.exit(0);
					break;

				default:
					JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida,
							Mensagem.erro, 0);

					break;
				}// fim do switch

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.valorInvalido);

			}// fim do try

		}// fim do while

	}// fim do metodo

	public void menuCadastro(String parametro) {// inicio metodo

		boolean valido = true;
		int opcao = 0;
		while (valido) {// inicio do while
			try {// inicio do try
				opcao = Integer
						.parseInt(JOptionPane
								.showInputDialog("Informe a opção: \n1 - Cadastrar "
										+ parametro
										+ "\n2 - Listar "
										+ parametro
										+ "\n3 - Consultar por nome \n9 - Menu Anterior"));
				switch (opcao) {// inicio switch
				case 1:
					if (parametro.equals("professor")) {
						new ProfessorController().cadastrar();
					} else if (parametro.equals("secretaria")) {
						new SecretariaController().cadastrar();
					} else if (parametro.equals("faxineira")) {
						new FaxineiraController().cadastrar();
					} else {
						new AlunoController().cadastrar();

					}
					break;
				case 2:
					if (parametro.equals("professor")) {
						new ProfessorController().listar();
					} else if (parametro.equals("secretaria")) {
						new SecretariaController().listar();
					} else if (parametro.equals("faxineira")) {
						new FaxineiraController().listar();
					} else {
						new AlunoController().listar();

					}
					break;
				case 3:
					if (parametro.equals("professor")) {
						new ProfessorController().consultar();
					} else if (parametro.equals("secretaria")) {
						new SecretariaController().consultar();
					} else if (parametro.equals("faxineira")) {
						new FaxineiraController().consultar();
					} else {
						new AlunoController().consultar();

					}

					break;

				case 9:
					menuPrincipal();

					break;

				default:
					JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida,
							Mensagem.erro, 0);

					break;
				}// fim do switch

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.valorInvalido);

			}// fim do try

		}// fim do while

	}// fim do metodo

}// fim da classe
