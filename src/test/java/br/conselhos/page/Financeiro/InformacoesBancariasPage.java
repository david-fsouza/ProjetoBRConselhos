package br.conselhos.page.Financeiro;

import org.openqa.selenium.By;

import br.conselhos.core.BasePage;

public class InformacoesBancariasPage extends BasePage {
	
	/**************************** TELA CONTA bancária ***********************************************************************************************/
	
	//*************************** Novo Conta bancária **********************************************************************************************//
    
	public String obterTextoNovoRegistroContaBancaria() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações das contas bancárias.']");
	}
	
	//************************* Consulta Conta bancária ********************************************************************************************//

	public String obterTextoConsultaContaBancaria() {
		return obterTextoXpath("//*[text()='Estrutura financeira']");
	}
	
	//***************** MENU LATERAL TELA SOBREPOSTA CONTA bancária ********************************************************************************//
	
	//*************************** Carteira de cobrança *********************************************************************************************//
	
	public void abaCarteiraDeCobranca() {
		clicarLink("Carteira de Cobrança");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoCarteiraDeCobranca() {
		return obterTextoCss("div[title='Carteira - Banco do Brasil']");
	}
	
	//***************************** Cheques Próprios ***********************************************************************************************//
	
	public void abaChequesProprios() {
		clicarLink("Cheques Próprios");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public String obterTextoChequesProprios() {
		return obterTextoXpath("//*[text()='Data da Situação']");
	}
	
	//****************************** Compartilhamento **********************************************************************************************//
	
	public void abaCompartilhamento() {
		clicarLink("Compartilhamento");
		entrarFrame("#panelcategory3>iframe");
	}
	
	public String obterTextoCompartilhamento() {
		return obterTextoCss("div[title='25,0000']");
	}
	
	/******************************** TELA AGÊNCIA ***************************************************************************************************/
	
	//******************************* Novo Agência **************************************************************************************************//
	
	public void agencia() {
		clicarBotaoSelector("div[title='Agência']");
	}
	
	public String obterTextoNovoAgencia() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações das agências bancárias.']");
	}
	
	//****************************** Consulta Agência **********************************************************************************************//
	
	public String obterTextoConsultaAgencia() {
		return obterTextoXpath("//*[text()='Banco']");
	}
	
	//******************************* Contas bancárias *********************************************************************************************//
	
	public void abaContasBancarias() {
		clicarLink("Contas bancárias");
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
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações de instituições financeiras.']");
	}
	
	//****************************** Consulta Bancos ******************************************************************************************//
	
	public String obterTextoConsultaBancos() {
		return obterTextoXpath("//*[text()='Código']");
	}
	
	//********************************* Agências **********************************************************************************************//
	
	public void abaAgencias() {
		clicarLink("Agências");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoAgencias() {
		return obterTextoCss("div[title='Agência B.Brasil']");
	}

	/************************* TELA INSTRUÇÕES DE COBRANÇAS ***********************************************************************************/
	
	//************************** Novo Instruções bancárias ***********************************************************************************//
	public void instrucoesDeCobranca() {
		clicarBotaoSelector("div[title='Instruções de cobrança']");
	}
	
	public String obterTextoNovoInstrucoesDeCobranca() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações das instruções de cobrança.']");
	}
	
	//*********************** Consulta Instruções de cobrança ********************************************************************************//
	
	public String obterTextoConsultaInstrucoesDeCobranca() {
		return obterTextoXpath("//*[text()='Descrição']");
	}
	
    //*************************** Configuração por banco *************************************************************************************//
	
	public void abaConfiguracaoPorBancos() {
		clicarLink("Configuração por banco");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoConfiguracaoPorBancos() {
		return obterTextoCss("div[title='Banco do Brasil S.A.']");
	}
	
	/**************************** CARTEIRAS  DE cobrança **************************************************************************************/
	
	//************************* Novo Carteiras de cobrança **********************************************************************************//
	
	public void carteirasDeCobranca() {
		clicarBotaoSelector("div[title='Carteiras de cobrança']");
	}
	
	public String obterTextoNovoCarteirasDeCobranca() {
		return obterTextoXpath("//*[text()='Permitir cadastrar/alterar as informações da Carteira de Cobrança.']");
	}
	
	//*********************** Consulta Carteiras de cobrança *******************************************************************************//
	
	public String obterTextoConsultaCarteirasDeCobranca() {
		return obterTextoXpath("//*[text()='Numeração de Remessa Bancária']");	
	}
	
	//********************* MENU LATERAL CARTEIRAS DE cobrança ********************************************************************************/
	
	//******************************* Configurações *****************************************************************************************//
	
	public void abaConfiguracoes() {
		clicarLink("Configurações");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoConfiguracoes() {
		return obterTextoCss("div[title='Nosso número']");
	}
	
	//********************************* Instruções ******************************************************************************************//
	
	public void abaInstrucoes() {
		clicarLink("Instruções");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public String obterTextoInstrucoes() {
		return obterTextoCss("div[title='O valor deste boleto JÁ CONTEMPLA o desconto referente ao período']");
	}
	
	//********************************* Movimentos *****************************************************************************************//
	
	public void abaMovimentos() {
		clicarLink("Movimentos");
		entrarFrame("#panelcategory3>iframe");
	}
	
	public String obterTextoMovimentos() {
		return obterTextoCss("div[title='Teste Movimentos Bancários']");
	}
	
	/*************************** TELA OCORRÃ£NCIA bancária ***********************************************************************************/
	
	//************************** Novo Ocorrência bancária **********************************************************************************//
	
	public void ocorrenciaBancaria() {
		clicarBotaoSelector("div[title='Ocorrência Bancária']");
	}
	
	public String obterTextoOcorrenciaBancaria() {
		return obterTextoXpath("//*[text()='Permite criar/editar Ocorrências Bancárias']");
	}
	
	
}
