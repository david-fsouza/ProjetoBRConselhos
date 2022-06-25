package Financeiro.HistoricoDeContatos;

import static br.conselhos.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.page.Financeiro.HistoricoDeContatosPage;

public class HistoricoDeContatos extends BaseTest {
	private HistoricoDeContatosPage historicodecontatos = new HistoricoDeContatosPage();
	
	@Before
	public void InicializaHistoricoDeContatos() {
		menu.Financeiro();
		menu.HistoricoDeContatos();
		frame.frameDireita();
	}
	
	/********************* TELA PRINCIPAL HISTORICO DE CONTATOS ************************************************************************************/
	
	@Test
	public void NovoRegistroHistoricoDeContatos() {
		
		page.botaoNovo();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Representa o Histórico de Contato com uma Pessoa.", historicodecontatos.obterTextoNovoRegistroHistoricoDeContatos());
	}
	
	@Test
	public void ConsultaHistoricoDeContatos() throws InterruptedException {
		
		page.inserirCampoFiltrar0("BEATRIZ DE FATIMA FANTIN");
		page.selecionarRegistro("Notificação Extrajudicial");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Representa o Histórico de Contato com uma Pessoa.", historicodecontatos.obterTextoConsultaHistoricoDeContatos());
	}
	
	/*********************************** FUNçõES ***************************************************************************************************/
	
	@Test
	public void Documentos() throws InterruptedException {
		
	    page.inserirCampoFiltrar0("ARIANNE ANDREACI ZULEGER DORINI");
	    page.selecionarCheckBoxGrid("0");
		page.botaoFuncoes0();
		sairFrame();
	    historicodecontatos.documentos();
		Assert.assertEquals("Modelo de documento", historicodecontatos.obterTextoDocumentos());
	}
	
	@Test
	public void ImpressaoRapida() {
		
		page.botaoFuncoes0();
		sairFrame();
		historicodecontatos.impressaoRapida();
		Assert.assertEquals("escolha a árvore da dados que você deseja visualizar ou imprimir", historicodecontatos.obterTextoImpressaoRapida());		
	}
	
	/***************** MENU LATERAL ESQUERDO TELA SOBREPOSTA REGISTRO ******************************************************************************/
	
	@Test
	public void ContasaReceber() throws InterruptedException {
		
		page.inserirCampoFiltrar0("ACENALDO FERREIRA LIMA");
		page.selecionarRegistro("Carta de Cobrança Administrativa");
		frame.frameTelaSobreposta();
		historicodecontatos.abaContasaReceber();
		Assert.assertEquals("000000365618", historicodecontatos.obterTextoContasaReceber());		
	}
	
	@Test
	public void DocumentosGED() throws InterruptedException {
		
		page.inserirCampoFiltrar0("ACENALDO FERREIRA LIMA");
		page.selecionarRegistro("Carta de Cobrança Administrativa");
		frame.frameTelaSobreposta();
		historicodecontatos.abaDocumentosGED();
		page.selecionarRegistro("ACENALDO FERREIRA LIMA");
		sairFrame();
		frame.frameTelaSobreposta2();
		Assert.assertEquals("Permite criar/alterar os Documentos GED", historicodecontatos.obterTextoDocumentosGED());				
	}
	
	/**************************** TELA ENVIO DE BOLETOS ******************************************************************************************/
	
	@Test
	public void ConsultaEnvioDeBoletos() throws InterruptedException {
		
		historicodecontatos.envioDeBoletos();
		page.inserirCampoFiltrar1("ANDRE JUNKES");
		page.selecionarRegistro("17/11/2021 17:16:46");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Histórico de Contato", historicodecontatos.obterTextoEnvioDeBoletos());
	}
	
		
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Historico de Contatos/" + testNome.getMethodName() + ".jpg"));
	 }
	

}
