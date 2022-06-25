package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class PlanosDePagamentoPage extends BasePage {



    //****************************** Novo Planos de Pagamento **********************************************************//

    public String obterTextoNovoPlanoDePagamento() {
	    return obterTextoXpath("//*[text()='Permitir selecionar títulos a renegociar']");
    }
    
    //**************************** Consulta Planos de Pagamento *******************************************************//
    
    public String obterTextoConsultaPlanosPagamento() {
    	return obterTextoXpath("//*[text()='Opção de parcelamento']");
    }
    
    //*********************************** Filtro Pessoa **************************************************************//
    
    public void filtroPessoa() {
    	clicarBotaoSelector("div[title='Filtro pessoa']");
    }
    
    public String obterTextoFiltroPessoa() {
    	return obterTextoXpath("//*[text()='Filtro SQL de restrição de pessoas']");
    }
    
    //*********************************** Filtro Título ***************************************************************//
    
    public void filtroTitulo() {
    	clicarBotaoSelector("div[title='Filtro título']");
    }
    
    public String obterTextoFiltroTitulo() {
    	return obterTextoXpath("//*[text()='Tipos de lançamentos']");
    }
    
    //************************************ Permissões *****************************************************************//
    
    public void abaPermissoes() {
    	clicarLink("Permissões");
    	entrarFrame("#panelcategory1>iframe");
    }
    
    public String obterTextoPermissoes() {
    	return obterTextoCss("div[title='Administradores do sistema']");
    }
    
    
}