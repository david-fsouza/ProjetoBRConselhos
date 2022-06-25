package Financeiro.DividaAtiva;

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
import br.conselhos.page.Financeiro.DividaAtivaPage;

public class DividaAtiva extends BaseTest {
	private DividaAtivaPage dividaAtiva = new DividaAtivaPage();
	
	@Before
	public void InicializaDividaAtiva() {
		
		menu.Financeiro();
		menu.DividaAtiva();
		frame.frameDireita();
	}
	
	/************************ TELA PRINCIPAL DIVIDA ATIVA ********************************************************************************/
	
	@Test
	public void NovoRegistroDividaAtiva() {
		
		page.botaoNovo();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Número da certidão", dividaAtiva.obterTextoNovoRegistroDividaAtiva());		
	}
	
	@Test
	public void ConsultaDividaAtiva() {
		
		dividaAtiva.selecionarRegistro();
		Assert.assertEquals("12.345", dividaAtiva.obterTextoConsultaDividaAtiva());		
	}
	
	@Test
	public void ImpressaoRapidaDividaAtiva() {
		
		dividaAtiva.funcoes();
		sairFrame();
		dividaAtiva.impressaoRapida();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Avançar", dividaAtiva.obterTextoImpressaoRapida());	
	}
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Divida Ativa/" + testNome.getMethodName() + ".jpg"));
	 }

}
