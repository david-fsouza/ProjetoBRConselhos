package br.conselhos.page.Financeiro;

import java.awt.Frame;

import br.conselhos.core.BasePage;

public class IndiceseMoedasPage extends BasePage {
	
	/***************************** TELA Índices E MOEDAS **********************************************************************************************/
	
	//**************************** Novo Índices e Moedas *********************************************************************************************//
	
	public String obterTextoNovoIndiceseMoedas() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações de índices, moedas ou taxas.']");
	}
	
	//************************** Consulta Índices e Moedas *******************************************************************************************//
	
	public String obterTextoConsultaIndiceseMoedas() {
		return obterTextoXpath("//*[text()='Sigla']");
	}
	
	//***************** MENU LATERAL TELA SOBREPOSTA Índices E MOEDAS ********************************************************************************//
	
	//********************************** Cotações ****************************************************************************************************//
	
	public void abaCotacoes() {
		
		sairFrame();
		clicarBotaoSelector("div[title='OK']");
		entrarFrame("div[class='x-fr-body x-win-body x-noscroll']>iframe");
		clicarLink("Cotações");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoCotacoes() {
		return obterTextoXpath("//*[text()='Percentual/ Valor']");
	}
	
	//***************************** Período de Suspensão *********************************************************************************************//
    
	public void abaPeriodoDeSuspensao() {
		sairFrame();
		clicarBotaoSelector("div[title='OK']");
		entrarFrame("div[class='x-fr-body x-win-body x-noscroll']>iframe");
		clicarLink("Período de Suspensão");
		entrarFrame("#panelcategory3>iframe");
	}
	
	public String obterTextoPeriodoDeSuspensao() {
		return obterTextoCss("div[title='Teste Período de Suspensão']");
	}
	
	/************************ TELA Índices E MOEDAS - serviços **************************************************************************************/
	
	//************************************ Faixas **************************************************************************************************//
	
	public void IndiceseMoedasServicos() {
		clicarBotaoSelector("div[title='Índices e moedas - serviços']");
	}
	
	public void abaFaixas() {
		clicarLink("Faixas");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public String obterTextoFaixas() {
		return obterTextoCss("div[title='acima de']");
	}
	
}
