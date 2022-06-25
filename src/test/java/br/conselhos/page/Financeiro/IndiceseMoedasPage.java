package br.conselhos.page.Financeiro;

import java.awt.Frame;

import br.conselhos.core.BasePage;

public class IndiceseMoedasPage extends BasePage {
	
	/***************************** TELA �ndices E MOEDAS **********************************************************************************************/
	
	//**************************** Novo �ndices e Moedas *********************************************************************************************//
	
	public String obterTextoNovoIndiceseMoedas() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es de �ndices, moedas ou taxas.']");
	}
	
	//************************** Consulta �ndices e Moedas *******************************************************************************************//
	
	public String obterTextoConsultaIndiceseMoedas() {
		return obterTextoXpath("//*[text()='Sigla']");
	}
	
	//***************** MENU LATERAL TELA SOBREPOSTA �ndices E MOEDAS ********************************************************************************//
	
	//********************************** Cota��es ****************************************************************************************************//
	
	public void abaCotacoes() {
		
		sairFrame();
		clicarBotaoSelector("div[title='OK']");
		entrarFrame("div[class='x-fr-body x-win-body x-noscroll']>iframe");
		clicarLink("Cota��es");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoCotacoes() {
		return obterTextoXpath("//*[text()='Percentual/ Valor']");
	}
	
	//***************************** Per�odo de Suspens�o *********************************************************************************************//
    
	public void abaPeriodoDeSuspensao() {
		sairFrame();
		clicarBotaoSelector("div[title='OK']");
		entrarFrame("div[class='x-fr-body x-win-body x-noscroll']>iframe");
		clicarLink("Per�odo de Suspens�o");
		entrarFrame("#panelcategory3>iframe");
	}
	
	public String obterTextoPeriodoDeSuspensao() {
		return obterTextoCss("div[title='Teste Per�odo de Suspens�o']");
	}
	
	/************************ TELA �ndices E MOEDAS - servi�os **************************************************************************************/
	
	//************************************ Faixas **************************************************************************************************//
	
	public void IndiceseMoedasServicos() {
		clicarBotaoSelector("div[title='�ndices e moedas - servi�os']");
	}
	
	public void abaFaixas() {
		clicarLink("Faixas");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public String obterTextoFaixas() {
		return obterTextoCss("div[title='acima de']");
	}
	
}
