package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class ConfiguracoesRecebimentoRecorrentePage extends BasePage {
	
    /**
     * TELA PRINCIPAL CONFIGURAÇÕES DE RECEBIMENTO RECORRENTE
     */
	// Novo Configurações de Recebimento Recorrente
	
	public String obterTextoNovoConfiguracoesDeRecebimentoRecorrente() {
		return obterTextoXpath("//*[text()='Permite criar recebimento recorrente.']");
	}
	
	// Consulta Configurações de Recebimento Recorrente
	
	public String obterTextoConsultaConfiguracoesDeRecebimentoRecorrente() {
		return obterTextoXpath("//*[text()='Recebimento Recorrente.']");
	}

}
