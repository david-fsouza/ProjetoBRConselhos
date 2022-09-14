package br.conselhos.page;

import static br.conselhos.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.conselhos.core.BasePage;

public class FramesPage extends BasePage {
	
	    /****************
	     * FRAMES GLOBAIS
	     ****************/

	    public void TelaSobreposta() {
		    entrarFrameDefault("div[class='x-fr-body x-win-body x-noscroll']>iframe");
	    }
	    
	    public void TelaSobreposta2() {
	    	entrarFrameDefault(By.xpath("//div[contains(@class, 'x-fr-body x-win-body x-noscroll') and contains(@style, 'height: 523px;')]/iframe"));
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
	    
	    public void frameDireita2() {
	    	entrarFrame(By.xpath("//*[@id='tabCt_0']/div/div/div/table/tbody/tr/td/iframe"));
	    }
	    
	    public void mainFrame() {
	    	entrarFrame("#MainFrm");
	    }
	    
	    /*******************
	     * FRAMES FINANCEIRO
	     *******************/
	    
	    
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
	    
	    public void GeracaoDeTitulosFrame2() {
	    	entrarFrame("#divIFrameGenerico>iframe");
	    }
	    
	    /******************
	    * FRAMES CADASTROS
	    ******************/
	    
	    /******** PESSOAS *********/
	    
	    //******* Tela Novo Vinculo Profissional
	    public void novoVinculoProfissional() {
	        entrarFrameDefault(By.xpath("//*[contains(@src, 'Pessoa.PessoaCategoria')]"));
	    }
	    
	    //******* Tela Inscrições ********//    
	    public void inscricoes() {
	    	entrarFrameDefault(By.xpath("//*[contains(@src, 'HistoricoInscricaoCategoria.Pessoa')]"));
	    	
	    }
	    
	    /******** SOCIEDADES ********/
	    
	    //******* Adicionar e Editar Socios *******//
	    public void socios() {
	    	entrarFrameDefault(By.xpath("//*[contains(@src, 'Pessoa.Sociedade')]"));
	    }
	    
	    //******** Registrar Alteraçoes Contratuais ********//
	    public void registrarAlteracoesContratuais() {
	    	entrarFrameDefault(By.xpath("//*[contains(@src, 'RegistrarHistoricoSociedade')]"));
	    }
	    
	    /******** EMITIR DOCUMENTO  ********/
	    
	    //******* Tela Filtros Emitir Documento *******//
	    public void filtrosEmitirDocumento() {
	    	entrarFrame("#iFrameMain_01");
	    }
	    
	    public void documentosEmitirDocumento() throws InterruptedException {
	    	esperaFixa(5000);
	    	frameDireita();
	    	frameDireita2();
	    	entrarFrame(By.name("iFrameChild_01"));
	    	entrarFrame("#iFrameMain_01_01");
	    }

}
