package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.CadastroPage;
import runner.RunCucumberTest;

public class CadastroSteps extends RunCucumberTest {

    CadastroPage cadastroPage = new CadastroPage(driver);

    String nome = "Jose";
    String sobrenome = "Ferreira";


    @Quando("^eu preeencho o formulário de cadastro$")
    public void eu_preeencho_o_formulário_de_cadastro()  {
        cadastroPage.selectTitle(1);
        cadastroPage.preencheNome(nome);
        cadastroPage.preencheSobrenome(sobrenome);
        cadastroPage.preenchePassword("123456");
        cadastroPage.selecionaAniversario(20, 8, "1995");
        cadastroPage.preencheAddress("Rua da Casa do Pedro, 123");
        cadastroPage.preencheCity("Juiz de Fora");
        cadastroPage.selecionaState("Colorado");
        cadastroPage.preenchePostalCode("88800");
        cadastroPage.preenchePhoneMobile("+55-32123456789");
    }

    @Quando("^clico em registrar$")
    public void clico_em_registrar() throws Throwable {
        cadastroPage.clickRegister();
    }

    @Então("^vejo cadastro realizado com sucesso$")
    public void vejo_cadastro_realizado_com_sucesso()  {
        cadastroPage.valida_cadastro(nome, sobrenome);
    }

}
