package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class IntegracaoDeReceitaRealizadaPage extends BasePage {



    /************  TELA NOVO REGISTRO INTERGRAçõO DE RECEITAS REALIZADAS  ***********************************/
    
    //************** Novo Registro Integração de Receitas Realizadas ***************************************//

    public void selecionarRegistro() {
    	clicarBotaoSelector("div[title='Integracao_Receita.txt']");
    }
    
    public String obterTextoRegistroReceitaRealizada() {
    	return obterTextoXpath("//*[text()='Integração de Receita Realizada']");
    }
    
    //********************************* títulos *************************************************************//
    
    public void titulos() {
    	clicarLink("Títulos");
    	entrarFrame("#panelcategory1>iframe");
    }
    
    public String obterTextoTitulos() {
    	return obterTextoXpath("//*[text()='Nenhum registro.']");
    }

 }