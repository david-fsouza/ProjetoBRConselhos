package br.conselhos.page.GestaoContabil;

import br.conselhos.core.BasePage;

public class EntidadeContabilPage extends BasePage {
	
	/**
	 * Novo Entidade Contabil
	 */
	
	public String obterTextoNovoEntidadeContabil() {
		esperaExplicitaXpath("//*[text()='Permite criar/editar as entidades contábeis.']");
		return obterTextoXpath("//*[text()='Permite criar/editar as entidades contábeis.']");
	}

}
