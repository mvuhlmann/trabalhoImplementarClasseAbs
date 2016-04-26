package br.univel;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

	public class AplicacaoDeTeste {

		public AplicacaoDeTeste() {

			String strCreateTable = getCreateTable(Cliente.class);
			System.out.println(strCreateTable);

			Cliente cliente = new Cliente(1, "Hugo");

			Connection con = null;
			try {

				con = new ConexaoFalsa();

				PreparedStatement ps = getPreparedStatementForInset(con, cliente);

				ps.executeUpdate();

				ps.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}

		private PreparedStatement getPreparedStatementForInset(Connection con, Cliente cliente) {
			// TODO Auto-generated method stub
			return null;
		}

		private String getCreateTable(Class<Cliente> cl) {

			try {

				StringBuilder sb = new StringBuilder();

				// Declara��o da tabela.
				{
					String nomeTabela;
					if (cl.isAnnotationPresent(Tabela.class)) {

						Tabela anotacaoTabela = cl.getAnnotation(Tabela.class);
						nomeTabela = anotacaoTabela.value();

					} else {
						nomeTabela = cl.getSimpleName().toUpperCase();

					}
					sb.append("CREATE TABLE ").append(nomeTabela).append(" (");
				}

				Field[] atributos = cl.getDeclaredFields();

				// Declara��o das colunas
				{
					for (int i = 0; i < atributos.length; i++) {

						Field field = atributos[i];

						String nomeColuna;
						String tipoColuna;

						if (field.isAnnotationPresent(Coluna.class)) {
							Coluna anotacaoColuna = field.getAnnotation(Coluna.class);

							if (anotacaoColuna.nome().isEmpty()) {
								nomeColuna = field.getName().toUpperCase();
							} else {
								nomeColuna = anotacaoColuna.nome();
							}

						} else {
							nomeColuna = field.getName().toUpperCase();
						}

						Class<?> tipoParametro = field.getType();

						if (tipoParametro.equals(String.class)) {
							tipoColuna = "VARCHAR(100)";

						} else if (tipoParametro.equals(int.class)) {
							tipoColuna = "INT";

						} else {
							tipoColuna = "DESCONHECIDO";
						}

						if (i > 0) {
							sb.append(",");
						}

						sb.append("\n\t").append(nomeColuna).append(' ').append(tipoColuna);
					}
				}

				// Declara��o das chaves prim�rias
				{

					sb.append(",\n\tPRIMARY KEY( ");

					for (int i = 0, achou = 0; i < atributos.length; i++) {

						Field field = atributos[i];

						if (field.isAnnotationPresent(Coluna.class)) {

							Coluna anotacaoColuna = field.getAnnotation(Coluna.class);

							if (anotacaoColuna.pk()) {

								if (achou > 0) {
									sb.append(", ");
								}

								if (anotacaoColuna.nome().isEmpty()) {
									sb.append(field.getName().toUpperCase());
								} else {
									sb.append(anotacaoColuna.nome());
								}

								achou++;
							}

						}
					}

					sb.append(" )");
				}

				sb.append("\n);");

				return sb.toString();

			} catch (SecurityException e) {
				throw new RuntimeException(e);
			}
		}
}
