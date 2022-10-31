package br.conselhos.core;
import org.junit.Assert;
import org.openqa.selenium.By;

import br.conselhos.SQL.Conexao;
import br.conselhos.SQL.JavaApplicationConexaoSQL;
import br.conselhos.core.DriverFactory;
import static br.conselhos.core.DriverFactory.getDriver;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Key;

public class DSL {
	
	/********** TextField e TextArea *******************************************************************************************************/

	// Escrever indicando o tipo de atributo (CSS, Name, ID ou Xpath)
	
	public void escrever(By by, String texto) {	                          		                                                                            
		getDriver().findElement(by).clear();                                        
		getDriver().findElement(by).sendKeys(texto);
	}	
	
	// Escrever utilizando atributo "Name"
	
	public void escrever(String name, String texto) {    
		esperaExplicitaName(name);
		escrever(By.name(name), texto);
	}
	
	// Escrever utilizando atributo "ID"
	
	public void escreverID(String id, String texto) {
		esperaExplicitaID(id);
		escrever(By.id(id), texto);
	}
	
	// Escrever utilizando "CSS"
	
	public void escreverCss(String cssSelector, String texto) {  
		esperaExplicita(cssSelector);
		escrever(By.cssSelector(cssSelector), texto);		
	}
	
	//Escrever utiliando "Xpath"
	
	public void escreverXpath(String xpath, String texto) {    
		esperaExplicitaXpath(xpath);
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
	
	
	/******************** Botão ********************************************************************************************************************/
	
	// Clicar indicando o tipo de atributo (CSS, Name, ID ou Xpath)
	
	public void clicarBotao(By by) {
		clicarBotao(by);
	}
	
	// Clicar botão Selector
	
	public void clicarBotaoSelector(String cssSelector) {
		esperaExplicita(cssSelector);
		getDriver().findElement(By.cssSelector(cssSelector)).click();			
	}
	
	 // Clicar botão por "Name"
		
	public void clicarBotao(String name) {  
		esperaExplicitaName(name);
        getDriver().findElement(By.name(name)).click();
	}
	
	// Clicar botão por "ID"
	
	public void clicarBotaoID(String id) {
        esperaExplicitaID(id);
		getDriver().findElement(By.id(id)).click();
	}
	
	// Clicar por Xpath
		
	public void clicarBotaoXpath(String xpath) {
		esperaExplicitaXpath(xpath);
		getDriver().findElement(By.xpath(xpath)).click();	
	}
	
	public void clicarBotaoDireito(String texto) {
		
        WebElement clickable = getDriver().findElement(By.xpath("//*[text()='" + texto +  "']"));
        new Actions(getDriver())
                .contextClick(clickable)
                .perform();
	}
	
	public void doisCliques(String texto) {
        WebElement clickable = getDriver().findElement(By.xpath("//*[text()='" + texto +  "']"));
        new Actions(getDriver())
                .doubleClick(clickable)
                .perform();
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
	
	// Obter texto por XPath(Escrever apenas o texto desejado no teste)
     
	public String obterTexto(String texto) {
		
	    WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + texto + "']")));	
	    return getDriver().findElement(By.xpath("//*[text()='" + texto + "']")).getText();
	}
	   
	
	// Obter texto por "ID"
	
	public String obterTextoID(String id) {
		esperaExplicitaID(id);
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
	
	// Obeter texto por "Value"
	
	public String obterTextoValue(String texto) {
	    return getDriver().findElement(By.cssSelector("input[value='" + texto + "']")).getAttribute("value");
	}
	
	
	/***************** Frames e Janelas ******************************************************************************************************************/
	
	// Entrar Frame Padrão por "CSS" (Tela Sobreposta)
	public void entrarFrameDefault(String Css) {                                   
	    getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector(Css)));	
	}
	
	// Entrar Frame Padrão por "By"
	public void entrarFrameDefault(By by) {
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame(getDriver().findElement(by));				
	}
	
	// Entrar Frame Diretamente por "CSS" (Sem Default)
	
	public void entrarFrame(String Css) {
		esperaExplicita(Css);
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
	
	public String JanelaP = getDriver().getWindowHandle();
	
	//Trocar Janela
	
	public void trocarJanela() {
		
		// It will return the parent window name as a String
		 String parent=getDriver().getWindowHandle();

		 Set<String>s=getDriver().getWindowHandles();

		 // Now iterate using Iterator
		 Iterator<String> I1= s.iterator();

		 while(I1.hasNext())
		 {

		 String child_window=I1.next();

		 if(!parent.equals(child_window))
		 {
		 getDriver().switchTo().window(child_window);
      
		 }
	   }
	}
	
	// Sair da Janela Sobreposta
	
	public void sairJanela() {
		
		getDriver().close();
	}
	
	// Volta a Janela Anterior	
	
	public void retornarJanela(String janelaPrincipal) throws InterruptedException {
		 
	    getDriver().switchTo().window(janelaPrincipal);		 
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
	
	// Enviar tecla por "xpath"
	
	public void digitateclaXapath(String xpath, Keys texto) {
		getDriver().findElement(By.xpath(xpath)).sendKeys(texto);	
	}
	
	
	/*************** Espera de Tela (Wait) ****************************************************************************************************************/
	
	// Espera por "CSS"
	
    @SuppressWarnings("deprecation")
	public void esperaExplicita(String cssSelector) {                                  
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
	}
    
	public void esperaExplicitaName(String name) {                                  
        @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
	}
    
    //Espera por "By"
    
	public void esperaExplicita(By by) {                                             
		esperaExplicita(by);
	}
	
	// Espera por "Xpath"
		
    @SuppressWarnings("deprecation")
	public void esperaExplicitaXpath(String xpath) {                                  
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));		
	}
    
    @SuppressWarnings("deprecation")
	public void esperaExplicitaID(String id) {                                  
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));		
	}
    
    @SuppressWarnings("deprecation")
	public void esperaExplicitaLink(String link) {                                  
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(link)));		
	}
    
    // Espera Fixa a variável Time recebe o valor em milisegundos
    
    public void esperaFixa(long Time) throws InterruptedException {                    
    	Thread.sleep(Time);	
    }
    
    //******* DATAS *******//
  
    // Inserir Data atual por "Name"
    public void inserirDataAtual(String name) throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date = new Date();
        String date1= dateFormat.format(date);
    	getDriver().findElement(By.name(name)).clear();
    	getDriver().findElement(By.name(name)).sendKeys(date1 + Keys.TAB);
        //getDriver().findElement(By.name(datadeagora)).getAttribute(date1); // Método que usei inicialmente, mas depois foi aperfeiçoado
        esperaFixa(2000); 
    }
    
    // Inserir Data atual por "ID"
    
    public void inserirDataAtualID(String id) throws InterruptedException {
    	 DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
         Date date = new Date();
         String date1= dateFormat.format(date);
         getDriver().findElement(By.id(id)).clear();
         getDriver().findElement(By.id(id)).sendKeys(date1 + Keys.TAB);
         //getDriver().findElement(By.name(datadeagora)).getAttribute(date1); // Método que usei inicialmente, mas depois foi aperfeiçoado
         esperaFixa(2000);        
    }
    
    public static String obterDataFormatada(Date data) {
    	DateFormat format = new SimpleDateFormat("dd/MM/YYY");
    	return format.format(data);
    }
    
    public void dataFutura(String id, int dias) throws InterruptedException {
    	
    	Date today = new Date();               
    	SimpleDateFormat formattedDate = new SimpleDateFormat("yyyyMMdd");            
    	Calendar c = Calendar.getInstance();        
    	c.add(Calendar.DATE, dias);  // Número de dias para adicionar no futuro, na variável "dias"    
    	String futuro = (String)(formattedDate.format(c.getTime()));
    	getDriver().findElement(By.id(id)).clear();
    	getDriver().findElement(By.id(id)).sendKeys(futuro + Keys.TAB);
    	esperaFixa(3000);
    }
    
    public void dataFuturaName(String name, int dias) throws InterruptedException {
    	
    	Date today = new Date();               
    	SimpleDateFormat formattedDate = new SimpleDateFormat("yyyyMMdd");            
    	Calendar c = Calendar.getInstance();        
    	c.add(Calendar.DATE, dias);  // Número de dias para adicionar no futuro, na variável "dias"    
    	String futuro = (String)(formattedDate.format(c.getTime()));
    	getDriver().findElement(By.name(name)).clear();
    	getDriver().findElement(By.name(name)).sendKeys(futuro + Keys.TAB);
    	esperaFixa(3000);
    }	
    
    public void dataFuturaXpath(String xpath, int dias) throws InterruptedException {
    	Date today = new Date();               
    	SimpleDateFormat formattedDate = new SimpleDateFormat("yyyyMMdd");            
    	Calendar c = Calendar.getInstance();        
    	c.add(Calendar.DATE, dias);  // Número de dias para adicionar no futuro, na variável "dias"    
    	String futuro = (String)(formattedDate.format(c.getTime()));
    	getDriver().findElement(By.xpath(xpath)).clear();
    	getDriver().findElement(By.xpath(xpath)).sendKeys(futuro + Keys.TAB);
    	esperaFixa(3000);
    }
    
    public void dataFuturaComHora(String id, int dias) throws InterruptedException {
    	
    	Date today = new Date();               
    	SimpleDateFormat formattedDate = new SimpleDateFormat("ddMMyyyy HH:mm");            
    	Calendar c = Calendar.getInstance();        
    	c.add(Calendar.DATE, dias);  // Número de dias para adicionar no futuro, na variável "dias"    
    	String futuro = (String)(formattedDate.format(c.getTime()));
    	getDriver().findElement(By.id(id)).clear();
    	getDriver().findElement(By.id(id)).sendKeys(futuro + Keys.TAB);
    	esperaFixa(3000);
    }
    
	//******* Método para verificar arquivo baixado *******//
	
	public void validarDownloadArquivoNoDiretorio(String caminhoarquivo) {
	    File f = new File(caminhoarquivo); 
	    if (f.exists()) {
	    	    System.out.println("Download realizado com sucesso.");
	    	    f.delete();
	    	    
	    } else
	    	    System.out.println("Download não encontrado.");
	}
	
	//******* Método Para Fazer Upload de Arquivo *******//
	
	public void uploadArquivo(String ID, String nomearquivo) {
	    escreverID(ID, "C:\\Users\\David\\eclipse-workspace\\ProjetoBRConselhos\\target\\Arquivos Upload\\"+nomearquivo+"");
	}
	
	//******** Executar Query SQLServer *********//
	
	public static void executarQuerySQL(String query) throws SQLException, InterruptedException {
	
	Thread.sleep(15000);
	Conexao con = new Conexao();
	Statement st = con.conexao.createStatement();
	
	st.executeQuery(query);	
	ResultSet rs = st.getResultSet();
	while(rs.next()) {
		System.out.println(rs.getString("Nome") + "," +rs.getString("ID"));
	}
  }  
}  
   
	

