package br.conselhos.page.Cadastros;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class RelatoriosCadastroPage extends BasePage {
	
	//****** Relatório R086C000000 PDF ******//
	
	public void inserirFiltro(String texto) {
		escreverID("m_InputProcurarEdt", texto + Keys.ENTER);
	}
	
	public void campoSacado(String texto) {
		escreverID("m_lkPessoaEdt", texto + Keys.ENTER);
		
	}
	public void gerarRelatorio() {
		clicarBotaoSelector("div[title='Gerar Relatório']");
	}
	
	//****** Relatório R086C000000 Excel ******//
	
	public void campoFormatoRelatorio(String texto) {
		escreverID("cbFormatoRelatorioEdt", texto + Keys.ENTER);
	}
	
	public void campoFormatoRelario_084(String texto) {
		escreverID("cbFormatoEdt", texto + Keys.ENTER);			
	}
}

