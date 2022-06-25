package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class FluxoDeCaixaPage extends BasePage {
	
	/**
	 * TELA PRINCIPAL FLUXO DE CAIXA
	 */
	// Novo Fluxo de Caixa
	
	public String obterTextoNovoFluxoDeCaixa() {
		return obterTextoXpath("//*[text()='Valor']");		
	}
	
	// Consulta Fluxo de Caixa
	
	public String obterTextoConsultaFluxoDeCaixa() {
		return obterTextoXpath("//*[text()='Data Vencimento']");
	}

}
