package Financeiro.IntegracaoBancaria;

import static br.conselhos.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Financeiro.PosicaoFinanceira.PosicaoFinanceira;
import br.conselhos.core.BaseTest;
import br.conselhos.page.Financeiro.IntegracaoBancariaPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IntegracaoBancaria extends BaseTest {
	private IntegracaoBancariaPage integracaobancaria = new IntegracaoBancariaPage();
	
	@Before
	public void InicializaGeracaoDeTitulos() throws InterruptedException {
		
		menu.Financeiro();
		menu.IntegracaoBancaria();
		frame.frameDireita();
	}
	
	/**
	 * TELA INICICAL REMESSA
	 */
	
	@Test
	public void T010_GeracaoArquivoRemessa() throws InterruptedException {
		
		integracaobancaria.remessa();
		page.botaoNovo();
		frame.TelaSobreposta();
		integracaobancaria.campoTipo("Carnê");
		integracaobancaria.campoCategoria("TÉCNICO DE ENFERMAGEM");
		frame.TelaSobreposta();
		page.esperar2segundos();
		frame.TelaSobreposta();
		integracaobancaria.campoCarteiraDeCobranca("Carteira - Banco do Brasil");
		integracaobancaria.campoNossoNumero("Gerar novo quando não possuir para carteira selecionada");
		integracaobancaria.campoMaxRegistrosArquivo("1");
		page.esperar2segundos();
		page.botaoGerar();
		page.botaoGerar();
		Assert.assertEquals("Arquivo gerado.", integracaobancaria.validarTextoGeracaoArquivoRemessa());		
	}

	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Integracao Bancaria/" + testNome.getMethodName() + ".jpg"));
	 }
	 

}
