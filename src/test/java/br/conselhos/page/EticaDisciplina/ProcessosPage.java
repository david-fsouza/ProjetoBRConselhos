package br.conselhos.page.EticaDisciplina;

import br.conselhos.core.BasePage;

public class ProcessosPage extends BasePage {
	
	//***** Incluir Infra��o no Processo �tica e Disciplina *****//
	
	public void abaInfracoes() {
		clicarLink("Infra��es");
		entrarFrame("#panelcategory8>iframe");
	}
	
	public void campoDescricao(String texto) {
		escreverID("txtDescricaoEdt", texto);
	}
	
	public String validarTextoinclusaoInfracao() {
		return obterTexto("Inclus�o de infra��o");
	}
	
	//***** Excluir Infra��o do Processo ******//
	public String validarTextoExcluirInfracaoProcesso () {
		return obterTexto("Nenhum registro.");
	}
	

}
