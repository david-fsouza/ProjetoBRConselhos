package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class PagamentoAutomatizadoPage extends BasePage {
	

    /****************** TELA INICIAL PAGAMENTO AUTOMATIZADO RETORNO *********************************************************************************/

    //***************** Novo Registro Pagamento Automatizado Retorno *******************************************************************************//

    public String obterTextoPagamentoAutomatizadoRetorno() {
    	return obterTextoXpath("//*[text()='Pagamento Automatizado de Retorno ou Remessa']");
    }
    
    //******************** Consulta Registro Pagemento Automatizado ********************************************************************************//
    
    public void inserirCampoFiltrar(String texto) {
    	escreverXpath("//input[contains(@id,'filterTBX_gridpanel') and contains(@name, 'tabCt_0')]", texto + Keys.ENTER);
    }
    
    public void selecionarResultadoBusca(String texto) {
    	esperaExplicita("div[title='" + texto + "']");
    	clicarBotaoSelector("div[title='" + texto + "']");
    }
    
    public String obterTextoConsultaPagamentoAutomatizado() {
    	return obterTextoXpath("//*[text()='Informações do Arquivo']");
    }
    
    //******************************** Itens Liquidação *************************************************************************************************//
    
    public void abaItens() {
    	clicarLink("Itens");
    	entrarFrame("#panelcategory1>iframe");
    }
    
    public String obterTextoItensLiquidacao() {
    	return obterTextoXpath("//*[text()='Nenhum registro.']");	
    }
    
    public void outrosMovimentos() {
    	clicarBotaoXpath("//*[text()='Outros movimentos']");
    }
    
    public String obterTextoItensOutrosMovimentos() {
    	return  obterTextoXpath("//*[text()='Nenhum registro.']");	
    }
    
    
}    