package br.conselhos.page.Financeiro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class CobrancaPage extends BasePage {
	
    /**
     * OBJETOS COMUNS
     */
	
	public void campoTipoLancamento(String texto) throws InterruptedException {
		clicarBotaoID("m_cbTiposLancamentoEdt");
		esperaFixa(1000);
		sairFrame();
		clicarBotaoSelector("div[title='ANUIDADE PJ']");	
	}
	
	public void consultaHistoricoDeContatos() {
		clicarBotaoSelector("div[title='Consultar Hist�ricos de Contato']");
	}
	
	//******* Gera��o de Contato Simples ********//
	
	public void campoSacado(String texto) throws InterruptedException {
		clicarBotaoID("m_lkpSacadoEdt");
		escreverID("m_lkpSacadoEdt", texto);
		esperaFixa(1000);
		digitaTeclaId("m_lkpSacadoEdt", Keys.ENTER);
	}
	
	public void gerarContato() {
		clicarBotaoSelector("div[title='Gerar Contato']");		
	}
	
	public void campoTipoDeContato(String texto) throws InterruptedException {
		escreverID("m_cbTipoContatoEdt", texto + Keys.ENTER);
		esperaFixa(1000);
	}
	
	public String validarTextoGeracaoContatoSimples() {
		sairFrame();
		return obterTexto("Aten��o");
	}
	
	//******* Gera��o de Contatos com Envio de Boletos em Anexo ********//
	
	public String validarTextoGeracaoEnvioBoletos() {
		sairFrame();
		return obterTexto("Aten��o");	
	}
	
	public String validarTextoHistoricoDeContatoGeradoEnvioBoleto() {
		return obterTexto("Contato cobran�a inicial (gera atualiza��o, gera boleto e envia boleto)");	
	}
	
	//****** Gera��o de Contatos Com Agendamento *******//
	
	public void campoData() throws InterruptedException {
		esperaFixa(2000);
		dataFuturaComHora("m_dtDataContatoEdt", 10);
	}
	
	public String validarTextoGerarContatoComAgendamento() {
		return obterTexto("Carta de Cobran�a Administrativa");
	}
	
	//****** Gerar Relat�rios de Cobran�a ******//
	
	public void gerarRelatorioDeCobranca() {
		clicarBotaoSelector("div[title='Gerar Relat�rio de Cobran�a']");	
	}
	
	//****** Gerar Contato de Recobran�a *******//
	
	public String validarTextoGerarContatoDeCobranca() {
		return obterTexto("Processo de gera��o dos contatos criado com sucesso!");
	}

}
