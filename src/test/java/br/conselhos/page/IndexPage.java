package br.conselhos.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import br.conselhos.core.BasePage;
import br.conselhos.core.DSL;

public class IndexPage extends BasePage {
	
	
	/****************************** FINANCEIRO ************************************/
	
	
	//****************************** Espera **************************************//
	
	public void esperar1segundo() throws InterruptedException {
		esperaFixa(1000);
	}	
	
	public void esperar2segundos() throws InterruptedException {
		esperaFixa(2000);
	}
	
	public void esperar3segundos() throws InterruptedException {
		esperaFixa(3000);
	}
	
		
	/********************************Botães Padrão *******************************/
		
	public void botaoNovo() {
		clicarBotaoXpath("//*[text()='Novo']");
	}
	
	public void BotaoNovo() {
		clicarBotaoSelector("div[class='x-btn x-borderbox x-btn-small x-btn-small-icon-left x-flex-item x-flex-item-hbox x-btn-center x-btn-noface x-border']");
	}
	
	public void botaoNovoTabela(String numerotabela) {
		clicarBotaoXpath("//*[@id='tabCt_" + numerotabela + "']/div/div/div/div/div/div/div/div/div/div[7]");
		
	}
	
	public void botaoLocalizar() throws InterruptedException {
		clicarBotaoSelector("div[title='Localizar']");
		esperar1segundo();
	}
	
	public void botaoFuncoes0() {
		clicarBotaoXpath("//div[@id='tabCt_0']/div/div/div/div/div/div/div/div/div/div");
	}

	
	/******************************* Campos Filtrar ******************************/
	
	public void inserirCampoFiltrar0(String texto) throws InterruptedException {
		escreverXpath("//input[contains(@id,'filterTBX_gridpanel') and contains(@name, 'tabCt_0')]", texto + Keys.ENTER);
		esperaFixa(1000);
	}
	
	public void inserirCampoFiltrar1(String texto) throws InterruptedException {
		escreverXpath("//input[contains(@id,'filterTBX_gridpanel') and contains(@name, 'tabCt_1')]", texto + Keys.ENTER);
		esperaFixa(1000);
	}
	
	public void inserirCampoFiltrar(String tabela, String texto) throws InterruptedException {
		escreverXpath("//input[contains(@id,'filterTBX_gridpanel') and contains(@name, 'tabCt_" + tabela + "')]", texto + Keys.ENTER);
		esperaFixa(1000);
		
	}
	
	/***************************** Selecionar Registros **************************/
	
	public void selecionarRegistro(String texto) {
		esperaExplicita("div[title='" + texto + "']");
		clicarBotaoSelector("div[title='" + texto + "']");
	}
	
	public void selecionarCheckBoxGrid(String numerodalinha) {
		clicarCheck(By.xpath("//*[contains(@class, 'x-grid-row x-grid-row') and contains(@index, '" + numerodalinha + "')]/td/div"));		
	}
	
	/*********************************** Obter Texto *********************************/
	
	public String verificarTextoXpath(String texto) {
		esperaExplicitaXpath("//*[text()='" + texto + "']");
		return obterTextoXpath("//*[text()='" + texto + "']");
	}
	
	public String verificarTextoCss(String texto) {
		esperaExplicita("div[title='" + texto + "']");
		return obterTextoCss("div[title='" + texto + "']");
	}
	

}
