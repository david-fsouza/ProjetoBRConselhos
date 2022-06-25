package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class EstruturaFinanceiraPage extends BasePage {
	
	/******************************* PLANO FINANCEIRO *******************************************************************/
	
	//**************************** Novo Plano Financeiro ***************************************************************//
	
	public String obterTextoNovoPlanoFinanceiro() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações dos planos financeiros.']");
	}
	
	//************************* Consulta Plano Financeiro **************************************************************//
		
	public String obterTextoConsultaPlanoFinanceiro() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações dos planos financeiros.']");
	}
	
	//***************************** Contas Financeiras *****************************************************************//
	
	public void abaContasFinanceiras() {
		clicarLink("Contas Financeiras");
		entrarFrame("#panelcategory1>iframe");		
	}
	
	public String obterTextoContasFinanceiras() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações dos planos financeiros.']");
	}
	
	/*************************** PLANO DE CENTRO DE RESULTADO 
	 * @throws InterruptedException ***********************************************************/
	
	//************************ Novo Plano de Centro de Resultado *******************************************************//
	
	public void planoCentroResultado() throws InterruptedException {
		clicarBotaoSelector("div[title='Plano de centro de resultado']");
		esperaFixa(2000);
	}
	
	public String obterTextoNovoPlanoCentroResultado() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações sobre os planos de centros de resultado.']");
	}
	
	//*********************** Consulta Plano de Centro de Resultado ****************************************************//
	
	public String obterTextoConsultaPlanoCentroResultado() {
		return obterTextoXpath("//*[text()='Vigência']");
	}
	
	//****************************** Centros de Resultado **************************************************************//
	
	public void abaCentrosDeResultado() {
		clicarLink("Centros de Resultado");
		entrarFrame("#panelcategory1>iframe");
	}

	public String obterTextoCentrosDeResultado() {
		return obterTextoCss("div[title='BRC']");
	}
	
	/******************************** PLANO CONTÁBIL **********************************************************************/
	
	//**************************** Novo Plano Contábil *******************************************************************//
	
	public void planoContabil() {
		clicarBotaoSelector("div[title='Plano contábil']");
	}
	
	public String obterTextoNovoPlanoContabil() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações do plano contábil.']");
	}
	
	//*************************** Consulta Plano Contábil ****************************************************************//
	
	public String obterTextoConsultaPlanoContabil() {
		return obterTextoXpath("//*[text()='Descrição']");
	}
	
	//******************************* Contas Contábeis *******************************************************************//
	
	public void abaContasContabeis() {
		clicarLink("Contas Contábeis");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoContasContabeis() {
		return obterTextoCss("div[title='R68R']");
	}
	
	/********************************* CRITÉRIOS DE RATEIO 
	 * @throws InterruptedException *****************************************************************/
	
	//***************************** Novo Critérios de Rateio **************************************************************//
	
	public void criteriosDeRateio() throws InterruptedException {
		clicarBotaoSelector("div[title='Critérios de rateio']");
		esperaFixa(2000);
	}
	
	public String obterTextoNovoCriteriosDeRateio() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações dos critérios utilizados para rateio de contas financeiras, centros de resultado e/ou projetos.']");
	}
	
	//*************************** Consulta Critérios de Rateio ***********************************************************//
	
	public String obterTextoConsultaCriteriosDeRateio() {
		return obterTextoXpath("//*[text()='Cta. Financeira']");
	}
	
	//************************** Critérios de Centro de Resultado *********************************************************//
	
	public void abaCriteriosDeCentroDeResultado() {
		clicarLink("Critérios de Centro de Resultado");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public String obterTextoCriteriosCentroResultado() {
		return obterTextoCss("div[title='BRC']");
	}
}
