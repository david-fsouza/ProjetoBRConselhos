package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class ConfiguracaoDeRepassesAutomaticosPage extends BasePage {



    /********************  TELA NOVO REGISTRO REPASSES AUTOMATICOS  *******************************************************************/
    
    //********************** Novo Registro Repasses AutomÃ£ticos***********************************************************************//

    public void campoNomeDoRepasse(String texto) {
    	escrever("NomeRepasse", texto);
    }
    
    public void salvareFechar() {
    	clicarBotaoID("SaveAndClose_CaixaBancoConfigRepasseReceita");
    }
    
    public String obterTextoRepassesAutomaticos() {
    	esperaExplicita("div[title='Teste novo registro']");
    	return obterTextoCss("div[title='Teste novo registro']");   	
    }
    
    //***************************** Abas Laterais Registro ****************************************************************************//
    
    public void selecionarRegistroRepasseAutomaticos() {
    	clicarBotaoSelector("div[title='Teste abas']");
    }
    
    public void abaInformacoesDeRepasse() {
    	clicarLink("Informações de Repasse");
    	entrarFrame("#panelcategory1>iframe");
    }
    
    public String obterTextoInformacoesDeRepasse() throws InterruptedException {
    	esperaFixa(2000);
    	return obterTextoXpath("//*[text()='Nenhum registro.']");
    }
    
    //*********************************** Receittas **********************************************************************************//
    
    public void abaReceitas() {
    	clicarLink("Receitas");
    	entrarFrame("#panelcategory2>iframe");
    }
    
    public String obterTextoReceitas() {
    	return obterTextoXpath("//*[text()='Nenhum registro.']");
    }
    
    
    
    
}