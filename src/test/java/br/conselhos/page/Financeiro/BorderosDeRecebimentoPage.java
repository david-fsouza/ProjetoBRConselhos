package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class BorderosDeRecebimentoPage extends BasePage {

    
    /******************* TELA PRINCIPAL BORDERãS DE RECEBIMENTO ************************************************************************/

    //******************* Novo Registro Borderãs de Recebimento ***********************************************************************//
    public void Novo() {
    	clicarBotaoXpath("/html/body/form/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div[7]/em/button/span[1]");
    }
    public String obterTextoNovoRegistroBorderosRecebimento() {
    	return obterTextoXpath("//*[text()='Permite visualizar os border�s de recebimento']");    	
    }
    
    //*********************** Consulta Border�s de Recebimento ************************************************************************//
    
    public void inserirCampoFiltrarRetorno(String texto) {
		escreverXpath("//input[contains(@id,'filterTBX_gridpanel') and contains(@name, 'tabCt_0')]", texto + Keys.ENTER);	
	}
	
	public void selecionarReultadoBusca(String texto) {
		clicarBotaoSelector("div[title='" + texto + "']");
	}
	
	public String obterTextoConsultaBorderosRecebimento() {
		return obterTextoXpath("//*[text()='Valor total recebido']");
	}
	
	//************************** Borderãs de Recebimento Itens ************************************************************************//
	
	public void Itens() {
		clicarLink("Itens");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoNovoRegistroItens() {
		return obterTextoXpath("//*[text()='Titular']");
	}
	
	
    	
}