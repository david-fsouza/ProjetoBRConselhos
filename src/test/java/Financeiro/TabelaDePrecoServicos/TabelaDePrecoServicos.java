package Financeiro.TabelaDePrecoServicos;

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
import br.conselhos.page.Financeiro.TabelaDePrecoServicosPage;

public class TabelaDePrecoServicos extends BaseTest {
	private TabelaDePrecoServicosPage tabelaprecoservico = new TabelaDePrecoServicosPage();

	@Before
	public void InicializaTabelaDePrecoServicos() throws InterruptedException {
		
		menu.Financeiro();
		menu.TabelaDePrecoServicos();
		frame.frameDireita();
	}
	
	/******************** TELA PRINCIPAL TABELA DE preço serviços *********************************************************************************/
	
	@Test
	public void NovoTabelaDePrecoServicos() {
		
		page.botaoNovo();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações de tabela de preço serviços solicitações.", tabelaprecoservico.obterTextoNovoTabelaDePrecoServicos());		
	}
	
    @Test																				
    public void ConsultaTabelaDePrecoServicos() throws InterruptedException {
		
		page.inserirCampoFiltrar0("Tabela de preços 2014");
		page.selecionarRegistro("01/01/2014");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Vigência", tabelaprecoservico.obterTextoConsultaTabelaDePrecoServico());
	}
	
	@Test
	public void Servicos() throws InterruptedException {
		
		page.inserirCampoFiltrar0("Tabela de preços 2014");
		page.selecionarRegistro("01/01/2014");
		frame.frameTelaSobreposta();
		tabelaprecoservico.abaServicos();
		Assert.assertEquals("PJ - Taxa de Registro", tabelaprecoservico.obterTextoServicos());
		
		
	}


 

	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Tabela de Preco Servicos/" + testNome.getMethodName() + ".jpg"));
	 }
	 
}





