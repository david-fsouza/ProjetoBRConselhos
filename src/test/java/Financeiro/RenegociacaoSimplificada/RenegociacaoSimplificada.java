package Financeiro.RenegociacaoSimplificada;

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
import br.conselhos.page.Financeiro.RenegociacaoSimplificadaPage;

public class RenegociacaoSimplificada extends BaseTest {
	private RenegociacaoSimplificadaPage renegociacaosimplificada = new RenegociacaoSimplificadaPage();

	
	@Before
	public void InicializaRenegociacaoSimplificada() throws InterruptedException {
		
		menu.Financeiro();
		menu.RenegociacaoSimplificada();
		frame.frameDireita();
		frame.frameDireita2();
	}
	
	@Test
	public void T010_EfetuarRenegociacaoSimplificada() throws InterruptedException {
		
		renegociacaosimplificada.campoPessoaFisica("ZULEIDE MENDES");
		renegociacaosimplificada.campoTipoDeInscricao("INSCRIÇÃO DEFINITIVA PRINCIPAL (AUXILIAR DE ENFERMAGEM)");
		renegociacaosimplificada.campoplanoDePagamento("Parcelamento de Anuidades");
		renegociacaosimplificada.campoQuantidadeDeParcelas("3");
		page.botaoLocalizar();
		//page.selecionarCheckBoxGrid("0");
		page.clicarBotaoGenerico("100,00");
		page.esperar2segundos();
		page.botaoAvancar();
		frame.TelaSobreposta();
		page.botaoConcluir();
		Assert.assertEquals("Informações da renegociação", renegociacaosimplificada.obterTextoNovoRenegociacaoSimplificada());		
	}
	
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Renegociacao Simplificada/" + testNome.getMethodName() + ".jpg"));
	 }
	
}
