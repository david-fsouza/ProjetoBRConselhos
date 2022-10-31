package br.conselhos.page;

import static br.conselhos.core.DriverFactory.getDriver;

import java.io.IOException;

import br.conselhos.core.BasePage;
import br.conselhos.core.DSL;
import net.sourceforge.tess4j.TesseractException;

public class LoginPage extends BasePage {

	public void acessarTelaInicial() {
		getDriver().get("https://brc_hml.brctotal.com/QLD_AUTOM_MainImpl/login/main2.aspx");
	}

	public void setLogin(String login) {
		escreverID("userFieldEdt", login);
	}

	public void setSenha(String senha) {
		escreverID("passFieldEdt", senha);
	}

	public void entrar() {
		clicarBotaoID("q-comp-15");
	}

	/********* Login com Captcha *********/
	
	public void acessarTelaInicialCaptcha() {		
		getDriver().get("https://qualidade.brctotal.com/QLD_BRC_Main/login/LoginBoleto.aspx");		
	}
		
	@SuppressWarnings("unlikely-arg-type")	
	public void campoTipoDeCategoria(String texto)throws InterruptedException, IOException, TesseractException {
		selecionarCombo("slTipoCategoria", texto);
	}
	
	public void campoCPF(String texto) {		
		escreverID("txtCPFCNPJ", texto);
	}	
	
	public void acessarTelaInicialRequerimentoOnline() {
	    getDriver().get("https://qualidade.brctotal.com/QLD_BRC_Main/pgsRequerimento/SelecionaRequerimento.aspx");
	}
	
	
	
	

}
