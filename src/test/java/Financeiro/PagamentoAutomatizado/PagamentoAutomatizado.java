package Financeiro.PagamentoAutomatizado;

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
import br.conselhos.page.Financeiro.PagamentoAutomatizadoPage;


/**
 * Classe de execução da função Pagamento Automatizado, deve executar os seguintes testes:
 * 
 * Inclusão de novo registro
 * Consulta do registro
 * Validar itens de Liquidação
 * Validar itens Outros Movimentos 
 * 
 */

public class PagamentoAutomatizado extends BaseTest {
	private PagamentoAutomatizadoPage pagamentoautomatizado = new PagamentoAutomatizadoPage();
	
	@Before
	public void InicializaPagamentoAutomatizado() {
		
		menu.Financeiro();
		menu.PagamentoAutomatizado();
		frame.frameDireita();		
	}
	
	
	/***************************************
	 * TELA INICIAL PAGAMENTO AUTOMATIZADO
	 **************************************/
	
	@Test
	public void NovoRegistroPagementoAutomatizado() {
		
		page.botaoNovo();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Pagamento Automatizado de Retorno ou Remessa", pagamentoautomatizado.obterTextoPagamentoAutomatizadoRetorno());
	}
	
	@Test
	public void ConsultaRegistroPagamentoAutomatizado() throws InterruptedException {
		
		pagamentoautomatizado.inserirCampoFiltrar("docteste.txt");
		page.esperar1segundo();
		page.selecionarRegistro("28/12/2021");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Informações do Arquivo", pagamentoautomatizado.obterTextoConsultaPagamentoAutomatizado());			
	}
	
	@Test
	public void ItensLiquidacao() {
		
		pagamentoautomatizado.inserirCampoFiltrar("docteste.txt");
		pagamentoautomatizado.selecionarResultadoBusca("29/12/2021");
		frame.frameTelaSobreposta();
		pagamentoautomatizado.abaItens();
		Assert.assertEquals("Nenhum registro.", pagamentoautomatizado.obterTextoItensLiquidacao());			
	}
	
	@Test
	public void ItensOutrosMovimentos() throws InterruptedException {
		
		pagamentoautomatizado.inserirCampoFiltrar("docteste.txt");
		page.esperar1segundo();
		pagamentoautomatizado.selecionarResultadoBusca("28/12/2021");
		frame.frameTelaSobreposta();
		pagamentoautomatizado.abaItens();
		pagamentoautomatizado.outrosMovimentos();
		Assert.assertEquals("Nenhum registro.", pagamentoautomatizado.obterTextoItensOutrosMovimentos());	
	}

	
	@Rule
    public TestName testNome = new TestName();
	 
	@After
	public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Pagamento Automatizado/" + testNome.getMethodName() + ".jpg"));
	 }

}
