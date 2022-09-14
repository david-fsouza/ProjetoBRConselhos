package br.conselhos.page.Cadastros;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.conselhos.SQL.JavaApplicationConexaoSQL;
import br.conselhos.core.BasePage;

public class PessoasFisicasPage extends BasePage {
	
	/**
	 * Objetos Globais
	 */
	
	public void campoRequerente(String texto) throws InterruptedException {
		escreverID("lkpRequerenteEdt", texto + Keys.ENTER);
		esperaFixa(1000);
	}

	public void campoSubsessao(String texto) throws InterruptedException {
		//escrever("SubUnidadeAtual", texto + Keys.ENTER);
		clicarBotao("SubUnidadeAtual");
		sairFrame();
		esperaFixa(1000);
	    doisCliques(texto);
		esperaFixa(2000);
	}
	
	public void campoInscricao(String texto) throws InterruptedException {
		clicarBotao("TipoInscricaoAtual");
		sairFrame();
		esperaFixa(1000);
		doisCliques(texto);
		esperaFixa(2000);
	}
	
	// ******* Incluir Nova Pessoa Fisica ******//

	public void campoNomeCompleto(String texto) {
		escrever("Nome", texto);
	}
	
	public void campoProcesso(String texto) {
		escrever("NumeroProcesso", texto);
	}
	
	public void campoRegional(String texto) throws InterruptedException {
		escrever("SubUnidadeOrigem", texto + Keys.ENTER);
		esperaFixa(1000);
	}
	
	public void campoNumeroInscricaoOrigem(String texto) {
		escrever("RegistroConselhoOrigem", texto);
	}
	
	public void campoInscricaoInformacaoRegionalOrigem(String texto) throws InterruptedException {
		escrever("TipoInscricaoConselhoAnter", texto + Keys.ENTER);
		esperaFixa(1000);
	}
	
	public void campoSituacao(String texto) throws InterruptedException {
		escrever("SituacaoConselhoAnterior", texto + Keys.ENTER);
		esperaFixa(1000);
	}
	
	public void abaEndResidencial() throws InterruptedException {
		clicarBotaoSelector("div[title='End. Residencial']");
		esperaFixa(1000);
	}
	
	public void campoCEP(String texto) throws InterruptedException {
		escrever("CEPResidencial", texto);
		esperaFixa(3000);
		digitaTeclaName("CEPResidencial", Keys.ENTER);
		esperaFixa(1000);
	}
	
	public void campoNumero(String texto) {
		escrever("NumeroResidencial", texto);
	}
	
	public void checkBoxCorrespondencia() {
		clicarCheck(By.name("CorrespondenciaResidencial"));
	}
	
	public void campoCelular(String texto) {
		escrever("TelefoneCelular", texto);
	}
	
	public void abainfPessoais() throws InterruptedException {
		clicarBotaoSelector("div[title='Inf. Pessoais']");
		esperaFixa(1000);
	}
	
	public void campoSexo(String texto) {
		escrever("Sexo", texto + Keys.ENTER);
	}
	
	public void campoCPF(String texto) throws InterruptedException {
		escrever("CPFCNPJ", texto);
		esperaFixa(2000);
	}
	
	public String validarTextoInclusaoPessoaFisica() {
		return obterTexto("PATRICIA SILVA PIRES TESTE");
	}
	
	//****** Alterar Pessoa Fisica ******//
	
	public String validarTextoAlterarPessoaFisicaRecemCadastrada() {
		return obterTexto("Chapecó");
	}
	
	//****** Alterar Situação Pessoa Física *****//
	
	public void alterarSituacao() {
		clicarBotaoXpath("//*[text()='Alterar Situação...']");
	}
	
	public void campoSituacaoDoComplemento(String texto) throws InterruptedException {
		escreverID("lkpSituacaoEdt", texto);
		esperaFixa(1000);
		digitaTeclaId("lkpSituacaoEdt", Keys.ENTER);	
	}
	
	public String validarTextoAlterarSituacaoPessoaFisica() {
		return obterTexto("Baixado");
	}
	
	//******* Verificar Histórico da Situação *******//
	
	public void historicoDeSituacoes() {
		clicarLink("Histórico de situações");
		entrarFrame("#panelcategory14>iframe");
	}
	
	public String validarTextoVerificarHistoricoDaSituacao() {
		return obterTexto("Baixado");
	}
	
	//******* Verificar Endereços *******//
	
	public void outrosEnderecos() {
		clicarLink("Outros endereços");
		entrarFrame("#panelcategory1>iframe");
	}
	
	public String validarTextoEnderecos() {
		return obterTexto("Residencial");
	}
	
	//******** Alterar Pessoa Física Cadastrada Anteriormente(Previamente) ********//
	
	public String validarTextoPrimeiraAlteracao() {
		return obterTexto("Campo a ser alterado");
	}
	
	public String validarTextoAlterarPessoaFisicaCadastradaAnteriormente() {
		return obterTexto("Alteração Realizada");
		
	}
	

//******* Apagar Registro no Final da Bateria de Testes ********//
	
	public void apagarRegistroSQL() throws SQLException, InterruptedException {
		executarQuerySQL("DECLARE @id_inscrito INT;\r\n" + "SELECT * FROM Pessoa\r\n"
				+ "WHERE Nome = 'PATRICIA SILVA PIRES TESTE'\r\n"
				+ "SELECT @id_inscrito = ID FROM Pessoa WHERE Nome = 'PATRICIA SILVA PIRES TESTE'\r\n" + "\r\n"
				+ "DELETE FROM OutrosEnderecos\r\n" + "WHERE Pessoa = @id_inscrito\r\n" + "\r\n"
				+ "DELETE FROM SituacaoTramite\r\n" + "WHERE Pessoa = @id_inscrito\r\n" + "\r\n"
				+ "DELETE FROM HistoricoInadimplencia\r\n" + "WHERE Pessoa = @id_inscrito\r\n" + "\r\n"
				+ "DELETE FROM Pessoa\r\n" + "WHERE Nome = 'PATRICIA SILVA PIRES TESTE'");
	}
}
