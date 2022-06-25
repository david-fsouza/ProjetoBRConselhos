package br.conselhos.page.Financeiro;


import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class IntegracaoBancariaPage extends BasePage {
	
	/*******************  TELA INICIAL Integra��o banc�ria RETORNO ***********************************/
	
	//********************** Novo Registro Integra��o banc�ria **************************************//
	
	
	public void botaoNovo() {
		clicarBotaoXpath("/html/body/form/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div[7]/em/button/span[1]");
	}
	public String obterTextoNovoRegistroRetorno() {
		return obterTextoXpath("//*[text()='Integra��o Banc�ria de Retorno ou Remessa']");
	}
	
	//************************** Consulta Registro Remessa ***********************************************//
	
	public void selecionarReultadoBusca(String texto) {
		clicarBotaoSelector("div[title='" + texto + "']");
	}
	
	public String obterTextoRegistroRetorno() {
		return obterTextoXpath("//*[text()='Informa��es do Arquivo']");
	}
	
	//******************************* Itens Liquida��o ***************************************************//
	
	public void abaItens() {
		clicarLink("Itens");
		entrarFrame("#panelcategory1>iframe");	
	}
	
	public String obterTextoItensLiquidacao() {
		return obterTextoCss("div[title='T�tulo est� com situa��o Pago.']");
	}
	
	//***************************** Itens Outros Movimentos *********************************************//
	
	public void outrosMovimentos() {
		clicarBotaoXpath("//*[text()='Outros movimentos']");
	}
	
	public String obterTextoOutrosMovimentos() {
		return obterTextoCss("div[title='Confirma��o de Entrada de T�tulo']");
	}
	
	/*******************  TELA INICIAL Integra��o banc�ria REMESSA **************************************/
	
	//****************** Novo Registro Integra��o banc�ria Remessa *************************************//
	
	public void remessa() {
		clicarBotaoXpath("//*[text()='Remessa']");
	}
	
	public String obterTextoRemessa() {
		return obterTextoXpath("//*[text()='Permite gerar arquivo de texto com as informa��es do sistema.']");
	}
	
	//********************** Consulta Registro Integra��o Remessa **************************************//
	
	public void inserirCampoFiltrarRemessa(String texto) {
		escreverXpath("//input[contains(@id,'filterTBX_gridpanel') and contains(@name, 'tabCt_1')]", texto + Keys.ENTER);
	}
	
	public String obterTextoRegistroRemessa() {
		return obterTextoXpath("//*[text()='Total de registros']");
	}
	
	//*********************************** Movimentos ****************************************************//
	
	public void abaMovimentos() {
		clicarLink("Movimentos");
		entrarFrame("#panelcategory1>iframe");		
	}
	
	public String obterTextoMovimentos() {
		return obterTextoCss("div[title='Gera��o de nosso n�mero']");
	}
	
	//************************************ Hist�rico ****************************************************//
	
	public void historico() {
		clicarBotaoID("historytbtn_IntegracaoBancariaRemessa");
	}
	
	public String obterTextoHistorico() {
		return obterTextoXpath("//*[text()='Hist�rico']");
	}
	
	

}
