package br.conselhos.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.net.ssl.SSLContext;

public class Conexao {
	
	// Par�metro "encrypt=false;sslProtocol=TLSv1.2" necess�rio para protocolo de seguran�a SSL do SQLServer
    String url = "jdbc:sqlserver://10.2.5.7;databaseName=QLD_BRC_Main_Automacao;encrypt=false;sslProtocol=TLSv1.2;";
	String username = "usrHBConselhos";
	String password = "HbC0n53lh05";
	
	//Utilizado "public Conection" para que a DSL pudesse enxergar, por�m o original � "public Conection conexao"
	public Connection conexao;
	
	
	// Utilizado "public Conexao" para que a DSL pudesse enxergar, por�m o original � apenas "Conex�o()"
	public Conexao() throws SQLException {
	conexao = DriverManager.getConnection(url, username, password);
	}
	
}
