package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.MessagePage;
import runner.RunCucumberTest;

public class MessagesSteps extends RunCucumberTest {

    MessagePage messagePage = new MessagePage(driver);

    @Dado("^que estou na tela de mensagens$")
    public void que_estou_na_tela_de_mensagens() {
        messagePage.acessarMessage();
    }

    @Dado("^preencho todos os campos$")
    public void preencho_todos_os_campos() {
        messagePage.selecionaAssunto("Webmaster");
        messagePage.preencheEmail("pedro@qazando.com.br");
        messagePage.preencheMensagem("Minha mensagem");
        messagePage.uploadFile("C:\\Users\\pedro\\Documents\\projetos\\automationpractice\\Teste.png");
    }

    @Quando("^clico em enviar mensagem$")
    public void clico_em_enviar_mensagem() {
        messagePage.click_submit();
    }

    @Então("^vejo feedback de mensagem enviada com sucesso$")
    public void vejo_feedback_de_mensagem_enviada_com_sucesso() {
        messagePage.validarMensagemSucesso();
    }
}
