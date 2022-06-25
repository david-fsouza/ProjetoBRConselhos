package br.conselhos.page.Financeiro;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class TesourariaPage extends BasePage {


	/************************ TELA NOVO REGISTRO TESOURARIA ******************************************************/
	
	//***********************   Novo Registro Tesouraria    ********************************************************/
	
	public void campoLiquidacao(String texto) throws InterruptedException {   
		escreverID("m_dtLiquidacaoEdt", texto );
	}
	
	public void campoValor(String texto) {
		escreverID("m_numValorEdt", texto + Keys.ENTER);
	}
	
	public void campoContaBancaria() throws InterruptedException {
		clicarBotaoID("m_lkContaBancariaEdt");
		esperaFixa(3000);
		digitaTeclaId("m_lkContaBancariaEdt", Keys.ENTER);
	}
	
	public void campoHistorico() throws InterruptedException {
		clicarBotaoID("m_lkHistoricoEdt");
		esperaFixa(2000);
		digitaTeclaId("m_lkHistoricoEdt", Keys.ENTER);		
	}
	
	public void campoTipoDeDocumento() throws InterruptedException {
		clicarBotaoID("m_lkTipoDocumentoEdt");
		esperaFixa(2000);
		digitaTeclaId("m_lkTipoDocumentoEdt", Keys.ENTER);
	}
	
	public void campoDisponibilidade(String texto) throws InterruptedException {   
		escreverID("m_dtDisponibilidadeEdt", texto);
	}
	
	public void campoFormaLiquidacao() throws InterruptedException {
		clicarBotaoID("m_lkFormaLiquidacaoEdt");
		esperaFixa(2000);
		digitaTeclaId("m_lkFormaLiquidacaoEdt", Keys.ENTER);		
	}
	
	public void salvareFechar() {
		clicarBotaoID("btnGerar");
	}
	
	public void botaoLocalizar() {
		clicarBotaoID("m_btLocalizar");
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
