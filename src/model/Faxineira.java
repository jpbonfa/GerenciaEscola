package model;

public class Faxineira extends Funcionario {

	public String setor;

	public Faxineira() {

	}

	public Faxineira(String setor) {
		super();
		this.setor = setor;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}
