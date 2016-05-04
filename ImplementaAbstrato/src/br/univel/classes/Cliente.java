package br.univel.classes;
import br.univel.anotacoes.Coluna;
import br.univel.anotacoes.Tabela;
import br.univel.enums.EstadoCivil;

@Tabela(value="Cliente")
public class Cliente {
	
	@Coluna(pk=true, nome="id_cliente", tamanho = 0)
	private int id;
	@Coluna(nome="nome_cliente", tamanho=45)
	private String nome;
	@Coluna(nome="end_cliente", tamanho=50)
	private String end;
	@Coluna(nome="tel_cliente", tamanho=45)
	private String tel;
	@Coluna(nome="estadoCivil_cliente", tamanho = 20)
	private EstadoCivil estadocivil;
	
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
	
	public EstadoCivil getEstadocivil() {
		return estadocivil;
	}
	
	public void setEstadocivil(EstadoCivil estadocivil) {
		this.estadocivil = estadocivil;
	}
	
}
