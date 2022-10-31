package br.conselhos.core;


import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.conselhos.page.FramesPage;
import br.conselhos.page.IndexPage;
import br.conselhos.page.LoginPage;
import br.conselhos.page.MenuPage;
import br.conselhos.page.Financeiro.ContasReceberPage;
import br.conselhos.page.Financeiro.TesourariaPage;
import io.cucumber.java.pt.Dado;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import static br.conselhos.core.DriverFactory.getDriver;
import static br.conselhos.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

public class BaseTest extends DSL { 
	
	protected DSL dsl;
	protected IndexPage page;
	protected LoginPage login;
	protected MenuPage menu;
	protected FramesPage frame;
	
	public BaseTest() {
		dsl = new DSL();
		page = new IndexPage();
		login = new LoginPage();
		menu = new MenuPage();
		frame = new FramesPage();
	}

	@Before
	public void Inicializa() throws InterruptedException{
		
		login.acessarTelaInicial();	
		login.setLogin("brconselhos");
		login.setSenha("a123");
		login.entrar();	    
	    menu.botaoMenuIndex();
	}
		
    @After
	public void Finaliza() throws IOException {
		
		TakesScreenshot ss = (TakesScreenshot) getDriver();
	    File arquivoallure = ss.getScreenshotAs(OutputType.FILE);
    	Allure.addAttachment("Screenshot", FileUtils.openInputStream(arquivoallure));
    	
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
									
	}
  }    
}
