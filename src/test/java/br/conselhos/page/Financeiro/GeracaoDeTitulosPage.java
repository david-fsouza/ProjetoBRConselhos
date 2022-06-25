package br.conselhos.page.Financeiro;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class GeracaoDeTitulosPage extends BasePage {
	
	/***********************  TELA INICIAL Gera��o DE t�tulos ***********************************/
	
	//*********************** Novo Registro Gera��o de t�tulos *********************************//
	
	public String obterTextoNovoRegistroGeracaodeTitulos() {
		return obterTextoXpath("//*[text()='Permite gerar t�tulos a receber.']");
	}
	
	//************************* Consulta Gera��o de t�tulos ***********************************//
	
	public void inserirCampoFiltrar(String texto) {
		escreverXpath("/html/body/form/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div/div/div[5]/div/div[2]/input", texto + Keys.ENTER);
	}
	
	public void selecionarResultadoBusca(String texto) {
		
		esperaExplicita("div[title='13/05/2021 15:04:16']");
		clicarBotaoSelector("div[title='" + texto + "']");
	}
	
	public String obterTextoConsultaGeracaoTitulos() {
		return obterTextoXpath("//*[text()='Permite gerar e/ou consultar informa��es da gera��o autom�tica de T�tulos']");		
	}
	
	//******************************* Titulos Gerados ******************************************//
	
	public void abaTitulosGerados() {
		clicarLink("T�tulos gerados");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoTitulosGerados() {
		esperaExplicita("div[title='545900']");
		return obterTextoCss("div[title='545900']");
	}

}
