package br.conselhos.page;

import static br.conselhos.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.conselhos.core.BasePage;

public class FramesPage extends BasePage {

	    public void frameTelaSobreposta() {
		    entrarFrameDefault("div[class='x-fr-body x-win-body x-noscroll']>iframe");
	    }
	    
	    public void frameTelaSobreposta2() {
	    	entrarFrame(By.xpath("//div[contains(@class, 'x-fr-body x-win-body x-noscroll') and contains(@style, 'height: 523px;')]/iframe"));
	    }
		
		public void frameDireita() {
			entrarFrameDefault("#rightCt>iframe");
		}	
			
	    public void sairFrame() {                                                  
			getDriver().switchTo().defaultContent();
	    }
	    
	    public void framePrincipal() {
	    	entrarFrame("#mainCt>iframe");
	    }
			
	    public void trocarJanela(String id) {                                          
		    getDriver().switchTo().window(id);
		}
	    
	    public void frameDireita2() {
	    	entrarFrame(By.xpath("//*[@id='tabCt_0']/div/div/div/table/tbody/tr/td/iframe"));
	    }
	    
	    /*************************** FRAMES FINANCEIRO *******************************************************************/
	    
	    
	    public void frameNovoRegistroTesouraria() {
	    	entrarFrame("#win_tesouraria_proxy");
	    }
	    
	    public void chamadaExternContasReceber() {
	    	entrarFrame("#win_ContaReceber_proxy");
	    }
	    
	    public void historicoDeContatos () {
	    	entrarFrame("#win_Historico_proxy");
	    }
	    
	    public void contato() {
	    	entrarFrame("#win_Contato_proxy");
	    }
	    
	    public void consultaDetalheInadimplente() {
	    	entrarFrame("#win_consultaDetalheInadimplente_proxy");
	    }

}
