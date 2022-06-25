package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class ConciliacaoBancariaPage extends BasePage {
	
	/*********** TELA PRINCIPAL concilia��o banc�ria (EXTRATOS banc�rios) ******************************************************************************************/
	
	//********************* Novo Registro Extratos banc�rios *****************************************************************************************************//
	
	public String obterTextoNovoExtratosBancarios() {
		return obterTextoXpath("//*[text()='Permite cadastrar/consultar informa��es dos extratos banc�rios']");
	}
	
	//************************* ConsultaExtratosBancarios ********************************************************************************************************//
	
	public String obterTextoConsultaExtratosBancarios() {
		return obterTextoXpath("//*[text()='Conta banc�ria']");
	}
	
	//******************************** Lancamentos ***************************************************************************************************************//
	
	public void abaLancamentos() {
		clicarLink("Lan�amentos");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoLancamentos() {
		return obterTextoCss("div[title='Teste Lan�amentos do extrato']");
	}
	
	//**************************** Importar Extrato ************************************************************************************************************//
	
	public void funcoes() {
		clicarBotaoXpath("/html/body/form/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div[1]/em/button/span[1]");	
	}
	
	public void importarExtrato() {
		clicarBotaoXpath("//*[text()='Importar Extrato...']");
	}
	
	public String obterTextoImportarExtrato() {
		return obterTextoXpath("//*[text()='Permite realizar a importa��o dos extratos banc�rios.']");
	}
	
	/************** TELA PRINCIPAL concilia��o banc�ria (concilia��o) ******************************************************************************************/
	
	//******************************* concilia��o *************************************************************************************************************//
    
	public void conciliacao() {
		clicarBotaoSelector("div[title='Concilia��o']");
	}
	
	public String obterTextoConciliacao() {
		return obterTextoXpath("//*[text()='Permite efetuar/consultar a concilia��o banc�ria.']");
		
	}
}
