package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class GerarNumeroDocumentoPage extends BasePage {
	
	
	/*********** TELA PRINCIPAL GERAR NÚMERO DOCUMENTO *************************************************************************/
	
	//**************** Novo Gerar Número Documento ***************************************************************************//
    public String obterTextoNovoGerarNumeroDocumento() {
    	return obterTextoXpath("//*[text()='Permite gerar numeração para documentos.']");
	}
}
