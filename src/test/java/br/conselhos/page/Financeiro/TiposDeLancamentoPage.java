package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class TiposDeLancamentoPage extends BasePage {
	
	//************************** Novo Tipos De Lan�amento ********************************************************************//
	
	public String obterTextoNovoTiposDeLancamento() {
		return obterTextoXpath("//*[text()='Permite cadastrar/alterar informa��es dos tipos de lan�amento.']");
	}
	
	//************************ Consulta Tipos de Lan�amento *****************************************************************//

	public String obterTextoConsultaTiposDeLancamento() {
		return obterTextoXpath("//*[text()='Considerar para c�lculo de inadimpl�ncia']");
		
	}
}
