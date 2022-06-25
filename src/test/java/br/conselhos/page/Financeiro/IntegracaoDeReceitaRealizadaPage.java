package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class IntegracaoDeReceitaRealizadaPage extends BasePage {



    /************  TELA NOVO REGISTRO INTERGRA��O DE RECEITAS REALIZADAS  ***********************************/
    
    //************** Novo Registro Integra��o de Receitas Realizadas ***************************************//

    public void selecionarRegistro() {
    	clicarBotaoSelector("div[title='Integracao_Receita.txt']");
    }
    
    public String obterTextoRegistroReceitaRealizada() {
    	return obterTextoXpath("//*[text()='Integra��o de Receita Realizada']");
    }
    
    //********************************* t�tulos *************************************************************//
    
    public void titulos() {
    	clicarLink("T�tulos");
    	entrarFrame("#panelcategory1>iframe");
    }
    
    public String obterTextoTitulos() {
    	return obterTextoXpath("//*[text()='Nenhum registro.']");
    }

 }