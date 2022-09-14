package Financeiro.ConfiguracaoDeRepassesAutomaticos;

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
import br.conselhos.page.Financeiro.ConfiguracaoDeRepassesAutomaticosPage;

public class ConfiguracaoDeRepassesAutomaticos extends BaseTest {
	private ConfiguracaoDeRepassesAutomaticosPage repassesautomaticos = new ConfiguracaoDeRepassesAutomaticosPage();
	
	@Before
	public void InicializaConfiguracaoDeRepassesAutomaticos() {
		menu.Financeiro();
		menu.ConfiguracaoDeRepassesAutomaticos();
		frame.frameDireita();		
	}
	
	/********************  TELA NOVO REGISTRO REPASSES AUTOMATICOS  ***********************************/
	
	@Test
	public void NovoRegistroRepassesAutomaticos() {
		
		page.botaoNovo();
		frame.TelaSobreposta();
		repassesautomaticos.campoNomeDoRepasse("Teste novo registro");
		repassesautomaticos.salvareFechar();
		sairFrame();
		frame.frameDireita();
		Assert.assertEquals("Teste novo registro", repassesautomaticos.obterTextoRepassesAutomaticos());				
    }
	
	@Test
	public void InformacoesDeRepasse() throws InterruptedException {
		
		repassesautomaticos.selecionarRegistroRepasseAutomaticos();
		frame.TelaSobreposta();
		repassesautomaticos.abaInformacoesDeRepasse();
		page.esperar1segundo();
		Assert.assertEquals("Nenhum registro.", repassesautomaticos.obterTextoInformacoesDeRepasse());		
	}
	
	@Test
	public void Receitas() throws InterruptedException {
		
		repassesautomaticos.selecionarRegistroRepasseAutomaticos();
		frame.TelaSobreposta();
		repassesautomaticos.abaReceitas();
		Assert.assertEquals("Nenhum registro.", repassesautomaticos.obterTextoReceitas());			
	}
	
	
	
	 @Rule
     public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Configuracao de Repasses Automaticos/" + testNome.getMethodName() + ".jpg"));
	 }
}
