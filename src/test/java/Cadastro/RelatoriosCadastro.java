package Cadastro;

import static br.conselhos.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.page.Cadastros.RelatoriosCadastroPage;
import br.conselhos.page.Financeiro.PosicaoFinanceiraPage;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RelatoriosCadastro extends BaseTest {
	private RelatoriosCadastroPage relatorioscadastro = new RelatoriosCadastroPage();
	private PosicaoFinanceiraPage posicaofinanceira = new PosicaoFinanceiraPage();
	
	@Before
	public void InicializaRelatorios() throws InterruptedException {
		
		menu.Cadastros();
		menu.RelatoriosCadastro();
		frame.frameDireita();	
		frame.frameDireita2();
	}
	
	@Test
	public void T010_EmitirRelatorio_086_pdf() throws InterruptedException {

		relatorioscadastro.inserirFiltro("R086C000000");
		page.selecionarRegistro("R086C000000");
		frame.TelaSobreposta();
		relatorioscadastro.campoSacado("ABEL WALTER DA SILVA");
		page.esperar1segundo();
		relatorioscadastro.gerarRelatorio();
		page.esperar3segundos();
		page.validarDownloadArquivo("RelatorioR086C000000.pdf");
	}
	
	@Test
	public void T020_EmitirRelatorio_086_Excel() throws InterruptedException {
		
		relatorioscadastro.inserirFiltro("R086C000000");
		page.selecionarRegistro("R086C000000");
		frame.TelaSobreposta();
		relatorioscadastro.campoFormatoRelatorio("Excel");
		relatorioscadastro.campoSacado("ABEL WALTER DA SILVA");
		page.esperar1segundo();
		relatorioscadastro.gerarRelatorio();
		page.esperar3segundos();
		page.validarDownloadArquivo("RelatorioR086C000000.xlsx");	
	}
	
	@Test
	public void T030_EmitirRelatorio_084_pdf() throws InterruptedException {
		
		relatorioscadastro.inserirFiltro("R084C000000");
		page.selecionarRegistro("R084C000000");
		frame.TelaSobreposta();
		posicaofinanceira.campoSacado("ABEL WALTER DA SILVA");
		page.esperar1segundo();
		relatorioscadastro.gerarRelatorio();
		page.esperar3segundos();
		page.validarDownloadArquivo("Relatório R084C000000.pdf");		
	}
	
	@Test
	public void T040_EmitirRelatorio_084_Excel() throws InterruptedException {
		
		relatorioscadastro.inserirFiltro("R084C000000");
		page.selecionarRegistro("R084C000000");
		frame.TelaSobreposta();
		relatorioscadastro.campoFormatoRelario_084("Excel");
		posicaofinanceira.campoSacado("ABEL WALTER DA SILVA");
		page.esperar1segundo();
		relatorioscadastro.gerarRelatorio();
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
				new File("target/screenshot/Cadastros/Relatorios/" + testNome.getMethodName() + ".jpg"));
	}

}
