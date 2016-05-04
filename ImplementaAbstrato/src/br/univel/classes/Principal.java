package br.univel.classes;

import java.sql.SQLException;

import br.univel.enums.EstadoCivil;

public class Principal {


	public Principal(){

		Cliente c1 = new Cliente();
		c1.setId(2);
		c1.setNome("Marcus");
		c1.setEnd("Rua blablabla");
		c1.setTel("9999-9999");
		c1.setEstadocivil(EstadoCivil.SOLTEIRO);

		Cliente c2 = new Cliente();
		c1.setId(3);
		c1.setNome("Marcus2");
		c1.setEnd("Rua blablablablaaaa");
		c1.setTel("9999-8888");
		c1.setEstadocivil(EstadoCivil.CASADO);

		ConectaBanco coneccao = new ConectaBanco();


		FilhaDao dao = new FilhaDao();

		try {
			dao.setConexao(coneccao.abrircon());
		} catch (SQLException e) {
			e.printStackTrace();
		}


		System.out.println("Apagar a Tabela\n");
		dao.apagarTabela(c1);

		System.out.println("Criando a Tabela\n");
		dao.criarTabela(c1);

		System.out.println("Inserindo Cliente 1\n");
		dao.salvar(c1);

		System.out.println("Inserindo Cliente 2\n");
		dao.salvar(c2);


		System.out.println("Mostrar Todos");
		for(Cliente c : dao.listarTodos()){
			System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getEnd() + " - " + 
					c.getTel() + " - " + c.getEstadocivil().toString());			
		}


		System.out.println("\nbuscar cliente 1");
		Cliente c4 = new Cliente();
		c4 = dao.buscar(c1.getId());		
		System.out.println(c4.getId() + " - " + c4.getNome() + " - " + c4.getEnd() + " - " + 
				c4.getTel() + " - " + c4.getEstadocivil().toString());			


		System.out.println("\nalterar cliente 2\n");
		c2.setEstadocivil(EstadoCivil.SOLTEIRO);
		dao.atualizar(c2);



		System.out.println("Mostrar Todos");		
		for(Cliente c : dao.listarTodos()){
			System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getEnd() + " - " + 
					c.getTel() + " - " + c.getEstadocivil().toString());			
		}


		dao.setConexao(null);
		try {
			coneccao.fecharConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String [] args){
		new Principal();
	}
}
