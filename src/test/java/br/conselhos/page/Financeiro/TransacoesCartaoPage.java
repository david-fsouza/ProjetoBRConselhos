package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class TransacoesCartaoPage extends BasePage {


    /*********************** TELA PRINCIPAL TRANSA��ES CARTãO *****************************************************************************/

    //******************** Consultar Registro Transa��es Cartão **************************************************************************//

    public void inserirCampoFiltrar(String texto) {
    	escreverXpath("/html/body/form/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div/div/div[5]/div/div[2]/input", texto + Keys.ENTER);
    }
    
    public void selecionarResultadoBusca(String resultadobusca) throws InterruptedException { 
    	esperaFixa(1000);
    	clicarBotaoSelector("div[title='" + resultadobusca + "']");
    }
    
    public String obterTextoTransacoesCartao() {
    	return obterTextoXpath("//*[text()='Permite visualizar as transa��es envolvendo cart�o de cr�dito']");   	
    }
    
    /*********************** MENU LATERAL TELA SOBREPOSTA ********************************************************************************/	
    
    //***************************** Liquida��es *****************************************************************************************//
    
    public void abaLiquidacoes() {
    	clicarLink("Liquida��es");
    	entrarFrame("#panelcategory1>iframe");
    }
    
    public String obterTextoLiquidacoes() {
    	return obterTextoCss("div[title='Quitado']");  	
    }
    
    //******************************* t�tulos ******************************************************************************************//
    
    public void abaTitulos() {
    	clicarLink("T�tulos");
    	entrarFrame("#panelcategory2>iframe");  	
    }
    
    public String obterTextoTitulos() throws InterruptedException {
    	esperaFixa(1000);
    	return obterTextoXpath("//*[text()='Nenhum registro.']");  	
    }
    
    
}   
    

