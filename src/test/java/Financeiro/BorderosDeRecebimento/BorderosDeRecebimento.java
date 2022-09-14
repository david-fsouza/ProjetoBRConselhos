package Financeiro.BorderosDeRecebimento;

import static br.conselhos.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import br.conselhos.core.BaseTest;
import br.conselhos.page.Financeiro.BorderosDeRecebimentoPage;
import io.qameta.allure.Allure;

public class BorderosDeRecebimento extends BaseTest {
	private BorderosDeRecebimentoPage borderosrecebimento = new BorderosDeRecebimentoPage();
	
	@Before
	public void InicializaBorderosDeRecebimento() {
		menu.Financeiro();
		menu.BorderosDeRecebimento();
		frame.frameDireita();
	}
	
	/******************* TELA PRINCIPAL BORDERÃ£S DE RECEBIMENTO ************************************************************************/
	   
	@Test
	public void NovoRegistroBorderosDeRecebimento() {
		
		borderosrecebimento.Novo();
		frame.TelaSobreposta();
		Assert.assertEquals("Permite visualizar os borderôs de recebimento", borderosrecebimento.obterTextoNovoRegistroBorderosRecebimento());				
	}
	
	@Test
	public void ConsultaBorderosDeRecebimento() throws InterruptedException {
		
		borderosrecebimento.selecionarReultadoBusca("15");
		Assert.assertEquals("Valor total recebido", borderosrecebimento.obterTextoConsultaBorderosRecebimento());		
	}
	
	@Test
	public void NovoRegistroItens() throws InterruptedException {
		
		borderosrecebimento.selecionarReultadoBusca("15");
		frame.TelaSobreposta();
		borderosrecebimento.Itens();
		page.botaoNovo();
		Assert.assertEquals("Titular", borderosrecebimento.obterTextoNovoRegistroItens());		                        			
	}
	
	
	@Rule
    public TestName testNome = new TestName();
	
	 
	@After
	public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Borderos de Recebimento/" + testNome.getMethodName() + ".jpg"));
	 }
	 
}	 
