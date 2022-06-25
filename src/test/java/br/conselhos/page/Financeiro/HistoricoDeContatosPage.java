package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class HistoricoDeContatosPage extends BasePage {
	
	/********************* TELA PRINCIPAL HISTORICO DE CONTATOS ************************************************************************************/

	//******************** Novo Registro Histórico de Contatos ************************************************************************************//
	
	public String obterTextoNovoRegistroHistoricoDeContatos() {
		return obterTextoXpath("//*[text()='Representa o Histórico de Contato com uma Pessoa.']");
	}
	
	//*********************** Consulta Histórico de Contatos **************************************************************************************//
	
	public String obterTextoConsultaHistoricoDeContatos() {
		return obterTextoXpath("//*[text()='Representa o Histórico de Contato com uma Pessoa.']");
	}
	
	
	/*********************************** FUNçõES ***************************************************************************************************/
	
	//********************************* Documentos ************************************************************************************************//
	
	public void documentos() {
		clicarBotaoXpath("//*[text()='Documentos']");
	}
	
	public String obterTextoDocumentos() {
		esperaExplicitaXpath("//*[text()='Modelo de documento']");
		return obterTextoXpath("//*[text()='Modelo de documento']");
	}
	
	//******************************* Impressão rápida ********************************************************************************************//
	
	public void impressaoRapida() {
		clicarBotaoXpath("//*[text()='Impressão rápida']");
	}
	
	public String obterTextoImpressaoRapida() {
		esperaExplicitaXpath("//*[text()='escolha a árvore da dados que você deseja visualizar ou imprimir']");
		return obterTextoXpath("//*[text()='escolha a árvore da dados que você deseja visualizar ou imprimir']");
	}
	
	
	/***************** MENU LATERAL ESQUERDO TELA SOBREPOSTA REGISTRO ******************************************************************************/
	
	//****************************** Contas a Receber *********************************************************************************************//
	
	public void abaContasaReceber() {
		clicarLink("Contas a Receber");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoContasaReceber() {
		return obterTextoCss("div[title='000000365618']");
	}
	
	//******************************* Documentos GED **********************************************************************************************//
	
	public void abaDocumentosGED() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public String obterTextoDocumentosGED() {
		esperaExplicitaXpath("//*[text()='Permite criar/alterar os Documentos GED']");
		return obterTextoXpath("//*[text()='Permite criar/alterar os Documentos GED']");
	}
	
	/****************************** TELA ENVIO DE BOLETOS ******************************************************************************************/
	
	//*************************** Consulta Envio de Boletos ***************************************************************************************//
	
	public void envioDeBoletos() {
		clicarBotaoSelector("div[title='Envios de boleto']");
	}
	
	public String obterTextoEnvioDeBoletos() {
		return obterTextoXpath("//*[text()='Histórico de Contato']");
	}
	
	
}	
