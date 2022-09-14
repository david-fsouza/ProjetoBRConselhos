package br.conselhos.page.Financeiro;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class GeracaoDeTitulosPage extends BasePage {
	
	
	//****** Gera��o de T�tulos Selecionados *****//
	
	public void campoAno(String texto) {
        escreverID("m_nbAnoEdt", texto);
	}
	
	public void campoValor(String texto) {
		escreverID("m_nbValorEdt", texto);
	}
	
	public void campoTipoLancamento(String texto) throws InterruptedException {
		escreverID("m_cbTipoLancamentoEdt", texto + Keys.ENTER);
		esperaFixa(2000);
	}
	
    public void campoCondicao(String texto) throws InterruptedException {
	    escreverID("m_lkCondicaoEdt", texto + Keys.ENTER);
	    esperaFixa(2000);
    }
    
    public void campoVencimentoParcela() throws InterruptedException {
    	dataFutura("m_dtVctoPrimeiraParcelaEdt", 20);
    }
    
    public void campoPessoa(String texto) throws InterruptedException {
    	escreverID("m_lkPessoaEdt", texto + Keys.ENTER);
    	esperaFixa(2000);
    }
    
    public void gerarParaSelecionados() {
    	clicarBotaoSelector("div[title='Gerar para selecionados']");
    }
    
	public String validarTextoGeracaoTitulosSelecionados() {
		sairFrame();
		return obterTexto("Gera��o de t�tulos a receber conclu�da.");
	}
	
	//***** Gera��o de T�tulos Agendamento ******//
	
	public void agendarParaSelecionados() {
	    clicarBotaoSelector("div[title='Agendar para selecionados']");
	}
	
	public void iniciarExecucoes() {
		clicarBotaoSelector("div[title='Iniciar execu��es']");
	}
	
	public void iniciar() {
		clicarBotaoID("btnAgendar");
	}
	
	public String validarTextoGeracaoTitulosAgendamento() {
		return obterTexto("Em andamento");		
	}
	
}
