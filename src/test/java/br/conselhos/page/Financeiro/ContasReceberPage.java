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
	
	
	/**
	 * Objetos Gerais
	 */
	public void filtroSituacao(String texto) {
		escreverXpath("//div[@id='tabCt_0']/div/div/div/div/div/div/div[2]/div/div/div/div/div/div[10]/div[3]/div/div/div/input", texto + Keys.ENTER);
	}
	
	public void filtroSituacaoGeracao(String texto) {
		escreverXpath("//div[@id='tabCt_1']/div/div/div/div/div/div/div[2]/div/div/div/div/div/div[9]/div[3]/div/div/div/input", texto + Keys.ENTER);	
	}
	
	public void botaoFuncoes() {
		clicarBotaoXpath("/html/body/form/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div[1]/em/button/span[1]");		
	}
	
	public void filtroBruto(String texto) {
		escreverXpath("//div[@id='tabCt_0']/div/div/div/div/div/div/div[2]/div/div/div/div/div/div[6]/div[3]/div/div/div/input", texto + Keys.ENTER);
	}
	
	public void filtroVencimento() throws InterruptedException {
		dataFuturaXpath("//div[@id='tabCt_0']/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div/div/div[6]/div[3]/div[1]/div/div/input", 2);
		
		
		
	}
	
	
	//***** TELA CONTAS A RECEBER *****//
	
	//***** Cadastro Contas a Receber *****/

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
	
	public void campoParcela(String parcela) throws InterruptedException {
		escrever("Parcela", parcela);
        esperaFixa(2000);
	}
	
	public void campoVencimento() throws InterruptedException {
		dataFuturaName("DataMovimento", 2);
	    digitaTeclaName("DataMovimento", Keys.ENTER);
	    esperaFixa(3000);
	}
	
	public void campoValorBruto(String valor) throws InterruptedException {
		escrever("ValorBruto", valor);
	    esperaFixa(2000);
	    digitaTeclaName("ValorBruto", Keys.ENTER);
	    esperaFixa(2000);
	}
	
	
	public void pesquisaSacado(String sacado ) {
		escreverXpath("/html/body/form/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div/div/div[2]/div[3]/div/div/div/input", sacado + Keys.ENTER);
	}
	
	public String validarTextoCadastroContasReceber() {
		return obterTexto("Permite cadastrar/alterar informações de títulos a receber.");
	}
	

	
	//***** TELA CONTAS A RECEBER - GERAÇÃO *****//
	
	//***** Contas Receber - Geração (Envio de Boleto Email Selecionadas******/
	
	public void abaContasReceberGeracao() {
		clicarBotaoSelector("div[title='Contas a receber – Geração']");
	}
	
	public void gerarBoletosSelecionados() {
		clicarBotaoXpath("//*[text()='Gerar boletos - Selecionados']");
	}
	
	public void campoMotivoAlerta(String texto) throws InterruptedException {
		escreverID("lkMotivoAlertaEdt", texto + Keys.ENTER);
		esperaFixa(2000);
	}
	
	public String validarTextoGeracaoEnvioBoletoEmailSelenionadas() {
		return obterTexto("Alertas agendado com sucesso.");
    }
	
	/***** Contas Receber - Geração (Envio de Boleto Email Todos *****/
	
	public void gerarBoletosTodos() {
		clicarBotaoXpath("//*[text()='Gerar boletos - Todos']");
	}
	
	public void campoFiltroPersonalizado(String texto) throws InterruptedException {
		escreverID("cbFiltrosEdt", texto + Keys.ENTER);
		esperaFixa(2000);
	}
	
	public String validarTextoGerecaoEnvioBoletoEmailTodos() {
		return obterTexto("O processo de envio de boletos por e-mail foi agendada.");
	}
	
	/***** Geração Impressão de Boletos - Selecionadas  *****/
	
	public void campoFuncao(String texto) throws InterruptedException {
		clicarBotaoID("cbFuncaoEdt");
		esperaFixa(1000);
		escreverID("cbFuncaoEdt", texto + Keys.ENTER);
		esperaFixa(2000);
	}
	
	
	//***** Estorno Recebimento ******/
	
	public void abaMovimentos() {
		clicarLink("Movimentos");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public void estornar() {
		clicarBotaoXpath("//*[text()='Estornar']");
	}
	public String obterTextoMovimentos() {
		return obterTexto("Estorno de recebimento");
	}

	
	//****** Documentos GED Inclusão ******/
	
	public void abaDocumentosGED() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory6>iframe");
	}
	
	public void campoTipoDocumento(String texto) {
		escreverID("m_cbTipoDocumentoEdt", texto );
		digitaTeclaId("m_cbTipoDocumentoEdt", Keys.ENTER);
	}
	
	public void campoDocumento(String nomearquivo) {
		uploadArquivo("file", nomearquivo);
	}
	
	public String validarTextoDocumentoGED() {
		return obterTexto("138528.pdf");
	}
	
	//******Documentos GED Alteração*******//
	
	public void campoTipoAssunto(String texto) throws InterruptedException {
		clicarBotaoID("m_lkTipoAssuntoEdt");
		escreverID("m_lkTipoAssuntoEdt", texto);
		esperaFixa(1000);
		digitaTeclaId("m_lkTipoAssuntoEdt", Keys.ENTER);
	}
	
	public String validarTextoDocumentosGEDAlteracao() throws InterruptedException {
		esperaFixa(3000);
		return obterTexto("Permite criar/alterar os Documentos GED");		
	}
	
	//******* Documentos GED Exclusao******//
	
	public String validarTextoGEDExclusao() {
		return obterTexto("Nenhum registro.");
	}
	
	
	//**** Recebimentos*****//
	
	public void checkboxRegistroGrid() {
		clicarCheck(By.cssSelector("div[class='x-grid-checker-icon']"));
	}
	
	public void recebimentos() {
		clicarBotaoXpath("//*[text()='Recebimentos...']");				
	}
	
	public String validarTextoRecebimentos() {
		return obterTexto("Permite cadastrar as informações de recebimentos.");
	}
	
	public void campoConta(String texto) throws InterruptedException {
		
		escreverID("m_lkContaBancariaEdt", texto);
		esperaFixa(2000);
		digitaTeclaId("m_lkContaBancariaEdt", Keys.ENTER);
	}
	
	public void campoHistorico(String texto) throws InterruptedException {
		
		escreverID("m_lkHistoricoEdt", texto);
		esperaFixa(2000);
		digitaTeclaId("m_lkHistoricoEdt", Keys.ENTER);
	}
	
	public void campoFormaLiquidacao(String texto) throws InterruptedException {
		clicarBotaoID("m_lkFormaLiquidacaoEdt");
		escreverID("m_lkFormaLiquidacaoEdt", texto);
        esperaFixa(2000);
		digitaTeclaId("m_lkFormaLiquidacaoEdt", Keys.ENTER);
		esperaFixa(1000);		
	}
	
	
	//**** Recebimento de Renegociações ****//
	
	public void renegociacao() {
		clicarBotaoXpath("//*[text()='Renegociação...']");		
	}
	
	public void campoQuantidadeParcelas(String texto) {
		escreverID("m_nbNumeroParcelaEdt", texto);
	}
	
	public void vencimentoPrimeiraParcela() throws InterruptedException {
		dataFutura("m_dtVctoPrimeiraParcelaEdt", 20);
	}
	
	public void concluirRenegociacao() {
		clicarBotaoSelector("div[title='Concluir renegociação']");
	}
	
	public String validarTextoRenegociacao() {
		sairFrame();
		return obterTexto("Renegociação gerada com sucesso.");
	}
	
	//******Emissão de Boleto ******//
	
	public void emitirBoleto() {
		clicarBotaoXpath("//*[text()='Emitir boleto...']");		
	}
	
	public String validarTextoEmitirBoleto() {
		return obterTexto("Permite selecionar a carteira de cobrança.");
	}
	
	public void botaoGerar() {
		clicarBotaoID("btnGerar");
	}

	
	//****** Alterar Situação/Complemento *****//
	
	public void alterarSituacaoComplemento() {
		clicarBotaoXpath("//*[contains(@id, 'AlterarSituacaoComplemento_gridpanel')]");				
	}
	
	public void campoSituacao(String texto) {
		clicarBotaoID("cbSituacaoEdt");
		sairFrame();
		clicarBotaoXpath("//*[text()='" + texto + "']");
	}
	
	public String validarTextoAlterarSituacaoComplemento() {
		return obterTexto("Alteração de Situação e/ou Complemento");
	}
}	