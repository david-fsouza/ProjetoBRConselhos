package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class CondicaoDeRecebimentoPage extends BasePage {
	
	/************************** TELA Condição DE RECEBIMENTO *********************************************************************************************/
	
	//************************* Novo Condição de Recebimento ********************************************************************************************//
	
	public String obterTextoNovoCondicaoDeRecebimento() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar as configurações das condições para pagamento/recebimento.']");
	}
	
	//************************ Consulta Condição de Recebimento *****************************************************************************************//
	
	public String obterTextoConsultaCondicaoDeRecebimento() {
		return obterTextoXpath("//*[text()='Organização']");
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
		clicarLink("Instruções");
		entrarFrame("#panelcategory2>iframe");		
	}
	
	public String obterTextoInstrucoes() {
		return obterTextoCss("div[title='Não receber após o vencimento']");
	}

}
