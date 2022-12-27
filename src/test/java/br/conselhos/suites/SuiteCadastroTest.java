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
	
	//PessoasFisicas.class, (Testes realizados no na função Pessoas)
	Pessoas.class,
	Sociedades.class,
	//RelatoriosCadastro.class, //Relatório 084 e 086 não estão presentes, porém estão em outros módulos(Consultar Teste Padrão)
	//EmitirDocumento.class, //Erro de SearchPage
	
})

public class SuiteCadastroTest {

}
