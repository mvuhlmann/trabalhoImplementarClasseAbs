package br.univel;

public enum EstadoCivil {
	C(1,"CASADO"),
	S(2,"SOLTEIRO"),
	D(3,"DIVORCIADO");
	
	private int id_ec;
	private String nome_ec;
	
	private EstadoCivil(int id_, String nome_ec_){
		this.id_ec = id_;
		this.nome_ec = nome_ec_;
	}

	public int getId_ec() {
		return id_ec;
	}

	public String getNome_ec() {
		return nome_ec;
	}
	
	

}
