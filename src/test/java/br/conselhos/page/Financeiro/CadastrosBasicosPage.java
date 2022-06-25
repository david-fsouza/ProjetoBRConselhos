package br.conselhos.page.Financeiro;

import br.conselhos.core.BaseTest;

public class CadastrosBasicosPage extends BaseTest {
	
	/*********************************** HIST�RICOS ***************************************************************************************/
	
	//******************************** Novo Hist�ricos ***********************************************************************************//
	
	
	
	//****************************** Consultar Hist�ricos ********************************************************************************//
	
	
	
	/********************************* TIPOS DE CONTATO ***********************************************************************************/
	
	//****************************** Novo Tipos de Contato *******************************************************************************//
	
	public void tiposDeContato() {
		clicarBotaoSelector("div[title='Tipos de contato']");
	}
	
	//**************************** Consulta Tipos de Contato *****************************************************************************//
	
	
	
	
	/********************************* TIPOS DE DOCUMENTO *********************************************************************************/
	
	//****************************** Novo Tipos de Documento *****************************************************************************//
	
	public void tiposDeDocumento() {
		clicarBotaoSelector("div[title='Tipos de documento");
	}
	
	//***************************** Consulta Tipos de Documento **************************************************************************//
	
	
	
    /******************************** TIPOS DE COBRAN�A ***********************************************************************************/
    
    //***************************** Novo Tipos de Cobran�a *******************************************************************************//
	
	public void tiposDeCobranca() {
		clicarBotaoSelector("div[title='Tipos de cobran�a']");
	}
	
	//**************************** Consulta Tipos de Cobran�a ****************************************************************************//

	
	
	/********************************* TIPOS DE PAGAMENTO *********************************************************************************/
	
	//****************************** Novo Tipos de Pagamento *****************************************************************************//
	
	public void tiposDePagamento() {
		esperaExplicita("div[title='Tipos de Pagamento']");
		clicarBotaoSelector("div[title='Tipos de Pagamento']");
	}
	
	
	
	/********************************* FORMAS LIQUIDA��O **********************************************************************************/
	
	public void formasLiquidacao() {
		esperaExplicita("div[title='Formas liquida��o']");
		clicarBotaoSelector("div[title='Formas liquida��o']");
	}
	
}
