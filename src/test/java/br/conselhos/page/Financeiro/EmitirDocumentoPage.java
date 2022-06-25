package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class EmitirDocumentoPage extends BasePage {
	
	//************************ Consulta Emitir Documento ********************************************************//
	
	public void campoModeloDocumento() throws InterruptedException {
		clicarBotaoID("m_lkModeloDocumentoEdt");
		esperaFixa(1000);
		digitaTeclaId("m_lkModeloDocumentoEdt", Keys.ENTER);	
	}
	
	public void avancar() {
		clicarBotaoXpath("//*[text()='Avançar']");
	}
	
	public String obterTextoConsultaEmitirDocumento() {
		entrarFrame("#iFrameMain_01");
		return obterTextoXpath("//*[text()='Pessoa']");
	}

}
