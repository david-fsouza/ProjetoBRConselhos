package Financeiro.PosicaoFinanceira;

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
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.page.Financeiro.ContasReceberPage;
import br.conselhos.page.Financeiro.PosicaoFinanceiraPage;
import br.conselhos.page.Financeiro.*;
import br.conselhos.page.Financeiro.ContasReceberPage;

public class PosicaoFinanceira extends BaseTest {
	private PosicaoFinanceiraPage posicaoFinanceira = new PosicaoFinanceiraPage();

	@Before
	public void InicializaPosicaoFinanceira() throws InterruptedException {

		menu.Financeiro();
		menu.PosicaoFinanceira();
		frame.frameDireita();
		frame.frameDireita2();

	}

	/***************************************
	 * TELA NOVO REGISTRO POSIÇÃO FINANCEIRA
	 **************************************/

	@Test
	public void NovoRegistroPosicaoFinanceira() {

		page.botaoNovo();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações de títulos a receber.",
				posicaoFinanceira.obterTexto("Permite cadastrar/alterar informações de títulos a receber."));
	}

	//@Test
	//public void ConsultaRegistroPosicaoFinanceira() throws InterruptedException {

	//	posicaoFinanceira.campoSacado("ADRIANA APARECIDA LUZETTI");
	//	sairFrame();
	//	frame.frameDireita();
	//	frame.frameDireita2();
	//	posicaoFinanceira.botaoLocalizar();
	//	page.esperar3segundos();
	//	posicaoFinanceira.selecionarResultadoBusca("328,46");
	//	page.esperar3segundos();
	//	sairFrame();
	//	Assert.assertEquals("ANUIDADE - ADRIANA APARECIDA LUZETTI - Contas a Receber nº 000000365698", posicaoFinanceira
	//			.obterTexto("ANUIDADE - ADRIANA APARECIDA LUZETTI - Contas a Receber nº 000000365698"));
	//}

	@Rule
	public TestName testNome = new TestName();

	@After
	public void FinalizaTest() throws IOException {

		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo,
				new File("target/screenshot/Financeiro/Posicao Financeira/" + testNome.getMethodName() + ".jpg"));
	}

}
