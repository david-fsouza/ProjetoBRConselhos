package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class DividaAtivaPage extends BasePage {
	
	/************************ TELA PRINCIPAL Dívida ATIVA ********************************************************************************/
	
	//*********************** Novo Registro Dívida Ativa ********************************************************************************//
	
	public String obterTextoNovoRegistroDividaAtiva() {
		return obterTextoXpath("//*[text()='Número da certidão']");	
	}
	
	//*************************** Consulta Dívida Ativa ********************************************************************************//
	
	public void selecionarRegistro() {
		clicarBotaoSelector("div[title='Teste dívida ativa']");
	}
	
	public String obterTextoConsultaDividaAtiva() {
		return obterTextoCss("div[title='12.345']");
	}
	
	//************************* Impressão rápida Dívida Ativa ***************************************************************************//
    
	public void funcoes() {
		clicarBotaoXpath("/html/body/form/div/div/div/div/div/div/div[1]/div/div[1]/div/div/div[1]/em/button/span[1]");
	}
	
	public void impressaoRapida() {
		clicarBotaoXpath("//*[text()='Impressão rápida']");
	}
	
	public String obterTextoImpressaoRapida() {
		return obterTextoXpath("//*[text()='Avançar']");
		
	}
}
