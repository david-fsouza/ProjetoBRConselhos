package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class RenegociacaoSimulacaoPage extends BasePage {
	
	//************************* Novo Renegocia��o Simula��o **********************************************************//
	
	public String obterTextoNovoRenegocicaoSimulacao() {
		return obterTextoXpath("//*[text()='Permite visualizar as simula��es / renegocia��es']");
	}
	
	//*********************** Consulta Renegocia��o Simula��o *******************************************************//
	
	public void campoFiltrar(String texto) {
		escreverXpath("//input[contains(@id,'filterTBX_gridpanel_')]", texto);
		
	}
	public String obterTextoConsultaRenegocicaoSimulacao() {
		return obterTextoXpath("//*[text()='T�tulos de origem']");
	}
	

}
