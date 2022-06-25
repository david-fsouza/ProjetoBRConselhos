package Financeiro.ContasAReceber;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.conselhos.core.BaseTest;
import br.conselhos.core.DSL;
import br.conselhos.core.DriverFactory;
import static br.conselhos.core.DriverFactory.getDriver;
import static br.conselhos.core.DriverFactory.killDriver;
import static org.junit.Assert.assertEquals;
import br.conselhos.page.FramesPage;
import br.conselhos.page.IndexPage;
import br.conselhos.page.MenuPage;
import br.conselhos.page.Financeiro.ContasReceberPage;
import io.cucumber.java.BeforeStep;

public class ContasReceber extends BaseTest {
	private ContasReceberPage contasreceber = new ContasReceberPage();
	
	@Before
	public void InicializaContasReceber() {
		menu.Financeiro();
	    menu.ContasReceber();
	    frame.frameDireita();
	}
	
		
	/****************************** TELA NOVO REGISTRO ***************************************************************************************************/ 
	    
	@Test
	public void Geral() throws InterruptedException {
	    
		page.botaoNovo();  
		frame.frameTelaSobreposta();
		//contasreceber.campoSacado("ZULEIDE MENDES");	            	    
	    //contasreceber.campoTipoLancamento("ANUIDADE PJ");
        //contasreceber.campoDataEmissao();
        //contasreceber.campoInscricaoCategoria("INSCRIÇÃO DEFINITIVA PRINCIPAL");
	    //contasreceber.campoPacela("8");  
	    //contasreceber.campoDataMovimento("10/03/2023");
	    //contasreceber.campoValorBruto("1000");
	    //contasreceber.salvareFechar();
	    //frame.frameDireita();
	    //contasreceber.pesquisaSacado("ZULEIDE MENDES");
	    Assert.assertEquals("Permite cadastrar/alterar informações de títulos a receber.", contasreceber.obterValorBruto()); 
	}
	
	@Test
	public void AcrescimoseDescontos() throws InterruptedException {
	    
	    page.botaoNovo();  
	    frame.frameTelaSobreposta();
	    contasreceber.acrescimoseDescontos();
	    Assert.assertEquals("Acréscimos e Descontos", contasreceber.obterValorAcrescimoseDescontos()); 	 	    
	}
	    
	@Test
	public void InformacoesLiquidacao() throws InterruptedException {
	   
	    page.botaoNovo();  
	    frame.frameTelaSobreposta();
		contasreceber.abaInformacoesDaLiquidacao();
		Assert.assertEquals("Informações da Liquidação", contasreceber.obterValorInformacoesLiquidacao());		    
	}	
	
	@Test
	public void Observacoes() {
		 
	    page.botaoNovo();  
	    frame.frameTelaSobreposta();
		contasreceber.abaObservacoes();
		Assert.assertEquals("Observações", contasreceber.obterValorAbaObservacoes());		 	
	}

	
	/************************* CONSULTA REGISTROS EXISTENTES ***************************************************************************************************************************/	
	
	@Test
    public void ConsultaRegistro() throws InterruptedException {
		
		page.inserirCampoFiltrar("0", "000000377507");
		contasreceber.selecionarResultadoBusca("KARINA FERREIRA HONORIO");
	    page.esperar2segundos();
	    sairFrame();
		Assert.assertEquals("ANUIDADE - KARINA FERREIRA HONORIO - Contas a Receber nº 000000377507", contasreceber.obterTextoRegistro());				
	 }
 
	 @Test
	 public void ConsultaRegistroGeracao() throws InterruptedException {
		 
		 contasreceber.abaContasReceberGeracao();
		 page.inserirCampoFiltrar1("000000370567");
		 page.esperar2segundos();
		 page.selecionarRegistro("DANIELA SILVEIRA PEREIRA");
		 Assert.assertEquals("DANIELA SILVEIRA PEREIRA", contasreceber.obterTextoNome());		 		 
	 }
	 
 /***************************** MENU LATERAL CONTAS A RECEBER  ********************************************************************/
	 
	 @Test
	 public void InstrucoesBancarias() throws InterruptedException {
			
		 page.inserirCampoFiltrar("0", "000000368507");
		 contasreceber.selecionarResultadoBusca("BIANCA ALVES SOARES DOS ANJOS");
		 frame.frameTelaSobreposta();
		 contasreceber.abaInstrucoesBancarias();
         Assert.assertEquals("Não receber após o vencimento", contasreceber.obterTextoInstrucoesBancarias());
	 }
	 	 
	 @Test
     public void Movimentos() throws InterruptedException {
			
		 page.inserirCampoFiltrar("0", "000000368507");
		 contasreceber.selecionarResultadoBusca("BIANCA ALVES SOARES DOS ANJOS");
		 frame.frameTelaSobreposta();
		 contasreceber.abaMovimentos();
		 Assert.assertEquals("Reajuste de vencimento", contasreceber.obterTextoMovimentos());	  
	 }
	 	 
	 @Test
     public void HistoricoDeContatos() throws InterruptedException {

		 page.inserirCampoFiltrar("0", "000000368507");
		 contasreceber.selecionarResultadoBusca("BIANCA ALVES SOARES DOS ANJOS");
		 frame.frameTelaSobreposta();
		 contasreceber.abaHistoricoDeContatos();
		 Assert.assertEquals("Contato", contasreceber.obterTextoHistoricoDeContatos());
	 }
	 	 
	 @Test
	 public void HistoricoDeSituacao() throws InterruptedException {
			
		 page.inserirCampoFiltrar("0", "000000368507");
		 contasreceber.selecionarResultadoBusca("BIANCA ALVES SOARES DOS ANJOS");
		 frame.frameTelaSobreposta();
		 contasreceber.abaHistoricoDeSituacao();
		 Assert.assertEquals("Situação", contasreceber.obterTextoHistoricoDeSituacao());
	 }	    
		 
	 @Test
     public void SaldosUtilizados() throws InterruptedException {
			
		 page.inserirCampoFiltrar("0", "000000368507");
		 contasreceber.selecionarResultadoBusca("BIANCA ALVES SOARES DOS ANJOS");
		 frame.frameTelaSobreposta();
		 contasreceber.abaSaldosUtilizados();
		 Assert.assertEquals("Disponível em", dsl.obterTextoXpath("//div[text()='Disponível em']"));
	 }
	 	 
	 @Test
     public void DocumentosGED() throws InterruptedException {
			
		 page.inserirCampoFiltrar("0", "000000368507");
		 contasreceber.selecionarResultadoBusca("BIANCA ALVES SOARES DOS ANJOS");
		 frame.frameTelaSobreposta();
		 contasreceber.abaDocumentosGED();
		 Assert.assertEquals("Documento", contasreceber.obterTextoDocumentosGED());
	 }
	 	 
	 @Test
     public void LancamentosContabeis() throws InterruptedException {
			
		 page.inserirCampoFiltrar("0", "000000368507");
		 contasreceber.selecionarResultadoBusca("BIANCA ALVES SOARES DOS ANJOS");
		 frame.frameTelaSobreposta();
		 contasreceber.abaLancamentosContabeis();
		 Assert.assertEquals("Conta contábil", contasreceber.obterTextoLancamentosContabeis());	    
	 }
	 	 
	// @Test
     //public void RenegociacaoDeOrigem() throws InterruptedException {
		 
		 //page.inserirCampoFiltrar("0", "000000368507");
		 //contasreceber.selecionarResultadoBusca("BIANCA ALVES SOARES DOS ANJOS");
	   	 //frame.frameTelaSobreposta();
		 //contasreceber.abaRenegociacaoDeOrigem();
		 //sairFrame();
		 //sairFrame();
		 //frame.framePrincipal();
		 //clicarBotaoXpath("//*[text()='OK']");
		// Assert.assertEquals("Renegociação atual", contasreceber.obterTextoRenegociacaoDeOrigem());
	 //}
	 

	 /************************ MENU FUNçõES CONTAS A RECEBER ********************************************************************************************/
	 
	 @Test
	 public void FuncaoImpressaoRapida() {
		 
		 contasreceber.botaoFuncoes();
		 sairFrame();
		 contasreceber.impressaoRapida();
         frame.frameTelaSobreposta();
		 Assert.assertEquals("Avançar", contasreceber.obterTextoImpressaoRapida());		    		 
	 }
	 
	 @Test
	 public void FuncaoRecebimentos() throws InterruptedException {
		    
		 page.inserirCampoFiltrar("0", "000000377536");
		 contasreceber.checkboxRegistroGrid();
		 contasreceber.botaoFuncoes();
		 sairFrame();
		 contasreceber.recebimentos();
		 frame.frameTelaSobreposta();
		 Assert.assertEquals("Permite cadastrar as informações de recebimentos.", contasreceber.obterTextoRecebimentos());		 		 
	 }
	 
	 @Test
	 public void FuncaoRenegociacao() throws InterruptedException {
		    
		 page.inserirCampoFiltrar("0", "000000377536");
		 contasreceber.checkboxRegistroGrid();
		 contasreceber.botaoFuncoes();
		 sairFrame();
		 contasreceber.renegociacao();
		 frame.frameTelaSobreposta();
		 Assert.assertEquals("Total renegociado", contasreceber.obterTextoRenegociacao());	    		    
	 }
	 
	 @Test
	 public void EmitirBoleto() throws InterruptedException {
		    
	     page.inserirCampoFiltrar("0", "000000377536");
		 contasreceber.checkboxRegistroGrid();
		 contasreceber.botaoFuncoes();
		 sairFrame();
		 contasreceber.emitirBoleto();
		 frame.frameTelaSobreposta();
		 Assert.assertEquals("Permite selecionar a carteira de cobrança.", contasreceber.obterTextoEmitirBoleto());		 		 
	 }
	 
	 @Test
	 public void AlteracaoDeTitulos() throws InterruptedException {
		 
		 page.inserirCampoFiltrar("0", "000000377536");
         contasreceber.checkboxRegistroGrid();
	     contasreceber.botaoFuncoes();
		 sairFrame();
		 contasreceber.alteracaoDeTitulos();
		 frame.frameTelaSobreposta();
		 Assert.assertEquals("Permite alterar as informações dos títulos a receber.", contasreceber.obterTextoAlteracaoDeTitulos());				    
	 }
	 
	 @Test
	 public void AtualizacaoDeTitulos() throws InterruptedException {
		    
		 page.inserirCampoFiltrar("0", "000000377536");
		 contasreceber.checkboxRegistroGrid();
		 contasreceber.botaoFuncoes();
		 sairFrame();
		 contasreceber.atualizacaoDeTitulos();
		 frame.frameTelaSobreposta();
		 Assert.assertEquals("Atualização de Titulos de Recebimento", contasreceber.obterTextoAtualizacaoDeTitulos());		    		    
	 }
	 
	 @Test
	 public void AlterarSituacaoComplemento() throws InterruptedException {
		    
	     page.inserirCampoFiltrar("0", "000000377536");
		 contasreceber.checkboxRegistroGrid();
		 contasreceber.botaoFuncoes();
		 sairFrame();
		 contasreceber.alterarSituacaoComplemento();
		 frame.frameTelaSobreposta();
		 Assert.assertEquals("Alteração de Situação e/ou Complemento", contasreceber.obterTextoAlterarSituacaoComplemento());
	 }
	 
	 
	 @Rule
     public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Contas a Receber/" + testNome.getMethodName() + ".jpg"));
	 }
	 

}
	  

	    