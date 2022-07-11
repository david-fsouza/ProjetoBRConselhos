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
		clicarLink("Posição financeira");
	}
	
	public void TranscoesCartao() {
		clicarLink("Transações Cartão");
	}
	
	public void ConfiguracaoDeRepassesAutomaticos() {
		clicarLink("Configuração de Repasses Automáticos");
	}
	
	public void IntegracaoDeReceitasRealizadas() {
		clicarLink("Integração de Receita Realizada");		
	}
	
	public void GeracaoDeTitulos() {
		clicarLink("Geração de Títulos");		
	}
	
	public void IntegracaoBancaria() {
		clicarLink("Integração bancária");
	}
	
	public void PagamentoAutomatizado() {
		clicarLink("Pagamento Automatizado");
	}
	
	public void Sacados() {
		clicarLink("Sacados");
	}
	
	public void DividaAtiva() {
		clicarLink("Dívida ativa");
	}	
	
	public void BorderosDeRecebimento() {
		clicarLink("Borderôs de recebimento");
	}
	
	public void Cedentes() {
		clicarLink("Cedentes");
	}
	
	public void ConciliacaoBancaria() {
		clicarLink("Conciliação bancária");
	}
	
	public void Cobranca() {
		clicarLink("Cobrança");
	}
	
	public void HistoricoDeContatos() {
		clicarLink("Histórico de Contatos");
	}
	
	public void InformacoesBancarias() {
		clicarLink("Informações bancárias");
	}
	
	public void CondicaoDeRecebimento() {
		clicarLink("Condição de Recebimento");
	}
	
	public void IndiceseMoedas() {
		clicarLink("Índices e moedas");
	}
	
	public void TabelaDePrecoServicos() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Tabela de preço serviços" + Keys.ENTER);
		esperaFixa(1000);
        clicarLink("Tabela de preço serviços");
	}
	
	public void GerarNumeroDocumento() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Gerar número documento" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Gerar número documento");
	}
	
	public void TipoDeLancamento() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Tipos de lançamento" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Tipos de lançamento");
	}
	
	public void EstruturaFinanceira() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Estrutura financeira" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Estrutura financeira");
	}
	
	public void RenegociacaoSimplificada() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Renegociação Simplificada" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Renegociação Simplificada");
	}
	
	public void RenegociacaoSimulacao() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Renegociação/Simulação" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Renegociação/Simulação");
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
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Cadastros básicos" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Cadastros básicos");
	}
	
	public void FluxoDeCaixa() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Fluxo de Caixa" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Fluxo de Caixa");
	}
	
	public void ConfiguracoesRecebimentoRecorrente() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Configurações de Recebimento Recorrente" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Configurações de Recebimento Recorrente");
	}
	
	public void DocumentosFiscais() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Documentos Fiscais" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Documentos Fiscais");
	}
	
	public void Relatorios() throws InterruptedException {
		escreverXpath("//input[contains(@name, 'mainCt:middleCt:leftCt:Pages:AccordionWithSearch:')]", "Relatórios" + Keys.ENTER);
		esperaFixa(1000);
		clicarLink("Relatórios");
	}
	
	/*************************
	 * MÓDULO GESTÃO CONTÁBIL
	 * **********************/
	
    public void GestaoContabil() {
    	clicarLink("Gestão Contábil");
    }
    
    public void EntidadeContabil() {
    	clicarLink("Entidade Contábil");
    	
    }
	
	
		
}