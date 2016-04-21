package br.univel;
@Tabela(value="Cliente")
public class Cliente {
	
	@Coluna(pk=true, nome="cadid", tamanho = 0)
	private int id;
	@Coluna(nome="cadnome", tamanho=45)
	private String nome;
	private String end;
	private String tel;
	
	public Cliente(){
		this(0, null);
	}
	
	public Cliente(int id, String nome){
		super();
		this.id = id;
		this.nome = nome;
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
