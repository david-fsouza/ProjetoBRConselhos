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

import br.conselhos.core.BaseTest;
import br.conselhos.page.Cadastros.PessoasFisicasPage;
import br.conselhos.page.Cadastros.PessoasPage;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Pessoas extends BaseTest {
	private PessoasPage pessoas = new PessoasPage();
	
	@Before
	public void InicializaPessoas() {
		 
		menu.Cadastros();
		menu.Pessoas();
		frame.frameDireita();
	}
	
	@Test
	public void T002_IncluirNovaPessoaFisica() throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		page.botaoNovoTabela("0");
		frame.TelaSobreposta();
		pessoas.campoNomeCompleto("PATRICIA SILVA PIRES TESTE");
		pessoas.campoCPF("22065736011");
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
		sairFrame();
		page.OK();
		frame.TelaSobreposta();
		page.fechar();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "220.657.360-11");
		Assert.assertEquals("PATRICIA SILVA PIRES TESTE", pessoas.validarTextoIncluirPessoaFisica());
	}
	
	//@Test
	//public void T003
	
	@Test
	public void T010_IncluirNovaPessoaJuridica() throws InterruptedException {
		
		page.botaoNovo();
		frame.TelaSobreposta();
		pessoas.campoTipo("Pessoa Jurídica");
		frame.TelaSobreposta();
		pessoas.campoNomeCompleto("PATRICIA SILVA JURIDICA TESTE");
		esperaFixa(5000);
		pessoas.campoCapitalSocial("5000");
		pessoas.campoProcesso("123456789987654321");
		pessoas.abaEndProfissional();
		pessoas.campoCEP("88150000");
		pessoas.campoNumero("20");
		pessoas.campoEmail("juridico@gmail.com");
		pessoas.botaoSalvarEFechar();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "PATRICIA SILVA JURIDICA TESTE");
		Assert.assertEquals("PATRICIA SILVA JURIDICA TESTE", pessoas.validarTextoIncluirNovaPessoaJuridica());
	//	page.selecionarRegistro("PATRICIA SILVA PESSOA JURIDICA");
	//	frame.TelaSobreposta();
	//	page.esperar3segundos();
    //	pessoas.botaoNovoEmpresa();
    //	frame.inscricoes();
    //	pessoas.campoTipoInscricao("REGISTRO DE EMPRESA");
	//	pessoas.botaoSalvarEFechar();
	//	page.esperar3segundos();
	//	frame.TelaSobreposta();
	//	page.salvareFechar();
	//	frame.frameDireita();
	//	page.inserirCampoFiltrar("0", "PATRICIA SILVA PESSOA JURIDICA");
	//	Assert.assertEquals("PATRICIA SILVA PESSOA JURIDICA", pessoas.validarTextoIncluirNovaPessoaJuridica());
	}
	
	@Test
    public void T020_AlterarPessoaJuridicaRecemCadastrada() throws InterruptedException {
		
		page.inserirCampoFiltrar("0", "PATRICIA SILVA JURIDICA TESTE");
		page.selecionarRegistro("PATRICIA SILVA JURIDICA TESTE");
		frame.TelaSobreposta();
	    pessoas.campoSubsessao("Florianópolis");
	    frame.TelaSobreposta();
	    page.salvareFechar();
	    frame.frameDireita();
		page.inserirCampoFiltrar("0", "PATRICIA SILVA JURIDICA TESTE");
		Assert.assertEquals("Florianópolis", pessoas.validarTextoAlterarPessoaJuridicaRecemCadastrada());
	}
	
	//@Test
	public void T030_AlterarSituacaoPessoaJuridica() throws InterruptedException {
		
		page.inserirCampoFiltrar("0", "PATRICIA SILVA JURIDICA TESTE");
		page.selecionarCheckBoxGrid("0");
		page.botaoFuncoes0();
		pessoas.alterarSituacaoEmLote();
		frame.TelaSobreposta();
		pessoas.campoCategoria("PESSOA JURÍDICA");
		pessoas.campoSituacao("Baixado");
		pessoas.campoComplementoSituacao("A pedido");
		page.salvar();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "PATRICIA SILVA PESSOA JURIDICA");
		Assert.assertEquals("A pedido", pessoas.validarTextoAlterarSituacaoPessoaJuridica());
	}
	
	@Test
	public void T040_AlterarPessoaJuridicaCadastradaAnteriormente() throws InterruptedException {
		
		page.inserirCampoFiltrar("0", "13.983.054/0001-66");
		page.selecionarRegistro("CLINICA DE IMUNIZACOES DO PARANA LTDA ME");
		frame.TelaSobreposta();
		pessoas.campoSubsessao("Lages");
		frame.TelaSobreposta();
		page.salvareFechar();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "13.983.054/0001-66");
		Assert.assertEquals("Lages", pessoas.validarTextoPrimeiraAlteracaoPessoaJuridica());
		page.selecionarRegistro("CLINICA DE IMUNIZACOES DO PARANA LTDA ME");
		frame.TelaSobreposta();
		frame.TelaSobreposta();
		pessoas.campoSubsessao("Florianópolis");
		frame.TelaSobreposta();
		page.salvareFechar();
		frame.frameDireita();
		page.inserirCampoFiltrar("0", "13.983.054/0001-66");
		Assert.assertEquals("Florianópolis", pessoas.validarTextoAlterarPessoaJuridicaCadastradaAnteriormente());
	}
	
	@Test
	public void T050_CriarVinculoProfissionalRT() throws InterruptedException, SQLException {
		
		page.inserirCampoFiltrar("0", "PATRICIA SILVA JURIDICA TESTE");
		page.selecionarRegistro("PATRICIA SILVA JURIDICA TESTE");
		frame.TelaSobreposta();
		pessoas.vinculosProfissionais();
		page.esperar2segundos();
		page.botaoNovoTabela("0");
	    page.esperar3segundos();
		frame.novoVinculoProfissional();
		pessoas.campoProfissional("ABDOM MURILO BARBOSA SANCHEZ");
		pessoas.campoTipoDeVinculo("Técnico");
		pessoas.campoInscricaoCategoria("INSCRIÇÃO DEFINITIVA PRINCIPAL");
		pessoas.campoPeriodoInicial();	
		page.salvareFechar();
		frame.TelaSobreposta();
        pessoas.vinculosProfissionais();
		Assert.assertEquals("ABDOM MURILO BARBOSA SANCHEZ", pessoas.validarTextoIncluirVinculoProfissional());
	}
	
	@Test
	public void T060_AlterarUmVinculoProfissionalJaexistente() throws InterruptedException, SQLException {
		
		page.inserirCampoFiltrar("0", "PATRICIA SILVA JURIDICA TESTE");
		page.selecionarRegistro("PATRICIA SILVA JURIDICA TESTE");
		frame.TelaSobreposta();
		pessoas.vinculosProfissionais();
		page.esperar2segundos();
        page.selecionarRegistro("ABDOM MURILO BARBOSA SANCHEZ");
        frame.novoVinculoProfissional();
		pessoas.campoTipoDeVinculo("Enfermeiro");
		page.salvareFechar();
		frame.TelaSobreposta();
        pessoas.vinculosProfissionais();
        Assert.assertEquals("Enfermeiro", pessoas.validarTextoAlterarVinculoProfissional());
		//pessoas.apagarRegistroSQL();		
		
		// Tirar registro de outros endereços, para depois excluir o registro
	}
	
	//@Test
	public void T060_AlterarSituacaoPessoaJuridica() {
		
		
	}
	
	//@Test
	public void T080_CriarART() {
		
		
	}
	
	
	 @Rule
     public TestName testNome = new TestName();
	 
	 @After
	 public void FinalizaTest() throws IOException {
		    
		 TakesScreenshot ss = (TakesScreenshot) getDriver();
	     File arquivo = ss.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(arquivo, new File("target/screenshot/Cadastros/Pessoas/" + testNome.getMethodName() + ".jpg"));
	 }

}
