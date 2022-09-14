package Financeiro.RenegociacaoSimulacao;

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
import br.conselhos.page.Financeiro.RenegociacaoSimulacaoPage;

public class RenegociacaoSimulacao extends BaseTest {
	private RenegociacaoSimulacaoPage renegociacaosimulacao = new RenegociacaoSimulacaoPage();
	
	
	@Before
	public void InicializaRenegociacaoSimulacao() throws InterruptedException {
		
		menu.Financeiro();
		menu.RenegociacaoSimulacao();
		frame.frameDireita();
	}
	
	@Test
	public void NovoRenegociacaoSimulacao() {
		
		page.botaoNovo();
		frame.TelaSobreposta();
		Assert.assertEquals("Permite visualizar as simulações / renegociações", renegociacaosimulacao.obterTextoNovoRenegocicaoSimulacao());
	}
	
	@Test
	public void ConsultaRenegociacaoSimulacao() throws InterruptedException {
		
		renegociacaosimulacao.campoFiltrar("44.064.695");
		page.selecionarRegistro("BRUNA CESTARI 23071529");
		frame.TelaSobreposta();
		Assert.assertEquals("Títulos de origem", renegociacaosimulacao.obterTextoConsultaRenegocicaoSimulacao());
	}
	
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Renegociacao Simulacao/" + testNome.getMethodName() + ".jpg"));
	 }

}
