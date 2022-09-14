package GestaoContabil;

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
import br.conselhos.page.GestaoContabil.EntidadeContabilPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class EntidadeContabil extends BaseTest {
	private EntidadeContabilPage entidadecontabil = new EntidadeContabilPage();
	
	@Before
	public void InicializaEntidadeContabil() {
		
		menu.GestaoContabil();
		menu.EntidadeContabil();
		frame.frameDireita();
	}
	
	@Test
	@Owner("Qualidade BRC")
	@Severity(SeverityLevel.NORMAL)
	@Description("Adiciona e verifica novo registro na função Entidade Contábil")	
	public void NovoEntidadeContabil() {
		
		page.botaoNovo();
		frame.TelaSobreposta();
		Assert.assertEquals("Permite criar/editar as entidades contábeis.", entidadecontabil.obterTextoNovoEntidadeContabil());
	}
	
	
	 @Rule
     public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Gestao Contabil/Entidade Contabil/" + testNome.getMethodName() + ".jpg"));
	 }
	
}
