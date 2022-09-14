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
	
	PessoasFisicas.class,
	Pessoas.class,
	Sociedades.class,
	RelatoriosCadastro.class,
	EmitirDocumento.class,
	
})

public class SuiteCadastroTest {

}
