package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class RelatoriosPage extends BasePage {
	
    /**
     * TELA PRINCIPAL RELAT�RIOS
     */
	// Consulta Relat�rios
	
	public void inserirFiltro(String texto) {
		escreverID("m_InputProcurarEdt", texto);
	}
	
	public void botaoAvancar() {
		clicarBotaoSelector("div[title='Avan�ar']");
	}
	
	public String obterTextoRelatorios() {
		return obterTextoXpath("//*[text()='relat�rio pode ser visualizado localmente, se preferir salve e visualize-o depois']"); 
	}	

}
