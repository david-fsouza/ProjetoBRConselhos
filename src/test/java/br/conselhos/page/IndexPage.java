package br.conselhos.page;

import java.io.File;

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
	
		
	/********************************Botões Padrões *******************************/
		
	public void botaoNovo() {
		clicarBotaoXpath("//*[text()='Novo']");
	}
	
	public void BotaoNovo() {
		clicarBotaoSelector("div[class='x-btn x-borderbox x-btn-small x-btn-small-icon-left x-flex-item x-flex-item-hbox x-btn-center x-btn-noface x-border']");
	}
	
	public void botaoNovoTabela(String numerotabela) {
		clicarBotaoXpath("//div[@id='tabCt_" + numerotabela + "']/div/div/div/div/div/div/div/div/div/div[7]");
		
	}
	
	public void botaoLocalizar() throws InterruptedException {
		clicarBotaoXpath("//*[text()='Localizar']");
		esperar1segundo();
	}
	
	public void botaoFuncoes0() {
		clicarBotaoXpath("//div[@id='tabCt_0']/div/div/div/div/div/div/div/div/div/div");
	}
	
	public void botaoFuncoes1() {
		clicarBotaoXpath("//div[@id='tabCt_1']/div/div/div/div/div/div/div/div/div/div");
	}
	
	public void salvareFechar() {
		clicarBotaoXpath("//*[text()='Salvar e Fechar']");
	}
	
	public void salvar() {
		clicarBotaoXpath("//*[text()='Salvar']");
	}
	
	public void botaoAdicionar() {		
		clicarBotaoXpath("//*[text()='Adicionar']");
	}
	
	public void excluir() {
		clicarBotaoXpath("//*[text()='Excluir']");
	}
	
	public void clicarBotaoGenerico(String nomebotao) {
		clicarBotaoXpath("//*[text()='" + nomebotao + "']");
	}
	
	public void botaoSim() {
		clicarBotaoXpath("//*[text()='Sim']");
	}
	
	public void botaoAvancar() {
		clicarBotaoXpath("//*[text()='Avançar']");
	}
	
	public void botaoConcluir() {
		clicarBotaoXpath("//*[text()='Concluir']");
	}
	
	public void botaoGerar() {
		clicarBotaoXpath("//*[text()='Gerar']");
	}
	
	public void OK() {
		clicarBotaoXpath("//*[text()='OK']");
	}
	
	public void Ok() {
		clicarBotaoXpath("//*[text()='Ok']");
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
		esperaExplicitaXpath("//*[contains(@class, 'x-grid-row x-grid-row') and contains(@index, '" + numerodalinha + "')]/td/div");
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
	
	/****** Verficar Download de Arquivos *****/
	
	public void validarDownloadArquivo(String nomearquivo) {
		validarDownloadArquivoNoDiretorio("C:\\Users\\David\\Downloads\\"+ nomearquivo +"");
	}
	    	    	    
}

