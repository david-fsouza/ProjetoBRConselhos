package br.conselhos.page.Fiscalizacao;

import br.conselhos.core.BasePage;

public class ProcessoPage extends BasePage {

	//****** Incluir Infra��o Processo Fiscalizacao *******//
	public void abaInfracao( ) {
		clicarLink("Infra��o");
		entrarFrame("#panelcategory14>iframe");
	}
	
	public void campoDescricao(String texto) {
		escreverID("txtDescricaoFisEdt", texto);
	}
	
	public String validarTextoIncluirInfracaoProcesso() {
		return obterTexto("Inclus�o infra��o Fiscaliza��o");
	}
	
	//****** Excluir Infra��o Processo Fiscaliza��o ******//
	public String validarTextoExcluirInfracaoProcesso() {
		return obterTexto("Nenhum registro.");
	}
}
