package br.conselhos.page.Financeiro;


import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class IntegracaoBancariaPage extends BasePage {
	
	/*******************  TELA INICIAL Integração bancária RETORNO ***********************************/
	
	//********************** Novo Registro Integração bancária **************************************//
	
	
	public void botaoNovo() {
		clicarBotaoXpath("/html/body/form/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div[7]/em/button/span[1]");
	}
	public String obterTextoNovoRegistroRetorno() {
		return obterTextoXpath("//*[text()='Integração Bancária de Retorno ou Remessa']");
	}
	
	//************************** Consulta Registro Remessa ***********************************************//
	
	public void selecionarReultadoBusca(String texto) {
		clicarBotaoSelector("div[title='" + texto + "']");
	}
	
	public String obterTextoRegistroRetorno() {
		return obterTextoXpath("//*[text()='Informações do Arquivo']");
	}
	
	//******************************* Itens Liquidação ***************************************************//
	
	public void abaItens() {
		clicarLink("Itens");
		entrarFrame("#panelcategory1>iframe");	
	}
	
	public String obterTextoItensLiquidacao() {
		return obterTextoCss("div[title='Título está com situação Pago.']");
	}
	
	//***************************** Itens Outros Movimentos *********************************************//
	
	public void outrosMovimentos() {
		clicarBotaoXpath("//*[text()='Outros movimentos']");
	}
	
	public String obterTextoOutrosMovimentos() {
		return obterTextoCss("div[title='Confirmação de Entrada de Título']");
	}
	
	/*******************  TELA INICIAL Integração bancária REMESSA **************************************/
	
	//****************** Novo Registro Integração bancária Remessa *************************************//
	
	public void remessa() {
		clicarBotaoXpath("//*[text()='Remessa']");
	}
	
	public String obterTextoRemessa() {
		return obterTextoXpath("//*[text()='Permite gerar arquivo de texto com as informações do sistema.']");
	}
	
	//********************** Consulta Registro Integração Remessa **************************************//
	
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
		return obterTextoCss("div[title='Geração de nosso número']");
	}
	
	//************************************ Histórico ****************************************************//
	
	public void historico() {
		clicarBotaoID("historytbtn_IntegracaoBancariaRemessa");
	}
	
	public String obterTextoHistorico() {
		return obterTextoXpath("//*[text()='Histórico']");
	}
	
	

}
