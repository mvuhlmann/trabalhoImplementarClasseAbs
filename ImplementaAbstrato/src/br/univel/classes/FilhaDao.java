package br.univel.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.enums.EstadoCivil;
import br.univel.interfaces.Dao;

public class FilhaDao implements Dao<Cliente, Object>{

	FilhaSqlGen gerar = new FilhaSqlGen();

	private Connection con = null;

	public Connection getConexao(){
		return con;
	}

	public void setConexao(Connection con1){
		this.con = con1;
	}

	@Override
	public void salvar(Cliente c) {
		try {
			PreparedStatement ps = gerar.getSqlInsert(con, c);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getEnd());
			ps.setString(4, c.getTel());
			ps.setInt(5, c.getEstadocivil().ordinal());

			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cliente buscar(Integer k) {
		Cliente c = new Cliente();

		try {

			PreparedStatement ps = gerar.getSqlSelectById(con, new Cliente());
			ps.setInt(1, k);
			ResultSet resultados = ps.executeQuery();

			while (resultados.next()) {
				c.setId(resultados.getInt("id_cliente"));
				c.setNome(resultados.getString("nome_cliente"));
				c.setEnd(resultados.getString("end_cliente"));
				c.setTel(resultados.getString("tel_cliente"));
				c.setEstadocivil(EstadoCivil.getPorid(resultados.getInt("estadoCivil_cliente")));
			}			

			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}				

		return c;
	}

	@Override
	public void atualizar(Cliente t) {
		try {
			PreparedStatement ps = gerar.getSqlUpdateById(con, t);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getEnd());
			ps.setString(3, t.getTel());
			ps.setInt(4, t.getEstadocivil().ordinal());
			ps.setInt(5, t.getId());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}	
	}

	public void excluir(Integer k) {
		try {

			PreparedStatement ps = gerar.getSqlDeleteById(con, new Cliente());
			ps.setInt(1, k);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public List<Cliente> listarTodos() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();

		try {

			PreparedStatement ps = gerar.getSqlSelectAll(con, new Cliente());
			ResultSet resultados = ps.executeQuery();

			while (resultados.next()) {

				Cliente cli = new Cliente();
				cli.setId(resultados.getInt("id"));
				cli.setNome(resultados.getString("clinome"));
				cli.setEnd(resultados.getString("cliendereco"));
				cli.setTel(resultados.getString("clitelefone"));
				cli.setEstadocivil(EstadoCivil.getPorid(resultados.getInt("cliestadocivil")));

				listaClientes.add(cli);
			}			

			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}				

		return listaClientes;
	}

	public void criarTabela(Cliente t){
		try {
			String sql = gerar.getCreateTable(con, t);	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}			

	}

	public void apagarTabela(Cliente t){
		try {
			String sql = gerar.getDropTable(con, t);	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}			

	}

	@Override
	public Cliente buscar(Object k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Object k) {
		// TODO Auto-generated method stub
		
	}

}
