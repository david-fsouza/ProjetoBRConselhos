package Cadastro;

import static br.conselhos.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.SQL.JavaApplicationConexaoSQL;
import br.conselhos.core.BaseTest;
import br.conselhos.page.Cadastros.PessoasFisicasPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PessoasFisicas extends BaseTest{
	private PessoasFisicasPage pessoasfisicas = new  PessoasFisicasPage();
	
	@Before
	public void InicializaPessoasFisicas() {
		
		menu.Cadastros();
		frame.frameDireita();		
	}
	
	@Test
	public void T010_IncluirNovaPessoaFisica() throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		page.botaoNovoTabela("0");
		frame.TelaSobreposta();
		//pessoasfisicas.campoRequerente("JANETE APARECIDA ALVES DE SOUZA SANTOS");
		page.botaoAvancar();
		sairFrame();
		page.Ok();
		page.esperar3segundos();
		frame.TelaSobreposta();
		pessoasfisicas.campoNomeCompleto("PATRICIA SILVA PIRES TESTE");
		pessoasfisicas.campoSubsessao("Blumenau");
		frame.TelaSobreposta();
		pessoasfisicas.campoProcesso("100981");
		pessoasfisicas.campoInscricao("INSCRIÇÃO DEFINITIVA P/ TRANSFERÊNCIA");
		pessoasfisicas.campoRegional("COREN/SC");
		pessoasfisicas.campoNumeroInscricaoOrigem("12345678901234567890");
		pessoasfisicas.campoInscricaoInformacaoRegionalOrigem("INSCRIÇÃO DEFINITIVA P/ TRANSFERÊNCIA");
		pessoasfisicas.campoSituacao("Regular");
		pessoasfisicas.abaEndResidencial();
		pessoasfisicas.campoCEP("89636000");
		pessoasfisicas.campoNumero("10");
		pessoasfisicas.checkBoxCorrespondencia();
		pessoasfisicas.campoCelular("99999999999");
		pessoasfisicas.abainfPessoais();
		pessoasfisicas.campoSexo("Feminino");
		pessoasfisicas.campoCPF("22065736011");
		page.salvareFechar();
		page.esperar2segundos();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "220.657.360-11");
		Assert.assertEquals("PATRICIA SILVA PIRES TESTE", pessoasfisicas.validarTextoInclusaoPessoaFisica());
	}
	
	@Test
	public void T020_AlterarPessoaFisicaRecemCadastrada() throws InterruptedException, SQLException { 
		
		page.inserirCampoFiltrar("0", "220.657.360-11");
		page.selecionarRegistro("PATRICIA SILVA PIRES TESTE");
		frame.TelaSobreposta();
		pessoasfisicas.campoSubsessao("Chapecó");
		frame.TelaSobreposta();
		page.salvareFechar();
		frame.frameDireita();
		Assert.assertEquals("Chapecó", pessoasfisicas.validarTextoAlterarPessoaFisicaRecemCadastrada());
	}
	
	@Test
	public void T030_AlterarSituacaoPessoaFisica() throws InterruptedException, SQLException {
		
		page.inserirCampoFiltrar("0", "220.657.360-11");
		page.selecionarCheckBoxGrid("0");
		page.botaoFuncoes0();
		sairFrame();
		pessoasfisicas.alterarSituacao();
		frame.TelaSobreposta();	
		pessoasfisicas.campoSituacaoDoComplemento("Baixado");
		page.salvar();
		sairFrame();
		page.Ok();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "220.657.360-11");
		Assert.assertEquals("Baixado", pessoasfisicas.validarTextoAlterarSituacaoPessoaFisica());
	}
	
	@Test
	public void T040_VerificarHistoricoDaSituacao() throws InterruptedException {
		
		page.inserirCampoFiltrar("0", "220.657.360-11");
		page.selecionarRegistro("PATRICIA SILVA PIRES TESTE");
		frame.TelaSobreposta();
		pessoasfisicas.historicoDeSituacoes();
		Assert.assertEquals("Baixado", pessoasfisicas.validarTextoVerificarHistoricoDaSituacao());	
	}
	
	@Test
	public void T050_VericarEnderecos() throws InterruptedException, SQLException {
		
		page.inserirCampoFiltrar("0", "220.657.360-11");
		page.selecionarRegistro("PATRICIA SILVA PIRES TESTE");
		frame.TelaSobreposta();
		pessoasfisicas.outrosEnderecos();
		Assert.assertEquals("Residencial", pessoasfisicas.validarTextoEnderecos());		
		pessoasfisicas.apagarRegistroSQL();	
	}
	
	@Test
	public void T060_AlterarPessoaFisicarCadastradaAnteriormente() throws InterruptedException {
		
		page.inserirCampoFiltrar("0", "043.039.859-02");
		page.selecionarRegistro("ADRIANA APARECIDA LUZETTI");
		frame.TelaSobreposta();
		pessoasfisicas.campoSubsessao("Chapecó");
		frame.TelaSobreposta();
		page.salvareFechar();
		frame.frameDireita();
		Assert.assertEquals("Chapecó", pessoasfisicas.validarTextoAlterarPessoaFisicaRecemCadastrada());
	}
	
	 @Rule
     public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Cadastros/Pessoas Fisicas/" + testNome.getMethodName() + ".jpg"));
	 }
	

}
