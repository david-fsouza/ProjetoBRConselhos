package Financeiro.CondicaoDeRecebimento;

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
import br.conselhos.page.Financeiro.CondicaoDeRecebimentoPage;

public class CondicaoDeRecebimento extends BaseTest {
	private CondicaoDeRecebimentoPage condicaorecebimento = new CondicaoDeRecebimentoPage();

	@Before
	public void InicializaCondicaoDeRecebimento() {
		
		menu.Financeiro();
		menu.CondicaoDeRecebimento();
		frame.frameDireita();		
	}
	
	/************************** TELA Condi��o DE RECEBIMENTO *********************************************************************************************/
	
	@Test
	public void NovoCondicaoDeRecebimento() {
		
		page.botaoNovo();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar as configura��es das condi��es para pagamento/recebimento.", condicaorecebimento.obterTextoNovoCondicaoDeRecebimento());
	}
	
	@Test
	public void ConsultaCondicaoDeRecebimento() throws InterruptedException {
		
		page.inserirCampoFiltrar0("Condi��o Taxas");
		page.selecionarRegistro("Condi��o Taxas");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Organiza��o", condicaorecebimento.obterTextoConsultaCondicaoDeRecebimento());
	}
	
	@Test
	public void FormasLiquid() throws InterruptedException {
		
		page.inserirCampoFiltrar0("Condi��o Taxas");
		page.selecionarRegistro("Condi��o Taxas");
		frame.frameTelaSobreposta();
		condicaorecebimento.abaFormasLiquid();
		Assert.assertEquals("Recebimento manual", condicaorecebimento.obterTextoFormasLiquid());
	}
	
	@Test
	public void Instrucoes() throws InterruptedException {
		
		page.inserirCampoFiltrar0("Condi��o Taxas");
		page.selecionarRegistro("Condi��o Taxas");
		frame.frameTelaSobreposta();
		condicaorecebimento.abaInstrucoes();
		Assert.assertEquals("N�o receber ap�s o vencimento", condicaorecebimento.obterTextoInstrucoes());	
	}
	
		
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Condicao de Recebimento/" + testNome.getMethodName() + ".jpg"));
	 }
}
