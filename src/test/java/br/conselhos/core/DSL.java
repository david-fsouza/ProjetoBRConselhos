package br.conselhos.core;
import org.openqa.selenium.By;
import br.conselhos.core.DriverFactory;
import static br.conselhos.core.DriverFactory.getDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {
	
	
	/********** TextField e TextArea *******************************************************************************************************/

	// Escrever indicando o tipo de atributo (CSS, Name, ID ou Xpath)
	
	public void escrever(By by, String texto) {	                          		                                                                            
		getDriver().findElement(by).clear();                                        
		getDriver().findElement(by).sendKeys(texto);
	}	
	
	// Escrever utilizando atributo "Name"
	
	public void escrever(String name, String texto) {                                          
		escrever(By.name(name), texto);
	}
	
	// Escrever utilizando atributo "ID"
	
	public void escreverID(String id, String texto) {                                                 
		escrever(By.id(id), texto);
	}
	
	// Escrever utilizando "CSS"
	
	public void escreverCss(String cssSelector, String texto) {                      
		escrever(By.cssSelector(cssSelector), texto);		
	}
	
	//Escrever utiliando "Xpath"
	
	public void escreverXpath(String xpath, String texto) {                          
		escrever(By.xpath(xpath), texto);
    }
	
	
	/********** Obter Valor Campo **************************************************************************************************************/
	
	 // Verificar (obter) campo por "ID
	
	public String obterValorCampoId(String id) {	                              
		return getDriver().findElement(By.id(id)).getAttribute("title");	
	}
	
	// Verificar (Obter) valor campo por "Name"
	
	public String obterValorCampoName(String name) {	                         
		return getDriver().findElement(By.name(name)).getAttribute("title");
	}
	
	// Verificar (obter) texto por "CSS"
	
	public String obterValorCampoTextoCss(String cssSelector) {	             
		return getDriver().findElement(By.cssSelector(cssSelector)).getAttribute("title");
	}
	
	 // Verificar (obter) texto por "Xpath"
	
	public String obterValorCampoTextoXpath(String xpath) {                    
		return getDriver().findElement(By.xpath(xpath)).getAttribute("title");
	}
	
	
	/*********** Radio e Check *******************************************************************************************************************/
	
	// Clicar em Radio Button
	
	public void clicarRadio(String id) {	                                        
		getDriver().findElement(By.id(id)).click();
	}
	
	// Verificar Radio Button marcado
	
	public boolean isRadioMarcado(String id) {	                                    
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	 // Clicar em CheckBox
	
	public void clicarCheck(By by) {                                                
		getDriver().findElement(by).click();
	}
	
	// Verificar CheckBox marcado
	
	public boolean isCheckMarcado(String id) {                                      
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	
	/******************** Combo *******************************************************************************************************************/
	
	// Selecionar combo
	
	public void selecionarCombo(String id, String valor) {                         
	    WebElement element = getDriver().findElement(By.id(id));
	    Select combo = new Select(element);
        combo.selectByVisibleText(valor);	
	}
	
	// Desselecionar combo
	
	public void deselecionarCombo(String id, String valor) {                        
	    WebElement element = getDriver().findElement(By.id(id));
	    Select combo = new Select(element);
        combo.deselectByVisibleText(valor);	
	} 
	
	 // Verificar valor combo
	
	public String obterValorCombo(String id) {                                     
	    WebElement element = getDriver().findElement(By.id(id));
	    Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();    
	}
	
	
	/******************** Bot„o ********************************************************************************************************************/
	
	// Clicar indicando o tipo de atributo (CSS, Name, ID ou Xpath)
	
	public void clicarBotao(By by) {
		clicarBotao(by);
	}
	
	// Clicar bot√£o Selector
	
	public void clicarBotaoSelector(String cssSelector) {                              
		getDriver().findElement(By.cssSelector(cssSelector)).click();			
	}
	
	 // Clicar bot√£o por "Name"
		
	public void clicarBotao(String name) {                                          
        getDriver().findElement(By.name(name)).click();
	}
	
	// Clicar bot√£o por "ID"
	
	public void clicarBotaoID(String id) {                                         
		getDriver().findElement(By.id(id)).click();
	}
	
	// Clicar por Xpath
		
	public void clicarBotaoXpath(String xpath) {                                  
		getDriver().findElement(By.xpath(xpath)).click();	
	}
	
	
	/************** Obter Atributo Botao ***************************************************************************************************************/
	
	// Obter valor do atributo
	
	public String obterValueElemento(String id) {                                  
		return getDriver().findElement(By.id(id)).getAttribute(id);
	}
	
	
    /******************** Link **************************************************************************************************************************/
	
	// Clicar em link
	
	public void clicarLink(String link) {
		esperaExplicitaLink(link);
        getDriver().findElement(By.linkText(link)).click();
	}
	
	
	/******************** Texto *************************************************************************************************************************/
	
	// Obter texto por (ID, Name, CSS e xpath)
	
	public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
	}
	
	// Obter texto por "Name"
	
	public String obterTexto(String name) {                                         
        return obterTexto(By.name(name));
	}
	
	// Obter texto por "ID"
	
	public String obterTextoID(String id) {
		return getDriver().findElement(By.id(id)).getText();
	}
	
	// Obter texto por "Xpath"
	
	public String obterTextoXpath(String xpath) {
		esperaExplicitaXpath(xpath);
		return getDriver().findElement(By.xpath(xpath)).getText();	
	}
	
	// Obter texto por "CSS"
	
	public String obterTextoCss(String cssSelector) {
		esperaExplicita(cssSelector);
		return getDriver().findElement(By.cssSelector(cssSelector)).getText();
	}
	
	
	/***************** Frames e Janelas ******************************************************************************************************************/
	
	// Entrar Frame Padr„o por "CSS" (Tela Sobreposta)
	public void entrarFrameDefault(String Css) {                                   
	    getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector(Css)));	
	}
	
	// Entrar Frame Padr„o por "By"
	public void entrarFrameDefault(By by) {
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame(getDriver().findElement(by));				
	}
	
	// Entrar Frame Diretamente por "CSS" (Sem Default)
	
	public void entrarFrame(String Css) {                                       
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector(Css)));	
	}
	
	// Entrar Frame Diretamente por "By" (Sem Default)
	
	public void entrarFrame(By by) {
		getDriver().switchTo().frame(getDriver().findElement(by));
		
	}
	
	// Sair do Frame
	
	public void sairFrame() {                    
		getDriver().switchTo().defaultContent();
	}
	
	//Trocar Janela
	
	public void trocarJanela(String id) {                                           
		getDriver().switchTo().window(id);
	}
	
	
	/**************** Enviar Teclas ***********************************************************************************************************************/
	
	// Enviar tecla por atributo "Name"
	public void digitaTeclaName(String name, Keys texto) {	             
		getDriver().findElement(By.name(name)).sendKeys(texto);
	}
	
	// Enviar tecla por atributo "ID"
	
	public void digitaTeclaId(String id, Keys texto) {	                   
		getDriver().findElement(By.id(id)).sendKeys(texto);
	}
	
	
	/*************** Espera de Tela (Wait) ****************************************************************************************************************/
	
	// Espera por "CSS"
	
    @SuppressWarnings("deprecation")
	public void esperaExplicita(String cssSelector) {                                  
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
	}
    
	public void espera(String name) {                                  
        @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
	}
    
    //Espera por "By"
    
	public void esperaExplicita(By by) {                                             
		esperaExplicita(by);
	}
	
	// Espera por "Xpath"
		
    @SuppressWarnings("deprecation")
	public void esperaExplicitaXpath(String xpath) {                                  
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));		
	}
    
    @SuppressWarnings("deprecation")
	public void esperaExplicitaLink(String link) {                                  
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(link)));		
	}
    
    // Espera Fixa a vari√£vel Time recebe o valor em milisegundos
    
    public void esperaFixa(long Time) throws InterruptedException {                    
    	Thread.sleep(Time);	
    }
    
    /******************* Datas  *****************************************************************************************************************************/
  
    // Inserir Data atual por "Name"
    public void inserirDataAtual(String datadeagora) throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        String date1= dateFormat.format(date);
        getDriver().findElement(By.name(datadeagora)).getAttribute(date1);
        esperaFixa(2000); 
    }
    
    // Inserir Data atual por "ID"
    
    public void inserirDataAtualID(String id) throws InterruptedException {
    	 DateFormat dateFormat = new SimpleDateFormat("dd");
         Date date = new Date();
         String date1= dateFormat.format(date);
         getDriver().findElement(By.id(id)).getAttribute(date1);
         esperaFixa(2000);        
    }
    
    public static Date obterDataComDiferencaDias(int dias) {
    	Calendar calendar = Calendar.getInstance(); //Esta linha j√£ traz uma instancia com a data atual
    	calendar.add(Calendar.DAY_OF_MONTH, dias);
    	return calendar.getTime();   	
    }
    
    public static String obterDataFormatada(Date data) {
    	DateFormat format = new SimpleDateFormat("dd/MM/YYY");
    	return format.format(data);
    }

}  
   
	

