package Financeiro.FluxoDeCaixa;

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
import br.conselhos.page.Financeiro.FluxoDeCaixaPage;

public class FluxoDeCaixa extends BaseTest {
	private FluxoDeCaixaPage fluxocaixa = new FluxoDeCaixaPage();
		
   @Before
   public void InicializaFluxoDeCaixa() throws InterruptedException {
					
	   menu.Financeiro();
	   menu.FluxoDeCaixa();
	   frame.frameDireita();
   }
   
   /**
    * TELA PRINCIPAL FLUXLO DE CAIXA
    */
   
   @Test
   public void NovoFluxoDeCaixa() {
	   
	   page.botaoNovoTabela("0");
	   frame.TelaSobreposta();
	   Assert.assertEquals("Valor", fluxocaixa.obterTextoNovoFluxoDeCaixa());
   }
   
   @Test
   public void ConsultaFluxoDeCaixa() throws InterruptedException {
	   
	   page.inserirCampoFiltrar("0", "Teste");
	   page.esperar2segundos();
	   page.selecionarRegistro("1.000,00");
	   frame.TelaSobreposta();	
	   Assert.assertEquals("Data Vencimento", fluxocaixa.obterTextoConsultaFluxoDeCaixa());
   }
   
   @Rule
   public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Fluxo de Caixa/" + testNome.getMethodName() + ".jpg"));
	 }


}
