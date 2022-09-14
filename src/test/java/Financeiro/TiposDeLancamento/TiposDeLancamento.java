package Financeiro.TiposDeLancamento;

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
import br.conselhos.page.Financeiro.TiposDeLancamentoPage;

public class TiposDeLancamento extends BaseTest {
	private TiposDeLancamentoPage tipolancamento = new TiposDeLancamentoPage();
	
	@Before
	public void InicializaTiposDeLancamento() throws InterruptedException {
		
		menu.Financeiro();
		menu.TipoDeLancamento();
		frame.frameDireita();
	}
	
	@Test
	public void NovoTiposDeLancamento() {
		
		page.botaoNovo();
		frame.TelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações dos tipos de lançamento.", tipolancamento.obterTextoNovoTiposDeLancamento());
	}
	
	@Test
	public void ConsultaTiposDeLacamento() throws InterruptedException {
		
		page.inserirCampoFiltrar0("ATUALIZAÇÃO");
		page.selecionarRegistro("ATU");
		frame.TelaSobreposta();
	}

	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/TiposDeLancamento/" + testNome.getMethodName() + ".jpg"));
	 }
}
