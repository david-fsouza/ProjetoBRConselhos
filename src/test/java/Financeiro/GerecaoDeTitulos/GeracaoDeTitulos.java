package Financeiro.GerecaoDeTitulos;

import static br.conselhos.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

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
import br.conselhos.page.Financeiro.GeracaoDeTitulosPage;


public class GeracaoDeTitulos extends BaseTest {
	private GeracaoDeTitulosPage geracaotitulos = new GeracaoDeTitulosPage();
	
	@Before
	public void InicializaGeracaoDeTitulos() {
		
		menu.Financeiro();
		menu.GeracaoDeTitulos();
		frame.frameDireita();
	}
	
	/***********************  TELA INICIAL Geração DE títulos ***********************************/
	
	@Test
	public void NovoRegistroGeracaoDeTitulos() {
		
		page.botaoNovo();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite gerar títulos a receber.", geracaotitulos.obterTextoNovoRegistroGeracaodeTitulos());				
	}
	
	@Test
	public void ConsultaRegistroGeracaoDeTitulos() throws InterruptedException {
		
		geracaotitulos.inserirCampoFiltrar("BRConselhos");
		page.esperar1segundo();
		geracaotitulos.selecionarResultadoBusca("13/05/2021 15:04:16");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite gerar e/ou consultar informações da geração automática de Títulos", geracaotitulos.obterTextoConsultaGeracaoTitulos());		
	}
	
	@Test
	public void TitulosGerados() throws InterruptedException {
		
		geracaotitulos.inserirCampoFiltrar("BRConselhos");
		page.esperar1segundo();
		geracaotitulos.selecionarResultadoBusca("13/05/2021 15:04:16");
		frame.frameTelaSobreposta();
		geracaotitulos.abaTitulosGerados();
		Assert.assertEquals("545900", geracaotitulos.obterTextoTitulosGerados());	
	}
	
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/GeracaoDeTitulos/" + testNome.getMethodName() + ".jpg"));
	 }
	 
}
    
