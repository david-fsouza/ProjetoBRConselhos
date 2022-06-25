package Financeiro.IntegracaoDeReceitaRealizada;

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
import br.conselhos.page.Financeiro.IntegracaoDeReceitaRealizadaPage;

public class IntegracaoDeReceitaRealizada extends BaseTest {
	private IntegracaoDeReceitaRealizadaPage receitarealizada = new IntegracaoDeReceitaRealizadaPage();
	
	
	@Before
	public void InicializaIntegracaoDeReaceitaRealizada() {
		
		menu.Financeiro();
		menu.IntegracaoDeReceitasRealizadas();
		frame.frameDireita();
	}	
	
	/************  TELA NOVO REGISTRO INTERGRAçõO DE RECEITAS REALIZADAS ***********************************/

	@Test
	public void ConsultaRegistroReceitaRealizada() throws InterruptedException {
		
	    page.esperar1segundo();
		page.selecionarRegistro("02/04/2022 15:46");
		page.esperar1segundo();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Integração de Receita Realizada", receitarealizada.obterTextoRegistroReceitaRealizada());				
	}
	
	@Test
	public void AbaTitulos() throws InterruptedException {
		
		page.esperar1segundo();
		page.selecionarRegistro("02/04/2022 15:46");
		page.esperar1segundo();
		frame.frameTelaSobreposta();
		receitarealizada.titulos();
		Assert.assertEquals("Nenhum registro.", receitarealizada.obterTextoTitulos());				
	}
	
	
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Integracao de Receita Realizada/" + testNome.getMethodName() + ".jpg"));
	 }
}
