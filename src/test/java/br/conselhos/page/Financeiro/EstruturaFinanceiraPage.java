package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class EstruturaFinanceiraPage extends BasePage {
	
	/******************************* PLANO FINANCEIRO *******************************************************************/
	
	//**************************** Novo Plano Financeiro ***************************************************************//
	
	public String obterTextoNovoPlanoFinanceiro() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es dos planos financeiros.']");
	}
	
	//************************* Consulta Plano Financeiro **************************************************************//
		
	public String obterTextoConsultaPlanoFinanceiro() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es dos planos financeiros.']");
	}
	
	//***************************** Contas Financeiras *****************************************************************//
	
	public void abaContasFinanceiras() {
		clicarLink("Contas Financeiras");
		entrarFrame("#panelcategory1>iframe");		
	}
	
	public String obterTextoContasFinanceiras() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es dos planos financeiros.']");
	}
	
	/*************************** PLANO DE CENTRO DE RESULTADO 
	 * @throws InterruptedException ***********************************************************/
	
	//************************ Novo Plano de Centro de Resultado *******************************************************//
	
	public void planoCentroResultado() throws InterruptedException {
		clicarBotaoSelector("div[title='Plano de centro de resultado']");
		esperaFixa(2000);
	}
	
	public String obterTextoNovoPlanoCentroResultado() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es sobre os planos de centros de resultado.']");
	}
	
	//*********************** Consulta Plano de Centro de Resultado ****************************************************//
	
	public String obterTextoConsultaPlanoCentroResultado() {
		return obterTextoXpath("//*[text()='Vig�ncia']");
	}
	
	//****************************** Centros de Resultado **************************************************************//
	
	public void abaCentrosDeResultado() {
		clicarLink("Centros de Resultado");
		entrarFrame("#panelcategory1>iframe");
	}

	public String obterTextoCentrosDeResultado() {
		return obterTextoCss("div[title='BRC']");
	}
	
	/******************************** PLANO CONT�BIL **********************************************************************/
	
	//**************************** Novo Plano Cont�bil *******************************************************************//
	
	public void planoContabil() {
		clicarBotaoSelector("div[title='Plano cont�bil']");
	}
	
	public String obterTextoNovoPlanoContabil() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es do plano cont�bil.']");
	}
	
	//*************************** Consulta Plano Cont�bil ****************************************************************//
	
	public String obterTextoConsultaPlanoContabil() {
		return obterTextoXpath("//*[text()='Descri��o']");
	}
	
	//******************************* Contas Cont�beis *******************************************************************//
	
	public void abaContasContabeis() {
		clicarLink("Contas Cont�beis");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoContasContabeis() {
		return obterTextoCss("div[title='R68R']");
	}
	
	/********************************* CRIT�RIOS DE RATEIO 
	 * @throws InterruptedException *****************************************************************/
	
	//***************************** Novo Crit�rios de Rateio **************************************************************//
	
	public void criteriosDeRateio() throws InterruptedException {
		clicarBotaoSelector("div[title='Crit�rios de rateio']");
		esperaFixa(2000);
	}
	
	public String obterTextoNovoCriteriosDeRateio() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es dos crit�rios utilizados para rateio de contas financeiras, centros de resultado e/ou projetos.']");
	}
	
	//*************************** Consulta Crit�rios de Rateio ***********************************************************//
	
	public String obterTextoConsultaCriteriosDeRateio() {
		return obterTextoXpath("//*[text()='Cta. Financeira']");
	}
	
	//************************** Crit�rios de Centro de Resultado *********************************************************//
	
	public void abaCriteriosDeCentroDeResultado() {
		clicarLink("Crit�rios de Centro de Resultado");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public String obterTextoCriteriosCentroResultado() {
		return obterTextoCss("div[title='BRC']");
	}
}
