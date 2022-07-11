package br.conselhos.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class MenuPage extends BasePage {
	
	public void botaoMenuIndex() {
		clicarBotaoID("q-comp-39");
	}
	
	public void Financeiro() {
		clicarBotaoXpath("/html/body/div[2]/div/div[24]/a/span[2]");
	}	
	
	public void ContasReceber() {
		clicarLink("Contas a receber");
	}
	
	public void Tesouraria() {
		clicarLink("Tesouraria");
	}
	
	public void PosicaoFinanceira() {
		clicarLink("Posi��o financeira");
	}
	
	public void TranscoesCartao() {
		clicarLink("Transa��es Cart�o");
	}
	
	public void ConfiguracaoDeRepassesAutomaticos() {
		clicarLink("Configura��o de Repasses Autom�ticos");
	}
	
	public void IntegracaoDeReceitasRealizadas() {
		clicarLink("Integra��o de Receita Realizada");		
	}
	
	public void GeracaoDeTitulos() {
		clicarLink("Gera��o de T�tulos");		
	}
	
	public void IntegracaoBancaria() {
		clicarLink("Integra��o banc�ria");
	}
	
	public void PagamentoAutomatizado() {
		clicarLink("Pagamento Automatizado");
	}
	
	public void Sacados() {
		clicarLink("Sacados");
	}
	
	public void DividaAtiva() {
		clicarLink("D�vida ativa");
	}	
	
	public void BorderosDeRecebimento() {
		clicarLink("Border�s de recebimento");
	}
	
	public void Cedentes() {
		clicarLink("Cedentes");
	}
	
	public void ConciliacaoBancaria() {
		clicarLink("Concilia��o banc�ria");
	}
	
	public void Cobranca() {
		clicarLink("Cobran�a");
	}
	
	public void HistoricoDeContatos() {
		clicarLink("Hist�rico de Contatos");
	}
	
	public void InformacoesBancarias() {
		clicarLink("Informa��es banc�rias");
	}
	
	public void CondicaoDeRecebimento() {
		clicarLink("Condi��o de Recebimento");
	}
	
	public void IndiceseMoedas() {
		clicarLink("�ndices e moedas");
	}
	
	public void TabelaDePrecoServicos() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Tabela de pre�o servi�os" + Keys.ENTER);
		esperaFixa(1000);
        clicarLink("Tabela de pre�o servi�os");
	}
	
	public void GerarNumeroDocumento() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Gerar n�mero documento" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Gerar n�mero documento");
	}
	
	public void TipoDeLancamento() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Tipos de lan�amento" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Tipos de lan�amento");
	}
	
	public void EstruturaFinanceira() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Estrutura financeira" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Estrutura financeira");
	}
	
	public void RenegociacaoSimplificada() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Renegocia��o Simplificada" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Renegocia��o Simplificada");
	}
	
	public void RenegociacaoSimulacao() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Renegocia��o/Simula��o" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Renegocia��o/Simula��o");
	}
	
	public void PlanosDePagamento() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Planos de pagamento" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Planos de pagamento");
	}
	
	public void EmitirDocumento() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Emitir documento" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Emitir documento");
	}
	
	public void CadastrosBasicos() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Cadastros b�sicos" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Cadastros b�sicos");
	}
	
	public void FluxoDeCaixa() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Fluxo de Caixa" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Fluxo de Caixa");
	}
	
	public void ConfiguracoesRecebimentoRecorrente() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Configura��es de Recebimento Recorrente" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Configura��es de Recebimento Recorrente");
	}
	
	public void DocumentosFiscais() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Documentos Fiscais" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Documentos Fiscais");
	}
	
	public void Relatorios() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Relat�rios" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Relat�rios");
	}
	
	/*************************
	 * M�DULO GEST�O CONT�BIL
	 * **********************/
	
    public void GestaoContabil() {
    	clicarLink("Gest�o Cont�bil");
    }
    
    public void EntidadeContabil() {
    	clicarLink("Entidade Cont�bil");
    	
    }
	
	
		
}