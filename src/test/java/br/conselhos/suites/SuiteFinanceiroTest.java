package br.conselhos.suites;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


import Financeiro.BorderosDeRecebimento.BorderosDeRecebimento;
import Financeiro.CadastrosBasicos.CadastrosBasicos;
import Financeiro.Cedentes.Cedentes;
import Financeiro.Cobranca.Cobranca;
import Financeiro.ConciliacaoBancaria.ConciliacaoBancaria;
import Financeiro.CondicaoDeRecebimento.CondicaoDeRecebimento;
import Financeiro.ConfiguracaoDeRepassesAutomaticos.ConfiguracaoDeRepassesAutomaticos;
import Financeiro.ConfiguracoesRecebimentoRecorrente.ConfiguracoesRecebimentoRecorrente;
import Financeiro.ContasAReceber.ContasReceber;
import Financeiro.DividaAtiva.DividaAtiva;
import Financeiro.DocumentosFiscais.DocumentosFiscais;
import Financeiro.EmitirDocumento.EmitirDocumento;
import Financeiro.EstruturaFinanceira.EstruturaFinanceira;
import Financeiro.FluxoDeCaixa.FluxoDeCaixa;
import Financeiro.GerarNumeroDocumento.GerarNumeroDocumento;
import Financeiro.GerecaoDeTitulos.GeracaoDeTitulos;
import Financeiro.HistoricoDeContatos.HistoricoDeContatos;
import Financeiro.IndiceseMoedas.IndiceseMoedas;
import Financeiro.InformacoesBancarias.InformacoesBancarias;
import Financeiro.IntegracaoBancaria.IntegracaoBancaria;
import Financeiro.IntegracaoDeReceitaRealizada.IntegracaoDeReceitaRealizada;
import Financeiro.PagamentoAutomatizado.PagamentoAutomatizado;
import Financeiro.PlanosDePagamento.PlanosDePagamento;
import Financeiro.PosicaoFinanceira.PosicaoFinanceira;
import Financeiro.Relatorios.Relatorios;
import Financeiro.RenegociacaoSimplificada.RenegociacaoSimplificada;
import Financeiro.RenegociacaoSimulacao.RenegociacaoSimulacao;
import Financeiro.Sacados.Sacados;
import Financeiro.TabelaDePrecoServicos.TabelaDePrecoServicos;
import Financeiro.Tesouraria.Tesouraria;
import Financeiro.TiposDeLancamento.TiposDeLancamento;
import Financeiro.TransacoesCartao.TransacoesCartao;

@RunWith(Suite.class)

@SuiteClasses({
	
	Tesouraria.class,
	PosicaoFinanceira.class,
	ContasReceber.class,
	TransacoesCartao.class,
	ConfiguracaoDeRepassesAutomaticos.class,
	IntegracaoDeReceitaRealizada.class,
	GeracaoDeTitulos.class,
	IntegracaoBancaria.class,
	PagamentoAutomatizado.class,
	Sacados.class,
	DividaAtiva.class,
	BorderosDeRecebimento.class,
	Cedentes.class,
	ConciliacaoBancaria.class,
	Cobranca.class,
	HistoricoDeContatos.class,
	InformacoesBancarias.class,
	CondicaoDeRecebimento.class,
	IndiceseMoedas.class,
	TabelaDePrecoServicos.class,
	GerarNumeroDocumento.class,
	TiposDeLancamento.class,
	EstruturaFinanceira.class,
	RenegociacaoSimplificada.class,
	RenegociacaoSimulacao.class,
	PlanosDePagamento.class,
	EmitirDocumento.class,
	CadastrosBasicos.class,
	FluxoDeCaixa.class,
	ConfiguracoesRecebimentoRecorrente.class,
	DocumentosFiscais.class,
	Relatorios.class,

})
public class SuiteFinanceiroTest {

	
}
