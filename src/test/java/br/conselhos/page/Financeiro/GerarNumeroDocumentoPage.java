package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class GerarNumeroDocumentoPage extends BasePage {
	
	
	/*********** TELA PRINCIPAL GERAR N�MERO DOCUMENTO *************************************************************************/
	
	//**************** Novo Gerar N�mero Documento ***************************************************************************//
    public String obterTextoNovoGerarNumeroDocumento() {
    	return obterTextoXpath("//*[text()='Permite gerar numera��o para documentos.']");
	}
}
