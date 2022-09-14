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
		clicarBotaoSelector("div[title='Consultar Históricos de Contato']");
	}
	
	//******* Geração de Contato Simples ********//
	
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
		return obterTexto("Atenção");
	}
	
	//******* Geração de Contatos com Envio de Boletos em Anexo ********//
	
	public String validarTextoGeracaoEnvioBoletos() {
		sairFrame();
		return obterTexto("Atenção");	
	}
	
	public String validarTextoHistoricoDeContatoGeradoEnvioBoleto() {
		return obterTexto("Contato cobrança inicial (gera atualização, gera boleto e envia boleto)");	
	}
	
	//****** Geração de Contatos Com Agendamento *******//
	
	public void campoData() throws InterruptedException {
		esperaFixa(2000);
		dataFuturaComHora("m_dtDataContatoEdt", 10);
	}
	
	public String validarTextoGerarContatoComAgendamento() {
		return obterTexto("Carta de Cobrança Administrativa");
	}
	
	//****** Gerar Relatórios de Cobrança ******//
	
	public void gerarRelatorioDeCobranca() {
		clicarBotaoSelector("div[title='Gerar Relatório de Cobrança']");	
	}
	
	//****** Gerar Contato de Recobrança *******//
	
	public String validarTextoGerarContatoDeCobranca() {
		return obterTexto("Processo de geração dos contatos criado com sucesso!");
	}

}
