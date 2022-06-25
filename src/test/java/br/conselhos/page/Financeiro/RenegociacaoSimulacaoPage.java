package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class RenegociacaoSimulacaoPage extends BasePage {
	
	//************************* Novo Renegociação Simulação **********************************************************//
	
	public String obterTextoNovoRenegocicaoSimulacao() {
		return obterTextoXpath("//*[text()='Permite visualizar as simulações / renegociações']");
	}
	
	//*********************** Consulta Renegociação Simulação *******************************************************//
	
	public void campoFiltrar(String texto) {
		escreverXpath("//input[contains(@id,'filterTBX_gridpanel_')]", texto);
		
	}
	public String obterTextoConsultaRenegocicaoSimulacao() {
		return obterTextoXpath("//*[text()='Títulos de origem']");
	}
	

}
