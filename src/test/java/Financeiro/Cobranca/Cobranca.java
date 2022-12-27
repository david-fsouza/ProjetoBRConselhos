package Financeiro.Cobranca;

import static br.conselhos.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.page.Financeiro.CobrancaPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Cobranca extends BaseTest {
	private CobrancaPage cobranca = new CobrancaPage();
	
	@Before
	public void InicializaCobranca() {
		menu.Financeiro();
		menu.Cobranca();
		frame.frameDireita();
		frame.frameDireita2();
	}
	
	@Test
	public void T010_GeracaoDeContatosSimples() throws InterruptedException {
		
		cobranca.campoSacado("AMANDA BERTOLINI ALVES PEREIRA");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.selecionarCheckBoxGrid("0");
		cobranca.gerarContato();
		frame.contato();
		cobranca.campoTipoDeContato("Carta de Cobrança Administrativa");
		page.botaoAvancar();
		page.botaoAvancar();
		page.esperar10segundos();
		Assert.assertEquals("Atenção", cobranca.validarTextoGeracaoContatoSimples());		
	}
	
	@Test
	public void T020_GeracaoDeContatoEnvioDeBoletoAnexo() throws InterruptedException {
		
		cobranca.campoSacado("ACENALDO FERREIRA LIMA");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.selecionarCheckBoxGrid("0");
		cobranca.gerarContato();
		frame.contato();
		cobranca.campoTipoDeContato("Contato cobrança inicial (gera atualização, gera boleto e envia boleto)");
		page.botaoAvancar();
		page.botaoAvancar();
		Assert.assertEquals("Atenção", cobranca.validarTextoGeracaoEnvioBoletos());
		page.OK();
		frame.frameDireita();
		frame.frameDireita2();
		page.selecionarCheckBoxGrid("0");
		cobranca.consultaHistoricoDeContatos();
		frame.historicoDeContatos();
		Assert.assertEquals("Contato cobrança inicial (gera atualização, gera boleto e envia boleto)", cobranca.validarTextoHistoricoDeContatoGeradoEnvioBoleto());
	}
	
	@Test
	public void T030_GerarContatoComAgendamento() throws InterruptedException {
		
		cobranca.campoSacado("AGATHA LARISSA CZARNESKI");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.selecionarCheckBoxGrid("0");
		cobranca.gerarContato();
		frame.contato();
		cobranca.campoData();
		cobranca.campoTipoDeContato("Carta de Cobrança Administrativa");
		page.botaoAvancar();
		page.botaoAvancar();
		sairFrame();
		page.OK();
		frame.frameDireita();
		frame.frameDireita2();
		page.selecionarCheckBoxGrid("0");
		cobranca.consultaHistoricoDeContatos();
		frame.historicoDeContatos();
		Assert.assertEquals("Carta de Cobrança Administrativa", cobranca.validarTextoGerarContatoComAgendamento());		
	}
	
	@Test
	public void T040_GerarRelatoriodeCobranca() throws InterruptedException {
		
		cobranca.campoSacado("ABDOM MURILO BARBOSA SANCHEZ");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.selecionarCheckBoxGrid("0");
		cobranca.gerarRelatorioDeCobranca();
		page.validarDownloadArquivo("RelatorioR086C000000.pdf");
		page.esperar3segundos();	
	}
	
	@Test
	public void T050_GerarContatoDeRecobranca() throws InterruptedException {
		
		cobranca.campoSacado("ABDOM MURILO BARBOSA SANCHEZ");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.selecionarCheckBoxGrid("0");
		cobranca.gerarContato();
		frame.contato();
		cobranca.campoTipoDeContato("Recobrança");
		page.botaoAvancar();
		page.botaoAvancar();
		sairFrame();
		Assert.assertEquals("Processo de geração dos contatos criado com sucesso!", cobranca.validarTextoGerarContatoDeCobranca());		
	}

	 
	
	 @Rule
     public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Cobranca/" + testNome.getMethodName() + ".jpg"));
	 }
	
}
