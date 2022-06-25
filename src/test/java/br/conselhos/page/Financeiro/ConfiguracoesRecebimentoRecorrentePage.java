package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class ConfiguracoesRecebimentoRecorrentePage extends BasePage {
	
    /**
     * TELA PRINCIPAL CONFIGURA��ES DE RECEBIMENTO RECORRENTE
     */
	// Novo Configura��es de Recebimento Recorrente
	
	public String obterTextoNovoConfiguracoesDeRecebimentoRecorrente() {
		return obterTextoXpath("//*[text()='Permite criar recebimento recorrente.']");
	}
	
	// Consulta Configura��es de Recebimento Recorrente
	
	public String obterTextoConsultaConfiguracoesDeRecebimentoRecorrente() {
		return obterTextoXpath("//*[text()='Recebimento Recorrente.']");
	}

}
