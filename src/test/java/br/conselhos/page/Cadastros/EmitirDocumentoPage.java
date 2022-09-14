package br.conselhos.page.Cadastros;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class EmitirDocumentoPage extends BasePage {
	
	//*******Emitir Documento *******//
	
	public void campoModeloDocumento(String texto) throws InterruptedException {
		clicarBotaoID("m_lkModeloDocumentoEdt");
		escreverID("m_lkModeloDocumentoEdt", texto);
		esperaFixa(3000);
		digitaTeclaId("m_lkModeloDocumentoEdt", Keys.ENTER);	
	}
	
	public void campoPessoa(String texto) throws InterruptedException {
		clicarBotaoID("HistoricoInscricaoCategoria_PessoaEdt");
		escreverID("HistoricoInscricaoCategoria_PessoaEdt", texto);
		esperaFixa(1000);
		digitaTeclaId("HistoricoInscricaoCategoria_PessoaEdt", Keys.ENTER);
		esperaFixa(1000);
	}

}
