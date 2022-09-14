package Financeiro.GerecaoDeTitulos;

import static br.conselhos.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

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

import br.conselhos.core.BaseTest;
import br.conselhos.page.Financeiro.GeracaoDeTitulosPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GeracaoDeTitulos extends BaseTest {
	private GeracaoDeTitulosPage geracaotitulos = new GeracaoDeTitulosPage();
	
	@Before
	public void InicializaGeracaoDeTitulos() {
		
		menu.Financeiro();
		menu.GeracaoDeTitulos();
		frame.frameDireita();
	}
	
	
	@Test
	public void T010_GeracaoDeTitulosSelecionados() throws InterruptedException {
		
		page.botaoNovo();
		frame.TelaSobreposta();
		geracaotitulos.campoAno("2022");
		geracaotitulos.campoValor("100");
		geracaotitulos.campoTipoLancamento("ANUIDADE");
		geracaotitulos.campoCondicao("Anuidades - Cota Única");
		geracaotitulos.campoVencimentoParcela();
		geracaotitulos.campoPessoa("ZULEIDE MENDES");
		page.botaoLocalizar();
		page.selecionarRegistro("32750");
		geracaotitulos.gerarParaSelecionados();			
		Assert.assertEquals("Geração de títulos a receber concluída.", geracaotitulos.validarTextoGeracaoTitulosSelecionados());			
	}
	
	@Test
	public void T020_GeracaoDeTitulosAgendamento() throws InterruptedException {
		
		page.botaoNovo();
		frame.TelaSobreposta();
		geracaotitulos.campoAno("2022");
		geracaotitulos.campoValor("100");
		geracaotitulos.campoTipoLancamento("ANUIDADE");
		geracaotitulos.campoCondicao("Anuidades - Cota Única");
		geracaotitulos.campoVencimentoParcela();
		geracaotitulos.campoPessoa("ZULEIDE MENDES");
		page.botaoLocalizar();
		page.selecionarRegistro("32750");
		geracaotitulos.agendarParaSelecionados();
		page.esperar3segundos();
		frame.TelaSobreposta();
		geracaotitulos.iniciarExecucoes();
		frame.TelaSobreposta2();
		frame.GeracaoDeTitulosFrame2();
		geracaotitulos.iniciar();
		page.esperar3segundos();
		frame.TelaSobreposta();
		Assert.assertEquals("Em andamento", geracaotitulos.validarTextoGeracaoTitulosAgendamento());		
	}
	
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/GeracaoDeTitulos/" + testNome.getMethodName() + ".jpg"));
	 }
	 
}
    
