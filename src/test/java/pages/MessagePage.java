package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import support.Utils;

public class MessagePage extends Utils {

    WebDriver driver;

    private By subject_field = By.id("id_contact");
    private By message_field = By.id("message");
    private By upload_field = By.id("fileUpload");
    private By submit_button = By.id("submitMessage");
    private By email_field = By.id("email");

    public MessagePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarMessage(){
        driver.get("http://automationpractice.com/index.php?controller=contact");
        esperarElementoEstarPresente(message_field, 20);
    }

    public void selecionaAssunto(String assunto){
        Select select_assunto = new Select(driver.findElement(subject_field));
        select_assunto.selectByVisibleText(assunto);
    }

    public void preencheMensagem(String message){
        driver.findElement(message_field).sendKeys(message);
    }

    public void preencheEmail(String email){
        driver.findElement(email_field).sendKeys(email);
    }

    public void uploadFile(String caminhoArquivo){
        driver.findElement(upload_field).sendKeys(caminhoArquivo);
    }

    public void click_submit(){
        driver.findElement(submit_button).click();
    }

    public void validarMensagemSucesso(){
        esperarElementoEstarPresente(By.cssSelector(".footer_links > li:nth-child(1) > a:nth-child(1) > span:nth-child(1) > i:nth-child(1)"), 20);
        String mensagemAtual = driver.findElement(By.cssSelector(".alert")).getText();
        Assert.assertEquals("Your message has been successfully sent to our team.", mensagemAtual);
    }
}
