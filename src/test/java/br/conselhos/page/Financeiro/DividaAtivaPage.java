package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class DividaAtivaPage extends BasePage {
	
	/************************ TELA PRINCIPAL D�vida ATIVA ********************************************************************************/
	
	//*********************** Novo Registro D�vida Ativa ********************************************************************************//
	
	public String obterTextoNovoRegistroDividaAtiva() {
		return obterTextoXpath("//*[text()='N�mero da certid�o']");	
	}
	
	//*************************** Consulta D�vida Ativa ********************************************************************************//
	
	public void selecionarRegistro() {
		clicarBotaoSelector("div[title='Teste d�vida ativa']");
	}
	
	public String obterTextoConsultaDividaAtiva() {
		return obterTextoCss("div[title='12.345']");
	}
	
	//************************* Impress�o r�pida D�vida Ativa ***************************************************************************//
    
	public void funcoes() {
		clicarBotaoXpath("/html/body/form/div/div/div/div/div/div/div[1]/div/div[1]/div/div/div[1]/em/button/span[1]");
	}
	
	public void impressaoRapida() {
		clicarBotaoXpath("//*[text()='Impress�o r�pida']");
	}
	
	public String obterTextoImpressaoRapida() {
		return obterTextoXpath("//*[text()='Avan�ar']");
		
	}
}
