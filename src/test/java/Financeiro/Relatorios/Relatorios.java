package Financeiro.Relatorios;

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
import br.conselhos.page.Financeiro.RelatoriosPage;

public class Relatorios extends BaseTest {
	private RelatoriosPage relatorio = new RelatoriosPage();

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
	public void ConsultaRelatorios() {

		relatorio.inserirFiltro("Lançamentos de Tesouraria por Conta Financeira");
		page.selecionarRegistro("R044C000000");
		frame.frameTelaSobreposta();
		relatorio.botaoAvancar();
		sairFrame();
		Assert.assertEquals("relatório pode ser visualizado localmente, se preferir salve e visualize-o depois",
				relatorio.obterTextoRelatorios());
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
