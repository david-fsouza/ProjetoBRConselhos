package Cadastro;

import static br.conselhos.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.page.Cadastros.EmitirDocumentoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmitirDocumento extends BaseTest {
	private EmitirDocumentoPage emitirdocumento = new EmitirDocumentoPage();
	
	@Before
	public void InicializaEmitirDocumento() throws InterruptedException {
		
		menu.Cadastros();
		menu.EmitirDocumentoCadastro();
		frame.frameDireita();
		frame.frameDireita2();
	}
	
	@Test
	public void T010_EmitirDocumento() throws InterruptedException {
		
		emitirdocumento.campoModeloDocumento("Certidão de Inscrição");
		page.botaoAvancar();
		frame.filtrosEmitirDocumento();
		emitirdocumento.campoPessoa("CLARICE SILVA DA ROCHA");
		page.botaoLocalizar();
		frame.documentosEmitirDocumento();
		page.selecionarCheckBoxGrid("0");
		page.clicarBotaoGenerico("Gerar para Selecionados");
		page.validarDownloadArquivo("Certidão_de_Inscrição..pdf");
	}
	
	
	@Rule
	public TestName testNome = new TestName();

	@After
	public void FinalizaTest() throws IOException {

		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo,
				new File("target/screenshot/Cadastros/Emitir Documento/" + testNome.getMethodName() + ".jpg"));
	}

}
