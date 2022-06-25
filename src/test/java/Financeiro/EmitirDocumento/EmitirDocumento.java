package Financeiro.EmitirDocumento;

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
import br.conselhos.page.Financeiro.EmitirDocumentoPage;

public class EmitirDocumento extends BaseTest {
	private EmitirDocumentoPage emitirdocumento = new EmitirDocumentoPage();
		
    @Before
	public void InicializaEmitirDocumento() throws InterruptedException {
				
		menu.Financeiro();
		menu.EmitirDocumento();
		frame.frameDireita();
		frame.frameDireita2();
	}
    
    @Test
    public void ConsultaEmitirDocumento() throws InterruptedException {
    	
    	emitirdocumento.campoModeloDocumento();
    	emitirdocumento.avancar();
    	Assert.assertEquals("Pessoa", emitirdocumento.obterTextoConsultaEmitirDocumento());
    }
    
    
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Emitir Documento/" + testNome.getMethodName() + ".jpg"));
	 }

	
}
