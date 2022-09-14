package Financeiro.ConciliacaoBancaria;

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
import br.conselhos.page.Financeiro.ConciliacaoBancariaPage;

public class ConciliacaoBancaria extends BaseTest {
	private ConciliacaoBancariaPage conciliacaobancaria = new ConciliacaoBancariaPage();
	
	@Before
	public void InicializaConciliacaoBancaria() {
	     
		menu.Financeiro();
		menu.ConciliacaoBancaria();
		frame.frameDireita();
	}
	
	/************ TELA PRINCIPAL conciliação bancária (EXTRATOS bancários) ******************************************************************************************/
	
	@Test
	public void NovoRegistroExtratosBancarios() {
		
		page.BotaoNovo();
		frame.TelaSobreposta();
		Assert.assertEquals("Permite cadastrar/consultar informações dos extratos bancários", conciliacaobancaria.obterTextoNovoExtratosBancarios());		
	}
	
	@Test
	public void ConsultaExtratosBancarios() throws InterruptedException {
		
		page.inserirCampoFiltrar0("CAIXA FUNDO FIXO SEDE");
		page.selecionarRegistro("CAIXA FUNDO FIXO SEDE");
		Assert.assertEquals("Conta bancária", conciliacaobancaria.obterTextoConsultaExtratosBancarios());		
	}
	
	@Test
	public void Lancamentos() throws InterruptedException {
		
		page.inserirCampoFiltrar0("CAIXA FUNDO FIXO SEDE");
		page.selecionarRegistro("CAIXA FUNDO FIXO SEDE");
		frame.TelaSobreposta();
		conciliacaobancaria.abaLancamentos();
		Assert.assertEquals("Teste Lançamentos do extrato", conciliacaobancaria.obterTextoLancamentos());
	}
	
	@Test
	public void ImportarExtrato() {
		
		conciliacaobancaria.funcoes();
		sairFrame();
		conciliacaobancaria.importarExtrato();
		frame.TelaSobreposta();
		Assert.assertEquals("Permite realizar a importação dos extratos bancários.", conciliacaobancaria.obterTextoImportarExtrato());
	}
	
	/************ TELA PRINCIPAL conciliação bancária (conciliação) ******************************************************************************************/
		
	@Test
	public void Conciliacao() {
		
		conciliacaobancaria.conciliacao();
		page.botaoNovo();
		frame.TelaSobreposta();
		Assert.assertEquals("Permite efetuar/consultar a conciliação bancária.", conciliacaobancaria.obterTextoConciliacao());
	}
	 	 
	 
	@Rule
	public TestName testNome = new TestName();
		 
	@After
    public void FinalizaTest() throws IOException {
			    
	    TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Conciliacao Bancaria/" + testNome.getMethodName() + ".jpg"));
	}
    	
}
