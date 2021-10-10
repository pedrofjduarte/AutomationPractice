package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.CadastroPage;
import runner.RunCucumberTest;

public class CadastroSteps extends RunCucumberTest {

    CadastroPage cadastroPage = new CadastroPage(driver);

    @Quando("^eu preeencho o formulário de cadastro$")
    public void eu_preeencho_o_formulário_de_cadastro()  {
        cadastroPage.selectTitle(1);
        cadastroPage.preencheNome("Pedro");
        cadastroPage.preencheSobrenome("Duarte");
        cadastroPage.preenchePassword("123456");
        cadastroPage.selecionaAniversario(20, 8, "1995");
    }

    @Quando("^clico em registrar$")
    public void clico_em_registrar() throws Throwable {

    }

    @Então("^vejo a mensagem de cadastro realizado com sucesso$")
    public void vejo_a_mensagem_de_cadastro_realizado_com_sucesso()  {

    }

}
