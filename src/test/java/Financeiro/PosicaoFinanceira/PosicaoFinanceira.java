package Financeiro.PosicaoFinanceira;

import static br.conselhos.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.page.Financeiro.ContasReceberPage;
import br.conselhos.page.Financeiro.PosicaoFinanceiraPage;
import br.conselhos.page.Financeiro.*;
import br.conselhos.page.Financeiro.ContasReceberPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PosicaoFinanceira extends BaseTest {
	private PosicaoFinanceiraPage posicaofinanceira = new PosicaoFinanceiraPage();
	private ContasReceberPage contasreceber = new ContasReceberPage();

	@Before
	public void InicializaPosicaoFinanceira() throws InterruptedException {

		menu.Financeiro();
		menu.PosicaoFinanceira();
		frame.frameDireita();
		frame.frameDireita2();

	}

	/***************************************
	 * TELA NOVO REGISTRO POSIÇÃO FINANCEIRA
	 * 
	 **************************************/

	@Test
	public void T010_NovoContasReceber() throws InterruptedException {

		page.botaoNovo();
		frame.TelaSobreposta();
		contasreceber.campoSacado("BIANCA RODRIGUES DOS SANTOS DE LIMA");
		contasreceber.campoTipoLancamento("ANUIDADE PJ");
		//contasreceber.campoInscricaoCategoria("INSCRIÇÃO DEFINITIVA PRINCIPAL");
		contasreceber.campoParcela("8");
		contasreceber.campoValorBruto("1000");
		contasreceber.campoVencimento();
		page.salvareFechar();
		sairFrame();
		frame.frameDireita();
		frame.frameDireita2();
		posicaofinanceira.campoSacado("BIANCA RODRIGUES DOS SANTOS DE LIMA");
		page.botaoLocalizar();
		page.esperar3segundos();
		Assert.assertEquals("ANUPJ", posicaofinanceira.validarTextoNovoContasReceberPosicaoFinanceira());
	}

	@Test
	public void T020_ConsultaRegistroPosicaoFinanceira() throws InterruptedException {

		posicaofinanceira.campoSacado("BIANCA RODRIGUES DOS SANTOS DE LIMA");
		posicaofinanceira.campoEmissaoInicial();
		posicaofinanceira.campoEmissaoFinal();
		sairFrame();
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.esperar3segundos();
		page.selecionarRegistro("ANUPJ");
		page.esperar3segundos();
		frame.TelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações de títulos a receber.",
				posicaofinanceira.validarTextoConsultaPosicaoFinanceira());
	}

	@Test
	public void T030_ConsultaFiltrosAvancados() throws InterruptedException {

		posicaofinanceira.campoSacado("ADRIANA APARECIDA LUZETTI");
		posicaofinanceira.campoNumero("207997");
		// posicaofinanceira.campoEmissaoInicial();
		// posicaofinanceira.campoEmissaoFinal();
		posicaofinanceira.campoVencimentoInicial("27/07/2022");
		posicaofinanceira.campoAReceber("1.152,87");
		posicaofinanceira.campoSubsessao("Chapecó");
		sairFrame();
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.esperar3segundos();
		page.selecionarRegistro("CERDI");
		page.esperar3segundos();
		sairFrame();
		Assert.assertEquals("CERTIDÕES DIVERSAS - ADRIANA APARECIDA LUZETTI - Contas a Receber nº 207997",
				posicaofinanceira.validarTextoConsultaPosicaoFinanceiraFiltrosAvancados());
	}	@Test
	public void T040_Atualizacao() throws InterruptedException {

		posicaofinanceira.campoSacado("BIANCA RODRIGUES DOS SANTOS DE LIMA");
		sairFrame();
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.esperar3segundos();
		page.clicarBotaoGenerico("Vencimento");
		page.esperar2segundos();
		page.selecionarCheckBoxGrid("0");
		posicaofinanceira.atualizacao();
		frame.TelaSobreposta();
		page.botaoGerar();
	}

	@Test
	public void T050_AlteracaoSituracaoComplementoContasAReceber() throws InterruptedException {

		posicaofinanceira.campoSacado("BIANCA RODRIGUES DOS SANTOS DE LIMA");
		sairFrame();
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.esperar2segundos();
		page.clicarBotaoGenerico("Vencimento");
		page.esperar2segundos();
		page.selecionarCheckBoxGrid("0");
		posicaofinanceira.AlterarSituacaoComplemento();
		frame.TelaSobreposta();
		posicaofinanceira.campoComplemento("Notifcado");
		page.salvareFechar();
		frame.frameDireita();
		frame.frameDireita2();
		Assert.assertEquals("Notificado", posicaofinanceira.validarTextoAlterarSituacaoComplemento());
	}

	@Test
	public void T060_Recebimentos() throws InterruptedException {

		posicaofinanceira.campoSacado("BIANCA RODRIGUES DOS SANTOS DE LIMA");
		sairFrame();
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.esperar3segundos();
		page.clicarBotaoGenerico("Vencimento");
		page.esperar2segundos();
		page.selecionarCheckBoxGrid("0");
		posicaofinanceira.recebimentos();
		frame.TelaSobreposta();
		Assert.assertEquals("Permite cadastrar as informações de recebimentos.",
				contasreceber.validarTextoRecebimentos());
		contasreceber.campoConta("CAIXA FUNDO FIXO SEDE");
		contasreceber.campoHistorico("Atualização/Aglutinação");
		contasreceber.campoFormaLiquidacao("Recebimento manual");
		page.botaoAdicionar();
		page.salvareFechar();
	}
	


	@Test
	public void T070_Renegociacao() throws InterruptedException {

		posicaofinanceira.campoSacado("BIANCA RODRIGUES DOS SANTOS DE LIMA");
		sairFrame();
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.esperar3segundos();
		page.clicarBotaoGenerico("Vencimento");
		page.esperar2segundos();
		page.selecionarCheckBoxGrid("0");
		posicaofinanceira.renegociacao();
		frame.TelaSobreposta();
		contasreceber.campoQuantidadeParcelas("2");
		contasreceber.vencimentoPrimeiraParcela();
		page.botaoAdicionar();
		contasreceber.concluirRenegociacao();
		Assert.assertEquals("Renegociação gerada com sucesso.", contasreceber.validarTextoRenegociacao());
	}


	@Test
	public void T080_ImprimirBoleto() throws InterruptedException {

		posicaofinanceira.campoSacado("BIANCA RODRIGUES DOS SANTOS DE LIMA");
		sairFrame();
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.esperar3segundos();
		page.clicarBotaoGenerico("Vencimento");
		page.esperar2segundos();
		page.selecionarCheckBoxGrid("0");
		posicaofinanceira.imprimirBoleto();
		frame.TelaSobreposta();
		page.botaoGerar();
		Assert.assertEquals("Emissão de Boletos", posicaofinanceira.validarTextoImprimirBoleto());
	}

	@Test
	public void T090_BoletoPorEmail() throws InterruptedException {

		posicaofinanceira.campoSacado("BIANCA RODRIGUES DOS SANTOS DE LIMA");
		sairFrame();
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.esperar3segundos();
		page.clicarBotaoGenerico("Vencimento");
		page.esperar2segundos();
		page.selecionarCheckBoxGrid("0");
		posicaofinanceira.boletoPorEmail();
		frame.TelaSobreposta();
		page.botaoGerar();
		sairFrame();
		Assert.assertEquals("OK", posicaofinanceira.validarTextoBoletoPorEmail());
	}

	@Test
	public void T100_EmissaoRelatorios() throws InterruptedException {

		posicaofinanceira.campoSacado("BIANCA RODRIGUES DOS SANTOS DE LIMA");
		sairFrame();
		frame.frameDireita();
		frame.frameDireita2();
		page.botaoLocalizar();
		page.clicarBotaoGenerico("Vencimento");
		page.esperar2segundos();
		page.selecionarCheckBoxGrid("0");
		posicaofinanceira.imprimirRelatorio();
		page.esperar3segundos();
		page.validarDownloadArquivo("Relatório R084C000000.pdf");
	}

	@Rule
	public TestName testNome = new TestName();

	@After
	public void FinalizaTest() throws IOException {

		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo,
				new File("target/screenshot/Financeiro/Posicao Financeira/" + testNome.getMethodName() + ".jpg"));
	}

}
