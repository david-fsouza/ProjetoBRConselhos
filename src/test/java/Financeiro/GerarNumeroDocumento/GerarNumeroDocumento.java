package Financeiro.GerarNumeroDocumento;

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
import br.conselhos.page.Financeiro.GerarNumeroDocumentoPage;

public class GerarNumeroDocumento extends BaseTest {
	private GerarNumeroDocumentoPage gerarnumero = new GerarNumeroDocumentoPage();
	
	@Before
	public void InicializaGerarNumeroDocumento() throws InterruptedException {
		
		menu.Financeiro();
		menu.GerarNumeroDocumento();
		frame.frameDireita();
		frame.frameDireita2();
	}
	
	/******************* TELA PRINCIPAL GERAR NÚMERO DOCUMENTO *************************************************************************/
	
	@Test
	public void NovoGerarNumeroDocumento() throws InterruptedException {
		
		Assert.assertEquals("Permite gerar numeração para documentos.", gerarnumero.obterTextoNovoGerarNumeroDocumento());		
	}
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Gerar Numero Documento/" + testNome.getMethodName() + ".jpg"));
	 }
	
	
	
	

}
