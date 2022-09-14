package Financeiro.InformacoesBancarias;

import static br.conselhos.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.page.Financeiro.InformacoesBancariasPage;

public class InformacoesBancarias extends BaseTest {
	private InformacoesBancariasPage infomacoesbancarias = new InformacoesBancariasPage();
	
	@Before
	public void InicializaInformacoesBancarias() {
		menu.Financeiro();
		menu.InformacoesBancarias();
		frame.frameDireita();
	}
	
	/**************************** TELA CONTA bancária ***********************************************************************************************/
	
	@Test
	public void NovoContaBancaria() {
		
		page.botaoNovoTabela("0");
		frame.TelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações das contas bancárias.", infomacoesbancarias.obterTextoNovoRegistroContaBancaria());
	}
	
	@Test
	public void ConsultaContaBancaria() {
		
		page.selecionarRegistro("74.219");
		frame.TelaSobreposta();
		Assert.assertEquals("Estrutura financeira", infomacoesbancarias.obterTextoConsultaContaBancaria());		
	}
	
	//***************** MENU LATERAL TELA SOBREPOSTA CONTA bancária ********************************************************************************//
	
	@Test
	public void CarteiraDeCobranca() {
		
		page.selecionarRegistro("74.219");
		frame.TelaSobreposta();
		infomacoesbancarias.abaCarteiraDeCobranca();
		Assert.assertEquals("Carteira - Banco do Brasil", infomacoesbancarias.obterTextoCarteiraDeCobranca());		
	}
	
	@Test
	public void ChequesProprios() {
		
		page.selecionarRegistro("74.219");
		frame.TelaSobreposta();
		infomacoesbancarias.abaChequesProprios();
		Assert.assertEquals("Data da Situação", infomacoesbancarias.obterTextoChequesProprios());		
	}
	
	@Test
	public void Compartilhamento() {
		
		page.selecionarRegistro("74.219");
		frame.TelaSobreposta();
		infomacoesbancarias.abaCompartilhamento();
		Assert.assertEquals("25,0000", infomacoesbancarias.obterTextoCompartilhamento());		
	}
	
	/******************************* TELA AGÊNCIA **************************************************************************************************/
	
	@Test
	public void NovoAgencia() {
		
		infomacoesbancarias.agencia();
		page.botaoNovoTabela("1");
		frame.TelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações das agências bancárias.", infomacoesbancarias.obterTextoNovoAgencia());
	}
	
	@Test
	public void ConsultaAgencia() {
		
		infomacoesbancarias.agencia();
		page.selecionarRegistro("CAIXA FUNDO FIXO");
		frame.TelaSobreposta();
		Assert.assertEquals("Banco", infomacoesbancarias.obterTextoConsultaAgencia());	
	}
	
	@Test
	public void ContasBancarias() {
		
		infomacoesbancarias.agencia();
		page.selecionarRegistro("CAIXA FUNDO FIXO");
		frame.TelaSobreposta();
		infomacoesbancarias.abaContasBancarias();
		Assert.assertEquals("CAIXA FUNDO FIXO SEDE", infomacoesbancarias.obterTextoContasBancarias());
	}
	
	/******************************* TELA BANCOS *****************************************************************************************************/
	
	@Test
	public void NovoBancos() {
		
		infomacoesbancarias.bancos();
		page.botaoNovoTabela("2");
		frame.TelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações de instituições financeiras.", infomacoesbancarias.obterTextoNovoBancos());
	}
	
	@Test
	public void ConsultaBancos() {
		
		infomacoesbancarias.bancos();
		page.selecionarRegistro("Banco do Brasil S.A.");
		frame.TelaSobreposta();
		Assert.assertEquals("Código", infomacoesbancarias.obterTextoConsultaBancos());
	}
	
	@Test
	public void Agencias() {
		
		infomacoesbancarias.bancos();
		page.selecionarRegistro("Banco do Brasil S.A.");
		frame.TelaSobreposta();
		infomacoesbancarias.abaAgencias();
		Assert.assertEquals("Agência B.Brasil", infomacoesbancarias.obterTextoAgencias());
	}
	
	/************************* TELA INSTRUçõES DE cobrançaS ******************************************************************************************/
	
	@Test
	public void NovoInstrucoesDeCobranca() {
		
		infomacoesbancarias.instrucoesDeCobranca();
		page.botaoNovoTabela("3");
		frame.TelaSobreposta();
		Assert.assertEquals("Permite cadastrar/alterar informações das instruções de cobrança.", infomacoesbancarias.obterTextoNovoInstrucoesDeCobranca());
	}
	
	@Test
	public void ConsultaInstrucoesDeCobranca() {
		
		infomacoesbancarias.instrucoesDeCobranca();
		page.selecionarRegistro("{Complemento}");
		frame.TelaSobreposta();
		Assert.assertEquals("Descrição", infomacoesbancarias.obterTextoConsultaInstrucoesDeCobranca());
	}
	
	@Test
	public void ConfiguracaoPorBancos() {
		
		infomacoesbancarias.instrucoesDeCobranca();
		page.selecionarRegistro("Não receber após o vencimento");
		frame.TelaSobreposta();
		infomacoesbancarias.abaConfiguracaoPorBancos();
		Assert.assertEquals("Banco do Brasil S.A.", infomacoesbancarias.obterTextoConfiguracaoPorBancos());		
	}
	
	/************************* TELA CARTEIRAS DE cobrança ********************************************************************************************/
	
	@Test
	public void NovoCarteirasDeCobranca() {
		
		infomacoesbancarias.carteirasDeCobranca();
		page.botaoNovoTabela("4");
		frame.TelaSobreposta();
		Assert.assertEquals("Permitir cadastrar/alterar as informações da Carteira de Cobrança.", infomacoesbancarias.obterTextoNovoCarteirasDeCobranca());		
	}
	
	@Test
	public void ConsultaCarteirasDeCobranca() {
		
		infomacoesbancarias.carteirasDeCobranca();
		page.selecionarRegistro("Protesto em Cartório");
		frame.TelaSobreposta();
		Assert.assertEquals("Numeração de Remessa Bancária", infomacoesbancarias.obterTextoConsultaCarteirasDeCobranca());		
	}
	
	//******************* MENU LATERAL CARTEIRAS DE cobrança ******************************************************************************************/
	
	@Test
	public void Configuracoes() {
		
		infomacoesbancarias.carteirasDeCobranca();
		page.selecionarRegistro("Protesto em Cartório");
		frame.TelaSobreposta();
		infomacoesbancarias.abaConfiguracoes();
		Assert.assertEquals("Nosso número", infomacoesbancarias.obterTextoConfiguracoes());		
	}
	
	@Test
	public void Instrucoes() {
		
		infomacoesbancarias.carteirasDeCobranca();
		page.selecionarRegistro("Protesto em Cartório");
		frame.TelaSobreposta();
		infomacoesbancarias.abaInstrucoes();
		Assert.assertEquals("O valor deste boleto JÁ CONTEMPLA o desconto referente ao período", infomacoesbancarias.obterTextoInstrucoes());	
	}
	
	@Test
	public void Movimentos() {
		
		infomacoesbancarias.carteirasDeCobranca();
		page.selecionarRegistro("Protesto em Cartório");
		frame.TelaSobreposta();
		infomacoesbancarias.abaMovimentos();
		Assert.assertEquals("Teste Movimentos Bancários", infomacoesbancarias.obterTextoMovimentos());
	}
	
	/************************ TELA OCORRÃ£NCIA bancária *************************************************************************************************/
	
	@Test
	public void NovoOcorrenciaBancaria() {
		
		infomacoesbancarias.ocorrenciaBancaria();
		page.botaoNovoTabela("5");
		frame.TelaSobreposta();
		Assert.assertEquals("Permite criar/editar Ocorrências Bancárias", infomacoesbancarias.obterTextoOcorrenciaBancaria());
	}
	
	
	
	@Rule
    public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Financeiro/Informacoes Bancarias/" + testNome.getMethodName() + ".jpg"));
	 }
	 

}
