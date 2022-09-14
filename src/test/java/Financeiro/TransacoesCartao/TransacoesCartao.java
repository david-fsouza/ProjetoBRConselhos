package Financeiro.TransacoesCartao;

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
import br.conselhos.page.Financeiro.TransacoesCartaoPage;

public class TransacoesCartao extends BaseTest {
	private TransacoesCartaoPage transacoescartao = new TransacoesCartaoPage();
	
	@Before
	public void InicializaTransacoesCartao() {
		menu.Financeiro();
	    menu.TranscoesCartao();
	    frame.frameDireita();
	}
	
	/*********************** TELA PRINCIPAL TRANSAÇOESS CARTÃ£O *****************************************************************************/
	
	@Test
	public void ConsultaRegistroTransacoesCartao() throws InterruptedException {
		transacoescartao.inserirCampoFiltrar("1A986BFC-47E2-41FF-B6B4-120870730AB4");
		transacoescartao.selecionarResultadoBusca("165,00");
		frame.TelaSobreposta();
		Assert.assertEquals("Permite visualizar as transações envolvendo cartão de crédito", transacoescartao.obterTextoTransacoesCartao());			 
	}
	
	/************************* MENU LATERAL TELA SOBREPOSTA ********************************************************************************/	
	
	@Test
	public void Liquidacoes() throws InterruptedException {
		transacoescartao.inserirCampoFiltrar("1A986BFC-47E2-41FF-B6B4-120870730AB4");
		transacoescartao.selecionarResultadoBusca("165,00");
		frame.TelaSobreposta();
		transacoescartao.abaLiquidacoes();
		Assert.assertEquals("Quitado", transacoescartao.obterTextoLiquidacoes());		
	}
	
	@Test
	public void Titulos() throws InterruptedException {
		
		transacoescartao.inserirCampoFiltrar("1A986BFC-47E2-41FF-B6B4-120870730AB4");
		//page.esperar3segundos();
		transacoescartao.selecionarResultadoBusca("165,00");
		frame.TelaSobreposta();
	    transacoescartao.abaTitulos();
	    Assert.assertEquals("Nenhum registro.", transacoescartao.obterTextoTitulos());	    
	}
		
		
	 @Rule
     public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Transacoes Cartao/" + testNome.getMethodName() + ".jpg"));
	 }

} 
