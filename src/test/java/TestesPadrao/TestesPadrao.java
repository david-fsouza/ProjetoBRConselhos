package TestesPadrao;

import static br.conselhos.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.page.Cadastros.PessoasFisicasPage;
import br.conselhos.page.Cadastros.PessoasPage;
import br.conselhos.page.EticaDisciplina.ProcessosPage;
import br.conselhos.page.Financeiro.CobrancaPage;
import br.conselhos.page.Financeiro.ContasReceberPage;
import br.conselhos.page.Financeiro.IntegracaoBancariaPage;
import br.conselhos.page.Financeiro.RelatoriosPage;
import br.conselhos.page.Financeiro.RenegociacaoSimplificadaPage;
import br.conselhos.page.Fiscalizacao.ProcessoPage;
import br.conselhos.page.GED.GEDPage;

/**
 * Principais testes a serem validados no sistema, são o mínimo que deve estar
 * funcional antes de liberar a versão.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestesPadrao extends BaseTest {

	// Instancia para os Page Objects
	private PessoasPage pessoas = new PessoasPage();
	private PessoasFisicasPage pessoasfisicas = new PessoasFisicasPage();
	private ContasReceberPage contasreceber = new ContasReceberPage();
	private RenegociacaoSimplificadaPage renegociacaosimplificada = new RenegociacaoSimplificadaPage();
	private RelatoriosPage relatorio = new RelatoriosPage();
	private IntegracaoBancariaPage integracaobancaria = new IntegracaoBancariaPage();
	private CobrancaPage cobranca = new CobrancaPage();
	private GEDPage ged = new GEDPage();
	private ProcessosPage processos = new ProcessosPage();
	private ProcessoPage processo = new ProcessoPage();

	@Test
	public void T010_IncluirNovaPessoaFisica() throws InterruptedException {

		menu.Cadastros();
		menu.Pessoas();
		frame.frameDireita();
		page.botaoNovoTabela("0");
		frame.TelaSobreposta();
		pessoas.campoNomeCompleto("PATRICIA SILVA PIRES TESTE 3");
		pessoas.campoCPF("42226787836");
		pessoas.abaEndProfissional();
		pessoas.campoCEP("89636000");
		pessoas.campoNumero("10");
		page.esperar3segundos();
		pessoas.campoEmail("testepessoafisica@gmail.com");
		pessoas.abaEndResidencial();
		pessoas.campoEmailResidencial("teste@gmail.com");
		pessoas.abaOutrasInformacoes();
		pessoas.campoSexo("Feminino");
		page.salvareFechar();
		page.esperar2segundos();
		//sairFrame();
		//page.OK();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "422.267.878-36");
		page.selecionarRegistro("PATRICIA SILVA PIRES TESTE 3");
		frame.TelaSobreposta();
		page.fechar();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "422.267.878-36");
		Assert.assertEquals("PATRICIA SILVA PIRES TESTE 3", pessoas.validarTextoIncluirPessoaFisica());
	}

	@Test
	public void T020_InscricaoPessoaFisica() throws InterruptedException {

		menu.Cadastros();
		menu.Pessoas();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "422.267.878-36");
		page.selecionarRegistro("PATRICIA SILVA PIRES TESTE 3");
		frame.TelaSobreposta();
		pessoas.botaoNovoInscrito();
		frame.inscricoes();
		pessoas.campoTipoInscricao("INSCRIÇÃO DEFINITIVA PRINCIPAL");
		pessoas.botaoSalvarEFechar();
		page.esperar3segundos();
		frame.TelaSobreposta();
		//page.salvareFechar();
		//sairFrame();
		//page.OK();
		//frame.TelaSobreposta();
		//frame.inscricoes();
		//page.fechar();
		//frame.frameDireita();
		//page.inserirCampoFiltrar("0", "422.267.878-36");
		//page.selecionarRegistro("PATRICIA SILVA PIRES TESTE 3");
		//Assert.assertEquals("INSCRIÇÃO DEFINITIVA PRINCIPAL", pessoas.validarTextoNovaInscricaoPessoaFisica());
	}

	@Test
	public void T030_IncluirNovaPessoaJuridica() throws InterruptedException {

		menu.Cadastros();
		menu.Pessoas();
		frame.frameDireita();
		page.botaoNovo();
		frame.TelaSobreposta();
		pessoas.campoTipo("Pessoa Jurídica");
		frame.TelaSobreposta();
		pessoas.campoNomeCompleto("PATRICIA SILVA JURIDICA TESTE 1");
		esperaFixa(5000);
		pessoas.campoCapitalSocial("5000");
		pessoas.campoProcesso("123456789987654322");
		pessoas.abaEndProfissional();
		pessoas.campoCEP("88150000");
		pessoas.campoNumero("20");
		pessoas.campoEmail("juridico@gmail.com");
		pessoas.botaoSalvarEFechar();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "PATRICIA SILVA JURIDICA TESTE 1");
		Assert.assertEquals("PATRICIA SILVA JURIDICA TESTE 1", pessoas.validarTextoIncluirNovaPessoaJuridica());
	}
	
	@Test
	public void T040_InscricaoPessoaJuridica() throws InterruptedException {
		
		 page.selecionarRegistro("PATRICIA SILVA PESSOA JURIDICA 1");
		 frame.TelaSobreposta();
		 page.esperar3segundos();
		 pessoas.botaoNovoInscrito();
		 frame.inscricoes();
         pessoas.campoTipoInscricao("REGISTRO DE EMPRESA");
		 pessoas.botaoSalvarEFechar();
		 page.esperar3segundos();
		 frame.TelaSobreposta();
		 page.salvareFechar();
		 frame.frameDireita();
		 page.inserirCampoFiltrar("0", "PATRICIA SILVA PESSOA JURIDICA 1");
	     Assert.assertEquals("PATRICIA SILVA PESSOA JURIDICA 1",
		 pessoas.validarTextoIncluirNovaPessoaJuridica());
	}

	@Test
	public void T050_CriarVinculoProfissionalRT() throws InterruptedException, SQLException {

		menu.Cadastros();
		menu.Pessoas();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "Eduardo Augusto Cestari");
		page.selecionarRegistro("Eduardo Augusto Cestari");
		frame.TelaSobreposta();
		pessoas.filtroColecaoPessoas("Vínculos Profissionais");
		pessoas.vinculosProfissionais();
		page.esperar2segundos();
		page.botaoNovoTabela("0");
		page.esperar3segundos();
		frame.novoVinculoProfissional();
		// pessoas.campoProfissional("Eduardo Augusto Cestari");
		pessoas.campoTipoDeVinculo("Técnico");
		pessoas.campoInscricaoCategoria("INSCRIÇÃO DEFINITIVA PRINCIPAL");
		pessoas.campoPeriodoInicial();
		page.salvareFechar();
		frame.TelaSobreposta();
		pessoas.filtroColecaoPessoas("Vínculos Profissionais");
		pessoas.vinculosProfissionais();
		Assert.assertEquals("Eduardo Augusto Cestari", obterTexto("Eduardo Augusto Cestari"));
	}

	@Test
	public void T060_ExcluirVinculoProfissionalRT() throws InterruptedException {

		menu.Cadastros();
		menu.Pessoas();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "Eduardo Augusto Cestari");
		page.selecionarRegistro("Eduardo Augusto Cestari");
		frame.TelaSobreposta();
		pessoas.filtroColecaoPessoas("Vínculos Profissionais");
		pessoas.vinculosProfissionais();
		page.esperar2segundos();
		page.selecionarCheckBoxGrid("0");
		page.botaoFuncoes0();
		sairFrame();
		page.excluir();
		page.esperar2segundos();
		frame.TelaSobreposta();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		pessoas.filtroColecaoPessoas("Vínculos Profissionais");
		pessoas.vinculosProfissionais();
		Assert.assertEquals("Nenhum registro.", obterTexto("Nenhum registro."));
	}

	@Test
	public void T070_CriarVinculoProfissionalART() throws InterruptedException {

		menu.Cadastros();
		menu.Pessoas();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "Eduardo Augusto Cestari");
		page.selecionarRegistro("Eduardo Augusto Cestari");
		frame.TelaSobreposta();
		pessoas.filtroColecaoPessoas("Vínculos Profissionais");
		pessoas.vinculosProfissionais();
		page.esperar2segundos();
		pessoas.abaART();
		page.esperar2segundos();
		page.botaoNovoTabela("1");
		page.esperar3segundos();
		frame.novoVinculoProfissional();
		// pessoas.campoProfissional("Eduardo Augusto Cestari");
		pessoas.campoTipoDeVinculo("Técnico");
		pessoas.campoInscricaoCategoria("INSCRIÇÃO DEFINITIVA PRINCIPAL");
		pessoas.campoPeriodoInicial();
		page.salvareFechar();
		frame.TelaSobreposta();
		pessoas.filtroColecaoPessoas("Vínculos Profissionais");
		pessoas.vinculosProfissionais();
		Assert.assertEquals("Eduardo Augusto Cestari", obterTexto("Eduardo Augusto Cestari"));
	}

	@Test
	public void T080_ExcluirVinculoProfissionalART() throws InterruptedException {

		menu.Cadastros();
		menu.Pessoas();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "Eduardo Augusto Cestari");
		page.selecionarRegistro("Eduardo Augusto Cestari");
		frame.TelaSobreposta();
		pessoas.filtroColecaoPessoas("Vínculos Profissionais");
		pessoas.vinculosProfissionais();
		page.esperar2segundos();
		pessoas.abaART();
		page.esperar2segundos();
		page.selecionarCheckBoxGrid("0");
		page.botaoFuncoes1();
		sairFrame();
		page.excluir();
		frame.TelaSobreposta();
		frame.TelaSobreposta2();
		page.esperar2segundos();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		pessoas.filtroColecaoPessoas("Vínculos Profissionais");
		pessoas.vinculosProfissionais();
		Assert.assertEquals("Nenhum registro.", obterTexto("Nenhum registro."));
	}

	@Test
	public void T090_CadastroContasReceber() throws InterruptedException {

		menu.Financeiro();
		menu.ContasReceber();
		frame.frameDireita();
		page.botaoNovo();
		frame.TelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações de títulos a receber.",
				contasreceber.validarTextoCadastroContasReceber());
		contasreceber.campoSacado("ACENALDO FERREIRA LIMA");
		contasreceber.campoTipoLancamento("ANUIDADE PJ");
		// contasreceber.campoDataEmissao();
		// contasreceber.campoInscricaoCategoria("INSCRIÇÃO DEFINITIVA PRINCIPAL");
		contasreceber.campoParcela("8");
		contasreceber.campoValorBruto("1000");
		contasreceber.campoVencimento();
		page.salvareFechar();
		page.esperar2segundos();
	}

	@Test
	public void T100_EfetuarRenegociacaoSimplificada() throws InterruptedException {

		menu.Financeiro();
		menu.RenegociacaoSimplificada();
		frame.frameDireita();
		frame.frameDireita2();
		renegociacaosimplificada.campoPessoaFisica("ZULEIDE MENDES");
		renegociacaosimplificada.campoTipoDeInscricao("INSCRIÇÃO DEFINITIVA PRINCIPAL (AUXILIAR DE ENFERMAGEM)");
		renegociacaosimplificada.campoplanoDePagamento("Parcelamento de Anuidades");
		renegociacaosimplificada.campoQuantidadeDeParcelas("3");
		page.botaoLocalizar();
		// page.selecionarCheckBoxGrid("0");
		page.clicarBotaoGenerico("1.000,00");
		page.esperar2segundos();
		page.botaoAvancar();
		frame.TelaSobreposta();
		page.botaoConcluir();
		page.esperar3segundos();
		Assert.assertEquals("Informações da renegociação",
				renegociacaosimplificada.obterTextoNovoRenegociacaoSimplificada());
	}

	@Test
	public void T110_GeracaoEnvioDeBoletoEmailSelecionadas() throws InterruptedException {

		menu.Financeiro();
		menu.ContasReceber();
		frame.frameDireita();
		contasreceber.abaContasReceberGeracao();
		contasreceber.filtroSituacaoGeracao("A receber");
		page.inserirCampoFiltrar("1", "ACENALDO FERREIRA LIMA");
		page.selecionarCheckBoxGrid("0");
		page.botaoFuncoes1();
		sairFrame();
		contasreceber.gerarBoletosSelecionados();
		frame.TelaSobreposta();
		contasreceber.campoMotivoAlerta("E-mail contas a receber");
		page.botaoAvancar();
		Assert.assertEquals("Alertas agendado com sucesso.",
				contasreceber.validarTextoGeracaoEnvioBoletoEmailSelenionadas());
	}

	@Test
	public void T120_GeracaoEnvioDeBoletosEmailTodos() throws InterruptedException {

		menu.Financeiro();
		menu.ContasReceber();
		frame.frameDireita();
		contasreceber.abaContasReceberGeracao();
		// contasreceber.selectVisualizarContasReceberGeracao("Todos");
		contasreceber.filtroSituacaoGeracao("A receber");
		page.inserirCampoFiltrar("1", "ACENALDO FERREIRA LIMA");
		page.botaoFuncoes1();
		sairFrame();
		contasreceber.gerarBoletosTodos();
		frame.TelaSobreposta();
		contasreceber.campoMotivoAlerta("E-mail contas a receber");
		contasreceber.campoFiltroPersonalizado("Anuidade");
		page.botaoAvancar();
		Assert.assertEquals("O processo de envio de boletos por e-mail foi agendada.",
				contasreceber.validarTextoGerecaoEnvioBoletoEmailTodos());
	}

	@Test
	public void T130_GeracaoImpressaoDeBoletosSelecionadas() throws InterruptedException {

		menu.Financeiro();
		menu.ContasReceber();
		frame.frameDireita();
		contasreceber.abaContasReceberGeracao();
		// contasreceber.selectVisualizarContasReceberGeracao("Todos");
		contasreceber.filtroSituacaoGeracao("A receber");
		page.inserirCampoFiltrar("1", "ACENALDO FERREIRA LIMA");
		page.selecionarCheckBoxGrid("0");
		page.botaoFuncoes1();
		sairFrame();
		contasreceber.gerarBoletosSelecionados();
		frame.TelaSobreposta();
		contasreceber.campoFuncao("Imprimir");
		page.botaoAvancar();
		page.esperar3segundos();
	}

	@Test
	public void T140_EstornoRecebimento() throws InterruptedException {

		menu.Financeiro();
		menu.ContasReceber();
		frame.frameDireita();
		contasreceber.filtroSituacao("Pago");
		page.inserirCampoFiltrar("0", "ACENALDO FERREIRA LIMA");
		contasreceber.filtroBruto("1000");
		page.selecionarRegistro("1.000,00");
		frame.TelaSobreposta();
		contasreceber.abaMovimentos();
		page.esperar2segundos();
		clicarBotaoDireito("Não");
		contasreceber.estornar();
		page.esperar2segundos();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		page.esperar3segundos();
		contasreceber.abaMovimentos();
		Assert.assertEquals("Estorno de recebimento", contasreceber.obterTextoMovimentos());
	}

	@Test
	public void T150_Relatorio_086_pdf() throws InterruptedException {

		menu.Financeiro();
		menu.Relatorios();
		frame.frameDireita();
		frame.frameDireita2();
		relatorio.inserirFiltro("R086C000000");
		page.selecionarRegistro("R086C000000");
		frame.TelaSobreposta();
		relatorio.campoSacado("ABEL WALTER DA SILVA");
		page.esperar1segundo();
		relatorio.gerarRelatorio();
		page.esperar3segundos();
		page.validarDownloadArquivo("RelatorioR086C000000.pdf");
	}

	@Test
	public void T160_Relatorio_086_Excel() throws InterruptedException {

		menu.Financeiro();
		menu.Relatorios();
		frame.frameDireita();
		frame.frameDireita2();
		relatorio.inserirFiltro("R086C000000");
		page.selecionarRegistro("R086C000000");
		frame.TelaSobreposta();
		relatorio.campoFormatoRelatorio("Excel");
		relatorio.campoSacado("ABEL WALTER DA SILVA");
		page.esperar1segundo();
		relatorio.gerarRelatorio();
		page.esperar3segundos();
		page.validarDownloadArquivo("RelatorioR086C000000.xlsx");
	}
	
	@Test
	public void T170_Relatorio_086_Por_Agendamento() throws InterruptedException {
		
		menu.Financeiro();
		menu.Relatorios();
		frame.frameDireita();
		frame.frameDireita2();
		relatorio.inserirFiltro("R086C000000");
		page.selecionarRegistro("R086C000000");
		frame.TelaSobreposta();
		relatorio.campoSacado("ZULEIDE MENDES");
		page.esperar1segundo();
		relatorio.checkBoxAgendar();
		relatorio.campoIniciarEm();
		relatorio.gerarRelatorio();
		page.esperar3segundos();
		sairFrame();
		Assert.assertEquals("A geração do relatório agendada.", relatorio.validarTextoGerarRelatorioAgendamento());
		
	}

	@Test
	public void T180_GeracaoArquivoRemessa() throws InterruptedException {

		menu.Financeiro();
		menu.IntegracaoBancaria();
		frame.frameDireita();
		integracaobancaria.remessa();
		page.botaoNovo();
		frame.TelaSobreposta();
		integracaobancaria.campoTipo("Carnê");
		integracaobancaria.campoCategoria("TÉCNICO DE ENFERMAGEM");
		frame.TelaSobreposta();
		page.esperar2segundos();
		frame.TelaSobreposta();
		integracaobancaria.campoCarteiraDeCobranca("Carteira - Banco do Brasil");
		integracaobancaria.campoNossoNumero("Gerar novo quando não possuir para carteira selecionada");
		integracaobancaria.campoMaxRegistrosArquivo("1");
		page.esperar2segundos();
		page.botaoGerar();
		page.botaoGerar();
		Assert.assertEquals("Arquivo gerado.", integracaobancaria.validarTextoGeracaoArquivoRemessa());
	}

	@Test
	public void T190_GerarContatoDeRecobranca() throws InterruptedException {

		menu.Financeiro();
		menu.Cobranca();
		frame.frameDireita();
		frame.frameDireita2();
		cobranca.campoSacado("ABDOM MURILO BARBOSA SANCHEZ");
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.selecionarCheckBoxGrid("0");
		cobranca.gerarContato();
		frame.contato();
		cobranca.campoTipoDeContato("Recobrança");
		page.botaoAvancar();
		page.botaoAvancar();
		sairFrame();
		Assert.assertEquals("Processo de geração dos contatos criado com sucesso!",
				cobranca.validarTextoGerarContatoDeCobranca());
	}

	@Test
	public void T200_GeracaoEnvioDeBoletoEmailSelecionadas() throws InterruptedException {

		menu.Financeiro();
		menu.ContasReceber();
		frame.frameDireita();
		contasreceber.abaContasReceberGeracao();
		contasreceber.filtroSituacaoGeracao("A receber");
		page.inserirCampoFiltrar("1", "ACENALDO FERREIRA LIMA");
		page.selecionarCheckBoxGrid("0");
		page.botaoFuncoes1();
		sairFrame();
		contasreceber.gerarBoletosSelecionados();
		frame.TelaSobreposta();
		contasreceber.campoMotivoAlerta("Envio de mensagem com boleto");
		// contasreceber.campoFiltroPersonalizado("Anuidade");
		page.botaoAvancar();
		Assert.assertEquals("Alertas agendado com sucesso.", obterTexto("Alertas agendado com sucesso."));
	}

	/**
	 * DOCUMENTOS GED
	 */

	@Test
	public void T210_SalvandoDocumentoGEDFiscalizacao() throws InterruptedException {

		menu.Fiscalizacao();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "Z L S ENFERMEIRAS ASSOCIADAS LTDA");
		page.selecionarRegistro("AD-1009");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		page.botaoNovo();

		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();

		// Entrar na Janela Sobreposta
		trocarJanela();

		// Teste dentro da Janela Sobresposta
		ged.campoDocumento("ArquivoGED.pdf");
		page.esperar2segundos();
		ged.campoTipoDocumento("Outros");
		page.salvareFechar();

		// Voltar para a Janela Principal
		retornarJanela(capturaJanelaPrincipal);
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		Assert.assertEquals("ArquivoGED.pdf", ged.validarTextoDocumentoGEDFiscalizacao());
	}

	@Test
	public void T220_AlterandoArquivosFiscalizacao() throws InterruptedException {

		menu.Fiscalizacao();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "Z L S ENFERMEIRAS ASSOCIADAS LTDA");
		page.selecionarRegistro("AD-1009");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
		ged.campoTipoAssunto("Alteração de Cadastro");
		page.salvareFechar();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
	}

	@Test
	public void T230_AssinaturaEletronicaFiscalizacao() throws InterruptedException {

		menu.Fiscalizacao();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "Z L S ENFERMEIRAS ASSOCIADAS LTDA");
		page.selecionarRegistro("AD-1009");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		clicarBotaoDireito("ArquivoGED.pdf");
		ged.assinarEletronicamente();

		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();

		// Entrar na Janela Sobreposta
		trocarJanela();

		// Teste dentro da Janela Sobresposta
		page.OK();
		Assert.assertEquals("Assinatura(s) realizada(s) com sucesso!.",
				ged.validarTextoAssinaturaEletronicaGEDFiscalizacao());
	}

	@Test
	public void T240_ExcluirDocumentoGEDFiscalizacao() throws InterruptedException {

		menu.Fiscalizacao();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "Z L S ENFERMEIRAS ASSOCIADAS LTDA");
		page.selecionarRegistro("AD-1009");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		clicarBotaoDireito("ArquivoGED.pdf");
		page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAutoInfracaoFiscalizacao();
		Assert.assertEquals("Nenhum registro.", ged.validarTextoDocumentoGEDExcluirFiscalizacao());
	}

	/**
	 * Jurídico
	 */
	@Test
	public void T250_SalvandoDocumentoGEDJuridico() throws InterruptedException {

		menu.Juridico();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "LUCIMARA CRISTINA GATTI");
		page.selecionarRegistro("COB70002");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProcessosJuridico();
		page.botaoNovo();

		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();

		// Entrar na Janela Sobreposta
		trocarJanela();

		// Teste dentro da Janela Sobresposta
		ged.campoDocumento("ArquivoGED.pdf");
		page.esperar2segundos();
		ged.campoTipoDocumento("Certidão");
		page.salvareFechar();

		// Voltar para a Janela Principal
		retornarJanela(capturaJanelaPrincipal);
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProcessosJuridico();
		Assert.assertEquals("ArquivoGED.pdf", ged.validarTextoSalvandoDocumentoGEDJuridico());
	}

	@Test
	public void T260_ExcluirDocumentoGEDProcessosJuridico() throws InterruptedException {

		menu.Juridico();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "LUCIMARA CRISTINA GATTI");
		page.selecionarRegistro("COB70002");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProcessosJuridico();
		page.clicarBotaoDireito("ArquivoGED.pdf");
		page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProcessosJuridico();
		Assert.assertEquals("Nenhum registro.", ged.validarTextoDocumentoGEDExcluirJuridico());
	}

	/**
	 * Protocolo
	 */
	@Test
	public void T270_SalvandoDocumentoGEDProtocolo() throws InterruptedException {

		menu.Protocolo();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ABDOM MURILO BARBOSA SANCHEZ");
		page.selecionarRegistro("273.395");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		page.botaoNovo();

		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();

		// Entrar na Janela Sobreposta
		trocarJanela();

		// Teste dentro da Janela Sobresposta
		ged.campoDocumento("ArquivoGED.pdf");
		page.esperar2segundos();
		ged.campoTipoDocumento("Certidão");
		page.salvareFechar();

		// Voltar para a Janela Principal
		retornarJanela(capturaJanelaPrincipal);
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		Assert.assertEquals("ArquivoGED.pdf", ged.validarTextoSalvandoDocumentoGEDProtocolo());
	}

	@Test
	public void T280_AlterandoDocumentoGEDProtocolo() throws InterruptedException {

		menu.Protocolo();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ABDOM MURILO BARBOSA SANCHEZ");
		page.selecionarRegistro("273.395");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
		ged.campoTipoAssunto("Alteração de Cadastro");
		page.salvareFechar();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
	}

	@Test
	public void T290_AssinaturaEletronicaProtocolo() throws InterruptedException {

		menu.Protocolo();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ABDOM MURILO BARBOSA SANCHEZ");
		page.selecionarRegistro("273.395");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		clicarBotaoDireito("ArquivoGED.pdf");
		ged.assinarEletronicamente();

		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();

		// Entrar na Janela Sobreposta
		trocarJanela();

		// Teste dentro da Janela Sobresposta
		page.OK();
		Assert.assertEquals("Assinatura(s) realizada(s) com sucesso!.",
				ged.validarTextoAssinaturaEletronicaGEDProtocolo());
	}

	@Test
	public void T300_ExcluirDocumentoGEDProtocolo() throws InterruptedException {

		menu.Protocolo();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ABDOM MURILO BARBOSA SANCHEZ");
		page.selecionarRegistro("273.395");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		page.clicarBotaoDireito("ArquivoGED.pdf");
		page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDProtocolo();
		Assert.assertEquals("Nenhum registro.", ged.validarTextoExcluirDocumentoGEDProtocolo());
	}

	/**
	 * Administrativo
	 */
	@Test
	public void T310_SalvandoDocumentoGEDAdministrativo() throws InterruptedException {

		menu.Administrativo();
		menu.PedidosPessoaFisica();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ANDREIA KUCARZ DO PRADO RODRIGUES");
		page.selecionarRegistro("10045");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		page.botaoNovo();

		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();

		// Entrar na Janela Sobreposta
		trocarJanela();

		// Teste dentro da Janela Sobresposta
		ged.campoDocumento("ArquivoGED.pdf");
		page.esperar2segundos();
		ged.campoTipoDocumento("Certidão de distribuição");
		page.salvareFechar();

		// Voltar para a Janela Principal
		retornarJanela(capturaJanelaPrincipal);
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		assertEquals("ArquivoGED.pdf", ged.validarTextoSalvandoDocumentoGEDAdministrativo());
	}

	@Test
	public void T320_AlterandoDocumentoGEDAdministrativo() throws InterruptedException {

		menu.Administrativo();
		menu.PedidosPessoaFisica();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ANDREIA KUCARZ DO PRADO RODRIGUES");
		page.selecionarRegistro("10045");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
		ged.campoTipoAssunto("Alteração de Cadastro");
		page.salvareFechar();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
	}

	@Test
	public void T330_AssinandoEletronicaAdministrativo() throws InterruptedException {

		menu.Administrativo();
		menu.PedidosPessoaFisica();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ANDREIA KUCARZ DO PRADO RODRIGUES");
		page.selecionarRegistro("10045");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		clicarBotaoDireito("ArquivoGED.pdf");
		ged.assinarEletronicamente();

		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();

		// Entrar na Janela Sobreposta
		trocarJanela();

		// Teste dentro da Janela Sobresposta
		page.OK();
		Assert.assertEquals("Assinatura(s) realizada(s) com sucesso!.",
				ged.validarTextoAssinaturaEletronicaGEDAdministrativo());
	}

	@Test
	public void T340_ExcluirDocumentoGEDAdministrativo() throws InterruptedException {

		menu.Administrativo();
		menu.PedidosPessoaFisica();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "ANDREIA KUCARZ DO PRADO RODRIGUES");
		page.selecionarRegistro("10045");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		clicarBotaoDireito("ArquivoGED.pdf");
		page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDAdministrativo();
		Assert.assertEquals("Nenhum registro.", ged.validarTextoExcluirDocumentoGEDAdministrativo());
	}

	/**
	 * Conselho Pleno
	 */
	@Test
	public void T350_SalvandoDocumentoGEDConselhoPleno() throws InterruptedException {

		menu.ConselhoPleno();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "SEBASTIAO TADEU HERSING");
		page.selecionarRegistro("10042");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		page.botaoNovo();

		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();

		// Entrar na Janela Sobreposta
		trocarJanela();

		// Teste dentro da Janela Sobresposta
		ged.campoDocumento("ArquivoGED.pdf");
		page.esperar2segundos();
		ged.campoTipoDocumento("Certidão de distribuição");
		page.salvareFechar();

		// Voltar para a Janela Principal
		retornarJanela(capturaJanelaPrincipal);
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		assertEquals("ArquivoGED.pdf", ged.validarTextoSalvandoDocumentoGEDConselhoPleno());
	}

	@Test
	public void T360_AlterandoDocumentoGEDConselhoPleno() throws InterruptedException {

		menu.ConselhoPleno();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "SEBASTIAO TADEU HERSING");
		page.selecionarRegistro("10042");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
		ged.campoTipoAssunto("Alteração de Cadastro");
		page.salvareFechar();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		page.selecionarRegistro("ArquivoGED.pdf");
		frame.TelaSobreposta2();
		page.esperar2segundos();
	}

	@Test
	public void T370_AssinandoEletronicamenteDocumentoGEDConselhoPleno() throws InterruptedException {

		menu.ConselhoPleno();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "SEBASTIAO TADEU HERSING");
		page.selecionarRegistro("10042");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		clicarBotaoDireito("ArquivoGED.pdf");
		ged.assinarEletronicamente();

		// Captura da Janela Principal
		String capturaJanelaPrincipal = getDriver().getWindowHandle();

		// Entrar na Janela Sobreposta
		trocarJanela();

		// Teste dentro da Janela Sobresposta
		page.OK();
		Assert.assertEquals("Assinatura(s) realizada(s) com sucesso!.",
				ged.validarTextoAssinaturaEletronicaGEDConselhoPleno());
	}

	@Test
	public void T380_ExcluirDocumentoGEDConselhoPleno() throws InterruptedException {

		menu.ConselhoPleno();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "SEBASTIAO TADEU HERSING");
		page.selecionarRegistro("10042");
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		clicarBotaoDireito("ArquivoGED.pdf");
		page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		ged.abaDocumentosGEDConselhoPleno();
		Assert.assertEquals("Nenhum registro.", ged.validarTextoExcluirDocumentoGEDConselhoPleno());
	}

	@Test
	public void T390_IncluirInfracaoProcessoEticaDisciplina() throws InterruptedException {
		
		menu.EticaDisciplina();
		frame.frameDireita();
        page.inserirCampoFiltrar("0", "ALEXANDRE MELLO VIANA");
        page.selecionarRegistro("273.189");
        frame.TelaSobreposta();
        processos.abaInfracoes();
        page.botaoNovo();
        frame.processosInfracoesEticaDisciplina();
        processos.campoDescricao("Inclusão de infração");
        page.salvar();
        page.esperar2segundos();
        page.fechar();
        frame.frameDireita();
        frame.TelaSobreposta();
        processos.abaInfracoes();
        Assert.assertEquals("Inclusão de infração", processos.validarTextoinclusaoInfracao());	
	}
	
	@Test
	public void T400_ExcluirInfracaoProcessoEticaDisciplina() throws InterruptedException {
		
		menu.EticaDisciplina();
		frame.frameDireita();
        page.inserirCampoFiltrar("0", "ALEXANDRE MELLO VIANA");
        page.selecionarRegistro("273.189");
        frame.TelaSobreposta();
        processos.abaInfracoes();
        clicarBotaoDireito("Inclusão de infração");
        page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		processos.abaInfracoes();
		Assert.assertEquals("Nenhum registro.", processos.validarTextoExcluirInfracaoProcesso());
	}
	
	@Test
	public void T410_IncluirInfracaoProcessoFiscalizacao() throws InterruptedException {
		
		menu.Fiscalizacao();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "VICTOR GUILHERME HAMMEMEISTER");
		page.selecionarRegistro("AD-1014");
		frame.TelaSobreposta();
		processo.abaInfracao();
		page.botaoNovo();
		frame.processosInfracoesFiscalizacao();
		processo.campoDescricao("Inclusão infração Fiscalização");
        page.salvar();
        page.esperar2segundos();
        sairFrame();
        page.OK();
        frame.frameDireita();
        frame.TelaSobreposta();
        frame.processosInfracoesFiscalizacao();
        page.fechar();
        frame.frameDireita();
        frame.TelaSobreposta();
        processo.abaInfracao();
        Assert.assertEquals("Inclusão infração Fiscalização", processo.validarTextoIncluirInfracaoProcesso());		
	}
	
	@Test
	public void T420_ExcluirInfracaoProcessoFiscalizacao() throws InterruptedException {
		
		menu.Fiscalizacao();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "VICTOR GUILHERME HAMMEMEISTER");
        page.selecionarRegistro("AD-1014");
        frame.TelaSobreposta();
        processo.abaInfracao();
        clicarBotaoDireito("Inclusão infração Fiscalização");
        page.excluir();
		frame.TelaSobreposta2();
		frame.mainFrame();
		page.botaoSim();
		frame.TelaSobreposta();
		processo.abaInfracao();
		Assert.assertEquals("Nenhum registro.", processo.validarTextoExcluirInfracaoProcesso());
	}
	
	@Rule
	public TestName testNome = new TestName();

	@After
	public void FinalizaTest() throws IOException {

		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target/screenshot/Testes Padroes/" + testNome.getMethodName() + ".jpg"));
	}

}
