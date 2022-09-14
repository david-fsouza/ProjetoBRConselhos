package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;
import br.conselhos.page.FramesPage;

public class RenegociacaoSimplificadaPage extends BasePage {
	private FramesPage frame = new FramesPage();
	
	//****** Efetuar Renegociacao Simplificada ******//
	
	public void campoPessoaFisica(String texto) throws InterruptedException {
		clicarBotaoID("lkPessoaEdt");
		escreverID("lkPessoaEdt", texto + Keys.ENTER);
		esperaFixa(5000);
		digitaTeclaId("lkPessoaEdt", Keys.TAB);
		esperaFixa(2000);
	}
	
	public void campoTipoDeInscricao() throws InterruptedException {
		clicarBotaoID("cbTipoInscricaoEdt");
		sairFrame();
		esperaExplicita("div[title='INSCRI��O DEFINITIVA PRINCIPAL (AUXILIAR DE ENFERMAGEM)']");
		clicarBotaoSelector("div[title='INSCRI��O DEFINITIVA PRINCIPAL (AUXILIAR DE ENFERMAGEM)']");
		frame.frameDireita();
		frame.frameDireita2();
		esperaFixa(2000);	
	}
	
	public void campoplanoDePagamento() throws InterruptedException {
		clicarBotaoID("cbPlanoPagamentoEdt");
		sairFrame();
		esperaExplicita("div[title='Parcelamento de Anuidades']");
		clicarBotaoSelector("div[title='Parcelamento de Anuidades']");
		frame.frameDireita();
		frame.frameDireita2();
		esperaFixa(2000);
	}
	
	public void campoQuantidadeDeParcelas() throws InterruptedException {
		clicarBotaoID("cbParcelasEdt");
		sairFrame();
		esperaExplicita("div[title='3']");
		clicarBotaoSelector("div[title='3']");
		frame.frameDireita();
		frame.frameDireita2();
		esperaFixa(2000);
	}	
	
	public String obterTextoNovoRenegociacaoSimplificada() {
		return obterTextoXpath("//*[text()='Informa��es da renegocia��o']");
	}

}
