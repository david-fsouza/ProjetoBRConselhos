package Financeiro.Relatorios;

import static br.conselhos.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.page.Financeiro.CobrancaPage;
import br.conselhos.page.Financeiro.PosicaoFinanceiraPage;
import br.conselhos.page.Financeiro.RelatoriosPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Relatorios extends BaseTest {
	private RelatoriosPage relatorio = new RelatoriosPage();
	private PosicaoFinanceiraPage posicaofinanceira = new PosicaoFinanceiraPage();
	

	@Before
	public void InicializaRelatorios() throws InterruptedException {

		menu.Financeiro();
		menu.Relatorios();
		frame.frameDireita();
		frame.frameDireita2();
	}

	/**
	 * TELA PRINCIPAL RELATÓRIOS
	 */

	@Test
	public void T010_Relatorio_086_pdf() throws InterruptedException {

		relatorio.inserirFiltro("R086C000000");
		page.selecionarRegistro("R086C000000");
		frame.TelaSobreposta();
		relatorio.campoSacado("ABEL WALTER DA SILVA");
		page.esperar1segundo();
		relatorio.gerarRelatorio();
		page.esperar3segundos();
		page.validarDownloadArquivo("RelatorioR086C000000.pdf");
	}
	
	@Test
	public void T020_Relatorio_086_Excel() throws InterruptedException {
		
		relatorio.inserirFiltro("R086C000000");
		page.selecionarRegistro("R086C000000");
		frame.TelaSobreposta();
		relatorio.campoFormatoRelatorio("Excel");
		relatorio.campoSacado("ABEL WALTER DA SILVA");
		page.esperar1segundo();
		relatorio.gerarRelatorio();
		page.esperar3segundos();
		page.validarDownloadArquivo("RelatorioR086C000000.xlsx");	
	}
	
	@Test
	public void T030_Relatorio_084_pdf() throws InterruptedException {
		
		relatorio.inserirFiltro("R084C000000");
		page.selecionarRegistro("R084C000000");
		frame.TelaSobreposta();
		posicaofinanceira.campoSacado("ABEL WALTER DA SILVA");
		page.esperar1segundo();
		relatorio.gerarRelatorio();
		page.esperar3segundos();
		page.validarDownloadArquivo("Relatório R084C000000.pdf");		
	}
	
	@Test
	public void T040_Relatorio_084_Excel() throws InterruptedException {
		
		relatorio.inserirFiltro("R084C000000");
		page.selecionarRegistro("R084C000000");
		frame.TelaSobreposta();
		relatorio.campoFormatoRelario_084("Excel");
		posicaofinanceira.campoSacado("ABEL WALTER DA SILVA");
		page.esperar1segundo();
		relatorio.gerarRelatorio();
		page.esperar3segundos();
		page.validarDownloadArquivo("Relatório R084C000000.xlsx");
	}
	

	@Rule
	public TestName testNome = new TestName();

	@After
	public void FinalizaTest() throws IOException {

		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo,
				new File("target/screenshot/Financeiro/Relatorios/" + testNome.getMethodName() + ".jpg"));
	}

}
