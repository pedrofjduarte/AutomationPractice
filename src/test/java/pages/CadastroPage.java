package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import support.Utils;

public class CadastroPage extends Utils {

    WebDriver driver;
    private By titleM = By.id("id_gender1");
    private By titleF = By.id("id_gender2");

    private By first_name_field = By.id("customer_firstname");
    private By last_name_field = By.id("customer_lastname");
    //private By email_field = By.id("id_gender2"); esse campo já vem preenchido.
    private By password_field = By.id("passwd");

    private By select_day_field = By.id("days");
    private By select_months_field = By.id("months");
    private By select_years_field = By.id("years");

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTitle(Integer type){

        esperarElementoEstarPresente(titleM, 20);

        if(type == 1){
            driver.findElement(titleM).click();
        }else if(type == 2){
            driver.findElement(titleF).click();
        }
    }

    public void preencheNome(String name){
        driver.findElement(first_name_field).sendKeys(name);
    }

    public void preencheSobrenome(String sobreNome){
        driver.findElement(last_name_field).sendKeys(sobreNome);
    }

    public void preenchePassword(String password){
        driver.findElement(password_field).sendKeys(password);
    }

    public void selecionaAniversario(Integer day, Integer month, String year){
        Select select_day = new Select(driver.findElement(select_day_field));
        select_day.selectByIndex(day);

        Select select_month = new Select(driver.findElement(select_months_field));
        select_month.selectByIndex(month);

        Select select_year = new Select(driver.findElement(select_years_field));
        select_year.selectByValue(year);
    }
}
