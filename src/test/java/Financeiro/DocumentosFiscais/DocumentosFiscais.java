package Financeiro.DocumentosFiscais;

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
import br.conselhos.page.Financeiro.DocumentosFiscaisPage;

public class DocumentosFiscais extends BaseTest {
	private DocumentosFiscaisPage documentosfiscais = new DocumentosFiscaisPage();
	
    @Before
	public void InicializaDocumentosFiscais() throws InterruptedException {
				
		menu.Financeiro();
		menu.DocumentosFiscais();
		frame.frameDireita();
    }
    
    /**
     * TELA PRINCIPAL DOCUMENTOS FISCAIS
     */
    
    @Test
    public void NovoDocumentosFiscais() {
    	
    	page.botaoNovoTabela("0");
    	frame.frameTelaSobreposta();
    	Assert.assertEquals("Permite manter os documentos fiscais.", documentosfiscais.obterTextoNovoDocumentosFiscais());
    }
    
    @Test
    public void ConsultaDocumentosFiscais() throws InterruptedException {
    	
    	page.inserirCampoFiltrar("0", "Nome Teste Fornecedores");
    	page.esperar1segundo();
    	page.selecionarRegistro("Boleto");
    	frame.frameTelaSobreposta();
    	Assert.assertEquals("Documentos Fiscais", documentosfiscais.obterTextoConsultaDocumentosFiscais());
    }
    
    /**
     * Tela Menu Lateral Tela Sobreposta
     * 
     */
    
    @Test
    public void Liquidacoes() throws InterruptedException {
    	
    	page.inserirCampoFiltrar("0", "Nome Teste Fornecedores");
    	page.esperar2segundos();
    	page.selecionarRegistro("Boleto");
    	frame.frameTelaSobreposta();
    	documentosfiscais.abaLiquidacoes();
    	Assert.assertEquals("Valor documento", documentosfiscais.obterTextoLiquidacoes());
    }
    
    @Test
    public void DocumentosGED() throws InterruptedException {
    	
    	page.inserirCampoFiltrar("0", "Nome Teste Fornecedores");
    	page.esperar1segundo();
    	page.selecionarRegistro("Boleto");
    	frame.frameTelaSobreposta();
    	documentosfiscais.abaDocumentosGED();
    	Assert.assertEquals("Data de Vínculo", documentosfiscais.obterTextoDocumentosGED());
    	
    	
    	
    }
    
    
    @Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Documentos Fiscais/" + testNome.getMethodName() + ".jpg"));
	 }

}
