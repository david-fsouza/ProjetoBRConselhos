package br.conselhos.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Cadastro.EmitirDocumento;
import Cadastro.Pessoas;
import Cadastro.PessoasFisicas;
import Cadastro.RelatoriosCadastro;
import Cadastro.Sociedades;

@RunWith(Suite.class)

@SuiteClasses({
	
	//PessoasFisicas.class, (Testes realizados no na fun��o Pessoas)
	Pessoas.class,
	Sociedades.class,
	//RelatoriosCadastro.class, //Relat�rio 084 e 086 n�o est�o presentes, por�m est�o em outros m�dulos(Consultar Teste Padr�o)
	//EmitirDocumento.class, //Erro de SearchPage
	
})

public class SuiteCadastroTest {

}
