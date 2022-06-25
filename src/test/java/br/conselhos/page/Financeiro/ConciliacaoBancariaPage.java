package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class ConciliacaoBancariaPage extends BasePage {
	
	/*********** TELA PRINCIPAL conciliação bancária (EXTRATOS bancários) ******************************************************************************************/
	
	//********************* Novo Registro Extratos bancários *****************************************************************************************************//
	
	public String obterTextoNovoExtratosBancarios() {
		return obterTextoXpath("//*[text()='Permite cadastrar/consultar informações dos extratos bancários']");
	}
	
	//************************* ConsultaExtratosBancarios ********************************************************************************************************//
	
	public String obterTextoConsultaExtratosBancarios() {
		return obterTextoXpath("//*[text()='Conta bancária']");
	}
	
	//******************************** Lancamentos ***************************************************************************************************************//
	
	public void abaLancamentos() {
		clicarLink("Lançamentos");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoLancamentos() {
		return obterTextoCss("div[title='Teste Lançamentos do extrato']");
	}
	
	//**************************** Importar Extrato ************************************************************************************************************//
	
	public void funcoes() {
		clicarBotaoXpath("/html/body/form/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div[1]/em/button/span[1]");	
	}
	
	public void importarExtrato() {
		clicarBotaoXpath("//*[text()='Importar Extrato...']");
	}
	
	public String obterTextoImportarExtrato() {
		return obterTextoXpath("//*[text()='Permite realizar a importação dos extratos bancários.']");
	}
	
	/************** TELA PRINCIPAL conciliação bancária (conciliação) ******************************************************************************************/
	
	//******************************* conciliação *************************************************************************************************************//
    
	public void conciliacao() {
		clicarBotaoSelector("div[title='Conciliação']");
	}
	
	public String obterTextoConciliacao() {
		return obterTextoXpath("//*[text()='Permite efetuar/consultar a conciliação bancária.']");
		
	}
}
