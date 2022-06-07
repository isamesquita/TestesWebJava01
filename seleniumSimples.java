//1 - pacote
package webTests;

//2 - Bibliotecas

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

//3 - Classe
public class seleniumSimples {
   //3.1 - Atributos

    //declarar o objeto do Selenium WebDriver
    WebDriver driver;

    //3.2 - Métodos e Funções

    @Test
    public void consultarCursoFundamentosDoJava(){

        // A - Inicio
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/91/chromedriver.exe");  //Aponta para onde está o driver do Chrome

        // Instancia o objeto driver como um controlador do Chrome - Passa a controlar o Chrome driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

        // B - Realizar o teste
        // Tudo que queremos fazer relacionado com o navegador, iniciamos com a palavra "driver"
        driver.get("https://www.iterasys.com.br");  //Abre o site informado
        driver.findElement(By.id("searchtext")).click(); // Clica no campo de pesquisa - Quem procura por um elemento, procura por BY "alguma coisa"
        driver.findElement(By.id("searchtext")).clear(); //Limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys( "preparatório ctfl"); // Escreve "mantis" no campo

        driver.findElement(By.id("btn_form_search")).click();  // Clique na lupa

        assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Cursos > \"preparatório ctfl\"");

        driver.findElement(By.cssSelector("span.comprar")).click();  //Clica no botão matricule-se
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(),"Preparatório CTFL");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), " R$ 169,00");

        // C - Encerrar o objeto
        driver.quit(); //Fecha o objeto do selenium



    }
}
