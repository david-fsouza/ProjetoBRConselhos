package GED;

import static br.conselhos.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.page.GED.GEDPage;

/**
 * As funcionalidades desse módulo estçao presentes em vários oustros módulos.
 * Centralizados os testes nessa classe principal e Page Objects "GEDPage", e alguns elementos aproveitados em cada módulo.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GED extends BaseTest{
	
	// Instâncias para as classes de Page Objects
	private GEDPage ged = new GEDPage();
	
	
	/**
	 * Módulo GED (A fazer)
	 */
	
	//@Test
	public void T010_SalvandoColecaoGED() {
		
		menu.GED();		
	}
	
	/**
	 * TED (A fazer, não encontrei módulo, verificar acesso)
	 */
	
	
	/**
	 * Fiscalização
	 */
	
	@Test
	public void T020_SalvandoDocumentoGEDFiscalizacao() throws InterruptedException {
		
		menu.Fiscalizacao();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "Z L S ENFERMEIRAS ASSOCIADAS LTDA");
		page.selecionarRegistro("AD-1009");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		page.botaoNovo();
		 
		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();
		 
		// Entrar na Janela Sobreposta
        trocarJanela();
        
        //Teste dentro da Janela Sobresposta
        ged.campoDocumento("ArquivoGED.pdf");
        page.esperar2segundos();
        ged.campoTipoDocumento("Outros");
        page.salvareFechar();
        
        // Voltar para a Janela Principal
        retornarJanela(capturaJanelaPrincipal);         
        frame.TelaSobreposta();
        ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
        Assert.assertEquals("ArquivoGED.pdf", ged.validarTextoDocumentoGEDFiscalizacao());     
	}
	
	@Test
	public void T030_AlterandoArquivosFiscalizacao() throws InterruptedException {
		
		menu.Fiscalizacao();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "Z L S ENFERMEIRAS ASSOCIADAS LTDA");
		page.selecionarRegistro("AD-1009");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
		ged.campoTipoAssunto("Alteração de Cadastro");
		page.salvareFechar();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
	}
	
	@Test
	public void T040_AssinaturaEletronicaFiscalizacao() throws InterruptedException {
		
		menu.Fiscalizacao();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "Z L S ENFERMEIRAS ASSOCIADAS LTDA");
		page.selecionarRegistro("AD-1009");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		clicarBotaoDireito("ArquivoGED.pdf");
		ged.assinarEletronicamente();
		
		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();
		 
		// Entrar na Janela Sobreposta
        trocarJanela();
        
        //Teste dentro da Janela Sobresposta
        page.OK();
        Assert.assertEquals("Assinatura(s) realizada(s) com sucesso!.", ged.validarTextoAssinaturaEletronicaGEDFiscalizacao());
	}
	
	@Test
	public void T050_ExcluirDocumentoGEDFiscalizacao() throws InterruptedException {
		
		menu.Fiscalizacao();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "Z L S ENFERMEIRAS ASSOCIADAS LTDA");
		page.selecionarRegistro("AD-1009");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		clicarBotaoDireito("ArquivoGED.pdf");
		page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		Assert.assertEquals("Nenhum registro.", ged.validarTextoDocumentoGEDExcluirFiscalizacao());
	}
	
	/**
	 * Comissões
	 */
	
	// Campo Tipo de Documento Não tem opções cadastradas ( Ver como fazer )
	//@Test
	public void T060_SalvandoColecaoComissoes() throws InterruptedException {
		
		menu.Comissoes();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "SEBASTIAO TADEU HERSING");
		page.selecionarCheckBoxGrid("10006");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProcessosComissoes();
		page.botaoNovo();
		
		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();
				 
		// Entrar na Janela Sobreposta
		trocarJanela();
		        
		//Teste dentro da Janela Sobresposta
		ged.campoDocumento("ArquivoGED.pdf");
		page.esperar2segundos();
		ged.campoTipoDocumento("Outros");
		page.salvareFechar();
		        
		// Voltar para a Janela Principal
		retornarJanela(capturaJanelaPrincipal);         
		frame.TelaSobreposta();
	}
	
	/**
	 * Jurídico
	 */
	@Test
	public void T070_SalvandoDocumentoGEDJuridico() throws InterruptedException {
		
		menu.Juridico();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "LUCIMARA CRISTINA GATTI");
		page.selecionarRegistro("COB70002");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProcessosJuridico();
		page.botaoNovo();
		
		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();
						 
		// Entrar na Janela Sobreposta
		trocarJanela();
				        
		//Teste dentro da Janela Sobresposta
		ged.campoDocumento("ArquivoGED.pdf");
		page.esperar2segundos();
		ged.campoTipoDocumento("Certidão");
		page.salvareFechar();
				        
		// Voltar para a Janela Principal
		retornarJanela(capturaJanelaPrincipal);         
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProcessosJuridico();
		Assert.assertEquals("ArquivoGED.pdf", ged.validarTextoSalvandoDocumentoGEDJuridico());
	}
	
	@Test
	public void T080_ExcluirDocumentoGEDProcessosJuridico() throws InterruptedException {
		
		menu.Juridico();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "LUCIMARA CRISTINA GATTI");
		page.selecionarRegistro("COB70002");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProcessosJuridico();
		page.clicarBotaoDireito("ArquivoGED.pdf");
		page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProcessosJuridico();
		Assert.assertEquals("Nenhum registro.", ged.validarTextoDocumentoGEDExcluirJuridico());	
	}
	
	/**
	 * Protocolo
	 */
	@Test
	public void T090_SalvandoDocumentoGEDProtocolo() throws InterruptedException {
		
		menu.Protocolo();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ABDOM MURILO BARBOSA SANCHEZ");
		page.selecionarRegistro("273.395");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		page.botaoNovo();
		
		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();
								 
		// Entrar na Janela Sobreposta
		trocarJanela();
						        
		//Teste dentro da Janela Sobresposta
		ged.campoDocumento("ArquivoGED.pdf");
		page.esperar2segundos();
		ged.campoTipoDocumento("Certidão");
		page.salvareFechar();
						        
		// Voltar para a Janela Principal
		retornarJanela(capturaJanelaPrincipal);         
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		Assert.assertEquals("ArquivoGED.pdf", ged.validarTextoSalvandoDocumentoGEDProtocolo());
	}
	
	@Test
	public void T100_AlterandoDocumentoGEDProtocolo() throws InterruptedException {
		
		menu.Protocolo();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ABDOM MURILO BARBOSA SANCHEZ");
		page.selecionarRegistro("273.395");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
		ged.campoTipoAssunto("Alteração de Cadastro");
		page.salvareFechar();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();	
	}
	
	@Test
	public void T110_AssinaturaEletronicaProtocolo() throws InterruptedException {
		
		menu.Protocolo();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ABDOM MURILO BARBOSA SANCHEZ");
		page.selecionarRegistro("273.395");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		clicarBotaoDireito("ArquivoGED.pdf");
		ged.assinarEletronicamente();
		
		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();
		 
		// Entrar na Janela Sobreposta
        trocarJanela();
        
        //Teste dentro da Janela Sobresposta
        page.OK();
        Assert.assertEquals("Assinatura(s) realizada(s) com sucesso!.", ged.validarTextoAssinaturaEletronicaGEDProtocolo());	
	}
	
	@Test
	public void T120_ExcluirDocumentoGEDProtocolo() throws InterruptedException {
		
		menu.Protocolo();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ABDOM MURILO BARBOSA SANCHEZ");
		page.selecionarRegistro("273.395");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		page.clicarBotaoDireito("ArquivoGED.pdf");
		page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		Assert.assertEquals("Nenhum registro.", ged.validarTextoExcluirDocumentoGEDProtocolo());	
	}
	
	/**
	 * Administrativo
	 */
	@Test
	public void T130_SalvandoDocumentoGEDAdministrativo() throws InterruptedException {
		
		menu.Administrativo();
		menu.PedidosPessoaFisica();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ANDREIA KUCARZ DO PRADO RODRIGUES");
		page.selecionarRegistro("10045");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		page.botaoNovo();
		
		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();
								 
		// Entrar na Janela Sobreposta
		trocarJanela();
						        
		//Teste dentro da Janela Sobresposta
		ged.campoDocumento("ArquivoGED.pdf");
		page.esperar2segundos();
		ged.campoTipoDocumento("Certidão de distribuição");
		page.salvareFechar();
						        
		// Voltar para a Janela Principal
		retornarJanela(capturaJanelaPrincipal);         
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		assertEquals("ArquivoGED.pdf", ged.validarTextoSalvandoDocumentoGEDAdministrativo());	
	}
	
	@Test
	public void T140_AlterandoDocumentoGEDAdministrativo() throws InterruptedException {
		
		menu.Administrativo();
		menu.PedidosPessoaFisica();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ANDREIA KUCARZ DO PRADO RODRIGUES");
		page.selecionarRegistro("10045");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
		ged.campoTipoAssunto("Alteração de Cadastro");
		page.salvareFechar();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();	
	}
	
	@Test
	public void T150_AssinandoEletronicaAdministrativo() throws InterruptedException {
		
		menu.Administrativo();
		menu.PedidosPessoaFisica();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ANDREIA KUCARZ DO PRADO RODRIGUES");
		page.selecionarRegistro("10045");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		clicarBotaoDireito("ArquivoGED.pdf");
		ged.assinarEletronicamente();
		
		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();
		 
		// Entrar na Janela Sobreposta
        trocarJanela();
        
        //Teste dentro da Janela Sobresposta
        page.OK();
        Assert.assertEquals("Assinatura(s) realizada(s) com sucesso!.", ged.validarTextoAssinaturaEletronicaGEDAdministrativo());
	}
	
	@Test
	public void T160_ExcluirDocumentoGEDAdministrativo() throws InterruptedException {
		
		menu.Administrativo();
		menu.PedidosPessoaFisica();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ANDREIA KUCARZ DO PRADO RODRIGUES");
		page.selecionarRegistro("10045");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		clicarBotaoDireito("ArquivoGED.pdf");
		page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		Assert.assertEquals("Nenhum registro.", ged.validarTextoExcluirDocumentoGEDAdministrativo());	
	}
	
	/**
	 * Conselho Pleno
	 */
	
	@Test
	public void T170_SalvandoDocumentoGEDConselhoPleno() throws InterruptedException {
		
		menu.ConselhoPleno();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "SEBASTIAO TADEU HERSING");
		page.selecionarRegistro("10042");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		page.botaoNovo();
		
		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();
										 
		// Entrar na Janela Sobreposta
		trocarJanela();
								        
		//Teste dentro da Janela Sobresposta
		ged.campoDocumento("ArquivoGED.pdf");
		page.esperar2segundos();
		ged.campoTipoDocumento("Certidão de distribuição");
		page.salvareFechar();
								        
		// Voltar para a Janela Principal
		retornarJanela(capturaJanelaPrincipal);         
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		assertEquals("ArquivoGED.pdf", ged.validarTextoSalvandoDocumentoGEDConselhoPleno());
	}
	
	@Test
	public void T180_AlterandoDocumentoGEDConselhoPleno() throws InterruptedException {
		
		menu.ConselhoPleno();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "SEBASTIAO TADEU HERSING");
		page.selecionarRegistro("10042");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
		ged.campoTipoAssunto("Alteração de Cadastro");
		page.salvareFechar();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();	
	}
	
	@Test
	public void T190_AssinandoEletronicamenteDocumentoGEDConselhoPleno() throws InterruptedException {
		
		menu.ConselhoPleno();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "SEBASTIAO TADEU HERSING");
		page.selecionarRegistro("10042");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		clicarBotaoDireito("ArquivoGED.pdf");
		ged.assinarEletronicamente();
		
		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();
		 
		// Entrar na Janela Sobreposta
        trocarJanela();
        
        //Teste dentro da Janela Sobresposta
        page.OK();
        Assert.assertEquals("Assinatura(s) realizada(s) com sucesso!.", ged.validarTextoAssinaturaEletronicaGEDConselhoPleno());
	}
	
	@Test
	public void T200_ExcluirDocumentoGEDConselhoPleno() throws InterruptedException {
		
		menu.ConselhoPleno();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "SEBASTIAO TADEU HERSING");
		page.selecionarRegistro("10042");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		clicarBotaoDireito("ArquivoGED.pdf");
		page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		Assert.assertEquals("Nenhum registro.", ged.validarTextoExcluirDocumentoGEDConselhoPleno());	
	}
	
	/**
	 * Cadastro
	 */
	
	@Test
	public void T210_SalvandoDocumentoGEDCadastro() throws InterruptedException {
		
		menu.Cadastros();
		menu.Pessoas();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ADALGISA CAMPOS DE SOUZA PEREZ");
		page.selecionarRegistro("098.481.939-87");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDCadastros();
		page.botaoNovo();
		
		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();
												 
		// Entrar na Janela Sobreposta
		trocarJanela();
										        
		//Teste dentro da Janela Sobresposta
		ged.campoDocumento("ArquivoGED.pdf");
		page.esperar2segundos();
		ged.campoTipoDocumento("Certidão Financeira");
		page.salvareFechar();
										        
		// Voltar para a Janela Principal
		retornarJanela(capturaJanelaPrincipal);         
		frame.TelaSobreposta();
		ged.abaDocumentosGEDCadastros();
		assertEquals("ArquivoGED.pdf", ged.validarTextoSalvandoDocumentoGEDCadastros());	
	}
	
	@Test
	public void T220_ExcluirDocumentoGEDCadastro() throws InterruptedException {
		
		menu.Cadastros();
		menu.Pessoas();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ADALGISA CAMPOS DE SOUZA PEREZ");
		page.selecionarRegistro("098.481.939-87");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDCadastros();
		clicarBotaoDireito("ArquivoGED.pdf");
		page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDCadastros();
		Assert.assertEquals("Nenhum registro.", ged.validarTextoExcluirDocumentoGEDCadastros());
	}
	
	@Test
	public void T230_SalvandoDocumentoGEDFinanceiro() throws InterruptedException {
		
		menu.Financeiro();
		menu.ContasReceber();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ADELSON LOPES DA SILVA");
		page.selecionarRegistro("000000365655");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDFinanceiro();
		page.botaoNovo();
		
		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();
												 
		// Entrar na Janela Sobreposta
		trocarJanela();
										        
		//Teste dentro da Janela Sobresposta
		ged.campoDocumento("ArquivoGED.pdf");
		page.esperar2segundos();
		ged.campoTipoDocumento("Boleto");
		page.salvareFechar();
										        
		// Voltar para a Janela Principal
		retornarJanela(capturaJanelaPrincipal);         
		frame.TelaSobreposta();
		ged.abaDocumentosGEDFinanceiro();
		assertEquals("ArquivoGED.pdf", ged.validarTextoSalvandoDocumentoGEDFinanceiro());
	}
	
	@Test
	public void T240_ExcluirDocumentoGEDFinanceiro() throws InterruptedException {
		
		menu.Financeiro();
		menu.ContasReceber();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ADALGISA CAMPOS DE SOUZA PEREZ");
		page.selecionarRegistro("098.481.939-87");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDFinanceiro();
		clicarBotaoDireito("ArquivoGED.pdf");
		page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDFinanceiro();
		Assert.assertEquals("Nenhum registro.", ged.validarTextoExcluirDocumentoGEDFinanceiro());	
	}
		
	
	
	 @Rule
     public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/GED/Modulos GED/" + testNome.getMethodName() + ".jpg"));
	 }
	
}
