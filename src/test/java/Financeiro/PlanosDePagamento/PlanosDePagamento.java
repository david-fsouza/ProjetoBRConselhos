package Financeiro.PlanosDePagamento;

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
import br.conselhos.page.Financeiro.PlanosDePagamentoPage;

public class PlanosDePagamento extends BaseTest {
	private PlanosDePagamentoPage planospagamento = new PlanosDePagamentoPage();
	
		
	@Before
	public void InicializaRenegociacaoSimulacao() throws InterruptedException {
			
		menu.Financeiro();
		menu.PlanosDePagamento();
		frame.frameDireita();
	}
	
	@Test
	public void NovoPlanosDePagamento() {
		
		page.botaoNovo();
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permitir selecionar títulos a renegociar", planospagamento.obterTextoNovoPlanoDePagamento());
	}
	
	@Test
	public void ConsultaPlanoDePagamento() throws InterruptedException {
		
		page.inserirCampoFiltrar0("Renegociação Débitos em Dívida Ativa");
		page.selecionarRegistro("01/01/2019");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Opção de parcelamento", planospagamento.obterTextoConsultaPlanosPagamento());		
	}
	
	@Test
	public void FiltroPessoa() throws InterruptedException {
		
		page.inserirCampoFiltrar0("Renegociação Débitos em Dívida Ativa");
		page.selecionarRegistro("01/01/2019");
		frame.frameTelaSobreposta();
		planospagamento.filtroPessoa();
		Assert.assertEquals("Filtro SQL de restrição de pessoas", planospagamento.obterTextoFiltroPessoa());		
	}
	
	@Test
	public void FiltroTitulo() throws InterruptedException {
		
		page.inserirCampoFiltrar0("Renegociação Débitos em Dívida Ativa");
		page.selecionarRegistro("01/01/2019");
		frame.frameTelaSobreposta();
		planospagamento.filtroTitulo();
		Assert.assertEquals("Tipos de lançamentos", planospagamento.obterTextoFiltroTitulo());
	}
	
	@Test
	public void Permissoes() throws InterruptedException {
		
		page.inserirCampoFiltrar0("Renegociação Débitos em Dívida Ativa");
		page.selecionarRegistro("01/01/2019");
		frame.frameTelaSobreposta();
		planospagamento.abaPermissoes();
		Assert.assertEquals("Administradores do sistema", planospagamento.obterTextoPermissoes());
	}
		
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Planos de Pagamento/" + testNome.getMethodName() + ".jpg"));
	 }
	 
}
