package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class TabelaDePrecoServicosPage extends BasePage {
	
	/******************** TELA PRINCIPAL TABELA DE preço serviços *********************************************************************************/
	
	//************************ Novo Tabela de preço serviços *************************************************************************************//
	
	public String obterTextoNovoTabelaDePrecoServicos() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações de tabela de preço serviços solicitações.']");
	}
	
	//*********************** Consulta Tabela de preço serviços **********************************************************************************//
    
	public String obterTextoConsultaTabelaDePrecoServico() {
		return obterTextoXpath("//*[text()='Vigência']");
	}
	
	//*********************************** serviços ***********************************************************************************************//
	
	public void abaServicos() {
		clicarLink("Serviços");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoServicos() {
		return obterTextoCss("div[title='PJ - Taxa de Registro']");
	}
}
