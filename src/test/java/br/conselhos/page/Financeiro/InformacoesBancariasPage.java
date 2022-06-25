package br.conselhos.page.Financeiro;

import org.openqa.selenium.By;

import br.conselhos.core.BasePage;

public class InformacoesBancariasPage extends BasePage {
	
	/**************************** TELA CONTA banc�ria ***********************************************************************************************/
	
	//*************************** Novo Conta banc�ria **********************************************************************************************//
    
	public String obterTextoNovoRegistroContaBancaria() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es das contas banc�rias.']");
	}
	
	//************************* Consulta Conta banc�ria ********************************************************************************************//

	public String obterTextoConsultaContaBancaria() {
		return obterTextoXpath("//*[text()='Estrutura financeira']");
	}
	
	//***************** MENU LATERAL TELA SOBREPOSTA CONTA banc�ria ********************************************************************************//
	
	//*************************** Carteira de cobran�a *********************************************************************************************//
	
	public void abaCarteiraDeCobranca() {
		clicarLink("Carteira de Cobran�a");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoCarteiraDeCobranca() {
		return obterTextoCss("div[title='Carteira - Banco do Brasil']");
	}
	
	//***************************** Cheques Pr�prios ***********************************************************************************************//
	
	public void abaChequesProprios() {
		clicarLink("Cheques Pr�prios");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public String obterTextoChequesProprios() {
		return obterTextoXpath("//*[text()='Data da Situa��o']");
	}
	
	//****************************** Compartilhamento **********************************************************************************************//
	
	public void abaCompartilhamento() {
		clicarLink("Compartilhamento");
		entrarFrame("#panelcategory3>iframe");
	}
	
	public String obterTextoCompartilhamento() {
		return obterTextoCss("div[title='25,0000']");
	}
	
	/******************************** TELA AG�NCIA ***************************************************************************************************/
	
	//******************************* Novo Ag�ncia **************************************************************************************************//
	
	public void agencia() {
		clicarBotaoSelector("div[title='Ag�ncia']");
	}
	
	public String obterTextoNovoAgencia() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es das ag�ncias banc�rias.']");
	}
	
	//****************************** Consulta Ag�ncia **********************************************************************************************//
	
	public String obterTextoConsultaAgencia() {
		return obterTextoXpath("//*[text()='Banco']");
	}
	
	//******************************* Contas banc�rias *********************************************************************************************//
	
	public void abaContasBancarias() {
		clicarLink("Contas banc�rias");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoContasBancarias() {
		return obterTextoCss("div[title='CAIXA FUNDO FIXO SEDE']");
	}
	
	/******************************* TELA BANCOS ***********************************************************************************************/
	
    //****************************** Novo Bancos **********************************************************************************************//

	public void bancos() {
		clicarBotaoSelector("div[title='Bancos']");
	}
	
	public String obterTextoNovoBancos() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es de institui��es financeiras.']");
	}
	
	//****************************** Consulta Bancos ******************************************************************************************//
	
	public String obterTextoConsultaBancos() {
		return obterTextoXpath("//*[text()='C�digo']");
	}
	
	//********************************* Ag�ncias **********************************************************************************************//
	
	public void abaAgencias() {
		clicarLink("Ag�ncias");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoAgencias() {
		return obterTextoCss("div[title='Ag�ncia B.Brasil']");
	}

	/************************* TELA INSTRU��ES DE COBRAN�AS ***********************************************************************************/
	
	//************************** Novo Instru��es banc�rias ***********************************************************************************//
	public void instrucoesDeCobranca() {
		clicarBotaoSelector("div[title='Instru��es de cobran�a']");
	}
	
	public String obterTextoNovoInstrucoesDeCobranca() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es das instru��es de cobran�a.']");
	}
	
	//*********************** Consulta Instru��es de cobran�a ********************************************************************************//
	
	public String obterTextoConsultaInstrucoesDeCobranca() {
		return obterTextoXpath("//*[text()='Descri��o']");
	}
	
    //*************************** Configura��o por banco *************************************************************************************//
	
	public void abaConfiguracaoPorBancos() {
		clicarLink("Configura��o por banco");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoConfiguracaoPorBancos() {
		return obterTextoCss("div[title='Banco do Brasil S.A.']");
	}
	
	/**************************** CARTEIRAS  DE cobran�a **************************************************************************************/
	
	//************************* Novo Carteiras de cobran�a **********************************************************************************//
	
	public void carteirasDeCobranca() {
		clicarBotaoSelector("div[title='Carteiras de cobran�a']");
	}
	
	public String obterTextoNovoCarteirasDeCobranca() {
		return obterTextoXpath("//*[text()='Permitir cadastrar/alterar as informa��es da Carteira de Cobran�a.']");
	}
	
	//*********************** Consulta Carteiras de cobran�a *******************************************************************************//
	
	public String obterTextoConsultaCarteirasDeCobranca() {
		return obterTextoXpath("//*[text()='Numera��o de Remessa Banc�ria']");	
	}
	
	//********************* MENU LATERAL CARTEIRAS DE cobran�a ********************************************************************************/
	
	//******************************* Configura��es *****************************************************************************************//
	
	public void abaConfiguracoes() {
		clicarLink("Configura��es");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoConfiguracoes() {
		return obterTextoCss("div[title='Nosso n�mero']");
	}
	
	//********************************* Instru��es ******************************************************************************************//
	
	public void abaInstrucoes() {
		clicarLink("Instru��es");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public String obterTextoInstrucoes() {
		return obterTextoCss("div[title='O valor deste boleto J� CONTEMPLA o desconto referente ao per�odo']");
	}
	
	//********************************* Movimentos *****************************************************************************************//
	
	public void abaMovimentos() {
		clicarLink("Movimentos");
		entrarFrame("#panelcategory3>iframe");
	}
	
	public String obterTextoMovimentos() {
		return obterTextoCss("div[title='Teste Movimentos Banc�rios']");
	}
	
	/*************************** TELA OCORRãNCIA banc�ria ***********************************************************************************/
	
	//************************** Novo Ocorr�ncia banc�ria **********************************************************************************//
	
	public void ocorrenciaBancaria() {
		clicarBotaoSelector("div[title='Ocorr�ncia Banc�ria']");
	}
	
	public String obterTextoOcorrenciaBancaria() {
		return obterTextoXpath("//*[text()='Permite criar/editar Ocorr�ncias Banc�rias']");
	}
	
	
}
