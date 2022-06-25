package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class TabelaDePrecoServicosPage extends BasePage {
	
	/******************** TELA PRINCIPAL TABELA DE pre�o servi�os *********************************************************************************/
	
	//************************ Novo Tabela de pre�o servi�os *************************************************************************************//
	
	public String obterTextoNovoTabelaDePrecoServicos() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es de tabela de pre�o servi�os solicita��es.']");
	}
	
	//*********************** Consulta Tabela de pre�o servi�os **********************************************************************************//
    
	public String obterTextoConsultaTabelaDePrecoServico() {
		return obterTextoXpath("//*[text()='Vig�ncia']");
	}
	
	//*********************************** servi�os ***********************************************************************************************//
	
	public void abaServicos() {
		clicarLink("Servi�os");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoServicos() {
		return obterTextoCss("div[title='PJ - Taxa de Registro']");
	}
}
