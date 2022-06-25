package Financeiro.IntegracaoBancaria;

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
import br.conselhos.page.Financeiro.IntegracaoBancariaPage;

public class IntegracaoBancaria extends BaseTest {
	private IntegracaoBancariaPage integracaobancaria = new IntegracaoBancariaPage();
	
	@Before
	public void InicializaGeracaoDeTitulos() throws InterruptedException {
		
		menu.Financeiro();
		menu.IntegracaoBancaria();
		frame.frameDireita();
	}
	
	/*********************  TELA INICIAL Integra��o banc�ria RETORNO ***********************************/
	
	@Test
	public void NovoRegistroRetorno() throws InterruptedException {
		
		page.esperar3segundos();
		integracaobancaria.botaoNovo();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Integra��o Banc�ria de Retorno ou Remessa", integracaobancaria.obterTextoNovoRegistroRetorno());
	}
	
	@Test
	public void ConsultaRegistroRetorno() throws InterruptedException {
		
	    page.esperar3segundos();
		page.inserirCampoFiltrar("0", "Retorno.ret");
		page.esperar1segundo();
		integracaobancaria.selecionarReultadoBusca("Conta B.Brasil");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Informa��es do Arquivo", integracaobancaria.obterTextoRegistroRetorno());				
	}
	
	@Test
	public void ItensLiquidacao() throws InterruptedException {
		
		page.inserirCampoFiltrar("0", "Retorno.ret");
		page.esperar1segundo();
		integracaobancaria.selecionarReultadoBusca("Conta B.Brasil");
		frame.frameTelaSobreposta();
		integracaobancaria.abaItens();
		Assert.assertEquals("T�tulo est� com situa��o Pago.", integracaobancaria.obterTextoItensLiquidacao());		
	}
	
	@Test
	public void ItensOutrosMovimentos() throws InterruptedException {
		
		page.inserirCampoFiltrar("0", "CBR6437331611201821427.ret");
		page.esperar1segundo();
		integracaobancaria.selecionarReultadoBusca("Conta B.Brasil");
		frame.frameTelaSobreposta();
		integracaobancaria.abaItens();
		integracaobancaria.outrosMovimentos();
		Assert.assertEquals("Confirma��o de Entrada de T�tulo", integracaobancaria.obterTextoOutrosMovimentos());		
	}
	
	/*******************  TELA INICIAL Integra��o banc�ria REMESSA ***********************************/
	
	@Test
	public void NovoRegistroRemessa() {
		
		integracaobancaria.remessa();
		page.botaoNovo();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite gerar arquivo de texto com as informa��es do sistema.", integracaobancaria.obterTextoRemessa());		
	}
	
	@Test
	public void ConsultaRegistroRemessa() throws InterruptedException {
		
		integracaobancaria.remessa();
		integracaobancaria.inserirCampoFiltrarRemessa("RemessaCorreio0071.REM");
		page.esperar1segundo();
		integracaobancaria.selecionarReultadoBusca("Conta B.Brasil");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Total de registros", integracaobancaria.obterTextoRegistroRemessa());		
	}
	
	@Test
	public void Movimentos() throws InterruptedException {
		
		integracaobancaria.remessa();
		integracaobancaria.inserirCampoFiltrarRemessa("RemessaCorreio0071.REM");
		page.esperar1segundo();
		integracaobancaria.selecionarReultadoBusca("Conta B.Brasil");
		frame.frameTelaSobreposta();
		integracaobancaria.abaMovimentos();
		Assert.assertEquals("Gera��o de nosso n�mero", integracaobancaria.obterTextoMovimentos());		
	}
	
	@Test
	public void Historico() throws InterruptedException {
		
		integracaobancaria.remessa();
		integracaobancaria.inserirCampoFiltrarRemessa("RemessaCorreio0071.REM");
		page.esperar1segundo();
		integracaobancaria.selecionarReultadoBusca("Conta B.Brasil");
		frame.frameTelaSobreposta();
		integracaobancaria.historico();
		esperaFixa(6000);
		sairFrame();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Hist�rico", integracaobancaria.obterTextoHistorico());
		
		
		
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
