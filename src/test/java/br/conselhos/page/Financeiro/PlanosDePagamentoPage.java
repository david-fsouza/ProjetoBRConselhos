package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class PlanosDePagamentoPage extends BasePage {



    //****************************** Novo Planos de Pagamento **********************************************************//

    public String obterTextoNovoPlanoDePagamento() {
	    return obterTextoXpath("//*[text()='Permitir selecionar t�tulos a renegociar']");
    }
    
    //**************************** Consulta Planos de Pagamento *******************************************************//
    
    public String obterTextoConsultaPlanosPagamento() {
    	return obterTextoXpath("//*[text()='Op��o de parcelamento']");
    }
    
    //*********************************** Filtro Pessoa **************************************************************//
    
    public void filtroPessoa() {
    	clicarBotaoSelector("div[title='Filtro pessoa']");
    }
    
    public String obterTextoFiltroPessoa() {
    	return obterTextoXpath("//*[text()='Filtro SQL de restri��o de pessoas']");
    }
    
    //*********************************** Filtro T�tulo ***************************************************************//
    
    public void filtroTitulo() {
    	clicarBotaoSelector("div[title='Filtro t�tulo']");
    }
    
    public String obterTextoFiltroTitulo() {
    	return obterTextoXpath("//*[text()='Tipos de lan�amentos']");
    }
    
    //************************************ Permiss�es *****************************************************************//
    
    public void abaPermissoes() {
    	clicarLink("Permiss�es");
    	entrarFrame("#panelcategory1>iframe");
    }
    
    public String obterTextoPermissoes() {
    	return obterTextoCss("div[title='Administradores do sistema']");
    }
    
    
}