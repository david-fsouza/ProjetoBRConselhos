package br.conselhos.page.GED;

import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class GEDPage extends BasePage {
	
	/******************
	 * Objetos Globais
	 *****************/	
	public void campoDocumento(String nomearquivo) {
		uploadArquivo("file", nomearquivo);
	}
	
	public void campoTipoDocumento(String texto) {
		escreverID("m_cbTipoDocumentoEdt", texto);
		digitaTeclaId("m_cbTipoDocumentoEdt", Keys.ENTER);
	}
	
	public void assinarEletronicamente() {
		clicarBotaoXpath("//*[text()='Assinar Eletronicamente']");
	}
	
	public void campoTipoAssunto(String texto) throws InterruptedException {
		clicarBotaoID("m_lkTipoAssuntoEdt");
		escreverID("m_lkTipoAssuntoEdt", texto);
		esperaFixa(1000);
		digitaTeclaId("m_lkTipoAssuntoEdt", Keys.ENTER);	
	}
	
	/**
	 * M�dulo GED
	 */
	
	// Salvando em diret�rio GED
	
	
	/**
	 * TED (A fazer,  n�o encontrei m�dulo, verificar acesso)
	 */
	
	
	/**
	 * Fiscaliza��o
	 */
	
	public void abaDocumentosGEDAutoInfracaoFiscalizacao() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory11>iframe");
	}
	
	// Salvando em Cole��es M�dulo Fiscaliza��o
	public String validarTextoDocumentoGEDFiscalizacao() {
		return obterTexto("ArquivoGED.pdf");
	}
	
	// Alterando Arquivos Salvos Fiscaliza��o (Sem objetos)

	
	// Assinar Eletronicamente Documentos GED Fiscaliza��o
	public String validarTextoAssinaturaEletronicaGEDFiscalizacao() {
		return obterTexto("Assinatura(s) realizada(s) com sucesso!.");
	}
	
	// Excluir Documento GED Fiscaliza��o
	public String validarTextoDocumentoGEDExcluirFiscalizacao() {
		return obterTexto("Nenhum registro.");
	}
	
	/**
	 * Comiss�es
	 */
	
	public void abaDocumentosGEDProcessosComissoes() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory13>iframe");
	}
	
	/**
	 * Jur�dico
	 */
	public void abaDocumentosGEDProcessosJuridico() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory5>iframe");
	}
	// Salvando em Cole��es M�dulo Jur�dico
	public String validarTextoSalvandoDocumentoGEDJuridico() {
		return obterTexto("ArquivoGED.pdf");
	}
	
	// Excluir Documento GED Jur�dico
	public String validarTextoDocumentoGEDExcluirJuridico() {
		return obterTexto("Nenhum registro.");		
	}
	
	/**
	 * Protocolo
	 */
	public void abaDocumentosGEDProtocolo() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory8>iframe");
	}
	
	// Salvando Documento GED M�dulo Protocolo
	public String validarTextoSalvandoDocumentoGEDProtocolo() {
		return obterTexto("ArquivoGED.pdf");
	}
	
	// Alterando Documento GED M�dulo Protocolo (Sem objeto)
	
	// Assinar Eletronicamente Documento GED M�dulo Protocolo
	public String validarTextoAssinaturaEletronicaGEDProtocolo() {
		return obterTexto("Assinatura(s) realizada(s) com sucesso!.");
	}	
	
	// Excluir Documento GED M�dulo Protocolo
	public String validarTextoExcluirDocumentoGEDProtocolo() {
		return obterTexto("Nenhum registro.");
	}
	
	/**
	 * Administrativo
	 */
	public void abaDocumentosGEDAdministrativo() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory10>iframe");
	}
	
	// Salvando Documento GED M�dulo Administrativo
	public String validarTextoSalvandoDocumentoGEDAdministrativo() {
		return obterTexto("ArquivoGED.pdf");
	}
	
	// Alterando Documento GED M�dulo Administrativo (Sem objeto)
	
	// Asssinar Eletr�nicamente Documento GED M�dulo Administrativo
	
	public String validarTextoAssinaturaEletronicaGEDAdministrativo() {
		return obterTexto("Assinatura(s) realizada(s) com sucesso!.");
	}
	
	// Excluir Documento GED M�dulo Protocolo
	public String validarTextoExcluirDocumentoGEDAdministrativo() {
		return obterTexto("Nenhum registro.");
	}
	
	/**
	 * Conselho Pleno
	 */
	public void abaDocumentosGEDConselhoPleno() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory9>iframe");
	}
	
	// Salvando Documento GED M�dulo Conselho Pleno
	public String validarTextoSalvandoDocumentoGEDConselhoPleno() {
		return obterTexto("ArquivoGED.pdf");
	}
	
	// Alterando Documento GED M�dulo Conselho Pleno (Sem objeto)
	
	// Assinar Eletr�nicamente Documento GED M�dulo Conselho Pleno
	public String validarTextoAssinaturaEletronicaGEDConselhoPleno() {
		return obterTexto("Assinatura(s) realizada(s) com sucesso!.");
	}
	
	// Excluir Documento GED M�dulo Conselho Pleno
	public String validarTextoExcluirDocumentoGEDConselhoPleno() {
		return obterTexto("Nenhum registro.");
	}
	
	/**
	 * Cadastros
	 */
	public void abaDocumentosGEDCadastros() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory15>iframe");
	}
	
	// Salvando Documento GED M�dulo Cadastros
	public String validarTextoSalvandoDocumentoGEDCadastros() {
		return obterTexto("ArquivoGED.pdf");
	}
	
		
}
