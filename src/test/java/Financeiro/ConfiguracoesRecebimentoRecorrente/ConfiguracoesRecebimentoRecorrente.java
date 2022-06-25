package Financeiro.ConfiguracoesRecebimentoRecorrente;

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
import br.conselhos.page.Financeiro.ConfiguracoesRecebimentoRecorrentePage;

public class ConfiguracoesRecebimentoRecorrente extends BaseTest {
	private ConfiguracoesRecebimentoRecorrentePage configuracoesrecebimento = new ConfiguracoesRecebimentoRecorrentePage();
	
    @Before
	public void InicializaConfiguracoesDeRecebimentoRecorrente() throws InterruptedException {
				
		menu.Financeiro();
		menu.ConfiguracoesRecebimentoRecorrente();
		frame.frameDireita();
    }
    
    /**
     * TELA PRINCIPAL CONFIGURAÇÕES DE RECEBIMENTO RECORRENTE
     */
    
    @Test
    public void NovoConfiguracoesDeRecebimentoRecorrente() {
    	
    	page.botaoNovoTabela("0");
    	frame.frameTelaSobreposta();
    	Assert.assertEquals("Permite criar recebimento recorrente.", configuracoesrecebimento.obterTextoNovoConfiguracoesDeRecebimentoRecorrente());
    }
    
    @Test
    public void ConsultaConfiguracoesDeRecebimentoRecorrente() throws InterruptedException {
    	
    	page.inserirCampoFiltrar("0", "Teste Recebimento Recorrente");
    	page.esperar2segundos();
    	page.selecionarRegistro("Teste Recebimento Recorrente");
    	frame.frameTelaSobreposta();
    	Assert.assertEquals("Recebimento Recorrente.", configuracoesrecebimento.obterTextoConsultaConfiguracoesDeRecebimentoRecorrente());
    }
    
    
    @Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Configuracoes de Recebimento Recorrente/" + testNome.getMethodName() + ".jpg"));
	 }

}
