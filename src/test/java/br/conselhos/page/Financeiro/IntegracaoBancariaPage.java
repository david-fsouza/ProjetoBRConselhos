package br.conselhos.page.Financeiro;


import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class IntegracaoBancariaPage extends BasePage {
	
	/*******************  TELA INICIAL Integração bancária RETORNO ***********************************/
	
	
	/**
	 * TELA INICICAL REMESSA
	 */
	
	//****** Geração Arquivo Remessa ********//
	
	public void remessa() {
		clicarBotaoXpath("//*[text()='Remessa']");
	}
	
	public void campoTipo(String texto) throws InterruptedException {
		esperaFixa(1000);
		escreverID("cbTipoEdt", texto);
		esperaFixa(1000);
		digitaTeclaId("cbTipoEdt", Keys.ENTER);
	}
	
	public void campoCategoria(String texto) {
		clicarBotaoID("cbCategoriaEdt");
		sairFrame();
		clicarBotaoSelector("div[title='" + texto + "']");
	}
	
	public void campoCarteiraDeCobranca(String texto) throws InterruptedException {
		escreverID("cbCarteiraCobrancaEdt", texto + Keys.ENTER);
		esperaFixa(1000);			
	}
	
	public void campoNossoNumero(String texto) throws InterruptedException {
		escreverID("cbNossoNumeroEdt", texto + Keys.ENTER);
		esperaFixa(1000);		
	}
	
	public void campoMaxRegistrosArquivo(String texto) throws InterruptedException {
		escreverID("numMaxRegistrosEdt", texto + Keys.ENTER);
		esperaFixa(1000);	
	}
	
	public String validarTextoGeracaoArquivoRemessa() {
		sairFrame();
		return obterTexto("Arquivo gerado.");
	}
	
}
