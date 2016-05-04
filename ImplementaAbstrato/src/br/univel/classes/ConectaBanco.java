package br.univel.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {

private Connection con = null;
	
	public Connection abrircon() throws SQLException {

		String url = "";
		String user = "";
		String pass = "";
		con = DriverManager.getConnection(url, user, pass);
		
		return con;
		
	}
	
	public void fecharConexao() throws SQLException{
		con.close();
	}
}
