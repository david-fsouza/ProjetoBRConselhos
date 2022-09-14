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
    
    /*********************************** HISTÓRICOS ***************************************************************************************/
    
    @Test
    public void NovoHistoricos() {
    	
    	page.botaoNovoTabela("0");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Permite cadastrar/alterar informações de históricos.", page.verificarTextoXpath("Permite cadastrar/alterar informações de históricos."));
    }
    
    @Test
    public void ConsultaHistoricos() throws InterruptedException {
    	
    	page.inserirCampoFiltrar("0", "Baixa Automática");
    	page.selecionarRegistro("Baixa Automática");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Histórico Contábil", page.verificarTextoXpath("Histórico Contábil"));
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
    	page.inserirCampoFiltrar("1", "Notificação Extrajudicial");
    	page.selecionarRegistro("Notificação Extrajudicial");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Geração de Atualização", page.verificarTextoXpath("Geração de Atualização"));
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
    	Assert.assertEquals("Módulo", page.verificarTextoXpath("Módulo"));
    }
    
    /******************************** TIPOS DE COBRANÇA **********************************************************************************/
    
    @Test
    public void NovoTiposDeCobranca() {
    	
    	cadastrosbasicos.tiposDeCobranca();
    	page.botaoNovoTabela("3");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Permite cadastrar/alterar informações dos tipos de cobrança.", page.verificarTextoXpath("Permite cadastrar/alterar informações dos tipos de cobrança."));    	
    }
    
    @Test
    public void ConsultaTiposDeCobranca() throws InterruptedException {
    	
    	cadastrosbasicos.tiposDeCobranca();
    	page.esperar2segundos();
    	page.inserirCampoFiltrar("3", "Teste Tipos de Cobrança");
    	page.selecionarRegistro("Teste Tipos de Cobrança");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Descrição", page.verificarTextoXpath("Descrição"));
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
    	Assert.assertEquals("Código", page.verificarTextoXpath("Código"));
    }
    
    /********************************* FORMAS LIQUIDAÇÃO **********************************************************************************/
    
    @Test
    public void NovoFormasLiquidacao() {
    	
    	cadastrosbasicos.formasLiquidacao();
    	page.botaoNovoTabela("5");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Permite cadastrar/alterar informações das formas de liquidação.", page.verificarTextoXpath("Permite cadastrar/alterar informações das formas de liquidação."));  	
    }
    
    @Test
    public void ConsultaFormasLiquidacao() throws InterruptedException {
    	
    	cadastrosbasicos.formasLiquidacao();
    	page.inserirCampoFiltrar("5", "Baixa bancária");
    	page.selecionarRegistro("Baixa bancária");
    	frame.TelaSobreposta();
    	Assert.assertEquals("Conta bancária padrão para recebimentos", page.verificarTextoXpath("Conta bancária padrão para recebimentos"));
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
