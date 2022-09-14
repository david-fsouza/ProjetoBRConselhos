package TED;

import static br.conselhos.core.DriverFactory.getDriver;
import static br.conselhos.core.DriverFactory.killDriver;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.conselhos.core.BaseTest;
import br.conselhos.core.DSL;
import br.conselhos.core.Propriedades;
import br.conselhos.page.FramesPage;
import br.conselhos.page.IndexPage;

public class DocumentosGED extends DSL {
	
	
	IndexPage page = new IndexPage();
	FramesPage frame = new FramesPage();
	
	
	@Test
	public void ConsultaTodosDocumentos() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	esperaExplicita("div[title='OK']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos2() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos3() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos4() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos5() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos6() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos7() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos8() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos9() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos10() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos11() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos12() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos13() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
    esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos14() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos15() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos16() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos17() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos18() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos19() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos20() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos21() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos22() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos23() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
    clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	

    }
	
	@Test
	public void ConsultaTodosDocumentos24() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	 clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);

    }
	
	@Test
	public void ConsultaTodosDocumentos25() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
    clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	
    }
	
	@Test
	public void ConsultaTodosDocumentos26() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	 clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	
    }
	
	@Test
	public void ConsultaTodosDocumentos27() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	 clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	
    }
	
	@Test
	public void ConsultaTodosDocumentos28() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	 clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	
    }
	
	@Test
	public void ConsultaTodosDocumentos29() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	 clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	
    }
	
	@Test
	public void ConsultaTodosDocumentos30() throws InterruptedException {
	
	getDriver().get("http://187.32.155.67/BRCONSELHOS_OABGO_H/login/main2.aspx");
	
	escreverID("userFieldEdt", "suporte");
	
	escreverID("passFieldEdt", "Pw12345@");
	
	clicarBotaoID("q-comp-15");
	
	clicarBotaoSelector("div[title='TED']");
	
	frame.frameDireita();
	
	page.inserirCampoFiltrar0("201506805");
	
	page.selecionarRegistro("201506805");
	
	frame.TelaSobreposta();
	
	clicarLink("Documentos GED");
	
	entrarFrame("#panelcategory14>iframe");	
	
	clicarBotaoSelector("div[title='Funções']");
	
	sairFrame();
	
	clicarBotaoXpath("//*[text()='Visualizar Documentos PDF/P7S - Todos']");
	
	clicarBotaoSelector("div[title='OK']");
	
	esperaFixa(20000);
	
    }
	
	@Rule
	public TestName testNome = new TestName();
	
	@After
	public void Finaliza() throws IOException {
		
	    TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target/GED_OAB/" + testNome.getMethodName() + ".jpg"));
		
	
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
	}
	
  }	

}