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
	 * Módulo GED
	 */
	
	// Salvando em diretório GED
	
	
	/**
	 * TED (A fazer,  não encontrei módulo, verificar acesso)
	 */
	
	
	/**
	 * Fiscalização
	 */
	
	public void abaDocumentosGEDAutoInfracaoFiscalizacao() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory11>iframe");
	}
	
	// Salvando em Coleções Módulo Fiscalização
	public String validarTextoDocumentoGEDFiscalizacao() {
		return obterTexto("ArquivoGED.pdf");
	}
	
	// Alterando Arquivos Salvos Fiscalização (Sem objetos)

	
	// Assinar Eletronicamente Documentos GED Fiscalização
	public String validarTextoAssinaturaEletronicaGEDFiscalizacao() {
		return obterTexto("Assinatura(s) realizada(s) com sucesso!.");
	}
	
	// Excluir Documento GED Fiscalização
	public String validarTextoDocumentoGEDExcluirFiscalizacao() {
		return obterTexto("Nenhum registro.");
	}
	
	/**
	 * Comissões
	 */
	
	public void abaDocumentosGEDProcessosComissoes() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory13>iframe");
	}
	
	/**
	 * Jurídico
	 */
	public void abaDocumentosGEDProcessosJuridico() {
		clicarLink("Documentos GED");
		entrarFrame("#panelcategory5>iframe");
	}
	// Salvando em Coleções Módulo Jurídico
	public String validarTextoSalvandoDocumentoGEDJuridico() {
		return obterTexto("ArquivoGED.pdf");
	}
	
	// Excluir Documento GED Jurídico
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
	
	// Salvando Documento GED Módulo Protocolo
	public String validarTextoSalvandoDocumentoGEDProtocolo() {
		return obterTexto("ArquivoGED.pdf");
	}
	
	// Alterando Documento GED Módulo Protocolo (Sem objeto)
	
	// Assinar Eletronicamente Documento GED Módulo Protocolo
	public String validarTextoAssinaturaEletronicaGEDProtocolo() {
		return obterTexto("Assinatura(s) realizada(s) com sucesso!.");
	}	
	
	// Excluir Documento GED Módulo Protocolo
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
	
	// Salvando Documento GED Módulo Administrativo
	public String validarTextoSalvandoDocumentoGEDAdministrativo() {
		return obterTexto("ArquivoGED.pdf");
	}
	
	// Alterando Documento GED Módulo Administrativo (Sem objeto)
	
	// Asssinar Eletrônicamente Documento GED Módulo Administrativo
	
	public String validarTextoAssinaturaEletronicaGEDAdministrativo() {
		return obterTexto("Assinatura(s) realizada(s) com sucesso!.");
	}
	
	// Excluir Documento GED Módulo Protocolo
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
	
	// Salvando Documento GED Módulo Conselho Pleno
	public String validarTextoSalvandoDocumentoGEDConselhoPleno() {
		return obterTexto("ArquivoGED.pdf");
	}
	
	// Alterando Documento GED Módulo Conselho Pleno (Sem objeto)
	
	// Assinar Eletrônicamente Documento GED Módulo Conselho Pleno
	public String validarTextoAssinaturaEletronicaGEDConselhoPleno() {
		return obterTexto("Assinatura(s) realizada(s) com sucesso!.");
	}
	
	// Excluir Documento GED Módulo Conselho Pleno
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
	
	// Salvando Documento GED Módulo Cadastros
	public String validarTextoSalvandoDocumentoGEDCadastros() {
		return obterTexto("ArquivoGED.pdf");
	}
	
		
}
