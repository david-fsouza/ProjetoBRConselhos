package br.conselhos.page.Cadastros;

import static br.conselhos.core.DriverFactory.getDriver;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.conselhos.core.BasePage;

public class PessoasPage extends BasePage {
	
	/**
	 * Objetos Globais
	 */
	
	public void botaoSalvarEFechar() {
		clicarBotaoXpath("/html/body/form/div/div/div[2]/div[1]/div/div[1]/div[2]");	
	}
	
	public void filtroColecaoPessoas(String texto) {
		escreverXpath("//input[contains(@name, 'FormPanelMain:leftContainer:')]", texto + Keys.ENTER);
	}
	
	public void abaEndProfissional() {
		clicarBotaoSelector("div[title='End. Profissional']");	
	}
	
	public void campoCEP(String texto) throws InterruptedException {
		escrever("CEPComercial", texto);
		esperaFixa(2000);
		digitaTeclaName("CEPComercial", Keys.ENTER);
		esperaFixa(1000);
	}
	
	public void campoNumero(String texto) {
		escrever("NumeroComercial", texto);
	}
	
	public void campoEmail(String texto) {
		escrever("EmailComercial", texto);
	}
	
	//CRIADO ESSE BOTÃO, NENHUM OUTRO PADRÃO FUNCIONOU NESTE PAINEL(PESSOAS, GERAL)
	public void botaoNovoInscrito() {
		clicarBotaoID("btNovoInscricao");
	}
	
	
	//****** Incluir Nova Pessoa Física ******//
	public void campoCPF(String texto) throws InterruptedException {
		escrever("CPFCNPJ", texto);
		esperaFixa(2000);
	}
	
	public void abaEndResidencial() {
		clicarBotaoSelector("div[title='End. Residencial']");
	}
	
	public void campoEmailResidencial(String texto) {
		escrever("EmailResidencial", texto);
	}
	
	public void abaOutrasInformacoes() {
		clicarBotaoSelector("div[title='Outras informações']");
	}
	
	public void campoSexo(String texto) {
		escrever("Sexo", texto + Keys.ENTER);
	}
	
	public String validarTextoIncluirPessoaFisica() {
		return obterTexto("PATRICIA SILVA PIRES TESTE");
	}
	
	// Assert para o módulo cadastro não interferir no teste padrão
	public String validarTextoIncluirPessoaFisicaCadastro() {
		return obterTexto("PATRICIA SILVA PIRES TESTE CADASTRO");
	}
	
	
	//****** Nova Inscrição Pessoa Física ******//
	public String validarTextoNovaInscricaoPessoaFisica() {
		return obterTexto("INSCRIÇÃO DEFINITIVA PRINCIPAL");
	}
	
	//******* Apagar Registro no Final da Bateria de Testes Padrão ********//
	
		public void apagarRegistroSQLPessoaaFisica() throws SQLException, InterruptedException {
			executarQuerySQL("DECLARE @id_inscrito INT;\r\n" + "SELECT * FROM Pessoa\r\n"
					+ "WHERE Nome = 'PATRICIA SILVA PIRES TESTE'\r\n"
					+ "SELECT @id_inscrito = ID FROM Pessoa WHERE Nome = 'PATRICIA SILVA PIRES TESTE'\r\n" + "\r\n"
					+ "DELETE FROM OutrosEnderecos\r\n" + "WHERE Pessoa = @id_inscrito\r\n" + "\r\n"
					+ "DELETE FROM SituacaoTramite\r\n" + "WHERE Pessoa = @id_inscrito\r\n" + "\r\n"
					+ "DELETE FROM HistoricoInadimplencia\r\n" + "WHERE Pessoa = @id_inscrito\r\n" + "\r\n"
					+ "DELETE FROM Pessoa\r\n" + "WHERE Nome = 'PATRICIA SILVA PIRES TESTE'");
		}
	
	//****** Incluir Nova Pessoa Jurídica *******//
	
	public void campoTipo(String texto) throws InterruptedException {
		clicarBotao("TipoPessoa");
		sairFrame();
		esperaFixa(1000);
		doisCliques(texto);
		esperaFixa(1000);
	}
	
	public void campoNomeCompleto(String texto) {
		escrever("Nome", texto);
	}
	
	public void campoCapitalSocial(String texto) {
		escrever("ValorCapitalSocial", texto);
	}
	
	public void campoProcesso(String texto) {
		escrever("NumeroProcesso", texto);
	}
	
	public String validarTextoIncluirNovaPessoaJuridica() {
		return obterTexto("PATRICIA SILVA JURIDICA TESTE");
	}
	
	// Assert para o módulo cadastro não interferir no teste padrão
	public String validarTextoIncluirNovaPessoaJuridicaCadastro() {
		return obterTexto("PATRICIA SILVA JURIDICA TESTE CADASTRO");
	}
	
	//******* Apagar Registro no Final da Bateria Módulo Cadastro ********//
	public void apagarRegistroSQLPessoaaFisicaCadastro() throws SQLException, InterruptedException {
		executarQuerySQL("DECLARE @id_inscrito INT;\r\n" + "SELECT * FROM Pessoa\r\n"
				+ "WHERE Nome = 'PATRICIA SILVA PIRES TESTE CADASTRO'\r\n"
				+ "SELECT @id_inscrito = ID FROM Pessoa WHERE Nome = 'PATRICIA SILVA PIRES TESTE CADASTRO'\r\n" + "\r\n"
				+ "DELETE FROM OutrosEnderecos\r\n" + "WHERE Pessoa = @id_inscrito\r\n" + "\r\n"
				+ "DELETE FROM SituacaoTramite\r\n" + "WHERE Pessoa = @id_inscrito\r\n" + "\r\n"
				+ "DELETE FROM HistoricoInadimplencia\r\n" + "WHERE Pessoa = @id_inscrito\r\n" + "\r\n"
				+ "DELETE FROM Pessoa\r\n" + "WHERE Nome = 'PATRICIA SILVA PIRES TESTE CADASTRO'");
	}
	
	
	
	public void campoTipoInscricao(String texto) throws InterruptedException {
		clicarBotao("TipoInscricao");
		escrever("TipoInscricao", texto);
		esperaFixa(1000);
		digitaTeclaName("TipoInscricao", Keys.ENTER);
	}
	
	
	//****** Alterar Pessoa Jurídica Recém Cadastrada ******//
	
	public void campoSubsessao(String texto) throws InterruptedException {
		//escrever("SubUnidadeAtual", texto + Keys.ENTER);
		esperaFixa(2000);
		clicarBotao("SubUnidadeAtual");
		sairFrame();
		sairFrame();
		esperaFixa(2000);
	    doisCliques(texto);
		esperaFixa(2000);
	}
	
    public String validarTextoAlterarPessoaJuridicaRecemCadastrada() {
    	return obterTexto("Florianópolis");
    }
    
    
    //******* Alterar Situação Pessoa Jurídica *******//
    
    public void alterarSituacaoEmLote() {
    	sairFrame();
    	clicarBotaoXpath("//*[text()='Alterar Situação em Lote']");
    }
    
    public void campoCategoria(String texto) throws InterruptedException {
    	escreverID("lkpCategoriaEdt", texto);
    	esperaFixa(1000);
    	digitaTeclaId("lkpCategoriaEdt", Keys.ENTER);  	
    }
    
    public void campoSituacao(String texto) throws InterruptedException {
    	escreverID("lkpSituacaoEdt", texto);
    	esperaFixa(1000);
    	digitaTeclaId("lkpSituacaoEdt", Keys.ENTER);    	
    }
    
    public void campoComplementoSituacao(String texto) throws InterruptedException {
    	escreverID("lkpComplementoSituacaoEdt", texto);
    	esperaFixa(1000);
    	digitaTeclaId("lkpComplementoSituacaoEdt", Keys.ENTER);	
    }
    
    public String validarTextoAlterarSituacaoPessoaJuridica() {
    	return obterTexto("A pedido");
    }
    
    //******* Alterar Pessoa Jurídica Cadastrada Anteriormente *******//
    
    public String validarTextoPrimeiraAlteracaoPessoaJuridica() throws InterruptedException {
    	return obterTextoCss("div[title='Lages']");
    }
    
    public String validarTextoAlterarPessoaJuridicaCadastradaAnteriormente() {
    	return obterTexto("Florianópolis");
    }
    
    //******** Criar Vículo Profissional (RT) ********//
    
    public void vinculosProfissionais() {
    	clicarLink("Vínculos Profissionais");
    	entrarFrame(By.xpath("//*[contains(@src, '+Profissionais')]"));
    }
    
    public void campoProfissional(String texto) throws InterruptedException {
    	escrever("Pessoa", texto);
    	esperaFixa(3000);
    	digitaTeclaName("Pessoa", Keys.ENTER);
    	esperaFixa(2000);
    }
    
    public void campoTipoDeVinculo(String texto) throws InterruptedException {
    	clicarBotao("TipoVinculo");
    	escrever("TipoVinculo", texto);
       	esperaFixa(1000);
       	digitaTeclaName("TipoVinculo", Keys.ENTER);
    	esperaFixa(1000);
    }
	
    public void campoInscricaoCategoria(String texto) throws InterruptedException {
    	clicarBotao("InscricaoCategoria");
    	escrever("InscricaoCategoria", texto);
       	esperaFixa(1000);
       	digitaTeclaName("InscricaoCategoria", Keys.ENTER);
    	esperaFixa(1000);
    }
    
    public void campoPeriodoInicial() throws InterruptedException {
    	inserirDataAtual("PeriodoInicial");
    }
    
    public String validarTextoIncluirVinculoProfissional() {
    	return obterTexto("ABDOM MURILO BARBOSA SANCHEZ");
    }
    
    //******* Alterar Vínculo Profissional Já Existente ********//
    
    public String validarTextoAlterarVinculoProfissional() {
    	return obterTexto("Enfermeiro");
    }
    
    //******** Criar Vinculo Profissional ART ********//
    
    public void abaART() {
    	clicarBotaoXpath("//*[contains(text(), 'ART')]");
    }
	
    //******** Apagar Pessoa Jurídica no Final do Teste Padrão*********//
    
	public void apagarRegistroSQLPessoaJuridica() throws SQLException, InterruptedException {
		executarQuerySQL("DECLARE @id_inscrito INT;\r\n"
				+ "SELECT * FROM Pessoa\r\n"
				+ "WHERE Nome = 'PATRICIA SILVA JURIDICA TESTE'\r\n"
				+ "SELECT @id_inscrito = ID FROM Pessoa WHERE Nome = 'PATRICIA SILVA JURIDICA TESTE'\r\n"
				+ "\r\n"
				+ "DELETE FROM OutrosEnderecos\r\n"
				+ "WHERE Pessoa = @id_inscrito\r\n"
				+ "\r\n"
				+ "DELETE FROM SituacaoTramite\r\n"
				+ "WHERE Pessoa = @id_inscrito\r\n"
				+ "\r\n"
				+ "DELETE FROM HistoricoInadimplencia\r\n"
				+ "WHERE Pessoa = @id_inscrito\r\n"
				+ "\r\n"
				+ "DELETE FROM VinculoProfissional\r\n"
				+ "WHERE PessoaJuridica = @id_inscrito\r\n"
				+ "\r\n"
				+ "DELETE FROM Pessoa\r\n"
				+ "WHERE Nome = 'PATRICIA SILVA JURIDICA TESTE'");
	}
	
    //******** Apagar Pessoa Jurídica no Final do Teste Módulo Cadastro*********//
	public void apagarRegistroSQLPessoaJuridicaCadastro() throws SQLException, InterruptedException {
		executarQuerySQL("DECLARE @id_inscrito INT;\r\n"
				+ "SELECT * FROM Pessoa\r\n"
				+ "WHERE Nome = 'PATRICIA SILVA JURIDICA TESTE CADASTRO'\r\n"
				+ "SELECT @id_inscrito = ID FROM Pessoa WHERE Nome = 'PATRICIA SILVA JURIDICA TESTE CADASTRO'\r\n"
				+ "\r\n"
				+ "DELETE FROM OutrosEnderecos\r\n"
				+ "WHERE Pessoa = @id_inscrito\r\n"
				+ "\r\n"
				+ "DELETE FROM SituacaoTramite\r\n"
				+ "WHERE Pessoa = @id_inscrito\r\n"
				+ "\r\n"
				+ "DELETE FROM HistoricoInadimplencia\r\n"
				+ "WHERE Pessoa = @id_inscrito\r\n"
				+ "\r\n"
				+ "DELETE FROM VinculoProfissional\r\n"
				+ "WHERE PessoaJuridica = @id_inscrito\r\n"
				+ "\r\n"
				+ "DELETE FROM Pessoa\r\n"
				+ "WHERE Nome = 'PATRICIA SILVA JURIDICA TESTE CADASTRO'");
	}

}
