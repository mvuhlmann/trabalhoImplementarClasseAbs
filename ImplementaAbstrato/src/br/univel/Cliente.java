package br.univel;

public class Cliente {

	private Integer id;
	private String nome;
	private String end;
	private String tel;
	
	public static void EC(EstadoCivil estado){
		
	}
	
	public static void main(String []args){
		EC(EstadoCivil.C);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
