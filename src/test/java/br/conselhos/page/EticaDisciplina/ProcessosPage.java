package br.conselhos.page.EticaDisciplina;

import br.conselhos.core.BasePage;

public class ProcessosPage extends BasePage {
	
	//***** Incluir Infração no Processo Ética e Disciplina *****//
	
	public void abaInfracoes() {
		clicarLink("Infrações");
		entrarFrame("#panelcategory8>iframe");
	}
	
	public void campoDescricao(String texto) {
		escreverID("txtDescricaoEdt", texto);
	}
	
	public String validarTextoinclusaoInfracao() {
		return obterTexto("Inclusão de infração");
	}
	
	//***** Excluir Infração do Processo ******//
	public String validarTextoExcluirInfracaoProcesso () {
		return obterTexto("Nenhum registro.");
	}
	

}
