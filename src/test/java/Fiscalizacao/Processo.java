package Fiscalizacao;

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
import br.conselhos.page.Fiscalizacao.ProcessoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Processo extends BaseTest {
	private ProcessoPage processo = new ProcessoPage();
	
	@Before
	public void InicializaProcesso() {
		 
		menu.Fiscalizacao();
		frame.frameDireita();
	}
	
	@Test
	public void T010_IncluirInfracaoProcessoFiscalizacao() throws InterruptedException {
		
		page.inserirCampoFiltrar("0", "VICTOR GUILHERME HAMMEMEISTER");
		page.selecionarRegistro("AD-1014");
		frame.TelaSobreposta();
		processo.abaInfracao();
		page.botaoNovo();
		frame.processosInfracoesFiscalizacao();
		processo.campoDescricao("Inclusão infração Fiscalização");
        page.salvar();
        page.esperar2segundos();
        sairFrame();
        page.OK();
        frame.frameDireita();
        frame.TelaSobreposta();
        frame.processosInfracoesFiscalizacao();
        page.fechar();
        frame.frameDireita();
        frame.TelaSobreposta();
        processo.abaInfracao();
        Assert.assertEquals("Inclusão infração Fiscalização", processo.validarTextoIncluirInfracaoProcesso());		
	}
	
	@Test
	public void T020_ExcluirInfracaoProcessoFiscalizacao() throws InterruptedException {
		
		page.inserirCampoFiltrar("0", "VICTOR GUILHERME HAMMEMEISTER");
        page.selecionarRegistro("AD-1014");
        frame.TelaSobreposta();
        processo.abaInfracao();
        clicarBotaoDireito("Inclusão infração Fiscalização");
        page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		processo.abaInfracao();
		Assert.assertEquals("Nenhum registro.", processo.validarTextoExcluirInfracaoProcesso());
	}
	
	
	 @Rule
     public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Fiscalizacao/Processo/" + testNome.getMethodName() + ".jpg"));
	 }

}
