package Financeiro.Cedentes;

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
import br.conselhos.page.Financeiro.CedentesPage;

public class Cedentes extends BaseTest {
	private CedentesPage cendentes = new CedentesPage();
		
    @Before
	public void InicializaCedentes() {
		menu.Financeiro();
		menu.Cedentes();
		frame.frameDireita();
	}
    
    /************************* TELA PRINCIPAL CEDENTES ****************************************************************/
    
    @Test
    public void NovoRegistroCedentes() {
    	
    	cendentes.novo();
    	frame.TelaSobreposta();
    	Assert.assertEquals("Permite cadastrar/alterar informações de outros tipos de cedentes.", cendentes.obterTextoNovoRegistroCedentes());
    }
    
    @Test
    public void Contabilizacao() {
    	
    	cendentes.novo();
    	frame.TelaSobreposta();
    	cendentes.contabilizacao();
    	Assert.assertEquals("Cta. Financeira", cendentes.obterTextoContabilizacao());
    }
    
    @Test
    public void ConsultaCedentes() throws InterruptedException {
    	
    	cendentes.inserirCampoFiltrarOutrosCedentes("Pessoa Teste");
    	page.esperar1segundo();
    	cendentes.selecionarReultadoBusca("Pessoa Teste");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Nome Completo", cendentes.obterTextoConsultaCedentes());
    }
    
    /******************** TELA PRINCIPAL CEDENTES (FORNECEDORES) *******************************************************************************/
    
    //*************** MENU ABAS LATERAIS CONSULTA REGISTRO FORNECEDORES ************************************************************************//
    
    @Test
    public void Geral() throws InterruptedException {
    	
    	cendentes.fornecedores();
    	cendentes.inserirCampoFiltrarFornecedores("Nome Teste Fornecedores");
    	page.esperar1segundo();
    	cendentes.selecionarReultadoBusca("333.098.850-97");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Código", cendentes.obterTextoGeral());
    }
    
    @Test
    public void AreasDeAtuacao() throws InterruptedException {
    	
    	cendentes.fornecedores();
    	cendentes.inserirCampoFiltrarFornecedores("Nome Teste Fornecedores");
    	page.esperar1segundo();
    	cendentes.selecionarReultadoBusca("333.098.850-97");
    	frame.TelaSobreposta();
    	cendentes.abaAreasDeAtuacao();        
    	Assert.assertEquals("Área de Atuação 01", cendentes.obterTextoAreasDeAtuacao());    	
    }
    
    @Test
    public void DocumentosDeHabilitacao() throws InterruptedException {
    	
    	cendentes.fornecedores();
    	cendentes.inserirCampoFiltrarFornecedores("Nome Teste Fornecedores");
    	page.esperar1segundo();
    	cendentes.selecionarReultadoBusca("333.098.850-97");
    	frame.TelaSobreposta();
    	cendentes.abaDocumentosDeHabilitacao();
    	Assert.assertEquals("Teste Documentos Habitação", cendentes.obterTextoDocumentosHabilitacao());   	
    }
    
    @Test
    public void Ocorrencias() throws InterruptedException {
    	
    	cendentes.fornecedores();
    	cendentes.inserirCampoFiltrarFornecedores("Nome Teste Fornecedores");
    	page.esperar1segundo();
    	cendentes.selecionarReultadoBusca("333.098.850-97");
    	frame.TelaSobreposta();
    	cendentes.abaOcorrencias();
    	Assert.assertEquals("Teste Ocorrências", cendentes.obterTextoOcorrencias());    	
    }
    
    @Test
    public void ContatosResponsaveis() throws InterruptedException {
    	
    	cendentes.fornecedores();
    	cendentes.inserirCampoFiltrarFornecedores("Nome Teste Fornecedores");
    	page.esperar1segundo();
    	cendentes.selecionarReultadoBusca("333.098.850-97");
    	frame.TelaSobreposta();
    	cendentes.abaContatosResponsaveis();
    	Assert.assertEquals("Teste Contatos Responsáveis", cendentes.obterTextoContatosResponsaveis());    	
    }
    
    //***************** TELA FORNECEDORES (TABELAS HORIZONTAIS) ***********************************************************************************************//
      
    @Test
    public void Enderecos() throws InterruptedException {
	   
	    cendentes.fornecedores();
   	    cendentes.inserirCampoFiltrarFornecedores("Nome Teste Fornecedores");
   	    page.esperar1segundo();
   	    cendentes.selecionarReultadoBusca("333.098.850-97");
   	    frame.TelaSobreposta();
   	    cendentes.enderecos();
   	   Assert.assertEquals("CEP cx postal", cendentes.obterTextoEnderecos());
    }
    
    @Test
    public void Telefones() throws InterruptedException {
    	
    	cendentes.fornecedores();
    	cendentes.inserirCampoFiltrarFornecedores("Nome Teste Fornecedores");
        page.esperar1segundo();
    	cendentes.selecionarReultadoBusca("333.098.850-97");
    	frame.TelaSobreposta();
    	cendentes.telefones();
    	Assert.assertEquals("Comercial", cendentes.obterTextoTelefones());
    }
    
    @Test
    public void Documentos() throws InterruptedException {
    	
    	cendentes.fornecedores();
    	cendentes.inserirCampoFiltrarFornecedores("Nome Teste Fornecedores");
        page.esperar1segundo();
    	cendentes.selecionarReultadoBusca("333.098.850-97");
    	frame.TelaSobreposta();
    	cendentes.documentos();
    	Assert.assertEquals("RG", cendentes.obterTextoDocumentos());
    }
    
    @Test
    public void InfComplementares() throws InterruptedException {
    	
    	cendentes.fornecedores();
    	cendentes.inserirCampoFiltrarFornecedores("Nome Teste Fornecedores");
        page.esperar1segundo();
    	cendentes.selecionarReultadoBusca("333.098.850-97");
    	frame.TelaSobreposta();
    	cendentes.infComplementares();
    	Assert.assertEquals("Email", cendentes.obterTextoInfComplementares());
    }
    
    @Test
    public void InfFinanceiras() throws InterruptedException {
    	
    	cendentes.fornecedores();
    	cendentes.inserirCampoFiltrarFornecedores("Nome Teste Fornecedores");
        page.esperar1segundo();
    	cendentes.selecionarReultadoBusca("333.098.850-97");
    	frame.TelaSobreposta();
    	cendentes.infFinanceiras();
    	Assert.assertEquals("Banco", cendentes.obterTextoInfFinanceiras());
    }
    
    @Test
    public void AbaContabilizacao() throws InterruptedException {
    	
    	cendentes.fornecedores();
    	cendentes.inserirCampoFiltrarFornecedores("Nome Teste Fornecedores");
        page.esperar1segundo();
    	cendentes.selecionarReultadoBusca("333.098.850-97");
    	frame.TelaSobreposta();
    	cendentes.abaContabilizacao();
    }
    
        
    
    @Rule
    public TestName testNome = new TestName();
	 
	@After
	public void FinalizaTest() throws IOException {
		    
	    TakesScreenshot ss = (TakesScreenshot) getDriver();
	    File arquivo = ss.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Cedentes/" + testNome.getMethodName() + ".jpg"));
	 }
	 

}
