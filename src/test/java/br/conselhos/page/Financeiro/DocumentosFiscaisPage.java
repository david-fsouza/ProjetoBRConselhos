package br.conselhos.page.Financeiro;

import br.conselhos.core.BasePage;

public class DocumentosFiscaisPage extends BasePage {
	
    /**
     * TELA PRINCIPAL DOCUMENTOS FISCAIS
     */
	// Novo Documentos Fiscais
	
	public String obterTextoNovoDocumentosFiscais() {
		return obterTextoXpath("//*[text()='Permite manter os documentos fiscais.']");
	}
	
	// Consulta Documentos Fiscais
	
	public String obterTextoConsultaDocumentosFiscais() {
		return obterTextoXpath("//*[text()='Documentos Fiscais']");
	}
	
    /**
     * Tela Menu Lateral Tela Sobreposta
     */
	// Liquidações
	
	public void abaLiquidacoes() {
		clicarLink("Liquidações");
		esperaExplicita("#panelcategory1>iframe");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String obterTextoLiquidacoes() {
		return obterTextoXpath("//*[text()='Valor documento']");
	}
	
	// Documentos GED
	
	public void abaDocumentosGED() {
		clicarLink("Documentos GED");
		esperaExplicita("#panelcategory2>iframe");
		entrarFrame("#panelcategory2>iframe");
	}
	
	public String obterTextoDocumentosGED() {
		return obterTextoXpath("//*[text()='Data de Vínculo']");
	}
	
	

}
