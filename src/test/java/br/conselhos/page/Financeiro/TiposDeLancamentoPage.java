package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class TiposDeLancamentoPage extends BasePage {
	
	//************************** Novo Tipos De Lançamento ********************************************************************//
	
	public String obterTextoNovoTiposDeLancamento() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informações dos tipos de lançamento.']");
	}
	
	//************************ Consulta Tipos de Lançamento *****************************************************************//

	public String obterTextoConsultaTiposDeLancamento() {
		return obterTextoXpath("//*[text()='Considerar para cálculo de inadimplência']");
		
	}
}
