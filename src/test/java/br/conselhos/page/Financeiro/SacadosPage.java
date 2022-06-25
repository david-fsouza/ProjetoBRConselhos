package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class SacadosPage extends BasePage {
	
	/***************************** TELA INICIAL SACADOS ******************************************************************************/
	
	//**************************** Novo Registro Sacados ****************************************************************************//
	
	public String obterTextoNovoRegistroSacados() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações de sacados.']");
	}
	
	//********************************* Endereços **********************************************************************************//
	
	public void enderecos() {
		clicarBotaoSelector("div[title='Endereços']");		
	}
	
	public String obterTextoEnderecos() {
		return obterTextoXpath("//*[text()='CEP']");
	}
	
	//******************************* Contabilizaçõo ********************************************************************************//
	
	public void contabilizacao() {
		clicarBotaoSelector("div[title='Contabilização']");
	}
	
	public String obterTextoContabilizacao() {
		return obterTextoXpath("//*[text()='Cta. Financeira']");
	}
	
	//*************************** Consulta Registro Sacados *************************************************************************//
	
    public void inserirCampoFiltrar(String texto) {
    	escreverXpath("//input[contains(@id,'filterTBX_gridpanel') and contains(@name, 'tabCt_0')]", texto + Keys.ENTER);
    }
    
    public void selecionarResultadoBusca(String texto) {
    	clicarBotaoSelector("div[title='" + texto + "']");
    }
    
    public String obterTextoConsultaRegistroSacados() {
    	return obterTextoXpath("//*[text()='CPF']");
    }
    
    //*********************************** Histórico *********************************************************************************//
    
    public void historico() {
    	clicarBotaoID("historytbtn_PessoaSacado");
    }
    
	public String obterTextoHistorico() {
		return obterTextoXpath("//*[text()='Histórico']");
	}	
	
	//*********************************** Log Registro ******************************************************************************//
	
	public void log() {
		clicarBotaoID("logbtn_PessoaSacado");
	}
	
	public String obterTextoLogRegistro() {
		return obterTextoXpath("//*[text()='Log']");
		
	}
	

}
