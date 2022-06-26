package br.conselhos.page.Financeiro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class CobrancaPage extends BasePage {
	
	/************************* TELA PRINCIPAL cobrançaS ***********************************************************************************/
	
	//************************* Pesquisa Inadimplentes ***********************************************************************************//
	
	public void campoTipoLancamento(String texto) throws InterruptedException {
		clicarBotaoID("m_cbTiposLancamentoEdt");
		esperaFixa(1000);
		sairFrame();
		clicarBotaoSelector("div[title='ANUIDADE PJ']");
	}
	
	public String obterTextoPesquisaInadimplentes() {
		return obterTextoXpath("//*[text()='Permite consultar os títulos do inadimplente.']");
	}
	
	//********************** Consultar Históricos de Contatos *****************************************************************************//
	
	
	public void selecionarCheckBoxRegistro(String numerodalinha) throws InterruptedException {
		esperaFixa(1000);
		clicarCheck(By.xpath("//*[contains(@class, 'x-grid-row x-grid-row') and contains(@index, '" + numerodalinha + "')]/td/div"));		
	}
	
	public void consultaHistoricoDeContatos() {
		clicarBotaoSelector("div[title='Consultar Históricos de Contato']");
	}
	
	public String obterTextoHistoricoDeContatos() {
		return obterTextoXpath("//*[text()='Permite consultar os históricos do contato.']");
	}
	
	//****************************** Gerar Contatos ************************************************************************************//
	
	public void gerarContatos() {
		clicarBotaoSelector("div[title='Gerar Contato']");		
	}
	
	public String obterTextoGerarContatos() {
		return obterTextoXpath("//*[text()='Permite gerar contatos.']");
	}

	//************************* Gerar Contatos Para Todos ****************************************************************************//
	
	public void gerarContatosParaTodos() {
		clicarBotaoSelector("div[title='Gerar Contato para Todos']");
	}
	
	public String obterTextoGerarContatosParaTodos() {
		return obterTextoXpath("//*[text()='Permite gerar contatos.']");
	}
	
	//************************ Gerar Relatório de cobrança ***************************************************************************//
	
	public String obterTextoRelatorioDeCobranca() {
		return obterTextoXpath("//*[text()='Gerar Relatório de Cobrança']");
	}
	
	
	/************************ TELA DETALHES DO INADIMPLENTE **************************************************************************/
	
	//******************************* Atualização ***********************************************************************************//
	
	public void atualizacao() {
		clicarBotaoSelector("div[title='Atualização.']");
	}
	
	public String obterTextoAtualizacao() {
		return obterTextoXpath("//*[text()='Atualização de Titulos de Recebimento']");
	}
	
	//****************************** Renegociação *******************************************************************************************************//
	
	public void renegociacao() {
		clicarBotaoSelector("div[title='Renegociação.']");		
	}
	
	public String obterTextoRenegociacao() {
		return obterTextoXpath("//*[text()='Títulos de origem']");
	}
	
	//***************************** Imprimir Boleto ****************************************************************************************************//
	
	public void imprimirBoleto() {
		clicarBotaoSelector("div[title='Imprimir boleto.']");		
	}
	
	public String obterTextoImprimirBoleto() {
		return obterTextoXpath("//*[text()='Permite selecionar a carteira de cobrança.']");
	}
	
		
	//********************** Chamada Externa Contas a Receber ****************************************************************************//
	
	public String obterTextoChamadaExternaContasReceber() {
		return obterTextoXpath("//*[text()='ANUIDADE PJ - ZURIELI DE OLIVEIRA SILVEIRA MACHADO - Contas a Receber nº 003575']");
	}

}
