package Financeiro.Cobranca;

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
import br.conselhos.page.Financeiro.CobrancaPage;

public class Cobranca extends BaseTest {
	private CobrancaPage cobranca = new CobrancaPage();
	
	@Before
	public void InicializaCobranca() {
		menu.Financeiro();
		menu.Cobranca();
		frame.frameDireita();
		frame.frameDireita2();
	}
	
	/************************* TELA PRINCIPAL cobrançaS ***********************************************************************************/
	
	@Test
	public void PesquisaInadimplentes() throws InterruptedException {
		
		cobranca.campoTipoLancamento("ANUIDADE PJ");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.selecionarRegistro("ABDOM MURILO BARBOSA SANCHEZ");
        frame.chamadaExternContasReceber();
		Assert.assertEquals("Permite consultar os títulos do inadimplente.", cobranca.obterTextoPesquisaInadimplentes());
	}
	
	@Test
	public void ConsultarHistoricosDeContatos() throws InterruptedException {
		
		cobranca.campoTipoLancamento("ANUIDADE PJ");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		cobranca.selecionarCheckBoxRegistro("1");
		cobranca.consultaHistoricoDeContatos();
		frame.historicoDeContatos();
		Assert.assertEquals("Permite consultar os históricos do contato.", cobranca.obterTextoHistoricoDeContatos());
	}
	
	@Test
	public void GerarContatos() throws InterruptedException {
		
		cobranca.campoTipoLancamento("ANUIDADE PJ");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		cobranca.selecionarCheckBoxRegistro("1");
		cobranca.gerarContatos();
		frame.contato();
		Assert.assertEquals("Permite gerar contatos.", cobranca.obterTextoGerarContatos());				
	}
	
	@Test
	public void GerarContatosParaTodos() throws InterruptedException {
		
		cobranca.campoTipoLancamento("ANUIDADE PJ");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		cobranca.selecionarCheckBoxRegistro("1");
		cobranca.gerarContatosParaTodos();
		frame.contato();
		Assert.assertEquals("Permite gerar contatos.", cobranca.obterTextoGerarContatosParaTodos());		
	}
	
	@Test
	public void GerarRelatorioDeCobranca() {
		
		Assert.assertEquals("Gerar Relatório de Cobrança", cobranca.obterTextoRelatorioDeCobranca());	
	}
	
	/********************** TELA DETALHES DO INADIMPLENTE *****************************************************************************************************/
	
	@Test
	public void Atualizacao() throws InterruptedException {
		
		cobranca.campoTipoLancamento("ANUIDADE PJ");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.selecionarRegistro("ABEL PENHACHEKI");
        frame.chamadaExternContasReceber();
        cobranca.selecionarCheckBoxRegistro("0");
        cobranca.atualizacao();
        sairFrame();
        frame.consultaDetalheInadimplente();
        Assert.assertEquals("Atualização de Titulos de Recebimento", cobranca.obterTextoAtualizacao());
   	}
	
	@Test
	public void Renegociacao() throws InterruptedException {
		
		cobranca.campoTipoLancamento("ANUIDADE PJ");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.selecionarRegistro("ABEL PENHACHEKI");
        frame.chamadaExternContasReceber();
        cobranca.selecionarCheckBoxRegistro("0");
        cobranca.renegociacao();
        sairFrame();
        frame.consultaDetalheInadimplente();
        Assert.assertEquals("Títulos de origem", cobranca.obterTextoRenegociacao());
	}
	
	@Test
	public void ImprimirBoleto() throws InterruptedException {
		
		cobranca.campoTipoLancamento("ANUIDADE PJ");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.selecionarRegistro("ABEL PENHACHEKI");
        frame.chamadaExternContasReceber();
        cobranca.selecionarCheckBoxRegistro("0");
        cobranca.imprimirBoleto();
        sairFrame();
        frame.consultaDetalheInadimplente();
        Assert.assertEquals("Permite selecionar a carteira de cobrança.", cobranca.obterTextoImprimirBoleto());
	}
	
	@Test
	public void ChamadaExternaContasReceber() throws InterruptedException {
		
		cobranca.campoTipoLancamento("ANUIDADE PJ");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.selecionarRegistro("ZURIELI DE OLIVEIRA SILVEIRA MACHADO");
        frame.chamadaExternContasReceber();
        page.selecionarRegistro("28/02/2022");
        sairFrame();
        page.esperar2segundos();
        Assert.assertEquals("ANUIDADE PJ - ZURIELI DE OLIVEIRA SILVEIRA MACHADO - Contas a Receber nº 003575", cobranca.obterTextoChamadaExternaContasReceber());
   	 }
	
	 
	
	 @Rule
     public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Cobranca/" + testNome.getMethodName() + ".jpg"));
	 }
	
}
