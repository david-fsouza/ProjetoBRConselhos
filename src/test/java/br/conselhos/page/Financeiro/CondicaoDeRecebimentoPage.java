package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class CondicaoDeRecebimentoPage extends BasePage {
	
	/************************** TELA Condi��o DE RECEBIMENTO *********************************************************************************************/
	
	//************************* Novo Condi��o de Recebimento ********************************************************************************************//
	
	public String obterTextoNovoCondicaoDeRecebimento() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar as configura��es das condi��es para pagamento/recebimento.']");
	}
	
	//************************ Consulta Condi��o de Recebimento *****************************************************************************************//
	
	public String obterTextoConsultaCondicaoDeRecebimento() {
		return obterTextoXpath("//*[text()='Organiza��o']");
	}
	
	//******************************** Formas de Liquid. ***********************************************************************************************//
	
	public void abaFormasLiquid() {
		clicarLink("Formas liquid.");
		entrarFrame("#panelcategory1>iframe");		
	}
	
	public String obterTextoFormasLiquid() {
		return obterTextoCss("div[title='Recebimento manual']");
	}
	
	//*********************************** Instrucoes ***************************************************************************************************//
	
	public void abaInstrucoes() {
		clicarLink("Instru��es");
		entrarFrame("#panelcategory2>iframe");		
	}
	
	public String obterTextoInstrucoes() {
		return obterTextoCss("div[title='N�o receber ap�s o vencimento']");
	}

}
