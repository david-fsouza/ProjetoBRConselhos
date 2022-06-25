package Financeiro.IndiceseMoedas;

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
import br.conselhos.page.Financeiro.IndiceseMoedasPage;

public class IndiceseMoedas extends BaseTest {
	private IndiceseMoedasPage indicesmoedas = new IndiceseMoedasPage();
	
	@Before
	public void InicializaIndiceseMoedas() {
		
		menu.Financeiro();
		menu.IndiceseMoedas();
		frame.frameDireita();
	}
	
	/*************************** TELA �NDICES E MOEDAS **********************************************************************************************/
	
	@Test
	public void NovoIndiceseMoedas() throws InterruptedException {
		
		page.botaoNovoTabela("0");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informa��es de �ndices, moedas ou taxas.", indicesmoedas.obterTextoNovoIndiceseMoedas());	
	}
	
	@Test
	public void ConsultaIndiceseMoedas() throws InterruptedException {
		
	    page.inserirCampoFiltrar0("ANUENF");
	    page.selecionarRegistro("Enfermeiro - Anuidade");
	    frame.frameTelaSobreposta();
	    sairFrame();
		clicarBotaoSelector("div[title='OK']");
		frame.frameTelaSobreposta();
	    Assert.assertEquals("Sigla", indicesmoedas.obterTextoConsultaIndiceseMoedas());
	}
	
	//*************** MENU LATERAL TELA SOBREPOSTA �ndices E MOEDAS ********************************************************************************//
		
	@Test
	public void Cotacoes() throws InterruptedException {
		
		page.inserirCampoFiltrar0("ANUENF");
	    page.selecionarRegistro("Enfermeiro - Anuidade");
	    frame.frameTelaSobreposta();
	    indicesmoedas.abaCotacoes();
	    Assert.assertEquals("Percentual/ Valor", indicesmoedas.obterTextoCotacoes());	
	}
	
	@Test
	public void PeriodoDeSuspensao() throws InterruptedException {
		
		page.inserirCampoFiltrar0("ANUENF");
	    page.selecionarRegistro("Enfermeiro - Anuidade");
	    frame.frameTelaSobreposta();
	    indicesmoedas.abaPeriodoDeSuspensao();
	    indicesmoedas.obterTextoPeriodoDeSuspensao();
	}
	
	/********************** TELA �ndices E MOEDAS - servi�os ****************************************************************************************/
	
	@Test
	public void Faixas() throws InterruptedException {
		
		indicesmoedas.IndiceseMoedasServicos();
		page.inserirCampoFiltrar1("ANUENF");
	    page.selecionarRegistro("Enfermeiro - Anuidade");
	    frame.frameTelaSobreposta();
	    indicesmoedas.abaFaixas();
	    Assert.assertEquals("acima de", indicesmoedas.obterTextoFaixas());
	}
	
	    	
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Indices e Moedas/" + testNome.getMethodName() + ".jpg"));
	 }
}
