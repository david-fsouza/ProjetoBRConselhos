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
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações de títulos a receber.']");
	}
	
	//********************       Acréscimos e Descontos        ******************************************************************************************************************************/
	
	public void acrescimoseDescontos() {
		clicarBotaoSelector("div[title='Acréscimos e Descontos']");
	}
	
	public String obterValorAcrescimoseDescontos() {
		return obterTextoCss("div[title='Acréscimos e Descontos']");
	}
	
	//********************       Informacoes Liquidação        *******************************************************************************************************************************/
	
	public void abaInformacoesDaLiquidacao() {
		clicarBotaoSelector("div[title='Informações da Liquidação']");
    }
	
	public String obterValorInformacoesLiquidacao() {
		return obterTextoCss("div[title='Informações da Liquidação']");
	}
	
	//********************             Observações             ********************************************************************************************************************************/
	
	public void abaObservacoes() {
		clicarBotaoSelector("div[title='Observações']");
	}
	
	public String obterValorAbaObservacoes() {
		return obterTextoCss("div[title='Observações']");
	}
 
	/************************ CONSULTA REGISTROS EXISTENTES ********************************************************************************************************************/
	
	//***********************      Consulta Resgistros         ***************************************************************************************************************************/
	
	public void selecionarResultadoBusca(String resultadobusca) {  // Usado no Teste abaixo(Consulta Registro Geração) também
		esperaExplicitaXpath("//div[text()='" + resultadobusca + "']");
	    clicarBotaoXpath("//div[text()='" + resultadobusca + "']");
	}
	
	public String obterTextoRegistro() {
		return obterTextoXpath("//*[text()='ANUIDADE - KARINA FERREIRA HONORIO - Contas a Receber nº 000000377507']");
	}
	
	//***********************    Consulta Registro Geração    *****************************************************************************************************************************/
	
	public void abaContasReceberGeracao() {
		clicarBotaoSelector("div[title='Contas a receber – Geração']");
	}
	
	public String obterTextoNome() {
		return obterValorCampoTextoCss("div[title='DANIELA SILVEIRA PEREIRA']");
    }
	
    /*********************** MENU LATERAL CONTAS A RECEBER ************************************************************************************************************************/
	
    //*************************** Instrucões Bancarias ****************************************************************************************************************************/

	public void abaInstrucoesBancarias() {
		clicarLink("Instruções bancárias");
		entrarFrame("#panelcategory1>iframe");		
	}
	
	public String obterTextoInstrucoesBancarias() {
		return obterTextoCss("div[title='Não receber após o vencimento']");
	}
	
	//***************************** Movimentos *********************************************************************************************************************************/
	
	public void abaMovimentos() {
		clicarLink("Movimentos");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public String obterTextoMovimentos() {
		return obterTextoCss("div[title='Reajuste de vencimento']");
	}
	
	//************************* Histórico de Contatos **************************************************************************************************************************/
    
	public void abaHistoricoDeContatos() {
		clicarLink("Histórico de Contatos");
		entrarFrame("#panelcategory3>iframe");		
	}
	
	public String obterTextoHistoricoDeContatos() {
		return obterTextoXpath("//div[text()='Contato']");		
	}
	
	//************************* Histórico de Situação **************************************************************************************************************************/
	
	public void abaHistoricoDeSituacao() {
		clicarLink("Histórico de Situação");
		entrarFrame("#panelcategory4>iframe");
	}
	
	public String obterTextoHistoricoDeSituacao() {
		return obterTextoXpath("//div[text()='Situação']");
	}
	
	//***************************** Saldos Utilizados **************************************************************************************************************************/
    
	public void abaSaldosUtilizados() {
		clicarLink("Saldos Utilizados");
		entrarFrame("#panelcategory5>iframe");
	}
	
	public String obterTextoSaldosUtilizados() {
		return obterTextoXpath("//div[text()='Disponível em']");
	}
	
	//****************************** Documentos GED ****************************************************************************************************************************/
	
	public void abaDocumentosGED() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory6>iframe");
	}
	
	public String obterTextoDocumentosGED() {
		return obterTextoXpath("//div[text()='Documento']");
	}
	
	//*************************** Lançamentos Contábeis ************************************************************************************************************************/
	
	public void abaLancamentosContabeis() {
		clicarLink("Lançamentos Contábeis");
		entrarFrame("#panelcategory7>iframe");
	}
	
	public String obterTextoLancamentosContabeis() {
		return obterTextoXpath("//div[text()='Conta contábil']");
	}
	
	//************************** Renegociação de Origem **********************************************************************************************************************/
	
	public void abaRenegociacaoDeOrigem() {
		clicarLink("Renegociação de origem");
		entrarFrame("#panelcategory9>iframe");
	}
	
	public String obterTextoRenegociacaoDeOrigem() {
		return obterTextoXpath("//div[text()='Renegociação atual']");
	}
	
	/************************ MENU FUNçõES CONTAS A RECEBER ********************************************************************************************/
	
	//*************************** Função Impressão rápida **********************************************************************************************//
	
	public void botaoFuncoes() {
		clicarBotaoXpath("/html/body/form/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div[1]/em/button/span[1]");		
	}
	
	public void impressaoRapida() {
		clicarBotaoXpath("//*[text()='Impressão rápida']");		
	}
	
	public String obterTextoImpressaoRapida() {
		return obterTextoXpath("//*[text()='Avançar']");
	}
	
	//**************************** Função Recebimentos *************************************************************************************************//
	
	public void checkboxRegistroGrid() {
		clicarCheck(By.cssSelector("div[class='x-grid-checker-icon']"));
	}
	
	public void recebimentos() {
		clicarBotaoXpath("//*[text()='Recebimentos...']");				
	}
	
	public String obterTextoRecebimentos() {
		return obterTextoXpath("//*[text()='Permite cadastrar as informações de recebimentos.']");
	}	
	
	
	//**************************** Função Renegociação ************************************************************************************************//
	
	public void renegociacao() {
		clicarBotaoXpath("//*[text()='Renegociação...']");		
	}
	
	public String obterTextoRenegociacao() {
		return obterTextoXpath("//*[text()='Total renegociado']");
	}
	
	//**************************** Função Emitir Boleto **********************************************************************************************//
	
	public void emitirBoleto() {
		clicarBotaoXpath("//*[text()='Emitir boleto...']");		
	}
	
	public String obterTextoEmitirBoleto() {
		return obterTextoXpath("//*[text()='Permite selecionar a carteira de cobrança.']");
	}
	
	//*************************** Função Alteração de títulos ****************************************************************************************//
	
	public void alteracaoDeTitulos() {
		clicarBotaoXpath("//*[text()='Alteração de Títulos...']");
	}
	
	public String obterTextoAlteracaoDeTitulos() {
		return obterTextoXpath("//*[text()='Permite alterar as informações dos títulos a receber.']");
	}
	
	//*************************** Função Atualização de títulos *************************************************************************************//
	
	public void atualizacaoDeTitulos() {
		clicarBotaoXpath("//*[text()='Atualização de Títulos...']");		
	}
	
	public String obterTextoAtualizacaoDeTitulos() {
		return obterTextoXpath("//*[text()='Atualização de Titulos de Recebimento']");
	}
	
	//************************* Função Alterar Situação/Complemento *********************************************************************************//
	
	public void alterarSituacaoComplemento() {
		clicarBotaoXpath("//*[contains(@id, 'AlterarSituacaoComplemento_gridpanel')]");				
	}
	
	public String obterTextoAlterarSituacaoComplemento() {
		return obterTextoXpath("//*[text()='Alteração de Situação e/ou Complemento']");
	}
}	