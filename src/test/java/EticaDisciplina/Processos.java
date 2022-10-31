package EticaDisciplina;

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

import br.conselhos.core.BaseTest;
import br.conselhos.page.EticaDisciplina.ProcessosPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Processos extends BaseTest {
	private ProcessosPage processos = new ProcessosPage();
	
	@Before
	public void InicializaProcessos() {
		 
		menu.EticaDisciplina();
		frame.frameDireita();
	}
	
	@Test
	public void T010_IncluirInfracaoProcessoEticaDisciplina() throws InterruptedException {
		
        page.inserirCampoFiltrar("0", "ALEXANDRE MELLO VIANA");
        page.selecionarRegistro("273.189");
        frame.TelaSobreposta();
        processos.abaInfracoes();
        page.botaoNovo();
        frame.processosInfracoesEticaDisciplina();
        processos.campoDescricao("Inclusão de infração");
        page.salvar();
        page.esperar2segundos();
        page.fechar();
        frame.frameDireita();
        frame.TelaSobreposta();
        processos.abaInfracoes();
        Assert.assertEquals("Inclusão de infração", processos.validarTextoinclusaoInfracao());	
	}
	
	@Test
	public void T020_ExcluirInfracaoProcessoEticaDisciplina() throws InterruptedException {
		
        page.inserirCampoFiltrar("0", "ALEXANDRE MELLO VIANA");
        page.selecionarRegistro("273.189");
        frame.TelaSobreposta();
        processos.abaInfracoes();
        clicarBotaoDireito("Inclusão de infração");
        page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		processos.abaInfracoes();
		Assert.assertEquals("Nenhum registro.", processos.validarTextoExcluirInfracaoProcesso());
	}
	
	
	 @Rule
     public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Etica e Disciplina/Processos/" + testNome.getMethodName() + ".jpg"));
	 }
	
}
