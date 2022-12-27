package br.conselhos.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.conselhos.core.DSL;

public class JavaApplicationConexaoSQL {
	
	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Conexao con = new Conexao();
		Statement st = con.conexao.createStatement();
		// PATRICIA SILVA JURIDICA TESTE
		//PATRICIA SILVA PIRES TESTE
		//PATRICIA SILVA PIRES TESTE CADASTRO
		//PATRICIA SILVA JURIDICA TESTE CADASTRO
		st.executeQuery("DECLARE @id_inscrito INT;\r\n" + "SELECT * FROM Pessoa\r\n"
				+ "WHERE Nome = 'PATRICIA SILVA JURIDICA TESTE CADASTRO'\r\n"
				+ "SELECT @id_inscrito = ID FROM Pessoa WHERE Nome = 'PATRICIA SILVA JURIDICA TESTE CADASTRO'\r\n" + "\r\n"
				+ "DELETE FROM OutrosEnderecos\r\n" + "WHERE Pessoa = @id_inscrito\r\n" + "\r\n"
				+ "DELETE FROM SituacaoTramite\r\n" + "WHERE Pessoa = @id_inscrito\r\n" + "\r\n"
				+ "DELETE FROM HistoricoInadimplencia\r\n" + "WHERE Pessoa = @id_inscrito\r\n" + "\r\n"
				+ "DELETE FROM Pessoa\r\n" + "WHERE Nome = 'PATRICIA SILVA JURIDICA TESTE CADASTRO'");	
		ResultSet rs = st.getResultSet();
		while(rs.next()) {
			System.out.println(rs.getString("Nome") + "," +rs.getString("ID"));
		}
	}
}
