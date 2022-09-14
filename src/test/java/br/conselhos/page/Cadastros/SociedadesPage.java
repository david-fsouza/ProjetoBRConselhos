package br.conselhos.page.Cadastros;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import br.conselhos.core.BasePage;

public class SociedadesPage extends BasePage {
	
	/**
	 * Objetos Globais
	 */
	
	//******* Adicionar S�cio ******//
	
	public void abaSocios() {
		clicarLink("S�cios");
		entrarFrame("#panelcategory3>iframe");
	}
	
	public void campoSocio(String texto) throws InterruptedException {
		clicarBotao("AdvogadoSocio");
		escrever("AdvogadoSocio", texto);
		esperaFixa(1000);
		digitaTeclaName("AdvogadoSocio", Keys.ENTER);
		esperaFixa(1000);
	}
	
	public void campoVinculo(String texto) throws InterruptedException {
		clicarBotao("TipoVinculo");
		escrever("TipoVinculo", texto);
		esperaFixa(1000);
		digitaTeclaName("TipoVinculo", Keys.ENTER);
		esperaFixa(1000);
	}
	
	public void campoCotas(String texto) {
		escrever("Cota", texto + Keys.ENTER);
	}
	
	public void campoPeriodoInicialDaSociedade() throws InterruptedException {
		inserirDataAtual("DataInicial");
	}
	
	public String validarTextoAdicionarSocio() {
		return obterTexto("IRENE RODRIGUES DA SILVA");
	}
	
	//******* Adicionar Associado *******//
	
	public String validarTextoAssociado() {
		return obterTexto("ADRIANI CAVALCANTI DE FIGUEIREDO COSTA PEREIRA");
	}
	
	//******* Remover S�cio *******//
	
	public String validarTextoSocioCadastrado() {
		return obterTexto("IRENE RODRIGUES DA SILVA");
	}
	
	//******* Remover Associado *******//
	
	public String validarTextoAssociadoCadastrado() {
		return obterTexto("ADRIANI CAVALCANTI DE FIGUEIREDO COSTA PEREIRA");
	}
	
	//******* Registrar Altera��o Contratual *******//
	
	public void registrarAlteracoesContratuais() {
		clicarBotaoID("cmdRegistrarAlteracaoContratual_Sociedade");
	}
	
	public void textAreaObservacoes(String texto) {
		escreverID("m_ObservacaoEdt", texto);
	}
	
	public void abaHistoricoDeAlteracoesContratuais() {
		clicarLink("Hist�rico de altera��es contratuais");
		entrarFrame("#panelcategory4>iframe");
	}
	
	public String validarTextoRegistroDeAlteracoesContratuais() {
		return obterTexto("Inclus�o");
	}
}
