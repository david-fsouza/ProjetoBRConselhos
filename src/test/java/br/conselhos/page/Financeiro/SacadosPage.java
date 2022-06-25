package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class SacadosPage extends BasePage {
	
	/***************************** TELA INICIAL SACADOS ******************************************************************************/
	
	//**************************** Novo Registro Sacados ****************************************************************************//
	
	public String obterTextoNovoRegistroSacados() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es de sacados.']");
	}
	
	//********************************* Endere�os **********************************************************************************//
	
	public void enderecos() {
		clicarBotaoSelector("div[title='Endere�os']");		
	}
	
	public String obterTextoEnderecos() {
		return obterTextoXpath("//*[text()='CEP']");
	}
	
	//******************************* Contabiliza��o ********************************************************************************//
	
	public void contabilizacao() {
		clicarBotaoSelector("div[title='Contabiliza��o']");
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
    
    //*********************************** Hist�rico *********************************************************************************//
    
    public void historico() {
    	clicarBotaoID("historytbtn_PessoaSacado");
    }
    
	public String obterTextoHistorico() {
		return obterTextoXpath("//*[text()='Hist�rico']");
	}	
	
	//*********************************** Log Registro ******************************************************************************//
	
	public void log() {
		clicarBotaoID("logbtn_PessoaSacado");
	}
	
	public String obterTextoLogRegistro() {
		return obterTextoXpath("//*[text()='Log']");
		
	}
	

}
