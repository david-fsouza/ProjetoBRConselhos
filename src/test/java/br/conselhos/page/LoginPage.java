package br.conselhos.page;

import static br.conselhos.core.DriverFactory.getDriver;

import br.conselhos.core.BasePage;
import br.conselhos.core.DSL;

public class LoginPage extends BasePage {

	public void acessarTelaInicial() {
		getDriver().get("http://186.250.186.214/QLD_BRC_Main_Automacao/login/main2.aspx");
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

	public void esperarLogin() {
		esperaExplicita("#q-comp-39");
	}

}
