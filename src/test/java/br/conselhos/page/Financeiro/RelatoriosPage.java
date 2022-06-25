package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class RelatoriosPage extends BasePage {
	
    /**
     * TELA PRINCIPAL RELATÓRIOS
     */
	// Consulta Relatórios
	
	public void inserirFiltro(String texto) {
		escreverID("m_InputProcurarEdt", texto);
	}
	
	public void botaoAvancar() {
		clicarBotaoSelector("div[title='Avançar']");
	}
	
	public String obterTextoRelatorios() {
		return obterTextoXpath("//*[text()='relatório pode ser visualizado localmente, se preferir salve e visualize-o depois']"); 
	}	

}
