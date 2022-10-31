package br.conselhos.page.Fiscalizacao;

import br.conselhos.core.BasePage;

public class ProcessoPage extends BasePage {

	//****** Incluir Infração Processo Fiscalizacao *******//
	public void abaInfracao( ) {
		clicarLink("Infração");
		entrarFrame("#panelcategory14>iframe");
	}
	
	public void campoDescricao(String texto) {
		escreverID("txtDescricaoFisEdt", texto);
	}
	
	public String validarTextoIncluirInfracaoProcesso() {
		return obterTexto("Inclusão infração Fiscalização");
	}
	
	//****** Excluir Infração Processo Fiscalização ******//
	public String validarTextoExcluirInfracaoProcesso() {
		return obterTexto("Nenhum registro.");
	}
}
