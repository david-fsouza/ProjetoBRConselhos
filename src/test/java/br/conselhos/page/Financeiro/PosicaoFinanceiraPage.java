package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class PosicaoFinanceiraPage extends BasePage {
	
	/********************* TELA NOVO REGISTRO POSIçõO FINANCEIRA *********************************************/
	
	//********************        Integração Contas Receber      *******************************//
	
	public String obterTexto(String texto) {
		esperaExplicitaXpath("//*[text()='" + texto +"']");
		return obterTextoXpath("//*[text()='" + texto +"']");
	}
	
	//********************* Consulta Registro Posiçõo Financeira ************************************************//
	
	public void campoSacado(String texto) throws InterruptedException {
		escreverID("lkpSacadoEdt", texto);
	    esperaFixa(3000);
	    digitaTeclaId("lkpSacadoEdt", Keys.ENTER);
	    esperaFixa(4000);
	}
	
	public void selecionarResultadoBusca(String texto) {
		clicarBotaoXpath("//*[text()='" + texto + "']");
	}
	
	public void botaoLocalizar() {
		clicarBotaoXpath("//*[text()='Localizar']");
	}

}
