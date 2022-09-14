package br.conselhos.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Financeiro.Cobranca.Cobranca;
import Financeiro.ContasAReceber.ContasReceber;
import Financeiro.GerecaoDeTitulos.GeracaoDeTitulos;
import Financeiro.IntegracaoBancaria.IntegracaoBancaria;
import Financeiro.PosicaoFinanceira.PosicaoFinanceira;
import Financeiro.Relatorios.Relatorios;
import Financeiro.RenegociacaoSimplificada.RenegociacaoSimplificada;
import Financeiro.Tesouraria.Tesouraria;

@RunWith(Suite.class)

@SuiteClasses({
	
	Tesouraria.class,
	PosicaoFinanceira.class,
	ContasReceber.class,
	GeracaoDeTitulos.class,
	IntegracaoBancaria.class,
	Cobranca.class,
	RenegociacaoSimplificada.class,
	Relatorios.class,

})
public class SuiteFinanceiroTest {

	
}
