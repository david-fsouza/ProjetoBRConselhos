package Cucumber.Steps;

import java.sql.Driver;

import org.junit.Assert;

import br.conselhos.core.BasePage;
import br.conselhos.core.BaseTest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class testSteps extends BaseTest {
	
    @Dado("^que esteja na tela de login$")
    public void acessarTelaLogin() {
    	
    	login.acessarTelaInicial();    	
    }
    
    @Quando("informar o usuario {string} e senha {string}")
    public void informarUsuarioSenha(String usuario, String senha) {
    	
    	login.setLogin(usuario);
    	login.setSenha(senha);
    	login.entrar();
    }
    
    @Entao("^o sistema exibe tela inicial$")
    public void acessoTelaInicial () {
    	
    	Assert.assertEquals("Home", obterTextoXpath("//*[text()='Home']"));   	
    }
    
    @E("^acessa o modulo Financeiro$")
    public void acessoModuloFinanceiro() {
    	
    	menu.botaoMenuIndex();
    	menu.Financeiro();   	
    }
    
    /**************************************************
     * Consulta de registro na funcao Contas a Receber
     *************************************************/
    
    @Dado("^que acesse a funcao Contas a Receber$")
    public void acessarContasReceber() {
    	
    	menu.ContasReceber();
    }
    
    @E("pesquise por {string} e selecione o registro")
    public void pesquisaFiltro(String textofiltro) throws InterruptedException {
    	
    	frame.frameDireita();
    	page.inserirCampoFiltrar0(textofiltro);
    	page.selecionarRegistro(textofiltro);
    }
    
    @Entao("o sistema exbibe a mensagem {string}")
    public void validarConsultaContasReceber(String texto) throws InterruptedException {
    	
    	frame.TelaSobreposta();
    	Assert.assertEquals(texto, obterTextoXpath("//*[text()='Data de execução']"));
    	page.esperar3segundos();
    }
    
    /*****************************************************
     * Consulta de registro na função Integração Bancária
     ****************************************************/
    
    @Dado("^que acesse a função Integracao Bancaria$")
    public void acessarIntegracaoBancaria() {
    	
    	menu.IntegracaoBancaria();
    }
    
    @E("pesquise por {string} no campo filtrar")
    public void pesquisaFiltroIntegracaoBancaria(String textofiltro) throws InterruptedException {
    	
    	frame.frameDireita();
    	page.inserirCampoFiltrar0(textofiltro);
    	page.selecionarRegistro(textofiltro);
    }
    
    @Entao("o sistema valida a mensgem {string}")
    public void validarConsultaIntegracaoBancaria(String texto) {
    	
    	frame.TelaSobreposta();
    	Assert.assertEquals(texto, obterTextoXpath("//*[text()='Integração Bancária de Retorno ou Remessa']"));
    }

}
