package br.conselhos.page.Financeiro;

import br.conselhos.page.*;

import static br.conselhos.core.DriverFactory.getDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.page.Page;

import br.conselhos.core.BasePage;

public class ContasReceberPage extends BasePage {
	
	/**************************** TELA NOVO REGISTRO  ********************************/
	
	//********************************* Geral *************************************************************************************************************************************************/

	public void campoSacado(String nome) throws InterruptedException {
		escrever("Pessoa", nome);
		esperaFixa(2000);
		digitaTeclaName("Pessoa", Keys.ENTER);
	}
	
	public void campoTipoLancamento(String nome) throws InterruptedException {
		escrever("TipoLancamento", nome);	
		esperaFixa(2000);
		digitaTeclaName("TipoLancamento", Keys.ENTER);
	}
	
	public void campoDataEmissao() throws InterruptedException {
		inserirDataAtual("DataOperacao");
	}
	
	public void campoInscricaoCategoria(String inscricao) throws InterruptedException {
		escrever("InscricaoCategoria", inscricao);
	    esperaFixa(2000);
	    digitaTeclaName("InscricaoCategoria", Keys.ENTER);
	    esperaFixa(2000);
	}
	
	public void campoPacela(String parcela) throws InterruptedException {
		escrever("Parcela", parcela);
        esperaFixa(2000);
	}
	
	public void campoDataMovimento(String data) throws InterruptedException {
		escrever("DataMovimento", data);
	    digitaTeclaName("DataMovimento", Keys.ENTER);
	    esperaFixa(2000);
	}
	
	public void campoValorBruto(String valor) throws InterruptedException {
		escrever("ValorBruto", valor);
	    esperaFixa(2000);
	    digitaTeclaName("ValorBruto", Keys.ENTER);
	    esperaFixa(2000);
	}
	
	public void salvareFechar() {
		clicarBotaoID("SaveAndClose_ContaReceberConselho");
	}
	
	public void pesquisaSacado(String sacado ) {
		escreverXpath("/html/body/form/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div/div/div[2]/div[3]/div/div/div/input", sacado + Keys.ENTER);
	}
	
	public String obterValorBruto() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es de t�tulos a receber.']");
	}
	
	//********************       Acr�scimos e Descontos        ******************************************************************************************************************************/
	
	public void acrescimoseDescontos() {
		clicarBotaoSelector("div[title='Acr�scimos e Descontos']");
	}
	
	public String obterValorAcrescimoseDescontos() {
		return obterTextoCss("div[title='Acr�scimos e Descontos']");
	}
	
	//********************       Informacoes Liquida��o        *******************************************************************************************************************************/
	
	public void abaInformacoesDaLiquidacao() {
		clicarBotaoSelector("div[title='Informa��es da Liquida��o']");
    }
	
	public String obterValorInformacoesLiquidacao() {
		return obterTextoCss("div[title='Informa��es da Liquida��o']");
	}
	
	//********************             Observa��es             ********************************************************************************************************************************/
	
	public void abaObservacoes() {
		clicarBotaoSelector("div[title='Observa��es']");
	}
	
	public String obterValorAbaObservacoes() {
		return obterTextoCss("div[title='Observa��es']");
	}
 
	/************************ CONSULTA REGISTROS EXISTENTES ********************************************************************************************************************/
	
	//***********************      Consulta Resgistros         ***************************************************************************************************************************/
	
	public void selecionarResultadoBusca(String resultadobusca) {  // Usado no Teste abaixo(Consulta Registro Gera��o) tamb�m
		esperaExplicitaXpath("//div[text()='" + resultadobusca + "']");
	    clicarBotaoXpath("//div[text()='" + resultadobusca + "']");
	}
	
	public String obterTextoRegistro() {
		return obterTextoXpath("//*[text()='ANUIDADE - KARINA FERREIRA HONORIO - Contas a Receber n� 000000377507']");
	}
	
	//***********************    Consulta Registro Gera��o    *****************************************************************************************************************************/
	
	public void abaContasReceberGeracao() {
		clicarBotaoSelector("div[title='Contas a receber � Gera��o']");
	}
	
	public String obterTextoNome() {
		return obterValorCampoTextoCss("div[title='DANIELA SILVEIRA PEREIRA']");
    }
	
    /*********************** MENU LATERAL CONTAS A RECEBER ************************************************************************************************************************/
	
    //*************************** Instruc�es Bancarias ****************************************************************************************************************************/

	public void abaInstrucoesBancarias() {
		clicarLink("Instru��es banc�rias");
		entrarFrame("#panelcategory1>iframe");		
	}
	
	public String obterTextoInstrucoesBancarias() {
		return obterTextoCss("div[title='N�o receber ap�s o vencimento']");
	}
	
	//***************************** Movimentos *********************************************************************************************************************************/
	
	public void abaMovimentos() {
		clicarLink("Movimentos");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public String obterTextoMovimentos() {
		return obterTextoCss("div[title='Reajuste de vencimento']");
	}
	
	//************************* Hist�rico de Contatos **************************************************************************************************************************/
    
	public void abaHistoricoDeContatos() {
		clicarLink("Hist�rico de Contatos");
		entrarFrame("#panelcategory3>iframe");		
	}
	
	public String obterTextoHistoricoDeContatos() {
		return obterTextoXpath("//div[text()='Contato']");		
	}
	
	//************************* Hist�rico de Situa��o **************************************************************************************************************************/
	
	public void abaHistoricoDeSituacao() {
		clicarLink("Hist�rico de Situa��o");
		entrarFrame("#panelcategory4>iframe");
	}
	
	public String obterTextoHistoricoDeSituacao() {
		return obterTextoXpath("//div[text()='Situa��o']");
	}
	
	//***************************** Saldos Utilizados **************************************************************************************************************************/
    
	public void abaSaldosUtilizados() {
		clicarLink("Saldos Utilizados");
		entrarFrame("#panelcategory5>iframe");
	}
	
	public String obterTextoSaldosUtilizados() {
		return obterTextoXpath("//div[text()='Dispon�vel em']");
	}
	
	//****************************** Documentos GED ****************************************************************************************************************************/
	
	public void abaDocumentosGED() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory6>iframe");
	}
	
	public String obterTextoDocumentosGED() {
		return obterTextoXpath("//div[text()='Documento']");
	}
	
	//*************************** Lan�amentos Cont�beis ************************************************************************************************************************/
	
	public void abaLancamentosContabeis() {
		clicarLink("Lan�amentos Cont�beis");
		entrarFrame("#panelcategory7>iframe");
	}
	
	public String obterTextoLancamentosContabeis() {
		return obterTextoXpath("//div[text()='Conta cont�bil']");
	}
	
	//************************** Renegocia��o de Origem **********************************************************************************************************************/
	
	public void abaRenegociacaoDeOrigem() {
		clicarLink("Renegocia��o de origem");
		entrarFrame("#panelcategory9>iframe");
	}
	
	public String obterTextoRenegociacaoDeOrigem() {
		return obterTextoXpath("//div[text()='Renegocia��o atual']");
	}
	
	/************************ MENU FUN��ES CONTAS A RECEBER ********************************************************************************************/
	
	//*************************** Fun��o Impress�o r�pida **********************************************************************************************//
	
	public void botaoFuncoes() {
		clicarBotaoXpath("/html/body/form/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div[1]/em/button/span[1]");		
	}
	
	public void impressaoRapida() {
		clicarBotaoXpath("//*[text()='Impress�o r�pida']");		
	}
	
	public String obterTextoImpressaoRapida() {
		return obterTextoXpath("//*[text()='Avan�ar']");
	}
	
	//**************************** Fun��o Recebimentos *************************************************************************************************//
	
	public void checkboxRegistroGrid() {
		clicarCheck(By.cssSelector("div[class='x-grid-checker-icon']"));
	}
	
	public void recebimentos() {
		clicarBotaoXpath("//*[text()='Recebimentos...']");				
	}
	
	public String obterTextoRecebimentos() {
		return obterTextoXpath("//*[text()='Permite cadastrar as informa��es de recebimentos.']");
	}	
	
	
	//**************************** Fun��o Renegocia��o ************************************************************************************************//
	
	public void renegociacao() {
		clicarBotaoXpath("//*[text()='Renegocia��o...']");		
	}
	
	public String obterTextoRenegociacao() {
		return obterTextoXpath("//*[text()='Total renegociado']");
	}
	
	//**************************** Fun��o Emitir Boleto **********************************************************************************************//
	
	public void emitirBoleto() {
		clicarBotaoXpath("//*[text()='Emitir boleto...']");		
	}
	
	public String obterTextoEmitirBoleto() {
		return obterTextoXpath("//*[text()='Permite selecionar a carteira de cobran�a.']");
	}
	
	//*************************** Fun��o Altera��o de t�tulos ****************************************************************************************//
	
	public void alteracaoDeTitulos() {
		clicarBotaoXpath("//*[text()='Altera��o de T�tulos...']");
	}
	
	public String obterTextoAlteracaoDeTitulos() {
		return obterTextoXpath("//*[text()='Permite alterar as informa��es dos t�tulos a receber.']");
	}
	
	//*************************** Fun��o Atualiza��o de t�tulos *************************************************************************************//
	
	public void atualizacaoDeTitulos() {
		clicarBotaoXpath("//*[text()='Atualiza��o de T�tulos...']");		
	}
	
	public String obterTextoAtualizacaoDeTitulos() {
		return obterTextoXpath("//*[text()='Atualiza��o de Titulos de Recebimento']");
	}
	
	//************************* Fun��o Alterar Situa��o/Complemento *********************************************************************************//
	
	public void alterarSituacaoComplemento() {
		clicarBotaoXpath("//*[contains(@id, 'AlterarSituacaoComplemento_gridpanel')]");				
	}
	
	public String obterTextoAlterarSituacaoComplemento() {
		return obterTextoXpath("//*[text()='Altera��o de Situa��o e/ou Complemento']");
	}
}	