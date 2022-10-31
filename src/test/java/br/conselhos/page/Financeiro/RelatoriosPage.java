package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class RelatoriosPage extends BasePage {
	
    /**
     * TELA PRINCIPAL RELAT�RIOS
     */
	
	//****** Relat�rio R086C000000 PDF ******//
	
	public void inserirFiltro(String texto) {
		escreverID("m_InputProcurarEdt", texto + Keys.ENTER);
	}
	
	public void campoSacado(String texto) {
		escreverID("m_lkPessoaEdt", texto + Keys.ENTER);
		
	}
	public void gerarRelatorio() {
		clicarBotaoSelector("div[title='Gerar Relat�rio']");
	}
	
	//****** Relat�rio R086C000000 Excel ******//
	
	public void campoFormatoRelatorio(String texto) {
		escreverID("cbFormatoRelatorioEdt", texto + Keys.ENTER);
	}
	
	public void campoFormatoRelario_084(String texto) {
		escreverID("cbFormatoEdt", texto + Keys.ENTER);			
	}
	
	//******* Relat�rio R086C000000 Por Agendamento *******//
	public void checkBoxAgendar() {
		clicarBotaoID("ckAgendarEdt");
	}
	
	public void campoIniciarEm() throws InterruptedException {
		dataFutura("dtAgendamentoEdt", 2);
	}
	
	public String validarTextoGerarRelatorioAgendamento() {
		return obterTexto("A gera��o do relat�rio agendada.");
	}
	
}
