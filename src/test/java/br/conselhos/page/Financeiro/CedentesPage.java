package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class CedentesPage extends BasePage {
	
	/******************** TELA PRINCIPAL CEDENTES (OUTROS CEDENTES) ****************************************************************/
	
	//****************************** Novo Registro Cedentes ***************************************************************//
    
	public void novo() {
		clicarBotaoXpath("/html/body/form/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div[7]/em/button/span[1]");
	}
	
	public String obterTextoNovoRegistroCedentes() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es de outros tipos de cedentes.']");
	}
	
	//*********************************** Contabiliza��o ******************************************************************//
	
	public void contabilizacao() {
		clicarBotaoXpath("//*[text()='Contabiliza��o']");
	}
	
	public String obterTextoContabilizacao() {
		return obterTextoXpath("//*[text()='Cta. Financeira']");
	}
	
	//*********************************** Consulta Cedentes ***************************************************************//
	
    public void inserirCampoFiltrarOutrosCedentes(String texto) {
		escreverXpath("//input[contains(@id,'filterTBX_gridpanel') and contains(@name, 'tabCt_0')]", texto + Keys.ENTER);	
	}
	
	public void selecionarReultadoBusca(String texto) {
		clicarBotaoSelector("div[title='" + texto + "']");
	}
	
	public String obterTextoConsultaCedentes() {
		return obterTextoXpath("//*[text()='Nome Completo']");
	}
	
	/***************** TELA PRINCIPAL CEDENTES CONSULTA (FORNECEDORES) ************************************************************/
	
	//*************** MENU ABAS LATERAIS CONSULTA REGISTRO FORNECEDORES **********************************************************//
	
	//*********************************** Geral **********************************************************************************//
	
	public void fornecedores() {
		clicarBotaoXpath("//*[text()='Fornecedores']");
	}
	
	public void inserirCampoFiltrarFornecedores(String texto) {
		escreverXpath("//input[contains(@id,'filterTBX_gridpanel') and contains(@name, 'tabCt_1')]", texto + Keys.ENTER);	
	}
	
	public String obterTextoGeral() {
		return obterTextoXpath("//*[text()='C�digo']");
	}
	
	//******************************* �reas de Atua��o ****************************************************************************//
	
	public void abaAreasDeAtuacao() {
		clicarLink("�reas de Atua��o");
	    entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoAreasDeAtuacao() {
		return obterTextoCss("div[title='�rea de Atua��o 01']");			
	}
	
	//**************************** Documentos de Habilita��o ************************************************************************//
	
	public void abaDocumentosDeHabilitacao() {
		clicarLink("Documentos de Habilita��o");
	    entrarFrame("#panelcategory2>iframe");	
	}
	
	public String obterTextoDocumentosHabilitacao() {
		return obterTextoCss("div[title='Teste Documentos Habita��o']");
	}
	
	//*********************************** Ocorr�ncias *******************************************************************************//
	
	public void abaOcorrencias() {
		clicarLink("Ocorr�ncias");
	    entrarFrame("#panelcategory3>iframe");
	}
	
	public String obterTextoOcorrencias() {
		return obterTextoCss("div[title='Teste Ocorr�ncias']");
	}
	
	//************************* Contatos Respons�veis *************************************************************************//
	
	public void abaContatosResponsaveis() {
		clicarLink("Contatos Respons�veis");
	    entrarFrame("#panelcategory4>iframe");
	}
	
	public String obterTextoContatosResponsaveis() {
		return obterTextoCss("div[title='Teste Contatos Respons�veis']");
	}
	
    //***************** TELA FORNECEDORES (TABELAS HORIZONTAIS) ***************************************************************//
    
    //******************************** Endere�os ******************************************************************************//
	
	public void enderecos() {
		clicarBotaoSelector("div[title='Endere�os']");
	}
	
	public String obterTextoEnderecos() {
		return obterTextoXpath("//*[text()='CEP cx postal']");
	}
	
	//********************************* Telefones *****************************************************************************//
	
	public void telefones() {
		clicarBotaoSelector("div[title='Telefones']");		
	}
	
	public String obterTextoTelefones() {
		return obterTextoXpath("//*[text()='Comercial']");
	}
	
	//********************************* Documentos ****************************************************************************//
	
	public void documentos() {
		clicarBotaoSelector("div[title='Documentos']");		
	}
	
	public String obterTextoDocumentos() {
		return obterTextoXpath("//*[text()='RG']");
	}
	
	//******************************* Inf.Complementares **********************************************************************//
	
	public void infComplementares() {
		clicarBotaoSelector("div[title='Inf. Complementares']");		
	}
	
	public String obterTextoInfComplementares() {
		return obterTextoXpath("//*[text()='Email']");
	}
	
	//********************************* Inf.Financeiras ***********************************************************************//
	
	public void infFinanceiras() {
		clicarBotaoSelector("div[title='Inf. Financeiras']");		
	}
	
	public String obterTextoInfFinanceiras() {
		return obterTextoXpath("//*[text()='Banco']");
	}
	
	//*********************************** Contabiliza��o **********************************************************************//
	
	public void abaContabilizacao() {
		clicarBotaoSelector("div[title='Contabiliza��o']");		
	}
	
	public String obterTextoAbaContabilizacao() {
		return obterTextoXpath("//*[text()='Conta cont�bil']");
	}
	
		
}
