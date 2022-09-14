package Financeiro.Tesouraria;

import static br.conselhos.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.page.Financeiro.TesourariaPage;

public class Tesouraria extends BaseTest {
	private TesourariaPage tesourariaPage = new TesourariaPage();
	
	@Before
	public void InicializaTesouraria() {
	    
		menu.Financeiro();
	    menu.Tesouraria();
	    frame.frameDireita();
	    frame.frameDireita2();
	}
	
	
	@Test
	public void T010_IncluirLancamentos() throws InterruptedException {
		
		page.botaoNovo();
		sairFrame();
		frame.frameNovoRegistroTesouraria();
		tesourariaPage.campoLiquidacao();
		tesourariaPage.campoValor("2.000,00");
		tesourariaPage.campoContaBancaria("CAIXA FUNDO FIXO SEDE");
		tesourariaPage.campoHistorico("Atualização/Aglutinação");
		tesourariaPage.campoTipoDeDocumento("Boleto");
		//tesourariaPage.campoDisponibilidade();
		tesourariaPage.campoFormaLiquidacao("Baixa bancária");
		page.salvareFechar();
		page.esperar2segundos();
		frame.frameDireita();
		frame.frameDireita2();
		tesourariaPage.campoDataInicialLiquidacao();
		tesourariaPage.campoDataFinalLiquidacao();
		page.botaoLocalizar();
		Assert.assertEquals("Atualização/Aglutinação", tesourariaPage.validarTextoInclusaoLancamentosTesouraria());		
	}
	
	@Test
	public void T020_ConsultaRegistroTesouraria() throws InterruptedException {
		
		tesourariaPage.campoDataLiquidacaoDataInicio("01/01/2021");
		tesourariaPage.campoNumeroDocumento();
		page.botaoLocalizar();
		page.esperar3segundos();
		tesourariaPage.selecionarResultadoBusca("44397");
		sairFrame();
		frame.TelaSobreposta();
		assertEquals("Lançamentos no caixa/banco", tesourariaPage.obterTexto("Lançamentos no caixa/banco"));
	}
	
	@Rule
	public TestName testNome = new TestName();
 
    @After
    public void FinalizaTest() throws IOException {
	    
    	TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Tesouraria/" + testNome.getMethodName() + ".jpg"));
    }	

}
