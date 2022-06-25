package Financeiro;
import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethodsIf.List;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;


public class BRConselhos {       


	@Test
	public void BotaoNovo() throws InterruptedException {  
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		//driver.get("file:/// + System.getProperty("user.dir") + "/src/main/resourses/componentes.html");
		driver.get("http://186.250.186.214/QLD_BRC_Main_Automacao/login/main2.aspx");
		driver.manage().window().maximize();
		
		// LOGIN
	    driver.findElement(By.id("userFieldEdt")).sendKeys("brconselhos");
	    driver.findElement(By.id("passFieldEdt")).sendKeys("a123");
	    driver.findElement(By.id("q-comp-15")).click();
	    
	    
	    //LOADING TELA
	    @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);  
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("q-comp-39")));
	    
	    
	    //SEQUENCIA CONTAS A RECEBER
	    driver.findElement(By.id("q-comp-39")).click();
	    driver.findElement(By.linkText("Financeiro")).click();
	    driver.findElement(By.linkText("Contas a receber")).click();
	    
	    
	    //FRAME BOTÃ£O NOVO	    
	    WebElement iframe = driver.findElement(By.cssSelector("#rightCt>iframe"));
	    driver.switchTo().frame(iframe); 
	    //driver.findElement(By.tagName("html")).click();
	    driver.findElement(By.cssSelector("div[title='Novo']")).click(); 
	    
	   	    	    
	    //FRAME TELA SOPREPOSTA	    
	    driver.switchTo().defaultContent();
	    WebElement iframe2 = driver.findElement(By.cssSelector("div[class='x-fr-body x-win-body x-noscroll']>iframe")); 
	    driver.switchTo().frame(iframe2);
	    
	    
	    //NAVEGAR PELAS ABAS
	    driver.findElement(By.cssSelector("div[title='Acréscimos e Descontos']")).click();
	    driver.findElement(By.cssSelector("div[title='Informações da Liquidação']")).click();
	    driver.findElement(By.cssSelector("div[title='Observações']")).click();
	    driver.findElement(By.cssSelector("div[title='Geral']")).click();
	    
	    
	    //CAPTURA FRAME TELA ANTERIOR
	    driver.findElement(By.cssSelector("div[title='Fechar']")).click(); 
	    driver.switchTo().defaultContent();
	    WebElement iframe3 = driver.findElement(By.cssSelector("div[id='rightCt']>iframe")); 
	    driver.switchTo().frame(iframe3);
	    
	    
	    // TELA PARA VERIFICAçõO FINAL
	    driver.findElement(By.cssSelector("div[title='Contas a receber Ã£ Geração']")).click(); 
	    driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div/div/div[3]/div[3]/div/div/div/input")).sendKeys("000000365617"+Keys.ENTER);
	    
	    Thread.sleep(3000);
	    WebElement verificacao = driver.findElement(By.cssSelector("div[title='ACENALDO FERREIRA LIMA']"));
	    Assert.assertEquals("ACENALDO FERREIRA LIMA", verificacao.getAttribute("title"));

	    		
		driver.quit();
		
		//FIM TESTE BOTAONOVO
    		  
	  }
		      
		      
	@Test
	public void ContasNovoRegistro() throws InterruptedException   {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("file:/// + System.getProperty("user.dir") + "/src/main/resourses/componentes.html"); //Com o System.get Property, utilizamos para executar o link local em qualquer usuÃ£rio, pois o arquivo .htm Ã£ colocado na pasta resourses, e não fica em um diretÃ£rio como "C://users/david por exemplo
		
		
		// LOGIN
		driver.get("http://186.250.186.214/QLD_BRC_Main_Automacao/login/main2.aspx");
		driver.manage().window().maximize();
	    driver.findElement(By.id("userFieldEdt")).sendKeys("brconselhos");
	    driver.findElement(By.id("passFieldEdt")).sendKeys("a123");
	    driver.findElement(By.id("q-comp-15")).click();
	    
	    
	    // LOADING TELA
	    @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("q-comp-39")));
	    
	    
	    // SEQUENCIA CONTAS A RECEBER
	    driver.findElement(By.id("q-comp-39")).click();
	    driver.findElement(By.linkText("Financeiro")).click(); 
	    driver.findElement(By.linkText("Contas a receber")).click();
	    
	    
	    // FRAME BOTÃ£O NOVO
	    WebElement iframe = driver.findElement(By.cssSelector("#rightCt>iframe")); 
	    driver.switchTo().frame(iframe); 
	    driver.findElement(By.cssSelector("div[title='Novo']")).click(); 
	    
	    
	    //FRAME TELA SOBREPOSTA
	    driver.switchTo().defaultContent();  
	    WebElement iframe2 = driver.findElement(By.cssSelector("div[class='x-fr-body x-win-body x-noscroll']>iframe")); 
	    driver.switchTo().frame(iframe2);
	    
	    
	    // CAMPO SACADO
	    driver.findElement(By.name("Pessoa")).sendKeys("ZULEIDE MENDES");
	    Thread.sleep(1000);
	    driver.findElement(By.name("Pessoa")).sendKeys(Keys.ENTER);
	    Thread.sleep(500);
	    	    
	    
	    // CAMPO TIPO LANCAMENTO
	    driver.findElement(By.name("TipoLancamento")).sendKeys("ANUIDADE PJ"+Keys.ENTER);
	    Thread.sleep(500);
	    driver.findElement(By.name("TipoLancamento")).sendKeys(Keys.ENTER);
	    Thread.sleep(500);
	    
	    
	    // DATA EMISSÃ£O
	    DateFormat dateFormat = new SimpleDateFormat("dd");
	    Date date = new Date();
	    String date1= dateFormat.format(date);
	    driver.findElement(By.name("DataOperacao")).getAttribute(date1);
	    Thread.sleep(500);
	    
	    
	    // INSCRIÇÃO
	    driver.findElement(By.name("InscricaoCategoria")).sendKeys("INSCRIÇÃO DEFINITIVA PRINCIPAL");
	    Thread.sleep(1000);
	    driver.findElement(By.name("InscricaoCategoria")).sendKeys(Keys.ENTER);
	    Thread.sleep(500);
	    
	    
	    // PARCELA
	    driver.findElement(By.name("Parcela")).sendKeys("3");
	    Thread.sleep(500);
	    
	    
	    // VENCIMENTO
	    driver.findElement(By.name("DataMovimento")).sendKeys("06/02/2025");
	    Thread.sleep(1000);
	    
	    
	    // VALOR BRUTO
	    driver.findElement(By.name("ValorBruto")).sendKeys("1000.0");
	    Thread.sleep(1000);
	    
	}    
	    
	    
	    @Test
		public void AcrescimoseDescontos() throws InterruptedException   {
	    	WebDriver driver = new ChromeDriver();
	    	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");


	    // ACRESCIMOS E DESCONTOS
	    driver.findElement(By.cssSelector("div[title='Acréscimos e Descontos']")).click();

	    
	    // MORA DIARIA
	    driver.findElement(By.name("PercentualMora")).sendKeys("1");
	    
	    
	    // OU VALOR MORA
	    driver.findElement(By.name("ValorMora")).sendKeys("1");
	    
	    
	    // OU INDICE MORA
	    driver.findElement(By.name("IndiceMoedaMulta")).click();
	    Thread.sleep(500);
	    driver.findElement(By.name("IndiceMoedaMulta")).sendKeys(Keys.ENTER);
	    
	    
	    // MULTA
	    driver.findElement(By.name("PercentualMulta")).sendKeys("1");
	    
	    
	    // OU VALOR MULTA
	    driver.findElement(By.name("ValorMulta")).sendKeys("1");
	    
	    
	    // OU INDICE MULTA
	    driver.findElement(By.name("IndiceMoedaMultahdn")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.name("IndiceMoedaMultahdn")).sendKeys(Keys.ENTER);
	    
	    
	    // JUROS FINANCEIROS
	    driver.findElement(By.name("PercentualJuro")).sendKeys("1");
	    
	    
	    // OU INDICE JUROS
	    driver.findElement(By.name("IndiceMoedaJurohdn")).click();
	    Thread.sleep(500);
	    driver.findElement(By.name("IndiceMoedaJurohdn")).sendKeys(Keys.ENTER);
	    
	    
	    // OUTROS ACRESCIMOS
	    driver.findElement(By.name("ValorAcrescimo")).sendKeys("1");
	    
	    
	    // DESCONTO
	    driver.findElement(By.name("PercentualDesconto")).sendKeys("1");
	    
	    
	    // OU VALOR DESCONTO
	    driver.findElement(By.name("ValorDesconto")).sendKeys("1");
	    
	    
	    // OU INDICE DESCONTO
	    driver.findElement(By.name("IndiceMoedaDesconto")).click();
	    Thread.sleep(500);
	    driver.findElement(By.name("IndiceMoedaDesconto")).sendKeys(Keys.ENTER);
	    
	    
	    // LIMITE DESCONTO
	    driver.findElement(By.name("IndiceMoedaDesconto")).sendKeys("15022030" + Keys.ENTER);
	    
	    
	    // OUTROS ABATIMENTOS
	    driver.findElement(By.name("ValorAbatimento")).sendKeys("1");
	    
	    
	    //OUTROS
	    driver.findElement(By.name("ValorDespesaCobranca")).sendKeys("1");
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	   
	    
	    
	    
	    
	    
	    
	    
	    
	    
	   // 
	 // BOTÃ£O SALVAR E FECHAR
	    //driver.findElement(By.id("SaveAndClose_ContaReceberConselho")).click();
	    //Thread.sleep(1000);
	    
	    
	    // FRAME TELA PRINCIPAL
	    //driver.switchTo().defaultContent();
	    //WebElement iframe3 = driver.findElement(By.cssSelector("div[id='rightCt']>iframe"));
	    //.switchTo().frame(iframe3);
	    
	    
	    //BUSCAR NOME
	    //driver.findElement(By.xpath("/html/body/form/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div/div/div[2]/div[3]/div/div/div/input")).sendKeys("ZULEIDE MENDES" + Keys.ENTER);
	    
	    
            // VERIFICAçõO FINAL
	    //Thread.sleep(3000);
	   // WebElement verificacao = driver.findElement(By.cssSelector("div[title='1.000,00']"));
	    //Assert.assertEquals("1.000,00", verificacao.getAttribute("title"));
	    
	    }   
	    
	        
}
	 
	    