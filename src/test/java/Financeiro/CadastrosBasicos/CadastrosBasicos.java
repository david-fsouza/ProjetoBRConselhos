package Financeiro.CadastrosBasicos;

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
import br.conselhos.page.Financeiro.CadastrosBasicosPage;

public class CadastrosBasicos extends BaseTest {
	private CadastrosBasicosPage cadastrosbasicos = new CadastrosBasicosPage();
	
    @Before
	public void InicializaCadastrosBasicos() throws InterruptedException {
				
		menu.Financeiro();
		menu.CadastrosBasicos();
		frame.frameDireita();
    }
    
    /*********************************** HIST�RICOS ***************************************************************************************/
    
    @Test
    public void NovoHistoricos() {
    	
    	page.botaoNovoTabela("0");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Permite cadastrar/alterar informa��es de hist�ricos.", page.verificarTextoXpath("Permite cadastrar/alterar informa��es de hist�ricos."));
    }
    
    @Test
    public void ConsultaHistoricos() throws InterruptedException {
    	
    	page.inserirCampoFiltrar("0", "Baixa Autom�tica");
    	page.selecionarRegistro("Baixa Autom�tica");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Hist�rico Cont�bil", page.verificarTextoXpath("Hist�rico Cont�bil"));
    }
    
    /********************************* TIPOS DE CONTATO ***********************************************************************************/
       
    @Test
    public void NovoTiposDeContato() {
    	
    	cadastrosbasicos.tiposDeContato();
    	page.botaoNovoTabela("1");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Permite cadastrar/alterar os tipos de contato", page.verificarTextoXpath("Permite cadastrar/alterar os tipos de contato"));
    }
    
    @Test
    public void ConsultaTiposDeContato() throws InterruptedException {
    	
        cadastrosbasicos.tiposDeContato();
    	page.inserirCampoFiltrar("1", "Notifica��o Extrajudicial");
    	page.selecionarRegistro("Notifica��o Extrajudicial");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Gera��o de Atualiza��o", page.verificarTextoXpath("Gera��o de Atualiza��o"));
    }
    
    /******************************** TIPOS DE DOCUMENTO **********************************************************************************/
    
    @Test
    public void NovoTiposDeDocumento() {
    	
    	cadastrosbasicos.tiposDeDocumento();
    	page.botaoNovoTabela("2");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Permite criar/editar Tipos de Documento", page.verificarTextoXpath("Permite criar/editar Tipos de Documento"));   	
    }
    
    @Test
    public void ConsultaTiposDeDocumento() throws InterruptedException {
    	
     	cadastrosbasicos.tiposDeDocumento();
    	page.inserirCampoFiltrar("2", "Boleto");
    	page.selecionarRegistro("Financeiro");
    	frame.TelaSobreposta();
    	Assert.assertEquals("M�dulo", page.verificarTextoXpath("M�dulo"));
    }
    
    /******************************** TIPOS DE COBRAN�A **********************************************************************************/
    
    @Test
    public void NovoTiposDeCobranca() {
    	
    	cadastrosbasicos.tiposDeCobranca();
    	page.botaoNovoTabela("3");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Permite cadastrar/alterar informa��es dos tipos de cobran�a.", page.verificarTextoXpath("Permite cadastrar/alterar informa��es dos tipos de cobran�a."));    	
    }
    
    @Test
    public void ConsultaTiposDeCobranca() throws InterruptedException {
    	
    	cadastrosbasicos.tiposDeCobranca();
    	page.esperar2segundos();
    	page.inserirCampoFiltrar("3", "Teste Tipos de Cobran�a");
    	page.selecionarRegistro("Teste Tipos de Cobran�a");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Descri��o", page.verificarTextoXpath("Descri��o"));
    }
    
    /******************************** TIPOS DE PAGAMENTO *********************************************************************************/
    
    @Test
    public void NovoTiposDePagamento() {
    	
    	cadastrosbasicos.tiposDePagamento();
    	page.botaoNovoTabela("4");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Permite criar/editar Tipos de Pagamento", page.verificarTextoXpath("Permite criar/editar Tipos de Pagamento"));
    }
    
    @Test
    public void ConsultaTiposDePagamento() throws InterruptedException {
    	
    	cadastrosbasicos.tiposDePagamento();
    	page.inserirCampoFiltrar("4", "12345");
    	page.selecionarRegistro("Teste Tipos de Pagamento");
    	frame.TelaSobreposta();
    	Assert.assertEquals("C�digo", page.verificarTextoXpath("C�digo"));
    }
    
    /********************************* FORMAS LIQUIDA��O **********************************************************************************/
    
    @Test
    public void NovoFormasLiquidacao() {
    	
    	cadastrosbasicos.formasLiquidacao();
    	page.botaoNovoTabela("5");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Permite cadastrar/alterar informa��es das formas de liquida��o.", page.verificarTextoXpath("Permite cadastrar/alterar informa��es das formas de liquida��o."));  	
    }
    
    @Test
    public void ConsultaFormasLiquidacao() throws InterruptedException {
    	
    	cadastrosbasicos.formasLiquidacao();
    	page.inserirCampoFiltrar("5", "Baixa banc�ria");
    	page.selecionarRegistro("Baixa banc�ria");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Conta banc�ria padr�o para recebimentos", page.verificarTextoXpath("Conta banc�ria padr�o para recebimentos"));
    }
   
    
    @Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Cadastros Basicos/" + testNome.getMethodName() + ".jpg"));
	 }

}
