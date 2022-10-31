package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;
import br.conselhos.page.FramesPage;

public class RenegociacaoSimplificadaPage extends BasePage {
	private FramesPage frame = new FramesPage();
	
	//****** Efetuar Renegociacao Simplificada ******//
	
	public void campoPessoaFisica(String texto) throws InterruptedException {
		clicarBotaoID("lkPessoaEdt");
		escreverID("lkPessoaEdt", texto);
		esperaFixa(3000);
		digitaTeclaId("lkPessoaEdt", Keys.TAB);
		esperaFixa(3000);
	}
	
	public void campoTipoDeInscricao(String texto) throws InterruptedException {
		clicarBotaoID("cbTipoInscricaoEdt");
		escreverID("cbTipoInscricaoEdt", texto);
		esperaFixa(1000);
		digitaTeclaId("cbTipoInscricaoEdt", Keys.ENTER);
        esperaFixa(1000);
	}
	
	public void campoplanoDePagamento(String texto) throws InterruptedException {
		clicarBotaoID("cbPlanoPagamentoEdt");
		escreverID("cbPlanoPagamentoEdt", texto);
        esperaFixa(1000);
		digitaTeclaId("cbPlanoPagamentoEdt", Keys.ENTER);
        esperaFixa(1000);
	}
	
	public void campoQuantidadeDeParcelas(String texto) throws InterruptedException {
		clicarBotaoID("cbParcelasEdt");
		escreverID("cbParcelasEdt", texto);
		esperaFixa(1000);
	    digitaTeclaId("cbParcelasEdt", Keys.ENTER);
		esperaFixa(1000);
	}	
	
	public String obterTextoNovoRenegociacaoSimplificada() {
		return obterTextoXpath("//*[text()='Informações da renegociação']");
	}

}
