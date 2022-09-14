package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class PosicaoFinanceiraPage extends BasePage {
	
	/****************************************
	 * TELA NOVO REGISTRO POSIÇAO FINANCEIRA
	 ***************************************/
	
	/******* INTEGRAÇÃO CONTAS A RECEBER *******/
	
	//****** Novo Contas a Receber *******//
	
	public String validarTextoNovoContasReceberPosicaoFinanceira() {
		return obterTexto("BIANCA RODRIGUES DOS SANTOS DE LIMA");
	}
	
	//******* Consulta Registro Posição Financeira *******//
	
	public void campoSacado(String texto) throws InterruptedException {
		escreverID("lkpSacadoEdt", texto);
	    esperaFixa(3000);
	    digitaTeclaId("lkpSacadoEdt", Keys.ENTER);
	    esperaFixa(4000);
	}
	
	public String validarTextoConsultaPosicaoFinanceira() {
		return obterTexto("ANUIDADE - ADRIANA APARECIDA LUZETTI - Contas a Receber nº 000000365698");
	}
	
	//****** Consulta Registro Com Filtros Avançados ******//
	
	public void campoNumero(String texto) {
		escreverID("txtNumeroEdt", texto);	
	}
	
	public void campoEmissaoInicial(String texto) {
		escreverID("dtEmissao_startDateEdt", texto);
	}
	
	public void campoEmissaoFinal(String texto) {
		escreverID("dtEmissao_endDateEdt", texto);
	}
	
	public void campoVencimentoInicial(String texto) {
		escreverID("dtVencimento_startDateEdt", texto);
	}
	
	public void campoVencimentoFinal(String texto) {
		escreverID("dtVencimento_endDateEdt", texto);
	}
	
	public void campoAReceber(String texto) {
		escreverID("numValorAReceber_startNumEdt", texto);
	}
	
	public void campoSubsessao(String texto) throws InterruptedException {
		escreverID("lkpSubsecaoEdt", texto + Keys.ENTER);
		esperaFixa(2000);
	}
	
	public String validarTextoConsultaPosicaoFinanceiraFiltrosAvancados() {
		return obterTexto("ANUIDADE - ADRIANA APARECIDA LUZETTI - Contas a Receber nº 000000365696");
	}
	
	//****** Alterar Situação Complemento Contas a Receber ******//
	
	public void AlterarSituacaoComplemento() {
		clicarBotaoXpath("//*[text()='Alterar situação/complemento']");
	}
	
	public void campoComplemento(String texto) {
		escreverID("cbComplementoSituacaoEdt", texto + Keys.ENTER);		
	}
	
	public String validarTextoAlterarSituacaoComplemento() {
		return obterTexto("Suspenso Temporariamente");
	}
	
	//****** Recebimnentos ******//
	
	public void recebimentos() {
		clicarBotaoSelector("div[title='Recebimentos']");	
	}
	
	//****** Renegociação *******//
	
	public void renegociacao() {
		clicarBotaoSelector("div[title='Renegociação']");
	}
	
	//****** Atualização *******//
	
	public void atualizacao() {
		clicarBotaoSelector("div[title='Atualização']");		
	}	
	
	//****** Imprimir Boleto *******//
	
	public void imprimirBoleto() {
		clicarBotaoSelector("div[title='Imprimir Boleto']");		
	}
	
	public String validarTextoImprimirBoleto() {
		return obterTexto("Emissão de Boletos");
	}
    
	//***** Boleto Por E-mail *****//
	
	public void boletoPorEmail() {
		clicarBotaoXpath("//*[text()='Boleto por e-mail']");		
	}
	
	public String validarTextoBoletoPorEmail() {
		return obterTexto("OK");	
	}
	
	//***** Emissão Relatórios *****//
	
	public void imprimirRelatorio() {
		clicarBotaoXpath("//*[text()='Imprimir Relatório']");
	}
	


}
