package Financeiro.ContasAReceber;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContasReceber extends BaseTest {
	private ContasReceberPage contasreceber = new ContasReceberPage();
	
	@Before
	public void InicializaContasReceber() {
		menu.Financeiro();
	    menu.ContasReceber();
	    frame.frameDireita();
	}
	
		
	//******* TELA CONTAS A RECEBER ********//
	
	    
	@Test
	public void T010_CadastroContasReceber() throws InterruptedException {
	    
		page.botaoNovo();  
		frame.TelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações de títulos a receber.", contasreceber.validarTextoCadastroContasReceber());
		contasreceber.campoSacado("ZULEIDE MENDES");	            	    
	    contasreceber.campoTipoLancamento("ANUIDADE PJ");
        //contasreceber.campoDataEmissao();
        //contasreceber.campoInscricaoCategoria("INSCRIÇÃO DEFINITIVA PRINCIPAL");
	    contasreceber.campoParcela("8");  
	    contasreceber.campoValorBruto("1000");
	    contasreceber.campoVencimento();
	    page.salvareFechar();
	}
	
	@Test
	public void T020_AlteracaoContasReceber() throws InterruptedException {
		
		contasreceber.filtroSituacao("A receber");
		page.inserirCampoFiltrar("0", "ZULEIDE MENDES");	
		page.selecionarRegistro("ZULEIDE MENDES");
		frame.TelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações de títulos a receber.", contasreceber.validarTextoCadastroContasReceber());
		contasreceber.campoParcela("9");
		page.salvareFechar();
	}	
	
	@Test
	public void T030_AlterarSituacaoComplemento() throws InterruptedException {
		
		contasreceber.filtroSituacao("A receber");
		page.inserirCampoFiltrar("0", "ZULEIDE MENDES");
		page.selecionarCheckBoxGrid("0");
		contasreceber.botaoFuncoes();
		sairFrame();
		contasreceber.alterarSituacaoComplemento();
		frame.TelaSobreposta();
		Assert.assertEquals("Alteração de Situação e/ou Complemento", contasreceber.validarTextoAlterarSituacaoComplemento());
		contasreceber.campoSituacao("Cancelado");
		frame.TelaSobreposta();
		page.salvareFechar();
	}
	
	 @Test
	 public void T040_EmissaoDeBoleto() throws InterruptedException {
		    
		 contasreceber.filtroSituacao("A receber");
	     page.inserirCampoFiltrar("0", "ZULEIDE MENDES");
		 page.selecionarCheckBoxGrid("0");
		 contasreceber.botaoFuncoes();
		 sairFrame();
		 contasreceber.emitirBoleto();
		 frame.TelaSobreposta();
		 Assert.assertEquals("Permite selecionar a carteira de cobrança.", contasreceber.validarTextoEmitirBoleto());
		 contasreceber.botaoGerar();		 
	 }
	 
	 @Test
	 public void T050_Recebimentos() throws InterruptedException {
		 
		 contasreceber.filtroSituacao("A receber");
		 page.inserirCampoFiltrar("0", "ZULEIDE MENDES");
		 page.selecionarCheckBoxGrid("0");
		 contasreceber.botaoFuncoes();
		 sairFrame();
		 contasreceber.recebimentos();
		 frame.TelaSobreposta();
		 Assert.assertEquals("Permite cadastrar as informações de recebimentos.", contasreceber.validarTextoRecebimentos());
		 contasreceber.campoConta("CAIXA FUNDO FIXO SEDE");
		 contasreceber.campoHistorico("Atualização/Aglutinação");
		 contasreceber.campoFormaLiquidacao("Boleto bancário");
		 page.botaoAdicionar();
		 page.salvareFechar();
	 }
	 
	 @Test
	 public void T060_EstornoRecebimento() throws InterruptedException {
		 
		 contasreceber.filtroSituacao("Pago");
		 page.inserirCampoFiltrar("0", "ZULEIDE MENDES");
		 page.selecionarRegistro("ZULEIDE MENDES");
		 frame.TelaSobreposta();  
		 contasreceber.abaMovimentos();
		 page.esperar2segundos();
		 clicarBotaoDireito("Recebimento");
		 contasreceber.estornar();
		 page.esperar2segundos();
		 frame.TelaSobreposta2();
		 frame.mainFrame();
		 page.botaoSim();
		 frame.TelaSobreposta();
		 contasreceber.abaMovimentos();
		 Assert.assertEquals("Estorno de recebimento", contasreceber.obterTextoMovimentos());	  
	 }
	 
	 
	 @Test
     public void T070_DocumentosGEDInclusao() throws InterruptedException {
			
		 contasreceber.filtroSituacao("A receber");
		 page.inserirCampoFiltrar("0", "ZULEIDE MENDES");
		 page.selecionarRegistro("ZULEIDE MENDES");
		 frame.TelaSobreposta();
		 contasreceber.abaDocumentosGED();			 
		 page.botaoNovo();
		 
		 // Captura da Janela Principal
		 String capturaJanelaPrincipal = getDriver().getWindowHandle();
		 
		 // Entrar na Janela Sobreposta
         trocarJanela();
         
         //Teste dentro da Janela Sobresposta
         contasreceber.campoDocumento("138528.pdf");       
         page.esperar2segundos();
         contasreceber.campoTipoDocumento("Boleto");
         page.salvareFechar();
         
         // Voltar para a Janela Principal
         retornarJanela(capturaJanelaPrincipal);         
         frame.TelaSobreposta();
		 contasreceber.abaDocumentosGED();
		 Assert.assertEquals("138528.pdf", contasreceber.validarTextoDocumentoGED());	 
	 }
	 
	 @Test
	 public void T080_DocumentosGED_Alteracao() throws InterruptedException {
		 
		 contasreceber.filtroSituacao("A receber");
		 page.inserirCampoFiltrar("0", "ZULEIDE MENDES");
		 page.selecionarRegistro("ZULEIDE MENDES");
		 frame.TelaSobreposta();
		 contasreceber.abaDocumentosGED();			 
		 page.selecionarRegistro("138528.pdf");
		 frame.TelaSobreposta2();
		 contasreceber.campoOrdem("2");
		 page.salvareFechar();
		 frame.TelaSobreposta();
		 contasreceber.abaDocumentosGED();		 
		 page.selecionarRegistro("138528.pdf");
		 frame.TelaSobreposta2();
		 Assert.assertEquals("2", contasreceber.validarTextoDocumentosGEDAlteracao());
	 }
	 
	 @Test
	 public void T090_DocumentosGED_Exclusao() throws InterruptedException {
		 
		 contasreceber.filtroSituacao("A receber");
		 page.inserirCampoFiltrar("0", "ZULEIDE MENDES");
		 page.selecionarRegistro("ZULEIDE MENDES");
		 frame.TelaSobreposta();
		 contasreceber.abaDocumentosGED();			 
		 page.selecionarRegistro("138528.pdf");
		 frame.TelaSobreposta2();
		 page.excluir();
		 sairFrame();
		 page.clicarBotaoGenerico("Ok");
		 frame.TelaSobreposta();
		 contasreceber.abaDocumentosGED();
		 Assert.assertEquals("Nenhum registro.", contasreceber.validarTextoGEDExclusao());		 
	  }
	 
	 @Test 
	 public void T100_RecebimentosDeRenegociacoes() throws InterruptedException {
		 
		 contasreceber.filtroSituacao("A receber");
		 page.inserirCampoFiltrar("0", "ZULEIDE MENDES");
		 page.selecionarCheckBoxGrid("0");		 
		 contasreceber.botaoFuncoes();
		 sairFrame();
		 contasreceber.renegociacao();
		 frame.TelaSobreposta();
		 contasreceber.campoQuantidadeParcelas("2");
		 contasreceber.vencimentoPrimeiraParcela();
         page.botaoAdicionar();
         contasreceber.concluirRenegociacao();
         Assert.assertEquals("Renegociação gerada com sucesso.", contasreceber.validarTextoRenegociacao());    		 
	 }
	 
	 @Test
	 public void T110_GeracaoEnvioDeBoletoEmailSelecionadas() throws InterruptedException {
		 
		 contasreceber.abaContasReceberGeracao();
		 contasreceber.filtroSituacaoGeracao("A receber");
		 page.inserirCampoFiltrar("1", "ZULEIDE MENDES");
		 page.selecionarCheckBoxGrid("0");
		 page.botaoFuncoes1();
		 sairFrame();
		 contasreceber.gerarBoletosSelecionados();
		 frame.TelaSobreposta();
		 contasreceber.campoMotivoAlerta("E-mail contas a receber");
		 page.botaoAvancar();
		 Assert.assertEquals("Alertas agendado com sucesso.", contasreceber.validarTextoGeracaoEnvioBoletoEmailSelenionadas());		 
	 }
	 
	 @Test
	 public void T120_GerecaoEnvioDeBoletosEmailTodos() throws InterruptedException {
		 
		 contasreceber.abaContasReceberGeracao();
		 contasreceber.filtroSituacaoGeracao("A receber");
		 page.inserirCampoFiltrar("1", "ZULEIDE MENDES");
		 page.botaoFuncoes1();
		 sairFrame();
		 contasreceber.gerarBoletosTodos();
		 frame.TelaSobreposta();
		 contasreceber.campoMotivoAlerta("E-mail contas a receber");
		 contasreceber.campoFiltroPersonalizado("Anuidade");
		 page.botaoAvancar();
		 Assert.assertEquals("O processo de envio de boletos por e-mail foi agendada.", contasreceber.validarTextoGerecaoEnvioBoletoEmailTodos());		 
	 }
	 
	 @Test
	 public void T130_GeracaoImpressaoDeBoletosSelecionadas() throws InterruptedException {
		 
		 contasreceber.abaContasReceberGeracao();
		 contasreceber.filtroSituacaoGeracao("A receber");
		 page.inserirCampoFiltrar("1", "ZULEIDE MENDES");
		 page.selecionarCheckBoxGrid("0");
		 page.botaoFuncoes1();
		 sairFrame();
		 contasreceber.gerarBoletosSelecionados();
		 frame.TelaSobreposta();
		 contasreceber.campoFuncao("Imprimir");
		 page.botaoAvancar();		 
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
	  

	    