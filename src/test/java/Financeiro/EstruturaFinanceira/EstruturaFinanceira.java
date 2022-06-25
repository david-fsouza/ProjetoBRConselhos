package Financeiro.EstruturaFinanceira;

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
import br.conselhos.page.Financeiro.EstruturaFinanceiraPage;

public class EstruturaFinanceira extends BaseTest {
	private EstruturaFinanceiraPage estruturafinanceira = new EstruturaFinanceiraPage();
	
	@Before
	public void InicializaEstruturaFinanceira() throws InterruptedException {
		
		menu.Financeiro();
		menu.EstruturaFinanceira();
		frame.frameDireita();
	}
	
	/******************************* PLANO FINANCEIRO ********************************************************************/
	
	@Test
	public void NovoPlanoFinanceiro() {
		
		page.botaoNovoTabela("0");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações dos planos financeiros.", estruturafinanceira.obterTextoNovoPlanoFinanceiro());				
	}
	
	@Test
	public void ConsultaPlanoFinanceiro() {
		
		page.selecionarRegistro("ORÇAMENTO");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações dos planos financeiros.", estruturafinanceira.obterTextoConsultaPlanoFinanceiro());
	}
	
	@Test
	public void ContasFinanceiras() {
		
		page.selecionarRegistro("ORÇAMENTO");
		frame.frameTelaSobreposta();
		estruturafinanceira.abaContasFinanceiras();
		page.selecionarRegistro("EXECUÇÃO DO ORÇAMENTO");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações dos planos financeiros.", estruturafinanceira.obterTextoContasFinanceiras());
	}
	
	/************************* PLANO DE CENTRO DE RESULTADO 
	 * @throws InterruptedException *******************************************************************************************************/
	
	@Test
	public void NovoPlanoCentroResultado() throws InterruptedException {
		
		estruturafinanceira.planoCentroResultado();
		page.botaoNovoTabela("1");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações sobre os planos de centros de resultado.", estruturafinanceira.obterTextoNovoPlanoCentroResultado());

	}
	
	@Test
	public void ConsultaPlanoCentroResultado() throws InterruptedException {
		
		estruturafinanceira.planoCentroResultado();
		page.selecionarRegistro("Padrão");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Vigência", estruturafinanceira.obterTextoConsultaPlanoCentroResultado());	
	}
	
	@Test
	public void CentrosDeResultado() throws InterruptedException {
		
		estruturafinanceira.planoCentroResultado();
		page.selecionarRegistro("Padrão");
		frame.frameTelaSobreposta();
		estruturafinanceira.abaCentrosDeResultado();
		Assert.assertEquals("BRC", estruturafinanceira.obterTextoCentrosDeResultado() );
	}
	
	/****************************** PLANO CONTÁBIL ************************************************************************************************************************/
	
	@Test
	public void NovoPlanoContabil() {
		
		estruturafinanceira.planoContabil();
		page.botaoNovoTabela("2");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações do plano contábil.", estruturafinanceira.obterTextoNovoPlanoContabil());		
	}
	
	@Test
	public void ConsultaPlanoContabil() {
		
		estruturafinanceira.planoContabil();
		page.selecionarRegistro("PLANO DE CONTAS");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Descrição", estruturafinanceira.obterTextoConsultaPlanoContabil());
	}
	
	@Test
	public void ContasContabeis() {
		
		estruturafinanceira.planoContabil();
		page.selecionarRegistro("PLANO DE CONTAS");
		frame.frameTelaSobreposta();
		estruturafinanceira.abaContasContabeis();
		Assert.assertEquals("R68R", estruturafinanceira.obterTextoContasContabeis() );
	}
	
	/****************************** CRITÉRIOS DE RATEIO ************************************************************************************/
	
	@Test
	public void NovoCriteriosDeRateio() throws InterruptedException {
		
		estruturafinanceira.criteriosDeRateio();
		page.botaoNovoTabela("3");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações dos critérios utilizados para rateio de contas financeiras, centros de resultado e/ou projetos.", estruturafinanceira.obterTextoNovoCriteriosDeRateio());		
	}
	
	@Test
	public void ConsultaCriteriosDeRateio() throws InterruptedException {
		
		estruturafinanceira.criteriosDeRateio();
		page.selecionarRegistro("Padrão");
		frame.frameTelaSobreposta();
		Assert.assertEquals("Cta. Financeira", estruturafinanceira.obterTextoConsultaCriteriosDeRateio());
	}
	
	@Test
	public void CriteriosCentroResultado() throws InterruptedException {
		
		estruturafinanceira.criteriosDeRateio();
		page.selecionarRegistro("Padrão");
		frame.frameTelaSobreposta();
		estruturafinanceira.abaCriteriosDeCentroDeResultado();
		Assert.assertEquals("BRC", estruturafinanceira.obterTextoCriteriosCentroResultado());
	}
	
	
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Estrutura Financeira/" + testNome.getMethodName() + ".jpg"));
	 }

}
