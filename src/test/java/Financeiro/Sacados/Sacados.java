package Financeiro.Sacados;

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
import br.conselhos.page.Financeiro.SacadosPage;

public class Sacados extends BaseTest {
	private SacadosPage sacados = new SacadosPage();
	
	@Before
	public void InicializaSacados() {
		
		menu.Financeiro();
		menu.Sacados();
		frame.frameDireita();
    }

	/***************************** TELA INICIAL SACADOS ******************************************************************************/
	
    @Test
    public void NovoRegistroScados() {
    	
    	page.botaoNovo();
    	frame.TelaSobreposta();
    	Assert.assertEquals("Permite cadastrar/alterar informações de sacados.", sacados.obterTextoNovoRegistroSacados());  	
    }
    
    @Test
    public void Enderecos() {
    	
    	page.botaoNovo();
    	frame.TelaSobreposta();
    	sacados.enderecos();
    	Assert.assertEquals("CEP", sacados.obterTextoEnderecos());    	
    }
    
    @Test
    public void Contabilizacao() {
    	
    	page.botaoNovo();
    	frame.TelaSobreposta();
    	sacados.contabilizacao();
    	Assert.assertEquals("Cta. Financeira", sacados.obterTextoContabilizacao());    	
    }
    
    @Test
    public void ConsultaRegistroSacados() throws InterruptedException {
    	
    	sacados.inserirCampoFiltrar("084.181.370-10");
    	page.esperar1segundo();
    	sacados.selecionarResultadoBusca("Paulo Cesar Pitz");
    	frame.TelaSobreposta();
    	Assert.assertEquals("CPF", sacados.obterTextoConsultaRegistroSacados());   	
    }
    
    @Test
    public void Historico() throws InterruptedException {
    	
    	sacados.inserirCampoFiltrar("084.181.370-10");
    	page.esperar1segundo();
    	sacados.selecionarResultadoBusca("Paulo Cesar Pitz");
    	frame.TelaSobreposta();
    	sacados.historico();
    	Assert.assertEquals("Histórico", sacados.obterTextoHistorico()); 	
    }
    
    @Test
    public void LogRegistro() throws InterruptedException {
    	
    	sacados.inserirCampoFiltrar("084.181.370-10");
    	page.esperar1segundo();
    	sacados.selecionarResultadoBusca("Paulo Cesar Pitz");
    	frame.TelaSobreposta();
    	sacados.log();
    	frame.TelaSobreposta();
    	Assert.assertEquals("Log", sacados.obterTextoLogRegistro());   	
    }
    
	

	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Sacados/" + testNome.getMethodName() + ".jpg"));
	 }
	
	
}	