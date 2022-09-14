package br.conselhos.page.Financeiro;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class TesourariaPage extends BasePage {


    /******* Incluir Lançamentos *****/
	
	public void campoLiquidacao() throws InterruptedException {   
		dataFutura("m_dtLiquidacaoEdt", 20);
	}
	
	public void campoValor(String texto) {
		escreverID("m_numValorEdt", texto + Keys.ENTER);
	}
	
	public void campoContaBancaria(String texto) throws InterruptedException {
		escreverID("m_lkContaBancariaEdt", texto + Keys.ENTER);
		esperaFixa(2000);
	}
	
	public void campoHistorico(String texto) throws InterruptedException {
		escreverID("m_lkHistoricoEdt", texto + Keys.ENTER);
		esperaFixa(2000);
	}
	
	public void campoTipoDeDocumento(String texto) throws InterruptedException {
		escreverID("m_lkTipoDocumentoEdt", texto + Keys.ENTER);
		esperaFixa(2000);
	}
	
	public void campoDisponibilidade() throws InterruptedException {   
		dataFutura("m_dtDisponibilidadeEdt", 20);
	}
	
	public void campoFormaLiquidacao(String texto) throws InterruptedException {
		escreverID("m_lkFormaLiquidacaoEdt", texto + Keys.ENTER);
		esperaFixa(2000);
	}
	
	public void campoDataInicialLiquidacao() throws InterruptedException {
		dataFutura("m_dtLiquidacao_startDateEdt", 20);
		esperaFixa(2000);
	}
	
	public void campoDataFinalLiquidacao() throws InterruptedException {
		dataFutura("m_dtLiquidacao_endDateEdt", 20);
		esperaFixa(2000);
	}
	
	public String validarTextoInclusaoLancamentosTesouraria() {
		return obterTexto("Atualização/Aglutinação");
	}
		
	
	//************************ Consulta Registro Tesouraria *********************************//
	
	public void campoDataLiquidacaoDataInicio(String data) {
		escreverID("m_dtLiquidacao_startDateEdt", data);
	}
	
	public void campoNumeroDocumento() {
		escreverID("m_tbNumeroDocumentoEdt", "44397");
	}
	
	public void selecionarResultadoBusca(String resultado) {
		clicarBotaoXpath("//*[text()= '" + resultado + "' ]");
	}
	
	public String obterTexto(String texto) {
		return obterTextoXpath("//*[text()='" + texto + "']");
	}
		
}
