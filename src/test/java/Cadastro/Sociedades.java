package Cadastro;

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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.page.Cadastros.SociedadesPage;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Sociedades extends BaseTest {
	private SociedadesPage sociedades = new SociedadesPage();
	
	@Before
	public void InicializaSociedades() {
		
		menu.Cadastros();
		menu.Sociedades();
		frame.frameDireita();
	}
	
	@Test
	public void T010_AdicionarSocio() throws InterruptedException {
		
		page.selecionarRegistro("JOSE CAIRES DE SOUZA ATENDIMENTO MEDICO");
		frame.TelaSobreposta();
		sociedades.abaSocios();
		page.botaoNovo();
		frame.socios();
		sociedades.campoSocio("IRENE RODRIGUES DA SILVA");
		sociedades.campoVinculo("Sócio");
		sociedades.campoCotas("10");
		sociedades.campoPeriodoInicialDaSociedade();
		page.salvareFechar();
		frame.TelaSobreposta();
		sociedades.abaSocios();
		Assert.assertEquals("IRENE RODRIGUES DA SILVA", sociedades.validarTextoAdicionarSocio());		
	}
	
	@Test
	public void T020_AdicionarAssociado() throws InterruptedException {
		
		page.selecionarRegistro("JOSE CAIRES DE SOUZA ATENDIMENTO MEDICO");
		frame.TelaSobreposta();
		sociedades.abaSocios();
		page.botaoNovo();
		frame.socios();
		sociedades.campoSocio("ADRIANI CAVALCANTI DE FIGUEIREDO COSTA PEREIRA");
		sociedades.campoVinculo("Associado");
		sociedades.campoCotas("10");
		sociedades.campoPeriodoInicialDaSociedade();
		page.salvareFechar();
		frame.TelaSobreposta();
		sociedades.abaSocios();
		Assert.assertEquals("ADRIANI CAVALCANTI DE FIGUEIREDO COSTA PEREIRA", sociedades.validarTextoAssociado());		
	}
	
	@Test
	public void T030_RemoverSocio() {
		
		page.selecionarRegistro("JOSE CAIRES DE SOUZA ATENDIMENTO MEDICO");
		frame.TelaSobreposta();
		sociedades.abaSocios();
		Assert.assertEquals("IRENE RODRIGUES DA SILVA", sociedades.validarTextoSocioCadastrado());
		clicarBotaoDireito("IRENE RODRIGUES DA SILVA");
		page.excluir();
		frame.TelaSobreposta();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
	}
	
	@Test
	public void T040_RemoverAssociado() {
		
		page.selecionarRegistro("JOSE CAIRES DE SOUZA ATENDIMENTO MEDICO");
		frame.TelaSobreposta();
		sociedades.abaSocios();
		Assert.assertEquals("ADRIANI CAVALCANTI DE FIGUEIREDO COSTA PEREIRA", sociedades.validarTextoAssociadoCadastrado());
		clicarBotaoDireito("ADRIANI CAVALCANTI DE FIGUEIREDO COSTA PEREIRA");
		page.excluir();
		frame.TelaSobreposta();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
    }
	
	@Test
	public void T050_RegistrareVerificarAlteracaoContratual() {
		
		page.selecionarRegistro("JOSE CAIRES DE SOUZA ATENDIMENTO MEDICO");
		frame.TelaSobreposta();
		sociedades.registrarAlteracoesContratuais();
		frame.registrarAlteracoesContratuais();
		sociedades.textAreaObservacoes("Teste de Registro de Alteração Contratual");
		page.salvar();
		sairFrame();
		page.OK();
		frame.TelaSobreposta();
		sociedades.abaHistoricoDeAlteracoesContratuais();
		Assert.assertEquals("Inclusão", sociedades.validarTextoRegistroDeAlteracoesContratuais());		
	}
	
	
	 @Rule
     public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Cadastros/Sociedades/" + testNome.getMethodName() + ".jpg"));
	 }

}
